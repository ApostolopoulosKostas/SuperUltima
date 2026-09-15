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
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

public class OfflineGameConnection {

    private static final String SERVICE_ID =
            "com.example.superultima";

    private static final String START_GAME_PREFIX =
            "START_GAME:";

    private final ConnectionsClient connectionsClient;

    private final Set<String> connectedEndpointIds =
            new HashSet<>();

    private final ConnectionListener listener;

    private boolean connectionRequested = false;

    private ConnectionLifecycleCallback connectionLifecycleCallback;
    private PayloadCallback payloadCallback;
    private EndpointDiscoveryCallback endpointDiscoveryCallback;

    public interface ConnectionListener {

        void onPlayerCountChanged(int playerCount);

        void onGameFound();

        void onGameStarted(String deckName);

        void onConnectionFailed();
    }

    public OfflineGameConnection(
            Context context,
            ConnectionListener listener) {

        this.listener = listener;

        connectionsClient =
                Nearby.getConnectionsClient(context);

        // RECEIVES DATA
        payloadCallback = new PayloadCallback() {

            @Override
            public void onPayloadReceived(
                    String endpointId,
                    Payload payload) {

                if (payload.getType() != Payload.Type.BYTES) {
                    return;
                }

                byte[] bytes = payload.asBytes();

                if (bytes == null) {
                    return;
                }

                String message =
                        new String(
                                bytes,
                                StandardCharsets.UTF_8
                        );

                if (message.startsWith(START_GAME_PREFIX)) {

                    String deckName =
                            message.substring(
                                    START_GAME_PREFIX.length()
                            );

                    listener.onGameStarted(deckName);
                }
            }

            @Override
            public void onPayloadTransferUpdate(
                    String endpointId,
                    PayloadTransferUpdate update) {
            }
        };

        // CONNECTION EVENTS
        connectionLifecycleCallback =
                new ConnectionLifecycleCallback() {

                    @Override
                    public void onConnectionInitiated(
                            String endpointId,
                            ConnectionInfo connectionInfo) {

                        /*
                         * Maximum 4 players total.
                         * Host + 3 connected players.
                         */
                        if (connectedEndpointIds.size() >= 3) {

                            connectionsClient.rejectConnection(
                                    endpointId
                            );

                            return;
                        }

                        connectionsClient.acceptConnection(
                                endpointId,
                                payloadCallback
                        );
                    }

                    @Override
                    public void onConnectionResult(
                            String endpointId,
                            ConnectionResolution result) {

                        if (result.getStatus().isSuccess()) {

                            connectedEndpointIds.add(
                                    endpointId
                            );

                            listener.onPlayerCountChanged(
                                    connectedEndpointIds.size() + 1
                            );

                        } else {

                            listener.onConnectionFailed();
                        }
                    }

                    @Override
                    public void onDisconnected(
                            String endpointId) {

                        connectedEndpointIds.remove(
                                endpointId
                        );

                        listener.onPlayerCountChanged(
                                connectedEndpointIds.size() + 1
                        );
                    }
                };

        // DISCOVERY
        endpointDiscoveryCallback =
                new EndpointDiscoveryCallback() {

                    @Override
                    public void onEndpointFound(
                            String endpointId,
                            DiscoveredEndpointInfo info) {

                        if (connectionRequested) {
                            return;
                        }

                        connectionRequested = true;

                        listener.onGameFound();

                        connectionsClient.requestConnection(
                                "SUPER ULTIMA",
                                endpointId,
                                connectionLifecycleCallback
                        );
                    }

                    @Override
                    public void onEndpointLost(
                            String endpointId) {
                    }
                };
    }

    // HOST
    public void startAdvertising() {

        AdvertisingOptions options =
                new AdvertisingOptions.Builder()
                        .setStrategy(Strategy.P2P_STAR)
                        .build();

        connectionsClient.startAdvertising(
                "SUPER ULTIMA",
                SERVICE_ID,
                connectionLifecycleCallback,
                options
        );
    }

    // JOINING PLAYER
    public void startDiscovery() {

        DiscoveryOptions options =
                new DiscoveryOptions.Builder()
                        .setStrategy(Strategy.P2P_STAR)
                        .build();

        connectionsClient.startDiscovery(
                SERVICE_ID,
                endpointDiscoveryCallback,
                options
        );
    }

    // STOP HOSTING
    public void stopAdvertising() {

        connectionsClient.stopAdvertising();
    }

    // STOP SEARCHING
    public void stopDiscovery() {

        connectionsClient.stopDiscovery();
    }

    // SEND START COMMAND TO ALL CONNECTED PLAYERS
    public void startGame(String deckName) {

        String message =
                START_GAME_PREFIX + deckName;

        Payload payload =
                Payload.fromBytes(
                        message.getBytes(
                                StandardCharsets.UTF_8
                        )
                );

        connectionsClient.sendPayload(
                new ArrayList<>(connectedEndpointIds),
                payload
        );
    }

    public int getPlayerCount() {

        return connectedEndpointIds.size() + 1;
    }
}