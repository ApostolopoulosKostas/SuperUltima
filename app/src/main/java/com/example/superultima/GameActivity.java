package com.example.superultima;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.superultima.cardgame.CardInfo;
import com.example.superultima.cardgame.Game;
import com.example.superultima.cpu.CpuPlayer;
import com.example.superultima.networking.OfflineGameConnection;
import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * GameActivity manages the main gameplay screen.
 * It handles displaying the player's current card, statistic selection,
 * turn transitions, and synchronization between players (local, bot, or remote).
 */
public class GameActivity extends AppCompatActivity {

    private static final String TAG = "GameActivity";

    /** The core game logic instance, tracking decks and turns. */
    private Game game;

    /** Singleton manager for nearby device synchronization. */
    private OfflineGameConnection connection;

    /**
     * Local player index on this device.
     * Host = index 0, Guest = index 1.
     */
    private int localPlayerId = 0;

    /** UI containers for the 6 selectable statistics. */
    private MaterialCardView[] statCards = new MaterialCardView[6];

    /** TextViews for the labels of the statistics (e.g., Speed, Power). */
    private TextView[] labelViews = new TextView[6];

    /** TextViews for the actual values of the statistics. */
    private TextView[] valueViews = new TextView[6];

    /** Keeps a list of statistic labels available on the current card. */
    private List<String> currentStatKeys = new ArrayList<>();

    /** Flag identifying if we are playing against the CPU. */
    private boolean isBotMode = false;

    /** Prevents multiple CPU move calculations from triggering at once. */
    private boolean cpuTurnScheduled = false;

    /**
     * The card that was on screen when the player picked a statistic.
     * playRound() removes cards from play immediately, so we keep this
     * reference around to know the stat's label/unit for the result dialog.
     */
    private CardInfo lastDisplayedCard;

    // ---- Round result overlay ----

    private FrameLayout roundResultOverlay;
    private TextView vsPulseText;
    private LinearLayout resultRevealGroup;
    private TextView resultBanner;
    private TextView resultStatLabel;
    private LinearLayout resultValuesList;
    private TextView continuePrompt;

    /** Animates the "VS" suspense beat before the result reveals. */
    private ObjectAnimator pulseAnimator;

    /** True once the result has finished revealing. */
    private boolean resultRevealed = false;

    /** What happens when the player taps the overlay after the result is revealed. */
    private Runnable pendingOverlayContinueAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        // ============================================================
        // SYSTEM NAVIGATION BAR / EDGE-TO-EDGE HANDLING
        // ============================================================

        View root = findViewById(R.id.main);
        View cardTemplate = findViewById(R.id.cardTemplate);

        if (root != null && cardTemplate != null) {

            ViewCompat.setOnApplyWindowInsetsListener(root, (v, insets) -> {

                Insets systemBars = insets.getInsets(
                        WindowInsetsCompat.Type.systemBars()
                );

                // Keep the card above the Poco navigation area.
                androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
                        cardParams =
                        (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)
                                cardTemplate.getLayoutParams();

                cardParams.bottomMargin = dpToPx(16) + systemBars.bottom;

                cardTemplate.setLayoutParams(cardParams);

                return insets;
            });

            ViewCompat.requestApplyInsets(root);
        }

        // 1. Get Game Configuration from Intent (mode and game state).
        isBotMode = getIntent().getBooleanExtra("is_bot_mode", false);
        game = (Game) getIntent().getSerializableExtra("game");

        // 2. Error Check: If no game data was found, exit.
        if (game == null) {
            new AlertDialog.Builder(this)
                    .setTitle("GAME ERROR")
                    .setMessage("Could not load the game data.")
                    .setPositiveButton("OK", (dialog, which) -> finish())
                    .setCancelable(false)
                    .show();
            return;
        }

        // 3. Initialize Networking Singleton.
        connection = OfflineGameConnection.getInstance();

        // 4. Assign Local Player ID
        // In multiplayer, the guest device is Player 2 (index 1).
        if (connection != null && !connection.isHost() && !isBotMode) {
            localPlayerId = 1;
        } else {
            localPlayerId = 0;
        }

        // 5. Setup Networking Listener
        if (connection != null && !isBotMode) {
            connection.setListener(new OfflineGameConnection.ConnectionListener() {
                @Override
                public void onMoveReceived(int statIndex) {
                    runOnUiThread(() -> executeRound(statIndex));
                }

                @Override
                public void onNextRoundReceived() {
                    runOnUiThread(() -> hideOverlayAndAdvance());
                }
            });
        }

        // 6. Cleanup UI
        View prevButton = findViewById(R.id.prevButton);
        View homeButton = findViewById(R.id.homeButton);
        View nextButton = findViewById(R.id.nextButton);
        View readMoreButton = findViewById(R.id.readMoreButton);

        if (prevButton != null) prevButton.setVisibility(View.GONE);
        if (homeButton != null) homeButton.setVisibility(View.GONE);
        if (nextButton != null) nextButton.setVisibility(View.GONE);
        if (readMoreButton != null) readMoreButton.setVisibility(View.GONE);

        // 7. Bind UI Stat components and click listeners.
        int[] statCardIds = {
                R.id.statCard1,
                R.id.statCard2,
                R.id.statCard3,
                R.id.statCard4,
                R.id.statCard5,
                R.id.statCard6
        };

        int[] labelIds = {
                R.id.label1,
                R.id.label2,
                R.id.label3,
                R.id.label4,
                R.id.label5,
                R.id.label6
        };

        int[] valueIds = {
                R.id.value1,
                R.id.value2,
                R.id.value3,
                R.id.value4,
                R.id.value5,
                R.id.value6
        };

        for (int i = 0; i < 6; i++) {

            statCards[i] = findViewById(statCardIds[i]);
            labelViews[i] = findViewById(labelIds[i]);
            valueViews[i] = findViewById(valueIds[i]);

            final int index = i;

            if (statCards[i] != null) {
                statCards[i].setClickable(true);
                statCards[i].setFocusable(true);
                statCards[i].setOnClickListener(v -> selectStatistic(index));
            }

            if (labelViews[i] != null) {
                labelViews[i].setOnClickListener(v -> selectStatistic(index));
            }

            if (valueViews[i] != null) {
                valueViews[i].setOnClickListener(v -> selectStatistic(index));
            }
        }

        // 8. Load Initial State.
        displayCurrentCard();
        updateTurnUI();

        // 9. Set up the round result overlay.
        bindResultOverlayViews();
    }

    /**
     * Converts dp to pixels.
     */
    private int dpToPx(int dp) {
        return Math.round(
                dp * getResources().getDisplayMetrics().density
        );
    }

    /** Finds the round result overlay's views and wires up the tap-to-continue behavior. */
    private void bindResultOverlayViews() {
        roundResultOverlay = findViewById(R.id.roundResultOverlay);
        vsPulseText = findViewById(R.id.vsPulseText);
        resultRevealGroup = findViewById(R.id.resultRevealGroup);
        resultBanner = findViewById(R.id.resultBanner);
        resultStatLabel = findViewById(R.id.resultStatLabel);
        resultValuesList = findViewById(R.id.resultValuesList);
        continuePrompt = findViewById(R.id.continuePrompt);

        if (roundResultOverlay != null) {
            roundResultOverlay.setOnClickListener(v -> onResultOverlayTapped());
        }
    }

    // =================================================
    // TURN LOGIC
    // =================================================

    private boolean isMyTurn() {
        return game.getCurrentPlayerTurn() == localPlayerId;
    }

    private void updateTurnUI() {
        if (isBotMode && game.getCurrentPlayerTurn() == 1) {
            disableStatCards();
            triggerCpuTurn();
            return;
        }

        if (isMyTurn()) {
            enableStatCards();
        } else {
            disableStatCards();
        }
    }

    // =================================================
    // SELECT STATISTIC
    // =================================================

    private void selectStatistic(int statisticPosition) {
        if (!isMyTurn()) return;

        if (connection != null && !isBotMode) {
            connection.sendMove(statisticPosition);
        }

        executeRound(statisticPosition);
    }

    // =================================================
    // EXECUTE ROUND
    // =================================================

    private void executeRound(int statisticPosition) {
        disableStatCards();

        String statLabel = "STAT";
        String statUnit = "";

        if (lastDisplayedCard != null &&
                lastDisplayedCard.statistics[statisticPosition] != null) {

            CardInfo.Statistic selectedStat =
                    lastDisplayedCard.statistics[statisticPosition];

            statLabel = selectedStat.label;
            statUnit = (selectedStat.unit != null)
                    ? selectedStat.unit
                    : "";
        }

        Game.RoundResult result =
                game.playRound(statisticPosition);

        if (game.isGameOver()) {

            int overallWinner = game.getWinner();

            String comparisonText =
                    buildComparisonText(
                            statLabel,
                            statUnit,
                            result.statValues
                    );

            String outcome =
                    (overallWinner == localPlayerId)
                            ? "YOU WIN THE GAME!"
                            : "GAME OVER - YOU LOSE.";

            new AlertDialog.Builder(GameActivity.this)
                    .setTitle("GAME OVER")
                    .setMessage(comparisonText + "\n\n" + outcome)
                    .setCancelable(false)
                    .setPositiveButton(
                            "FINISH",
                            (dialog, which) -> finish()
                    )
                    .show();

            return;
        }

        int nextPicker =
                result.isTie()
                        ? game.getCurrentPlayerTurn()
                        : result.winnerIndex;

        boolean cpuContinues =
                isBotMode && nextPicker == 1;

        showRoundResultOverlay(
                result,
                statLabel,
                statUnit,
                cpuContinues
        );
    }

    // =================================================
    // ROUND RESULT OVERLAY
    // =================================================

    private void showRoundResultOverlay(
            Game.RoundResult result,
            String statLabel,
            String statUnit,
            boolean cpuContinues) {

        resultRevealed = false;
        pendingOverlayContinueAction = null;

        resultRevealGroup.setVisibility(View.GONE);

        vsPulseText.setVisibility(View.VISIBLE);
        vsPulseText.setText("COMPARING...");
        vsPulseText.setAlpha(1f);
        vsPulseText.setScaleX(1f);
        vsPulseText.setScaleY(1f);

        roundResultOverlay.setVisibility(View.VISIBLE);

        pulseAnimator =
                ObjectAnimator.ofFloat(
                        vsPulseText,
                        "scaleX",
                        1f,
                        1.1f,
                        1f
                );

        pulseAnimator.setDuration(500);
        pulseAnimator.setRepeatCount(ValueAnimator.INFINITE);
        pulseAnimator.start();

        ObjectAnimator pulseY =
                ObjectAnimator.ofFloat(
                        vsPulseText,
                        "scaleY",
                        1f,
                        1.1f,
                        1f
                );

        pulseY.setDuration(500);
        pulseY.setRepeatCount(ValueAnimator.INFINITE);
        pulseY.start();

        boolean tie = result.isTie();
        boolean localWon =
                !tie && result.winnerIndex == localPlayerId;

        new android.os.Handler(
                Looper.getMainLooper()
        ).postDelayed(
                () -> revealRoundResult(
                        result,
                        tie,
                        localWon,
                        statLabel,
                        statUnit,
                        cpuContinues
                ),
                700
        );
    }

    private void revealRoundResult(
            Game.RoundResult result,
            boolean tie,
            boolean localWon,
            String statLabel,
            String statUnit,
            boolean cpuContinues) {

        if (pulseAnimator != null) {
            pulseAnimator.cancel();
        }

        vsPulseText.setVisibility(View.GONE);

        if (tie) {
            resultBanner.setText("TIE!");
            resultBanner.setTextColor(0xFFFFD700);

        } else if (localWon) {
            resultBanner.setText("YOU WIN!");
            resultBanner.setTextColor(0xFF4CAF50);

        } else {
            resultBanner.setText("YOU LOSE");
            resultBanner.setTextColor(0xFFFF5555);
        }

        resultStatLabel.setText(
                statLabel.toUpperCase(Locale.getDefault())
        );

        resultValuesList.removeAllViews();

        double topValue = Double.NEGATIVE_INFINITY;

        for (double v : result.statValues) {
            if (!Double.isNaN(v) && v > topValue) {
                topValue = v;
            }
        }

        for (int i = 0; i < result.statValues.length; i++) {

            double value = result.statValues[i];

            if (Double.isNaN(value)) continue;

            String name =
                    (i == localPlayerId)
                            ? "YOU"
                            : (isBotMode && i == 1)
                            ? "CPU"
                            : "PLAYER " + (i + 1);

            String valueText =
                    formatValue(value)
                            + (statUnit.isEmpty()
                            ? ""
                            : " " + statUnit);

            TextView row = new TextView(this);

            row.setText(name + ": " + valueText);
            row.setTextSize(16f);
            row.setGravity(Gravity.CENTER);
            row.setPadding(0, 4, 0, 4);

            boolean hasTopValue =
                    (value == topValue);

            if (tie && hasTopValue) {
                row.setTextColor(0xFFFFD700);

            } else if (!tie && hasTopValue) {
                row.setTextColor(0xFF4CAF50);

            } else {
                row.setTextColor(0xFFFFFFFF);
            }

            resultValuesList.addView(row);
        }

        continuePrompt.setText(
                cpuContinues
                        ? "CPU IS THINKING..."
                        : "TAP TO CONTINUE"
        );

        resultRevealGroup.setRotationY(90f);
        resultRevealGroup.setAlpha(0f);
        resultRevealGroup.setVisibility(View.VISIBLE);

        resultRevealGroup.animate()
                .rotationY(0f)
                .alpha(1f)
                .setDuration(300)
                .setInterpolator(
                        new AccelerateDecelerateInterpolator()
                )
                .start();

        resultRevealed = true;

        if (cpuContinues) {

            pendingOverlayContinueAction =
                    this::hideOverlayAndAdvance;

            new android.os.Handler(
                    Looper.getMainLooper()
            ).postDelayed(
                    this::hideOverlayAndAdvance,
                    1500
            );

        } else {

            pendingOverlayContinueAction = () -> {

                if (connection != null && !isBotMode) {
                    connection.sendNextRound();
                }

                hideOverlayAndAdvance();
            };
        }
    }

    private void onResultOverlayTapped() {

        if (!resultRevealed) return;

        if (pendingOverlayContinueAction != null) {

            Runnable action =
                    pendingOverlayContinueAction;

            pendingOverlayContinueAction = null;

            action.run();
        }
    }

    private void hideOverlayAndAdvance() {

        if (roundResultOverlay != null) {
            roundResultOverlay.setVisibility(View.GONE);
        }

        if (resultRevealGroup != null) {
            resultRevealGroup.setVisibility(View.GONE);
        }

        proceedToNextTurn();
    }

    // =================================================
    // COMPARISON TEXT
    // =================================================

    private String buildComparisonText(
            String statLabel,
            String statUnit,
            double[] statValues) {

        StringBuilder sb =
                new StringBuilder(
                        statLabel.toUpperCase()
                );

        for (int i = 0; i < statValues.length; i++) {

            if (Double.isNaN(statValues[i])) continue;

            String playerName =
                    (isBotMode && i == 1)
                            ? "CPU"
                            : "Player " + (i + 1);

            String valueText =
                    formatValue(statValues[i]);

            if (!statUnit.isEmpty()) {
                valueText += " " + statUnit;
            }

            sb.append("\n")
                    .append(playerName)
                    .append(": ")
                    .append(valueText);
        }

        return sb.toString();
    }

    private void proceedToNextTurn() {
        displayCurrentCard();
        updateTurnUI();
    }

    // =================================================
    // DISPLAY CARD
    // =================================================

    private void displayCurrentCard() {

        CardInfo currentCard =
                game.getPlayerCard(localPlayerId);

        if (currentCard == null) return;

        lastDisplayedCard = currentCard;

        TextView cardCode =
                findViewById(R.id.cardCode);

        if (cardCode != null) {
            cardCode.setText(currentCard.code);
        }

        TextView cardName =
                findViewById(R.id.cardName);

        if (cardName != null) {
            cardName.setText(currentCard.name);
        }

        TextView cardType =
                findViewById(R.id.cardType);

        if (cardType != null) {
            cardType.setText(currentCard.type);
        }

        ImageView cardImage =
                findViewById(R.id.cardImage);

        if (cardImage != null) {
            cardImage.setImageResource(currentCard.image);
        }

        currentStatKeys.clear();

        for (int i = 0; i < 6; i++) {

            CardInfo.Statistic stat =
                    currentCard.statistics[i];

            if (stat == null) {

                if (statCards[i] != null) {
                    statCards[i].setVisibility(View.GONE);
                }

                continue;
            }

            currentStatKeys.add(stat.label);

            if (statCards[i] != null) {
                statCards[i].setVisibility(View.VISIBLE);
            }

            if (labelViews[i] != null) {
                labelViews[i].setText(
                        stat.label.toUpperCase()
                );
            }

            if (valueViews[i] != null) {

                String text =
                        formatValue(stat.value);

                if (stat.unit != null &&
                        !stat.unit.isEmpty()) {

                    text += " " + stat.unit;
                }

                valueViews[i].setText(text);
            }
        }
    }

    private String formatValue(Object value) {

        if (value == null) return "0";

        if (value instanceof Double) {

            double d = (Double) value;

            if (d == (long) d) {

                return String.format(
                        Locale.getDefault(),
                        "%d",
                        (long) d
                );
            }
        }

        return String.valueOf(value);
    }

    private void disableStatCards() {

        for (MaterialCardView card : statCards) {

            if (card != null) {
                card.setEnabled(false);
            }
        }
    }

    private void enableStatCards() {

        for (MaterialCardView card : statCards) {

            if (card != null) {
                card.setEnabled(true);
            }
        }
    }

    // =================================================
    // CPU LOGIC
    // =================================================

    private void triggerCpuTurn() {

        if (cpuTurnScheduled) return;

        cpuTurnScheduled = true;

        new android.os.Handler(
                Looper.getMainLooper()
        ).postDelayed(() -> {

            cpuTurnScheduled = false;

            if (!isBotMode ||
                    game.getCurrentPlayerTurn() != 1) {
                return;
            }

            CardInfo cpuCard =
                    game.getPlayerCard(1);

            if (cpuCard == null) return;

            int bestStatIndex =
                    CpuPlayer.getBestStatIndex(cpuCard);

            executeRound(bestStatIndex);

        }, 1000);
    }
}