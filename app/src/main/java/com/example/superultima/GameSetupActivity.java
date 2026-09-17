package com.example.superultima;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.superultima.cardgame.CardInfo;
import com.example.superultima.cardgame.Game;
import com.example.superultima.decks.AirplanesDeck;
import com.example.superultima.decks.CarsDeck;
import com.example.superultima.networking.OfflineGameConnection;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

/**
 * GameSetupActivity allows the user to configure the game settings before starting.
 * Users can choose their role (Host or Joiner), the game mode (VS Bot or Multiplayer),
 * the number of players, and the card deck theme.
 */
public class GameSetupActivity extends AppCompatActivity {

    // UI Buttons for configuration
    private MaterialButton btnRoleHost;
    private MaterialButton btnRoleJoin;
    private MaterialButton btnModeBot;
    private MaterialButton btnModePassPlay;
    private MaterialButton btn2Players;
    private MaterialButton btn3Players;
    private MaterialButton btn4Players;
    private MaterialButton btnStartDuel;
    private MaterialButton btnCancel;

    // UI elements for deck selection and info display
    private Spinner deckSpinner;
    private TextView deckInfoText;

    /** The list of cards for the chosen deck theme. */
    private List<CardInfo> selectedDeckCards = new ArrayList<>();

    // State variables for game configuration
    private boolean isHosting = true;
    private boolean isBotMode = true;
    private int selectedPlayerCount = 2;
    private boolean hostIsReadyToStart = false;

    /**
     * Handles the result of the nearby devices permission request.
     * Required for multiplayer mode using Nearby Connections.
     */
    private final ActivityResultLauncher<String[]> nearbyPermissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestMultiplePermissions(),
                    result -> {
                        if (hasNearbyPermissions()) {
                            // Permission granted: Switch to multiplayer mode setup.
                            isBotMode = false;
                            updateModeSelection();
                        } else {
                            // Permission denied: Inform the user.
                            new AlertDialog.Builder(this)
                                    .setTitle("NEARBY PERMISSION REQUIRED")
                                    .setMessage("Nearby devices permission is required for multiplayer.")
                                    .setPositiveButton("OK", null)
                                    .show();
                        }
                    }
            );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_setup);

        // Initialize UI component references
        initializeViews();

        // Configure the deck selection spinner
        setupDeckSpinner();

        // Set up click listeners for role, mode, and player count selection
        setupSelectionListeners();

        // Initial UI update to match default state
        updateRoleSelection();
        updateModeSelection();
        updatePlayerCountSelection();
    }

    /** Binds UI elements from the layout. */
    private void initializeViews() {
        btnRoleHost = findViewById(R.id.btnRoleHost);
        btnRoleJoin = findViewById(R.id.btnRoleJoin);
        btnModeBot = findViewById(R.id.btnModeBot);
        btnModePassPlay = findViewById(R.id.btnModePassPlay);
        btn2Players = findViewById(R.id.btn2Players);
        btn3Players = findViewById(R.id.btn3Players);
        btn4Players = findViewById(R.id.btn4Players);
        btnStartDuel = findViewById(R.id.btnStartDuel);
        btnCancel = findViewById(R.id.btnCancel);
        deckSpinner = findViewById(R.id.deckSpinner);
        deckInfoText = findViewById(R.id.deckInfoText);
    }

    /** Configures the spinner used to select between different card decks. */
    private void setupDeckSpinner() {
        String[] deckThemes = {"Airplanes", "Cars"};

        // Custom adapter to style the spinner text and dropdown
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        deckThemes) {
                    @Override
                    public View getView(int position, View convertView, ViewGroup parent) {
                        TextView view = (TextView) super.getView(position, convertView, parent);
                        view.setTextColor(Color.WHITE);
                        view.setTextSize(14f);
                        return view;
                    }

                    @Override
                    public View getDropDownView(int position, View convertView, ViewGroup parent) {
                        TextView view = (TextView) super.getView(position, convertView, parent);
                        view.setTextColor(Color.WHITE);
                        view.setBackgroundColor(Color.parseColor("#171C24"));
                        view.setPadding(24, 24, 24, 24);
                        return view;
                    }
                };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deckSpinner.setAdapter(adapter);

        // Update the selectedDeckCards list when a theme is picked
        deckSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTheme = parent.getItemAtPosition(position).toString();
                if (selectedTheme.equals("Airplanes")) {
                    selectedDeckCards = new AirplanesDeck().getCards();
                } else if (selectedTheme.equals("Cars")) {
                    selectedDeckCards = new CarsDeck().getCards();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedDeckCards = new AirplanesDeck().getCards();
            }
        });
    }

    /** Sets up click listeners for all configuration buttons. */
    private void setupSelectionListeners() {
        btnRoleHost.setOnClickListener(v -> {
            isHosting = true;
            hostIsReadyToStart = false;
            updateRoleSelection();
        });

        btnRoleJoin.setOnClickListener(v -> {
            isHosting = false;
            hostIsReadyToStart = false;
            updateRoleSelection();
        });

        btnModeBot.setOnClickListener(v -> {
            isBotMode = true;
            hostIsReadyToStart = false;
            updateModeSelection();
        });

        btnModePassPlay.setOnClickListener(v -> {
            if (hasNearbyPermissions()) {
                isBotMode = false;
                updateModeSelection();
            } else {
                requestNearbyPermissions();
            }
        });

        btn2Players.setOnClickListener(v -> {
            selectedPlayerCount = 2;
            hostIsReadyToStart = false;
            updatePlayerCountSelection();
        });

        btn3Players.setOnClickListener(v -> {
            selectedPlayerCount = 3;
            hostIsReadyToStart = false;
            updatePlayerCountSelection();
        });

        btn4Players.setOnClickListener(v -> {
            selectedPlayerCount = 4;
            hostIsReadyToStart = false;
            updatePlayerCountSelection();
        });

        btnStartDuel.setOnClickListener(v -> handleStartDuelAction());
        btnCancel.setOnClickListener(v -> finish());
    }

    /** Updates the Role selection UI (Host vs Joiner). */
    private void updateRoleSelection() {
        int yellow = Color.parseColor("#FFD700");
        int darkBg = Color.parseColor("#1E232A");

        if (isHosting) {
            btnRoleHost.setBackgroundTintList(ColorStateList.valueOf(yellow));
            btnRoleHost.setTextColor(Color.BLACK);
            btnRoleJoin.setBackgroundTintList(ColorStateList.valueOf(darkBg));
            btnRoleJoin.setTextColor(Color.WHITE);
            btnStartDuel.setText("START DUEL");
            deckInfoText.setText("ROLE: HOST. CONFIGURE GAME.");
        } else {
            btnRoleJoin.setBackgroundTintList(ColorStateList.valueOf(yellow));
            btnRoleJoin.setTextColor(Color.BLACK);
            btnRoleHost.setBackgroundTintList(ColorStateList.valueOf(darkBg));
            btnRoleHost.setTextColor(Color.WHITE);
            btnStartDuel.setText("SEARCH & JOIN");
            deckInfoText.setText("ROLE: JOINER. SEARCH FOR HOST.");
        }
    }

    /** Updates the Game Mode UI (Bot vs Pass & Play/Nearby). */
    private void updateModeSelection() {
        int yellow = Color.parseColor("#FFD700");
        int darkBg = Color.parseColor("#1E232A");

        if (isBotMode) {
            btnModeBot.setBackgroundTintList(ColorStateList.valueOf(yellow));
            btnModeBot.setTextColor(Color.BLACK);
            btnModePassPlay.setBackgroundTintList(ColorStateList.valueOf(darkBg));
            btnModePassPlay.setTextColor(Color.WHITE);
            deckInfoText.setText("MODE: VS BOT / CPU SELECTED.");
        } else {
            btnModePassPlay.setBackgroundTintList(ColorStateList.valueOf(yellow));
            btnModePassPlay.setTextColor(Color.BLACK);
            btnModeBot.setBackgroundTintList(ColorStateList.valueOf(darkBg));
            btnModeBot.setTextColor(Color.WHITE);
            deckInfoText.setText("MODE: PASS & PLAY / NEARBY.");
        }
    }

    /** Updates the Player Count selection UI. */
    private void updatePlayerCountSelection() {
        int yellow = Color.parseColor("#FFD700");
        int darkBg = Color.parseColor("#1E232A");

        btn2Players.setBackgroundTintList(ColorStateList.valueOf(selectedPlayerCount == 2 ? yellow : darkBg));
        btn2Players.setTextColor(selectedPlayerCount == 2 ? Color.BLACK : Color.WHITE);
        
        btn3Players.setBackgroundTintList(ColorStateList.valueOf(selectedPlayerCount == 3 ? yellow : darkBg));
        btn3Players.setTextColor(selectedPlayerCount == 3 ? Color.BLACK : Color.WHITE);
        
        btn4Players.setBackgroundTintList(ColorStateList.valueOf(selectedPlayerCount == 4 ? yellow : darkBg));
        btn4Players.setTextColor(selectedPlayerCount == 4 ? Color.BLACK : Color.WHITE);
    }

    /** 
     * Handles the logic for the primary action button (Start, Wait, or Search).
     * The behavior depends on whether the user is playing against a bot, hosting, or joining.
     */
    private void handleStartDuelAction() {
        // Mode: VS BOT
        if (isBotMode) {
            Game botGame = new Game(selectedPlayerCount, selectedDeckCards);
            openGame(botGame, selectedPlayerCount, true);
            return;
        }

        // Mode: Multiplayer (Nearby Connections)
        OfflineGameConnection.ConnectionListener connectionListener = new OfflineGameConnection.ConnectionListener() {
            @Override
            public void onPlayerCountChanged(int playerCount) {
                runOnUiThread(() -> {
                    deckInfoText.setText("PLAYERS CONNECTED: " + playerCount + " / " + selectedPlayerCount);
                    if (isHosting && playerCount >= selectedPlayerCount) {
                        hostIsReadyToStart = true;
                        btnStartDuel.setEnabled(true);
                        btnStartDuel.setText("START DUEL");
                        deckInfoText.setText("ALL PLAYERS CONNECTED. PRESS START DUEL.");
                    }
                });
            }

            @Override
            public void onGameFound() {
                runOnUiThread(() -> deckInfoText.setText("HOST FOUND! CONNECTING..."));
            }

            @Override
            public void onConnectionFailed() {
                runOnUiThread(() -> {
                    btnStartDuel.setEnabled(true);
                    deckInfoText.setText("CONNECTION FAILED. TRY AGAIN.");
                });
            }

            @Override
            public void onGameStarted(String deckName, Game sharedGame) {
                runOnUiThread(() -> openGame(sharedGame, selectedPlayerCount, false));
            }
        };

        OfflineGameConnection connection = OfflineGameConnection.getInstance(this, connectionListener);

        if (isHosting) {
            if (!hostIsReadyToStart) {
                // Host starts advertising and waits for players
                connection.startAdvertising();
                btnStartDuel.setEnabled(false);
                deckInfoText.setText("WAITING FOR PLAYERS... (1/" + selectedPlayerCount + ")");
            } else {
                // Host starts the duel
                startHostGame();
            }
        } else {
            // Joiner starts searching for hosts
            connection.startDiscovery();
            btnStartDuel.setEnabled(false);
            deckInfoText.setText("SEARCHING FOR NEARBY HOST...");
        }
    }

    /** 
     * Final step for the host: creates the game object and broadcasts it to all connected peers.
     */
    private void startHostGame() {
        OfflineGameConnection connection = OfflineGameConnection.getInstance();
        if (connection == null) return;

        String deckName = deckSpinner.getSelectedItem().toString();
        
        // Game object is created once on the host and shared to ensure all players have the same deck state.
        Game sharedGame = new Game(selectedPlayerCount, selectedDeckCards);
        connection.startGame(deckName, sharedGame);
        connection.stopAdvertising();

        openGame(sharedGame, selectedPlayerCount, false);
    }

    /** Launches the GameActivity with the configured game state. */
    private void openGame(Game game, int playerCount, boolean botMode) {
        Intent intent = new Intent(GameSetupActivity.this, GameActivity.class);
        intent.putExtra("game", game);
        intent.putExtra("player_count", playerCount);
        intent.putExtra("is_bot_mode", botMode);
        startActivity(intent);
    }

    /** Checks if the app has the necessary permissions for Nearby Connections based on Android version. */
    private boolean hasNearbyPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            boolean scan = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_SCAN) == PackageManager.PERMISSION_GRANTED;
            boolean connect = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED;
            boolean advertise = ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_ADVERTISE) == PackageManager.PERMISSION_GRANTED;
            if (!scan || !connect || !advertise) return false;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ContextCompat.checkSelfPermission(this, Manifest.permission.NEARBY_WIFI_DEVICES) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    /** Requests the required permissions for Nearby Connections. */
    private void requestNearbyPermissions() {
        ArrayList<String> permissions = new ArrayList<>();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions.add(Manifest.permission.BLUETOOTH_SCAN);
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT);
            permissions.add(Manifest.permission.BLUETOOTH_ADVERTISE);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions.add(Manifest.permission.NEARBY_WIFI_DEVICES);
        }
        if (!permissions.isEmpty()) {
            nearbyPermissionLauncher.launch(permissions.toArray(new String[0]));
        }
    }
}
