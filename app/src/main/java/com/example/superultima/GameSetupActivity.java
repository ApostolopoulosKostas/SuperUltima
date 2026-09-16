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

import com.example.superultima.Decks.AirplanesDeck;
import com.example.superultima.Decks.CarsDeck;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class GameSetupActivity extends AppCompatActivity {

    private MaterialButton btnRoleHost;
    private MaterialButton btnRoleJoin;

    private MaterialButton btnModeBot;
    private MaterialButton btnModePassPlay;

    private MaterialButton btn2Players;
    private MaterialButton btn3Players;
    private MaterialButton btn4Players;

    private MaterialButton btnStartDuel;
    private MaterialButton btnCancel;

    private Spinner deckSpinner;
    private TextView deckInfoText;

    private List<CardInfo> selectedDeckCards =
            new ArrayList<>();

    private boolean isHosting = true;
    private boolean isBotMode = true;

    private int selectedPlayerCount = 2;

    private boolean hostIsReadyToStart = false;

    // -------------------------------------------------
    // NEARBY PERMISSION
    // -------------------------------------------------

    private final ActivityResultLauncher<String[]> nearbyPermissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestMultiplePermissions(),
                    result -> {

                        if (hasNearbyPermissions()) {

                            isBotMode = false;
                            updateModeSelection();

                        } else {

                            new AlertDialog.Builder(this)
                                    .setTitle(
                                            "NEARBY PERMISSION REQUIRED"
                                    )
                                    .setMessage(
                                            "Nearby devices permission is " +
                                                    "required for Pass & Play."
                                    )
                                    .setPositiveButton(
                                            "OK",
                                            null
                                    )
                                    .show();
                        }
                    }
            );

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_game_setup
        );

        // -------------------------------------------------
        // VIEWS
        // -------------------------------------------------

        btnRoleHost =
                findViewById(R.id.btnRoleHost);

        btnRoleJoin =
                findViewById(R.id.btnRoleJoin);

        btnModeBot =
                findViewById(R.id.btnModeBot);

        btnModePassPlay =
                findViewById(R.id.btnModePassPlay);

        btn2Players =
                findViewById(R.id.btn2Players);

        btn3Players =
                findViewById(R.id.btn3Players);

        btn4Players =
                findViewById(R.id.btn4Players);

        btnStartDuel =
                findViewById(R.id.btnStartDuel);

        btnCancel =
                findViewById(R.id.btnCancel);

        deckSpinner =
                findViewById(R.id.deckSpinner);

        deckInfoText =
                findViewById(R.id.deckInfoText);

        // -------------------------------------------------
        // DECK SPINNER
        // -------------------------------------------------

        String[] deckThemes = {
                "Airplanes",
                "Cars"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        deckThemes) {

                    @Override
                    public View getView(
                            int position,
                            View convertView,
                            ViewGroup parent) {

                        TextView view =
                                (TextView) super.getView(
                                        position,
                                        convertView,
                                        parent
                                );

                        view.setTextColor(Color.WHITE);
                        view.setTextSize(14f);

                        return view;
                    }

                    @Override
                    public View getDropDownView(
                            int position,
                            View convertView,
                            ViewGroup parent) {

                        TextView view =
                                (TextView) super.getView(
                                        position,
                                        convertView,
                                        parent
                                );

                        view.setTextColor(Color.WHITE);

                        view.setBackgroundColor(
                                Color.parseColor(
                                        "#171C24"
                                )
                        );

                        view.setPadding(
                                24,
                                24,
                                24,
                                24
                        );

                        return view;
                    }
                };

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        deckSpinner.setAdapter(adapter);

        deckSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        String selectedTheme =
                                parent
                                        .getItemAtPosition(
                                                position
                                        )
                                        .toString();

                        if (selectedTheme.equals(
                                "Airplanes")) {

                            selectedDeckCards =
                                    new AirplanesDeck()
                                            .getCards();

                        } else if (selectedTheme.equals(
                                "Cars")) {

                            selectedDeckCards =
                                    new CarsDeck()
                                            .getCards();
                        }
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {

                        selectedDeckCards =
                                new AirplanesDeck()
                                        .getCards();
                    }
                }
        );

        // -------------------------------------------------
        // ROLE
        // -------------------------------------------------

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

        // -------------------------------------------------
        // MODE
        // -------------------------------------------------

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

        // -------------------------------------------------
        // PLAYER COUNT
        // -------------------------------------------------

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

        // -------------------------------------------------
        // START
        // -------------------------------------------------

        btnStartDuel.setOnClickListener(
                v -> handleStartDuelAction()
        );

        // -------------------------------------------------
        // CANCEL
        // -------------------------------------------------

        btnCancel.setOnClickListener(
                v -> finish()
        );

        updateRoleSelection();
        updateModeSelection();
        updatePlayerCountSelection();
    }

    // =================================================
    // ROLE UI
    // =================================================

    private void updateRoleSelection() {

        int yellow =
                Color.parseColor("#FFD700");

        int darkBg =
                Color.parseColor("#1E232A");

        int black =
                Color.BLACK;

        int white =
                Color.WHITE;

        if (isHosting) {

            btnRoleHost.setBackgroundTintList(
                    ColorStateList.valueOf(yellow)
            );

            btnRoleHost.setTextColor(black);

            btnRoleJoin.setBackgroundTintList(
                    ColorStateList.valueOf(darkBg)
            );

            btnRoleJoin.setTextColor(white);

            btnStartDuel.setText(
                    "START DUEL"
            );

            deckInfoText.setText(
                    "ROLE: HOST. CONFIGURE GAME."
            );

        } else {

            btnRoleJoin.setBackgroundTintList(
                    ColorStateList.valueOf(yellow)
            );

            btnRoleJoin.setTextColor(black);

            btnRoleHost.setBackgroundTintList(
                    ColorStateList.valueOf(darkBg)
            );

            btnRoleHost.setTextColor(white);

            btnStartDuel.setText(
                    "SEARCH & JOIN"
            );

            deckInfoText.setText(
                    "ROLE: JOINER. SEARCH FOR HOST."
            );
        }
    }

    // =================================================
    // MODE UI
    // =================================================

    private void updateModeSelection() {

        int yellow =
                Color.parseColor("#FFD700");

        int darkBg =
                Color.parseColor("#1E232A");

        int black =
                Color.BLACK;

        int white =
                Color.WHITE;

        if (isBotMode) {

            btnModeBot.setBackgroundTintList(
                    ColorStateList.valueOf(yellow)
            );

            btnModeBot.setTextColor(black);

            btnModePassPlay.setBackgroundTintList(
                    ColorStateList.valueOf(darkBg)
            );

            btnModePassPlay.setTextColor(white);

            deckInfoText.setText(
                    "MODE: VS BOT / CPU SELECTED."
            );

        } else {

            btnModePassPlay.setBackgroundTintList(
                    ColorStateList.valueOf(yellow)
            );

            btnModePassPlay.setTextColor(black);

            btnModeBot.setBackgroundTintList(
                    ColorStateList.valueOf(darkBg)
            );

            btnModeBot.setTextColor(white);

            deckInfoText.setText(
                    "MODE: PASS & PLAY / NEARBY."
            );
        }
    }

    // =================================================
    // PLAYER COUNT UI
    // =================================================

    private void updatePlayerCountSelection() {

        int yellow =
                Color.parseColor("#FFD700");

        int darkBg =
                Color.parseColor("#1E232A");

        int black =
                Color.BLACK;

        int white =
                Color.WHITE;

        MaterialButton[] buttons = {
                btn2Players,
                btn3Players,
                btn4Players
        };

        for (MaterialButton button :
                buttons) {

            button.setBackgroundTintList(
                    ColorStateList.valueOf(
                            darkBg
                    )
            );

            button.setTextColor(white);
        }

        MaterialButton selectedButton;

        if (selectedPlayerCount == 2) {

            selectedButton = btn2Players;

        } else if (selectedPlayerCount == 3) {

            selectedButton = btn3Players;

        } else {

            selectedButton = btn4Players;
        }

        selectedButton.setBackgroundTintList(
                ColorStateList.valueOf(
                        yellow
                )
        );

        selectedButton.setTextColor(
                black
        );
    }

    // =================================================
    // START ACTION
    // =================================================

    private void handleStartDuelAction() {

        // ---------------------------------------------
        // BOT MODE
        // ---------------------------------------------

        if (isBotMode) {

            Game botGame =
                    new Game(
                            selectedPlayerCount,
                            selectedDeckCards
                    );

            openGame(
                    botGame,
                    selectedPlayerCount,
                    true
            );

            return;
        }

        // ---------------------------------------------
        // CONNECTION LISTENER
        // ---------------------------------------------

        OfflineGameConnection.ConnectionListener
                connectionListener =
                new OfflineGameConnection.ConnectionListener() {

                    @Override
                    public void onPlayerCountChanged(
                            int playerCount) {

                        runOnUiThread(() -> {

                            deckInfoText.setText(
                                    "PLAYERS CONNECTED: "
                                            + playerCount
                                            + " / "
                                            + selectedPlayerCount
                            );

                            if (isHosting
                                    && playerCount
                                    >= selectedPlayerCount) {

                                hostIsReadyToStart =
                                        true;

                                btnStartDuel.setEnabled(
                                        true
                                );

                                btnStartDuel.setText(
                                        "START DUEL"
                                );

                                deckInfoText.setText(
                                        "ALL PLAYERS CONNECTED. "
                                                + "PRESS START DUEL."
                                );
                            }
                        });
                    }

                    @Override
                    public void onGameFound() {

                        runOnUiThread(() ->
                                deckInfoText.setText(
                                        "HOST FOUND! CONNECTING..."
                                )
                        );
                    }

                    @Override
                    public void onConnectionFailed() {

                        runOnUiThread(() -> {

                            btnStartDuel.setEnabled(
                                    true
                            );

                            deckInfoText.setText(
                                    "CONNECTION FAILED. TRY AGAIN."
                            );
                        });
                    }

                    @Override
                    public void onGameStarted(
                            String deckName,
                            Game sharedGame) {

                        runOnUiThread(() -> {

                            // The host sent us the actual
                            // Game object.
                            // DO NOT create another Game.

                            openGame(
                                    sharedGame,
                                    selectedPlayerCount,
                                    false
                            );
                        });
                    }
                };

        OfflineGameConnection connection =
                OfflineGameConnection.getInstance(
                        this,
                        connectionListener
                );

        // ---------------------------------------------
        // HOST
        // ---------------------------------------------

        if (isHosting) {

            if (!hostIsReadyToStart) {

                connection.startAdvertising();

                btnStartDuel.setEnabled(false);

                deckInfoText.setText(
                        "WAITING FOR PLAYERS... (1/"
                                + selectedPlayerCount
                                + ")"
                );

                return;
            }

            startHostGame();

            return;
        }

        // ---------------------------------------------
        // JOINER
        // ---------------------------------------------

        connection.startDiscovery();

        btnStartDuel.setEnabled(false);

        deckInfoText.setText(
                "SEARCHING FOR NEARBY HOST..."
        );
    }

    // =================================================
    // HOST STARTS GAME
    // =================================================

    private void startHostGame() {

        OfflineGameConnection connection =
                OfflineGameConnection.getInstance();

        if (connection == null) {
            return;
        }

        String deckName =
                deckSpinner
                        .getSelectedItem()
                        .toString();

        // THIS GAME IS CREATED ONLY ON THE HOST.
        Game sharedGame =
                new Game(
                        selectedPlayerCount,
                        selectedDeckCards
                );

        // Send the exact same Game object
        // to every connected phone.
        connection.startGame(
                deckName,
                sharedGame
        );

        connection.stopAdvertising();

        // Host uses the exact same Game object.
        openGame(
                sharedGame,
                selectedPlayerCount,
                false
        );
    }

    // =================================================
    // OPEN GAME
    // =================================================

    private void openGame(
            Game game,
            int playerCount,
            boolean botMode) {

        Intent intent =
                new Intent(
                        GameSetupActivity.this,
                        GameActivity.class
                );

        intent.putExtra(
                "game",
                game
        );

        intent.putExtra(
                "player_count",
                playerCount
        );

        intent.putExtra(
                "is_bot_mode",
                botMode
        );

        startActivity(intent);
    }

    // =================================================
    // NEARBY PERMISSIONS
    // =================================================

    private boolean hasNearbyPermissions() {

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.S) {

            boolean scan =
                    ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.BLUETOOTH_SCAN
                    ) == PackageManager.PERMISSION_GRANTED;

            boolean connect =
                    ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.BLUETOOTH_CONNECT
                    ) == PackageManager.PERMISSION_GRANTED;

            boolean advertise =
                    ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.BLUETOOTH_ADVERTISE
                    ) == PackageManager.PERMISSION_GRANTED;

            if (!scan
                    || !connect
                    || !advertise) {

                return false;
            }
        }

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.TIRAMISU) {

            boolean wifi =
                    ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.NEARBY_WIFI_DEVICES
                    ) == PackageManager.PERMISSION_GRANTED;

            if (!wifi) {
                return false;
            }
        }

        return true;
    }

    private void requestNearbyPermissions() {

        ArrayList<String> permissions =
                new ArrayList<>();

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.S) {

            permissions.add(
                    Manifest.permission.BLUETOOTH_SCAN
            );

            permissions.add(
                    Manifest.permission.BLUETOOTH_CONNECT
            );

            permissions.add(
                    Manifest.permission.BLUETOOTH_ADVERTISE
            );
        }

        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.TIRAMISU) {

            permissions.add(
                    Manifest.permission.NEARBY_WIFI_DEVICES
            );
        }

        if (!permissions.isEmpty()) {

            nearbyPermissionLauncher.launch(
                    permissions.toArray(
                            new String[0]
                    )
            );
        }
    }
}