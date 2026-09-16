package com.example.superultima;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private OfflineGameConnection connection;

    // Host = Player 1
    // Guest = Player 2
    private int localPlayerId = 0;

    private AlertDialog activeResultDialog;

    private MaterialCardView[] statCards =
            new MaterialCardView[6];

    private TextView[] labelViews =
            new TextView[6];

    private TextView[] valueViews =
            new TextView[6];

    private List<String> currentStatKeys =
            new ArrayList<>();

    private boolean isBotMode = false;

    private boolean cpuTurnScheduled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.card);

        isBotMode =
                getIntent().getBooleanExtra(
                        "is_bot_mode",
                        false
                );

        game =
                (Game) getIntent().getSerializableExtra(
                        "game"
                );

        if (game == null) {

            new AlertDialog.Builder(this)
                    .setTitle("GAME ERROR")
                    .setMessage(
                            "Could not load the game."
                    )
                    .setPositiveButton(
                            "OK",
                            (dialog, which) -> finish()
                    )
                    .setCancelable(false)
                    .show();

            return;
        }

        connection =
                OfflineGameConnection.getInstance();

        // -------------------------------------------------
        // PLAYER ID
        // -------------------------------------------------

        if (connection != null
                && !connection.isHost()
                && !isBotMode) {

            localPlayerId = 1;
        } else {

            localPlayerId = 0;
        }

        // -------------------------------------------------
        // CONNECTION LISTENER
        // -------------------------------------------------

        if (connection != null
                && !isBotMode) {

            connection.setListener(
                    new OfflineGameConnection.ConnectionListener() {

                        @Override
                        public void onMoveReceived(
                                int statIndex) {

                            runOnUiThread(() ->
                                    executeRound(statIndex)
                            );
                        }

                        @Override
                        public void onNextRoundReceived() {

                            runOnUiThread(() ->
                                    advanceToNextRound()
                            );
                        }
                    }
            );
        }

        // -------------------------------------------------
        // HIDE NAVIGATION
        // -------------------------------------------------

        Button prevButton =
                findViewById(R.id.prevButton);

        Button homeButton =
                findViewById(R.id.homeButton);

        Button nextButton =
                findViewById(R.id.nextButton);

        if (prevButton != null) {
            prevButton.setVisibility(View.GONE);
        }

        if (homeButton != null) {
            homeButton.setVisibility(View.GONE);
        }

        if (nextButton != null) {
            nextButton.setVisibility(View.GONE);
        }

        // -------------------------------------------------
        // STAT UI
        // -------------------------------------------------

        for (int i = 0; i < 6; i++) {

            int cardId =
                    getResources().getIdentifier(
                            "statCard" + (i + 1),
                            "id",
                            getPackageName()
                    );

            int labelId =
                    getResources().getIdentifier(
                            "label" + (i + 1),
                            "id",
                            getPackageName()
                    );

            int valueId =
                    getResources().getIdentifier(
                            "value" + (i + 1),
                            "id",
                            getPackageName()
                    );

            statCards[i] =
                    findViewById(cardId);

            labelViews[i] =
                    findViewById(labelId);

            valueViews[i] =
                    findViewById(valueId);

            final int index = i;

            if (statCards[i] != null) {

                statCards[i].setClickable(true);
                statCards[i].setFocusable(true);

                statCards[i].setOnClickListener(
                        v -> selectStatistic(index)
                );
            }

            if (labelViews[i] != null) {

                labelViews[i].setOnClickListener(
                        v -> selectStatistic(index)
                );
            }

            if (valueViews[i] != null) {

                valueViews[i].setOnClickListener(
                        v -> selectStatistic(index)
                );
            }
        }

        displayCurrentCard();
        updateTurnUI();
    }

    // =================================================
    // TURN
    // =================================================

    private boolean isMyTurn() {

        return game.getCurrentPlayerTurn()
                == localPlayerId;
    }

    private void updateTurnUI() {

        if (isBotMode
                && game.getCurrentPlayerTurn() == 1) {

            disableStatCards();

            triggerCpuTurn();

            return;
        }

        if (isMyTurn()) {

            enableStatCards();

            return;
        }

        disableStatCards();
    }

    // =================================================
    // SELECT STAT
    // =================================================

    private void selectStatistic(
            int statisticPosition) {

        if (!isMyTurn()) {
            return;
        }

        disableStatCards();

        if (connection != null
                && !isBotMode) {

            connection.sendMove(
                    statisticPosition
            );
        }

        executeRound(
                statisticPosition
        );
    }

    // =================================================
    // EXECUTE ROUND
    // =================================================

    private void executeRound(
            int statisticPosition) {

        disableStatCards();

        int winnerIndex =
                game.playRound(
                        statisticPosition
                );

        if (game.isGameOver()) {

            int overallWinner =
                    game.getWinner();

            new AlertDialog.Builder(
                    GameActivity.this
            )
                    .setTitle("GAME OVER")
                    .setMessage(
                            "Player "
                                    + (overallWinner + 1)
                                    + " wins the game!"
                    )
                    .setCancelable(false)
                    .setPositiveButton(
                            "FINISH",
                            (dialog, which) ->
                                    finish()
                    )
                    .show();

            return;
        }

        boolean cpuWon =
                isBotMode
                        && winnerIndex == 1;

        AlertDialog.Builder builder =
                new AlertDialog.Builder(
                        GameActivity.this
                )
                        .setTitle("ROUND RESULT")
                        .setCancelable(false);

        if (cpuWon) {

            builder.setMessage(
                    "Player "
                            + (winnerIndex + 1)
                            + " won this round!\n\n"
                            + "CPU will continue..."
            );

            activeResultDialog =
                    builder.create();

            activeResultDialog.show();

            new android.os.Handler(
                    Looper.getMainLooper()
            ).postDelayed(
                    this::advanceToNextRound,
                    1500
            );

            return;
        }

        builder.setMessage(
                "Player "
                        + (winnerIndex + 1)
                        + " won this round!"
        );

        builder.setPositiveButton(
                "NEXT TURN",
                (dialog, which) -> {

                    if (connection != null
                            && !isBotMode) {

                        connection.sendNextRound();
                    }

                    advanceToNextRound();
                }
        );

        activeResultDialog =
                builder.create();

        activeResultDialog.show();
    }

    // =================================================
    // NEXT ROUND
    // =================================================

    private void advanceToNextRound() {

        if (activeResultDialog != null
                && activeResultDialog.isShowing()) {

            activeResultDialog.dismiss();
        }

        displayCurrentCard();
        updateTurnUI();
    }

    // =================================================
    // DISPLAY MY CARD
    // =================================================

    private void displayCurrentCard() {

        // IMPORTANT:
        // Each phone displays its OWN player's card.
        CardInfo currentCard =
                game.getPlayerCard(
                        localPlayerId
                );

        if (currentCard == null) {
            return;
        }

        TextView cardCode =
                findViewById(R.id.cardCode);

        if (cardCode != null) {
            cardCode.setText(
                    currentCard.code
            );
        }

        TextView cardName =
                findViewById(R.id.cardName);

        if (cardName != null) {
            cardName.setText(
                    currentCard.name
            );
        }

        TextView cardType =
                findViewById(R.id.cardType);

        if (cardType != null) {
            cardType.setText(
                    currentCard.type
            );
        }

        ImageView cardImage =
                findViewById(R.id.cardImage);

        if (cardImage != null) {

            cardImage.setImageResource(
                    currentCard.image
            );
        }

        currentStatKeys.clear();

        for (int i = 0; i < 6; i++) {

            CardInfo.Statistic stat =
                    currentCard.statistics[i];

            if (stat == null) {

                if (statCards[i] != null) {

                    statCards[i].setVisibility(
                            View.GONE
                    );
                }

                continue;
            }

            currentStatKeys.add(
                    stat.label
            );

            if (statCards[i] != null) {

                statCards[i].setVisibility(
                        View.VISIBLE
                );
            }

            if (labelViews[i] != null) {

                labelViews[i].setText(
                        stat.label.toUpperCase()
                );
            }

            if (valueViews[i] != null) {

                String text =
                        formatValue(
                                stat.value
                        );

                if (stat.unit != null
                        && !stat.unit.isEmpty()) {

                    text +=
                            " " + stat.unit;
                }

                valueViews[i].setText(
                        text
                );
            }
        }
    }

    // =================================================
    // FORMAT
    // =================================================

    private String formatValue(
            Object value) {

        if (value == null) {
            return "0";
        }

        return String.valueOf(value);
    }

    // =================================================
    // BUTTONS
    // =================================================

    private void disableStatCards() {

        for (MaterialCardView card :
                statCards) {

            if (card != null) {
                card.setEnabled(false);
            }
        }
    }

    private void enableStatCards() {

        for (MaterialCardView card :
                statCards) {

            if (card != null) {
                card.setEnabled(true);
            }
        }
    }

    // =================================================
    // CPU
    // =================================================

    private void triggerCpuTurn() {

        if (cpuTurnScheduled) {
            return;
        }

        cpuTurnScheduled = true;

        new android.os.Handler(
                Looper.getMainLooper()
        ).postDelayed(() -> {

            cpuTurnScheduled = false;

            if (!isBotMode) {
                return;
            }

            if (game.getCurrentPlayerTurn() != 1) {
                return;
            }

            CardInfo cpuCard =
                    game.getPlayerCard(1);

            if (cpuCard == null) {
                return;
            }

            int bestStatIndex =
                    CpuPlayer.getBestStatIndex(
                            cpuCard
                    );

            executeRound(
                    bestStatIndex
            );

        }, 1000);
    }
}