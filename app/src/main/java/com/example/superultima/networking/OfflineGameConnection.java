package com.example.superultima.networking;

import android.content.Context;

import com.example.superultima.cardgame.Game;
import com.example.superultima.GameStartData;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.DiscoveredEndpointInfo;
import com.google.android.gms.nearby.connection.DiscoveryOptions;
import com.google.android.gms.nearby.connection.EndpointDiscoveryCallback;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Manages the offline multiplayer connections using Google Nearby Connections API.
 * This class handles device discovery, advertising, connection management, 
 * and data synchronization (moves, game start, round transitions).
 */
public class OfflineGameConnection {

    /** Unique service identifier for the Nearby Connections API. */
    private static final String SERVICE_ID = "com.example.superultima";

    /** Prefix for payload messages indicating a player move. */
    private static final String MOVE_PREFIX = "MOVE:";

    /** Prefix for payload messages indicating the transition to the next round. */
    private static final String NEXT_ROUND_PREFIX = "NEXT_ROUND:";

    /** Singleton instance of the connection manager. */
    private static OfflineGameConnection instance;

    /** Client for interacting with the Google Nearby Connections service. */
    private final ConnectionsClient connectionsClient;

    /** Set of endpoint IDs for all currently connected players. */
    private final Set<String> connectedEndpointIds = new HashSet<>();

    /** Listener for connection and game events. */
    private ConnectionListener listener;

    /** Flag to prevent duplicate connection requests. */
    private boolean connectionRequested = false;

    /** Indicates if the local device is the game host. */
    private boolean isHost = false;

    private final ConnectionLifecycleCallback connectionLifecycleCallback;
    private final PayloadCallback payloadCallback;
    private final EndpointDiscoveryCallback endpointDiscoveryCallback;

    /**
     * Interface for components interested in connection and gameplay events.
     */
    public interface ConnectionListener {
        /** Called when the number of connected players changes. */
        default void onPlayerCountChanged(int playerCount) {}

        /** Called when a nearby game is discovered. */
        default void onGameFound() {}

        /** Called when the host starts the game with a specific deck and state. */
        default void onGameStarted(String deckName, Game game) {}

        /** Called when a connection attempt fails. */
        default void onConnectionFailed() {}

        /** Called when a move (stat selection) is received from another player. */
        default void onMoveReceived(int statIndex) {}

        /** Called when a signal to proceed to the next round is received. */
        default void onNextRoundReceived() {}
    }

    /**
     * Gets or creates the singleton instance.
     * @param context Application context.
     * @param listener Initial event listener.
     */
    public static synchronized OfflineGameConnection getInstance(Context context, ConnectionListener listener) {
        if (instance == null) {
            instance = new OfflineGameConnection(context.getApplicationContext(), listener);
        } else {
            instance.setListener(listener);
        }
        return instance;
    }

    /**
     * Retrieves the existing singleton instance.
     */
    public static synchronized OfflineGameConnection getInstance() {
        return instance;
    }

    private OfflineGameConnection(Context context, ConnectionListener listener) {
        this.listener = listener;
        connectionsClient = Nearby.getConnectionsClient(context);

        // --- RECEIVE DATA LOGIC ---
        payloadCallback = new PayloadCallback() {
            @Override
            public void onPayloadReceived(String endpointId, Payload payload) {
                if (payload.getType() != Payload.Type.BYTES) return;

                byte[] bytes = payload.asBytes();
                if (bytes == null) return;

                // 1. Attempt to deserialize as GameStartData (complex object)
                try {
                    ByteArrayInputStream input = new ByteArrayInputStream(bytes);
                    ObjectInputStream objectInput = new ObjectInputStream(input);
                    Object object = objectInput.readObject();

                    if (object instanceof GameStartData) {
                        GameStartData data = (GameStartData) object;
                        if (OfflineGameConnection.this.listener != null) {
                            OfflineGameConnection.this.listener.onGameStarted(data.deckName, data.game);
                        }
                        return;
                    }
                } catch (Exception ignored) {
                    // Not game start data, proceed to check for text commands.
                }

                // 2. Parse as string command (moves or round sync)
                String message = new String(bytes, StandardCharsets.UTF_8);
                if (message.startsWith(MOVE_PREFIX)) {
                    int statIndex = Integer.parseInt(message.substring(MOVE_PREFIX.length()));
                    if (OfflineGameConnection.this.listener != null) {
                        OfflineGameConnection.this.listener.onMoveReceived(statIndex);
                    }
                } else if (message.startsWith(NEXT_ROUND_PREFIX)) {
                    if (OfflineGameConnection.this.listener != null) {
                        OfflineGameConnection.this.listener.onNextRoundReceived();
                    }
                }
            }

            @Override
            public void onPayloadTransferUpdate(String endpointId, PayloadTransferUpdate update) {}
        };

        // --- CONNECTION MANAGEMENT LOGIC ---
        connectionLifecycleCallback = new ConnectionLifecycleCallback() {
            @Override
            public void onConnectionInitiated(String endpointId, ConnectionInfo connectionInfo) {
                // Limit to 4 players total (Host + 3 Guests).
                if (connectedEndpointIds.size() >= 3) {
                    connectionsClient.rejectConnection(endpointId);
                    return;
                }
                // Automatically accept the connection.
                connectionsClient.acceptConnection(endpointId, payloadCallback);
            }

            @Override
            public void onConnectionResult(String endpointId, ConnectionResolution result) {
                if (result.getStatus().isSuccess()) {
                    connectedEndpointIds.add(endpointId);
                    if (OfflineGameConnection.this.listener != null) {
                        OfflineGameConnection.this.listener.onPlayerCountChanged(connectedEndpointIds.size() + 1);
                    }
                } else {
                    if (OfflineGameConnection.this.listener != null) {
                        OfflineGameConnection.this.listener.onConnectionFailed();
                    }
                }
            }

            @Override
            public void onDisconnected(String endpointId) {
                connectedEndpointIds.remove(endpointId);
                if (OfflineGameConnection.this.listener != null) {
                    OfflineGameConnection.this.listener.onPlayerCountChanged(connectedEndpointIds.size() + 1);
                }
            }
        };

        // --- DISCOVERY LOGIC ---
        endpointDiscoveryCallback = new EndpointDiscoveryCallback() {
            @Override
            public void onEndpointFound(String endpointId, DiscoveredEndpointInfo info) {
                if (connectionRequested) return;
                connectionRequested = true;

                if (OfflineGameConnection.this.listener != null) {
                    OfflineGameConnection.this.listener.onGameFound();
                }

                // Automatically request connection to the first discovered game.
                connectionsClient.requestConnection("SUPER ULTIMA", endpointId, connectionLifecycleCallback);
            }

            @Override
            public void onEndpointLost(String endpointId) {}
        };
    }

    public void setListener(ConnectionListener listener) {
        this.listener = listener;
    }

    public boolean isHost() {
        return isHost;
    }

    /**
     * Starts advertising the device as a game host.
     */
    public void startAdvertising() {
        isHost = true;
        AdvertisingOptions options = new AdvertisingOptions.Builder().setStrategy(Strategy.P2P_STAR).build();
        connectionsClient.startAdvertising("SUPER ULTIMA", SERVICE_ID, connectionLifecycleCallback, options);
    }

    /**
     * Starts searching for existing game hosts.
     */
    public void startDiscovery() {
        isHost = false;
        connectionRequested = false;
        DiscoveryOptions options = new DiscoveryOptions.Builder().setStrategy(Strategy.P2P_STAR).build();
        connectionsClient.startDiscovery(SERVICE_ID, endpointDiscoveryCallback, options);
    }

    public void stopAdvertising() {
        connectionsClient.stopAdvertising();
    }

    public void stopDiscovery() {
        connectionsClient.stopDiscovery();
    }

    /**
     * Broadcasts the game start signal and shared game state to all connected guests.
     */
    public void startGame(String deckName, Game game) {
        GameStartData data = new GameStartData(deckName, game);
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(output);
            objectOutput.writeObject(data);
            objectOutput.flush();
            byte[] bytes = output.toByteArray();

            Payload payload = Payload.fromBytes(bytes);
            connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a player's move (the index of the selected statistic) to other players.
     */
    public void sendMove(int statIndex) {
        String message = MOVE_PREFIX + statIndex;
        Payload payload = Payload.fromBytes(message.getBytes(StandardCharsets.UTF_8));
        connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
    }

    /**
     * Sends a signal to proceed to the next round to all connected players.
     */
    public void sendNextRound() {
        String message = NEXT_ROUND_PREFIX;
        Payload payload = Payload.fromBytes(message.getBytes(StandardCharsets.UTF_8));
        connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
    }

    public int getPlayerCount() {
        return connectedEndpointIds.size() + 1;
    }
}
