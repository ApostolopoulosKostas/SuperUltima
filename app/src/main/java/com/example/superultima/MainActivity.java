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

        // Permission launcher setup...
        nearbyPermissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestMultiplePermissions(),
                result -> {
                    boolean bluetoothScan = Boolean.TRUE.equals(result.get(Manifest.permission.BLUETOOTH_SCAN));
                    boolean bluetoothConnect = Boolean.TRUE.equals(result.get(Manifest.permission.BLUETOOTH_CONNECT));
                    boolean bluetoothAdvertise = Boolean.TRUE.equals(result.get(Manifest.permission.BLUETOOTH_ADVERTISE));

                    if (bluetoothScan && bluetoothConnect && bluetoothAdvertise) {
                        if (pendingAction == 1) {
                            pendingAction = 0;
                            createGame();
                        } else if (pendingAction == 2) {
                            pendingAction = 0;
                            joinGame();
                        }
                    } else {
                        pendingAction = 0;
                        showMessage("PERMISSION REQUIRED", "Nearby devices permission is required to create or join a game.");
                    }
                }
        );

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                }
        );

        // 1. PLAY NOW BUTTON
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("PLAY GAME");
            builder.setItems(
                    new String[]{"CREATE GAME", "JOIN GAME"},
                    (dialog, which) -> {
                        if (which == 0) {
                            createGameWithPermission();
                        } else {
                            joinGameWithPermission();
                        }
                    }
            );
            builder.setNegativeButton("Cancel", null);
            builder.show();
        });

        // 2. BROWSE ALL CARDS BUTTON (Navigates to CardActivity now)
        Button browseCardsButton = findViewById(R.id.browseCardsButton);
        browseCardsButton.setOnClickListener(v -> {
            List<CardInfo> deck = new AirplanesDeck().getCards();
            Intent intent = new Intent(MainActivity.this, CardActivity.class);
            intent.putExtra("deck", new ArrayList<>(deck));
            startActivity(intent);
        });

        // 3. RULES BUTTON
        Button rulesButton = findViewById(R.id.rulesButton);
        rulesButton.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("GAME RULES")
                    .setMessage("1. Select a stat from your active card.\n" +
                            "2. The player with the highest stat value wins the round.\n" +
                            "3. Collect all cards in the deck to win!")
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
    private void createGameWithPermission() {
        if (hasNearbyPermissions()) {
            createGame();
        } else {
            pendingAction = 1;
            requestNearbyPermissions();
        }
    }

    private void joinGameWithPermission() {
        if (hasNearbyPermissions()) {
            joinGame();
        } else {
            pendingAction = 2;
            requestNearbyPermissions();
        }
    }

    private boolean hasNearbyPermissions() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.S) {
            return true;
        }

        return checkSelfPermission(Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED
                && checkSelfPermission(Manifest.permission.BLUETOOTH_ADVERTISE) == PackageManager.PERMISSION_GRANTED;
    }

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

    private void createGame() {
        connection = OfflineGameConnection.getInstance(
                this,
                new OfflineGameConnection.ConnectionListener() {
                    @Override
                    public void onPlayerCountChanged(int playerCount) {
                        runOnUiThread(() -> {
                            if (waitingDialog != null) {
                                waitingDialog.setMessage("PLAYERS CONNECTED: " + playerCount + "\n\nWAITING FOR 2–4 PLAYERS");
                            }
                        });
                    }

                    @Override
                    public void onConnectionFailed() {
                        runOnUiThread(() -> showMessage("CONNECTION FAILED", "A player could not connect."));
                    }
                }
        );

        connection.startAdvertising();

        waitingDialog = new AlertDialog.Builder(this)
                .setTitle("CREATE GAME")
                .setMessage("PLAYERS CONNECTED: 1\n\nWAITING FOR 2–4 PLAYERS")
                .setPositiveButton("START", null)
                .setNegativeButton("CANCEL", (dialog, which) -> {
                    connection.stopAdvertising();
                    waitingDialog = null;
                })
                .create();

        waitingDialog.setOnShowListener(dialog -> {
            Button startButton = waitingDialog.getButton(AlertDialog.BUTTON_POSITIVE);
            startButton.setOnClickListener(v -> selectDeck());
        });

        waitingDialog.show();
    }

    private void selectDeck() {
        String[] decks = {"AIRPLANES"};

        new AlertDialog.Builder(this)
                .setTitle("SELECT DECK")
                .setItems(decks, (dialog, which) -> {
                    if (which == 0) {
                        startSelectedDeck("AIRPLANES");
                    }
                })
                .setNegativeButton("CANCEL", null)
                .show();
    }

    private void startSelectedDeck(String deckName) {
        if (waitingDialog != null) {
            waitingDialog.dismiss();
            waitingDialog = null;
        }

        connection.stopAdvertising();
        connection.startGame(deckName);
        openGame(deckName);
    }

    private void joinGame() {
        connection = OfflineGameConnection.getInstance(
                this,
                new OfflineGameConnection.ConnectionListener() {
                    @Override
                    public void onGameFound() {
                        runOnUiThread(() -> showMessage("GAME FOUND", "Joining game..."));
                    }

                    @Override
                    public void onGameStarted(String deckName) {
                        runOnUiThread(() -> {
                            connection.stopDiscovery();
                            openGame(deckName);
                        });
                    }

                    @Override
                    public void onConnectionFailed() {
                        runOnUiThread(() -> showMessage("CONNECTION FAILED", "Could not join the game."));
                    }
                }
        );

        AlertDialog searchingDialog = new AlertDialog.Builder(this)
                .setTitle("JOIN GAME")
                .setMessage("SEARCHING FOR AVAILABLE GAMES...")
                .setNegativeButton("CANCEL", (dialog, which) -> connection.stopDiscovery())
                .create();

        searchingDialog.show();
        connection.startDiscovery();
    }

    private void openGame(String deckName) {
        if (!deckName.equals("AIRPLANES")) {
            return;
        }

        List<CardInfo> deck = new AirplanesDeck().getCards();

        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra("deck", new ArrayList<>(deck));
        startActivity(intent);
    }

    private void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}