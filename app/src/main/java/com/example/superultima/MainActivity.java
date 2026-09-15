 package com.example.superultima;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CardInfo> selectedDeck;

    private OfflineGameConnection connection;

    private AlertDialog waitingDialog;

    /*
     * 0 = nothing
     * 1 = create game
     * 2 = join game
     */
    private int pendingAction = 0;

    private ActivityResultLauncher<String[]> nearbyPermissionLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // ---------------------------------------------------------
        // NEARBY DEVICES PERMISSION
        // ---------------------------------------------------------

        nearbyPermissionLauncher =
                registerForActivityResult(
                        new ActivityResultContracts.RequestMultiplePermissions(),
                        result -> {

                            boolean bluetoothScan =
                                    Boolean.TRUE.equals(
                                            result.get(
                                                    Manifest.permission.BLUETOOTH_SCAN
                                            )
                                    );

                            boolean bluetoothConnect =
                                    Boolean.TRUE.equals(
                                            result.get(
                                                    Manifest.permission.BLUETOOTH_CONNECT
                                            )
                                    );

                            boolean bluetoothAdvertise =
                                    Boolean.TRUE.equals(
                                            result.get(
                                                    Manifest.permission.BLUETOOTH_ADVERTISE
                                            )
                                    );

                            if (bluetoothScan &&
                                    bluetoothConnect &&
                                    bluetoothAdvertise) {

                                if (pendingAction == 1) {

                                    pendingAction = 0;
                                    createGame();

                                } else if (pendingAction == 2) {

                                    pendingAction = 0;
                                    joinGame();
                                }

                            } else {

                                pendingAction = 0;

                                showMessage(
                                        "PERMISSION REQUIRED",
                                        "Nearby devices permission is required to create or join a game."
                                );
                            }
                        }
                );

        // ---------------------------------------------------------
        // AIRPLANES PACK
        // Only for viewing the cards.
        // ---------------------------------------------------------

        MaterialCardView airplanesPack1 =
                findViewById(R.id.airplanesPack1);

        airplanesPack1.setOnClickListener(v -> {

            selectedDeck =
                    new AirplanesDeck().getCards();

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            CardActivity.class
                    );

            startActivity(intent);
        });

        // ---------------------------------------------------------
        // WINDOW INSETS
        // ---------------------------------------------------------

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // ---------------------------------------------------------
        // PLAY
        // ---------------------------------------------------------

        Button playButton =
                findViewById(R.id.playButton);

        playButton.setOnClickListener(v -> {

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(
                            MainActivity.this
                    );

            builder.setTitle("PLAY GAME");

            builder.setItems(
                    new String[]{
                            "CREATE GAME",
                            "JOIN GAME"
                    },
                    (dialog, which) -> {

                        if (which == 0) {

                            createGameWithPermission();

                        } else {

                            joinGameWithPermission();
                        }
                    }
            );

            builder.setNegativeButton(
                    "Cancel",
                    null
            );

            builder.show();
        });
    }

    // ---------------------------------------------------------
    // CREATE GAME - CHECK PERMISSION
    // ---------------------------------------------------------

    private void createGameWithPermission() {

        if (hasNearbyPermissions()) {

            createGame();

        } else {

            pendingAction = 1;
            requestNearbyPermissions();
        }
    }

    // ---------------------------------------------------------
    // JOIN GAME - CHECK PERMISSION
    // ---------------------------------------------------------

    private void joinGameWithPermission() {

        if (hasNearbyPermissions()) {

            joinGame();

        } else {

            pendingAction = 2;
            requestNearbyPermissions();
        }
    }

    // ---------------------------------------------------------
    // CHECK NEARBY PERMISSIONS
    // ---------------------------------------------------------

    private boolean hasNearbyPermissions() {

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return true;
        }

        return checkSelfPermission(
                Manifest.permission.BLUETOOTH_SCAN
        ) == PackageManager.PERMISSION_GRANTED

                &&

                checkSelfPermission(
                        Manifest.permission.BLUETOOTH_CONNECT
                ) == PackageManager.PERMISSION_GRANTED

                &&

                checkSelfPermission(
                        Manifest.permission.BLUETOOTH_ADVERTISE
                ) == PackageManager.PERMISSION_GRANTED;
    }

    // ---------------------------------------------------------
    // REQUEST NEARBY PERMISSIONS
    // ---------------------------------------------------------

    private void requestNearbyPermissions() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {

            nearbyPermissionLauncher.launch(
                    new String[]{
                            Manifest.permission.BLUETOOTH_SCAN,
                            Manifest.permission.BLUETOOTH_CONNECT,
                            Manifest.permission.BLUETOOTH_ADVERTISE
                    }
            );
        }
    }

    // ---------------------------------------------------------
    // CREATE GAME
    // ---------------------------------------------------------

    private void createGame() {

        connection =
                new OfflineGameConnection(
                        this,
                        new OfflineGameConnection.ConnectionListener() {

                            @Override
                            public void onPlayerCountChanged(
                                    int playerCount) {

                                runOnUiThread(() -> {

                                    if (waitingDialog != null) {

                                        waitingDialog.setMessage(
                                                "PLAYERS CONNECTED: "
                                                        + playerCount
                                                        + "\n\n"
                                                        + "WAITING FOR 2–4 PLAYERS"
                                        );
                                    }
                                });
                            }

                            @Override
                            public void onGameFound() {
                                // Host does not search.
                            }

                            @Override
                            public void onGameStarted(
                                    String deckName) {
                                // Host does not receive
                                // the start command.
                            }

                            @Override
                            public void onConnectionFailed() {

                                runOnUiThread(() ->
                                        showMessage(
                                                "CONNECTION FAILED",
                                                "A player could not connect."
                                        )
                                );
                            }
                        }
                );

        connection.startAdvertising();

        waitingDialog =
                new AlertDialog.Builder(this)
                        .setTitle("CREATE GAME")
                        .setMessage(
                                "PLAYERS CONNECTED: 1\n\n"
                                        + "WAITING FOR 2–4 PLAYERS"
                        )
                        .setPositiveButton(
                                "START",
                                null
                        )
                        .setNegativeButton(
                                "CANCEL",
                                (dialog, which) -> {

                                    connection.stopAdvertising();
                                    waitingDialog = null;
                                }
                        )
                        .create();

        waitingDialog.setOnShowListener(
                dialog -> {

                    Button startButton =
                            waitingDialog.getButton(
                                    AlertDialog.BUTTON_POSITIVE
                            );

                    startButton.setOnClickListener(
                            v -> selectDeck()
                    );
                }
        );

        waitingDialog.show();
    }

    // ---------------------------------------------------------
    // SELECT DECK
    // ---------------------------------------------------------

    private void selectDeck() {

        String[] decks = {
                "AIRPLANES"
        };

        new AlertDialog.Builder(this)
                .setTitle("SELECT DECK")
                .setItems(
                        decks,
                        (dialog, which) -> {

                            if (which == 0) {

                                startSelectedDeck(
                                        "AIRPLANES"
                                );
                            }
                        }
                )
                .setNegativeButton(
                        "CANCEL",
                        null
                )
                .show();
    }

    // ---------------------------------------------------------
    // START SELECTED DECK
    // ---------------------------------------------------------

    private void startSelectedDeck(
            String deckName) {

        if (waitingDialog != null) {

            waitingDialog.dismiss();
            waitingDialog = null;
        }

        connection.stopAdvertising();

        // Tell connected players to start.
        connection.startGame(deckName);

        // Start the host locally.
        openGame(deckName);
    }

    // ---------------------------------------------------------
    // JOIN GAME
    // ---------------------------------------------------------

    private void joinGame() {

        connection =
                new OfflineGameConnection(
                        this,
                        new OfflineGameConnection.ConnectionListener() {

                            @Override
                            public void onPlayerCountChanged(
                                    int playerCount) {

                                // Joiner does not control
                                // the player count.
                            }

                            @Override
                            public void onGameFound() {

                                runOnUiThread(() ->
                                        showMessage(
                                                "GAME FOUND",
                                                "Joining game..."
                                        )
                                );
                            }

                            @Override
                            public void onGameStarted(
                                    String deckName) {

                                runOnUiThread(() -> {

                                    connection.stopDiscovery();

                                    openGame(deckName);
                                });
                            }

                            @Override
                            public void onConnectionFailed() {

                                runOnUiThread(() ->
                                        showMessage(
                                                "CONNECTION FAILED",
                                                "Could not join the game."
                                        )
                                );
                            }
                        }
                );

        AlertDialog searchingDialog =
                new AlertDialog.Builder(this)
                        .setTitle("JOIN GAME")
                        .setMessage(
                                "SEARCHING FOR AVAILABLE GAMES..."
                        )
                        .setNegativeButton(
                                "CANCEL",
                                (dialog, which) ->
                                        connection.stopDiscovery()
                        )
                        .create();

        searchingDialog.show();

        connection.startDiscovery();
    }

    // ---------------------------------------------------------
    // OPEN GAME
    // ---------------------------------------------------------

    private void openGame(
            String deckName) {

        if (!deckName.equals("AIRPLANES")) {
            return;
        }

        List<CardInfo> deck =
                new AirplanesDeck().getCards();

        Intent intent =
                new Intent(
                        MainActivity.this,
                        GameActivity.class
                );

        intent.putExtra(
                "deck",
                new ArrayList<>(deck)
        );

        startActivity(intent);
    }

    // ---------------------------------------------------------
    // MESSAGE
    // ---------------------------------------------------------

    private void showMessage(
            String title,
            String message) {

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(
                        "OK",
                        null
                )
                .show();
    }
}
