package com.example.superultima;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
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

    /** Tracks the currently open round result dialog so it can be dismissed programmatically. */
    private AlertDialog activeResultDialog;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

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

        // 5. Setup Networking Listener (Multiplayer synchronization)
        if (connection != null && !isBotMode) {
            connection.setListener(new OfflineGameConnection.ConnectionListener() {
                @Override
                public void onMoveReceived(int statIndex) {
                    // Receive the stat index picked by the other player and play it.
                    runOnUiThread(() -> executeRound(statIndex));
                }

                @Override
                public void onNextRoundReceived() {
                    // Receive confirmation to proceed to the next turn display.
                    runOnUiThread(() -> advanceToNextRound());
                }
            });
        }

        // 6. Cleanup UI: Hide buttons used in browser/viewer mode.
        View prevButton = findViewById(R.id.prevButton);
        View homeButton = findViewById(R.id.homeButton);
        View nextButton = findViewById(R.id.nextButton);

        if (prevButton != null) prevButton.setVisibility(View.GONE);
        if (homeButton != null) homeButton.setVisibility(View.GONE);
        if (nextButton != null) nextButton.setVisibility(View.GONE);

        // 7. Bind UI Stat components and click listeners.
        for (int i = 0; i < 6; i++) {
            // Find IDs dynamically by name (e.g., statCard1, label1, value1).
            int cardId = getResources().getIdentifier("statCard" + (i + 1), "id", getPackageName());
            int labelId = getResources().getIdentifier("label" + (i + 1), "id", getPackageName());
            int valueId = getResources().getIdentifier("value" + (i + 1), "id", getPackageName());

            statCards[i] = findViewById(cardId);
            labelViews[i] = findViewById(labelId);
            valueViews[i] = findViewById(valueId);

            final int index = i;

            // Make rows clickable for stat selection.
            if (statCards[i] != null) {
                statCards[i].setClickable(true);
                statCards[i].setFocusable(true);
                statCards[i].setOnClickListener(v -> selectStatistic(index));
            }
            if (labelViews[i] != null) labelViews[i].setOnClickListener(v -> selectStatistic(index));
            if (valueViews[i] != null) valueViews[i].setOnClickListener(v -> selectStatistic(index));
        }

        // 8. Load Initial State.
        displayCurrentCard();
        updateTurnUI();
    }

    // =================================================
    // TURN LOGIC
    // =================================================

    /**
     * Determines if it is currently this device user's turn.
     * @return True if the local player should select a statistic.
     */
    private boolean isMyTurn() {
        return game.getCurrentPlayerTurn() == localPlayerId;
    }

    /**
     * Updates UI interactivity based on turn status.
     * Also triggers CPU AI if it is currently the bot's turn.
     */
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

    /**
     * Handles the event when a player chooses a statistic to compare.
     * @param statisticPosition Index (0-5) of the selected statistic.
     */
    private void selectStatistic(int statisticPosition) {
        if (!isMyTurn()) return;

        disableStatCards();

        // Broadcast the choice to the remote player if in multiplayer.
        if (connection != null && !isBotMode) {
            connection.sendMove(statisticPosition);
        }

        executeRound(statisticPosition);
    }

    // =================================================
    // EXECUTE ROUND
    // =================================================

    /**
     * Compares the selected statistic across players and determines a round winner.
     * @param statisticPosition Index of the statistic chosen for comparison.
     */
    private void executeRound(int statisticPosition) {
        disableStatCards();

        // Grab the label/unit for the stat being compared, from the card that
        // was on screen before playRound() consumes it.
        String statLabel = "STAT";
        String statUnit = "";
        if (lastDisplayedCard != null && lastDisplayedCard.statistics[statisticPosition] != null) {
            CardInfo.Statistic selectedStat = lastDisplayedCard.statistics[statisticPosition];
            statLabel = selectedStat.label;
            statUnit = (selectedStat.unit != null) ? selectedStat.unit : "";
        }

        // Perform the round logic comparison.
        Game.RoundResult result = game.playRound(statisticPosition);

        // Build the "PLAYER: value unit" breakdown shown for every round.
        String comparisonText = buildComparisonText(statLabel, statUnit, result.statValues);

        // Check for overall Game Over.
        if (game.isGameOver()) {
            int overallWinner = game.getWinner();
            new AlertDialog.Builder(GameActivity.this)
                    .setTitle("GAME OVER")
                    .setMessage(comparisonText + "\n\nPlayer " + (overallWinner + 1) + " wins the game!")
                    .setCancelable(false)
                    .setPositiveButton("FINISH", (dialog, which) -> finish())
                    .show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this)
                .setTitle(result.isTie() ? "IT'S A TIE!" : "ROUND RESULT")
                .setCancelable(false);

        String outcomeLine = result.isTie()
                ? "\n\nNo one wins this round - the cards carry over to the next one!"
                : "\n\nPlayer " + (result.winnerIndex + 1) + " won this round!";

        // After a tie, the SAME player who picked continues to pick next.
        // After a win, the winner picks next. Either way, check if that's the CPU.
        int nextPicker = result.isTie() ? game.getCurrentPlayerTurn() : result.winnerIndex;
        boolean cpuContinues = isBotMode && nextPicker == 1;

        builder.setMessage(comparisonText + outcomeLine
                + (cpuContinues ? "\n\nCPU will continue..." : ""));

        if (cpuContinues) {
            // CPU's turn continues automatically after a short delay.
            activeResultDialog = builder.create();
            activeResultDialog.show();
            new android.os.Handler(Looper.getMainLooper()).postDelayed(this::advanceToNextRound, 1500);
            return;
        }

        // Human turn result: Show message and wait for user to click "Next".
        builder.setPositiveButton("NEXT TURN", (dialog, which) -> {
            if (connection != null && !isBotMode) {
                connection.sendNextRound();
            }
            advanceToNextRound();
        });

        activeResultDialog = builder.create();
        activeResultDialog.show();
    }

    /**
     * Builds a readable "who had what" breakdown for the round result dialog,
     * e.g. "SPEED\n\nPlayer 1: 2414 km/h\nPlayer 2: 2495 km/h".
     */
    private String buildComparisonText(String statLabel, String statUnit, double[] statValues) {
        StringBuilder sb = new StringBuilder(statLabel.toUpperCase());

        for (int i = 0; i < statValues.length; i++) {
            if (Double.isNaN(statValues[i])) continue; // that player was already out.

            String playerName = (isBotMode && i == 1) ? "CPU" : "Player " + (i + 1);
            String valueText = formatValue(statValues[i]);
            if (!statUnit.isEmpty()) {
                valueText += " " + statUnit;
            }
            sb.append("\n").append(playerName).append(": ").append(valueText);
        }

        return sb.toString();
    }

    /**
     * Dismisses the results dialog and moves to the next card/turn state.
     */
    private void advanceToNextRound() {
        if (activeResultDialog != null && activeResultDialog.isShowing()) {
            activeResultDialog.dismiss();
        }
        displayCurrentCard();
        updateTurnUI();
    }

    // =================================================
    // DISPLAY CARD
    // =================================================

    /**
     * Updates the UI to show the current top card for the local player.
     * Only the player's own card data is shown on their device.
     */
    private void displayCurrentCard() {
        CardInfo currentCard = game.getPlayerCard(localPlayerId);
        if (currentCard == null) return;

        lastDisplayedCard = currentCard;

        // Card header bindings.
        TextView cardCode = findViewById(R.id.cardCode);
        if (cardCode != null) cardCode.setText(currentCard.code);

        TextView cardName = findViewById(R.id.cardName);
        if (cardName != null) cardName.setText(currentCard.name);

        TextView cardType = findViewById(R.id.cardType);
        if (cardType != null) cardType.setText(currentCard.type);

        ImageView cardImage = findViewById(R.id.cardImage);
        if (cardImage != null) cardImage.setImageResource(currentCard.image);

        currentStatKeys.clear();

        // Card statistic bindings (filling 6 possible slots).
        for (int i = 0; i < 6; i++) {
            CardInfo.Statistic stat = currentCard.statistics[i];

            if (stat == null) {
                if (statCards[i] != null) statCards[i].setVisibility(View.GONE);
                continue;
            }

            currentStatKeys.add(stat.label);
            if (statCards[i] != null) statCards[i].setVisibility(View.VISIBLE);
            if (labelViews[i] != null) labelViews[i].setText(stat.label.toUpperCase());

            if (valueViews[i] != null) {
                String text = formatValue(stat.value);
                if (stat.unit != null && !stat.unit.isEmpty()) {
                    text += " " + stat.unit;
                }
                valueViews[i].setText(text);
            }
        }
    }

    /** Helper to handle data formatting for numeric values. */
    private String formatValue(Object value) {
        if (value == null) return "0";
        if (value instanceof Double) {
            double d = (Double) value;
            if (d == (long) d) {
                return String.format(Locale.getDefault(), "%d", (long) d);
            }
        }
        return String.valueOf(value);
    }

    /** Prevents clicking any stat row. */
    private void disableStatCards() {
        for (MaterialCardView card : statCards) {
            if (card != null) card.setEnabled(false);
        }
    }

    /** Allows clicking stat rows for selection. */
    private void enableStatCards() {
        for (MaterialCardView card : statCards) {
            if (card != null) card.setEnabled(true);
        }
    }

    // =================================================
    // CPU LOGIC
    // =================================================

    /**
     * Executes the logic for a computer opponent turn after a short delay.
     */
    private void triggerCpuTurn() {
        if (cpuTurnScheduled) return;
        cpuTurnScheduled = true;

        new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {
            cpuTurnScheduled = false;

            if (!isBotMode || game.getCurrentPlayerTurn() != 1) return;

            CardInfo cpuCard = game.getPlayerCard(1);
            if (cpuCard == null) return;

            // Simple AI picks the best statistic index to play.
            int bestStatIndex = CpuPlayer.getBestStatIndex(cpuCard);
            executeRound(bestStatIndex);

        }, 1000);
    }
}