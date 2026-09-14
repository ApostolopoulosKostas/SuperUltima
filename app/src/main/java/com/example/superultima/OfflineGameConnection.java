package com.example.superultima;

import android.content.Context;

import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AdvertisingOptions;
import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;
import com.google.android.gms.nearby.connection.ConnectionsClient;
import com.google.android.gms.nearby.connection.Payload;
import com.google.android.gms.nearby.connection.PayloadCallback;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;
import com.google.android.gms.nearby.connection.Strategy;

public class OfflineGameConnection {

    private final Context context;
    private final ConnectionsClient connectionsClient;

    private ConnectionLifecycleCallback connectionLifecycleCallback;
    private PayloadCallback payloadCallback;

    public OfflineGameConnection(Context context) {

        this.context = context;

        connectionsClient = Nearby.getConnectionsClient(context);

        // Handles incoming data
        payloadCallback = new PayloadCallback() {

            @Override
            public void onPayloadReceived(
                    String endpointId,
                    Payload payload) {

            }

            @Override
            public void onPayloadTransferUpdate(
                    String endpointId,
                    PayloadTransferUpdate update) {

            }
        };

        // Handles connection events
        connectionLifecycleCallback =
                new ConnectionLifecycleCallback() {

                    @Override
                    public void onConnectionInitiated(
                            String endpointId,
                            ConnectionInfo connectionInfo) {

                        connectionsClient.acceptConnection(
                                endpointId,
                                payloadCallback
                        );
                    }

                    @Override
                    public void onConnectionResult(
                            String endpointId,
                            ConnectionResolution result) {

                    }

                    @Override
                    public void onDisconnected(
                            String endpointId) {

                    }
                };
    }

    public void startAdvertising() {

        AdvertisingOptions advertisingOptions =
                new AdvertisingOptions.Builder()
                        .setStrategy(Strategy.P2P_STAR)
                        .build();

        connectionsClient.startAdvertising(
                "SUPER ULTIMA",
                "com.example.superultima",
                connectionLifecycleCallback,
                advertisingOptions
        );
    }

    public void stopAdvertising() {

        connectionsClient.stopAdvertising();
    }
}
