package com.example.superultima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<CardInfo> selectedDeck;

    private OfflineGameConnection connection;

    private AlertDialog waitingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        // AIRPLANES PACK
        // Only for viewing the cards.
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

        // SYSTEM BAR INSETS
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

        // PLAY
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

                            createGame();

                        } else {

                            joinGame();
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
                                // the start message.
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

        // Tell the connected players to start.
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

                                // Joiner doesn't control
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
                new java.util.ArrayList<>(deck)
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