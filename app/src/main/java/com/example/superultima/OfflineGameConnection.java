package com.example.superultima;

import android.content.Context;

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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class OfflineGameConnection {

    private static final String SERVICE_ID = "com.example.superultima";
    private static final String START_GAME_PREFIX = "START_GAME:";
    private static final String MOVE_PREFIX = "MOVE:";
    private static final String NEXT_ROUND_PREFIX = "NEXT_ROUND:";

    private static OfflineGameConnection instance;

    private final ConnectionsClient connectionsClient;
    private final Set<String> connectedEndpointIds = new HashSet<>();

    private ConnectionListener listener;
    private boolean connectionRequested = false;
    private boolean isHost = false;

    private final ConnectionLifecycleCallback connectionLifecycleCallback;
    private final PayloadCallback payloadCallback;
    private final EndpointDiscoveryCallback endpointDiscoveryCallback;

    public interface ConnectionListener {
        default void onPlayerCountChanged(int playerCount) {}
        default void onGameFound() {}
        default void onGameStarted(String deckName) {}
        default void onConnectionFailed() {}
        default void onMoveReceived(int statIndex) {}
        default void onNextRoundReceived() {}
    }

    public static synchronized OfflineGameConnection getInstance(Context context, ConnectionListener listener) {
        if (instance == null) {
            instance = new OfflineGameConnection(context.getApplicationContext(), listener);
        } else {
            instance.setListener(listener);
        }
        return instance;
    }

    public static synchronized OfflineGameConnection getInstance() {
        return instance;
    }

    private OfflineGameConnection(Context context, ConnectionListener listener) {
        this.listener = listener;
        this.connectionsClient = Nearby.getConnectionsClient(context);

        this.payloadCallback = new PayloadCallback() {
            @Override
            public void onPayloadReceived(String endpointId, Payload payload) {
                if (payload.getType() != Payload.Type.BYTES) {
                    return;
                }

                byte[] bytes = payload.asBytes();
                if (bytes == null) {
                    return;
                }

                String message = new String(bytes, StandardCharsets.UTF_8);

                if (message.startsWith(START_GAME_PREFIX)) {
                    String deckName = message.substring(START_GAME_PREFIX.length());
                    if (OfflineGameConnection.this.listener != null) {
                        OfflineGameConnection.this.listener.onGameStarted(deckName);
                    }
                } else if (message.startsWith(MOVE_PREFIX)) {
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

        this.connectionLifecycleCallback = new ConnectionLifecycleCallback() {
            @Override
            public void onConnectionInitiated(String endpointId, ConnectionInfo connectionInfo) {
                if (connectedEndpointIds.size() >= 3) {
                    connectionsClient.rejectConnection(endpointId);
                    return;
                }
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

        this.endpointDiscoveryCallback = new EndpointDiscoveryCallback() {
            @Override
            public void onEndpointFound(String endpointId, DiscoveredEndpointInfo info) {
                if (connectionRequested) {
                    return;
                }
                connectionRequested = true;

                if (OfflineGameConnection.this.listener != null) {
                    OfflineGameConnection.this.listener.onGameFound();
                }

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

    public void startAdvertising() {
        this.isHost = true;
        AdvertisingOptions options = new AdvertisingOptions.Builder()
                .setStrategy(Strategy.P2P_STAR)
                .build();

        connectionsClient.startAdvertising("SUPER ULTIMA", SERVICE_ID, connectionLifecycleCallback, options);
    }

    public void startDiscovery() {
        this.isHost = false;
        DiscoveryOptions options = new DiscoveryOptions.Builder()
                .setStrategy(Strategy.P2P_STAR)
                .build();

        connectionsClient.startDiscovery(SERVICE_ID, endpointDiscoveryCallback, options);
    }

    public void stopAdvertising() {
        connectionsClient.stopAdvertising();
    }

    public void stopDiscovery() {
        connectionsClient.stopDiscovery();
    }

    public void startGame(String deckName) {
        String message = START_GAME_PREFIX + deckName;
        Payload payload = Payload.fromBytes(message.getBytes(StandardCharsets.UTF_8));
        connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
    }

    public void sendMove(int statIndex) {
        String message = MOVE_PREFIX + statIndex;
        Payload payload = Payload.fromBytes(message.getBytes(StandardCharsets.UTF_8));
        connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
    }

    public void sendNextRound() {
        String message = NEXT_ROUND_PREFIX;
        Payload payload = Payload.fromBytes(message.getBytes(StandardCharsets.UTF_8));
        connectionsClient.sendPayload(new ArrayList<>(connectedEndpointIds), payload);
    }

    public int getPlayerCount() {
        return connectedEndpointIds.size() + 1;
    }
}