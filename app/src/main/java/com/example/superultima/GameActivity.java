package com.example.superultima;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class GameActivity extends AppCompatActivity {

    private Game game;
    private List<CardInfo> deck;
    private OfflineGameConnection connection;
    private int localPlayerId = 0; // Host = 0, Guest = 1
    private AlertDialog activeResultDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        deck = (List<CardInfo>) getIntent().getSerializableExtra("deck");
        connection = OfflineGameConnection.getInstance();

        // Assign player ID: Host is 0, connected Guest is 1
        if (connection != null && !connection.isHost()) {
            localPlayerId = 1;
        }

        if (connection != null) {
            connection.setListener(new OfflineGameConnection.ConnectionListener() {
                @Override
                public void onMoveReceived(int statIndex) {
                    runOnUiThread(() -> executeRound(statIndex));
                }

                @Override
                public void onNextRoundReceived() {
                    runOnUiThread(() -> advanceToNextRound());
                }
            });
        }

        int playerCount = (connection != null) ? connection.getPlayerCount() : 2;
        game = new Game(playerCount, deck);

        // Hide card viewer navigation buttons
        Button prevButton = findViewById(R.id.prevButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button nextButton = findViewById(R.id.nextButton);

        if (prevButton != null) prevButton.setVisibility(View.GONE);
        if (homeButton != null) homeButton.setVisibility(View.GONE);
        if (nextButton != null) nextButton.setVisibility(View.GONE);

        // Set stat card click listeners
        MaterialCardView statCard1 = findViewById(R.id.statCard1);
        MaterialCardView statCard2 = findViewById(R.id.statCard2);
        MaterialCardView statCard3 = findViewById(R.id.statCard3);
        MaterialCardView statCard4 = findViewById(R.id.statCard4);
        MaterialCardView statCard5 = findViewById(R.id.statCard5);
        MaterialCardView statCard6 = findViewById(R.id.statCard6);

        statCard1.setOnClickListener(v -> selectStatistic(0));
        statCard2.setOnClickListener(v -> selectStatistic(1));
        statCard3.setOnClickListener(v -> selectStatistic(2));
        statCard4.setOnClickListener(v -> selectStatistic(3));
        statCard5.setOnClickListener(v -> selectStatistic(4));
        statCard6.setOnClickListener(v -> selectStatistic(5));

        displayCurrentCard();
        updateTurnUI();
    }

    private boolean isMyTurn() {
        return game.getCurrentPlayerTurn() == localPlayerId;
    }

    private void updateTurnUI() {
        if (isMyTurn()) {
            enableStatCards();
        } else {
            disableStatCards();
        }
    }

    private void selectStatistic(int statisticPosition) {
        // Prevent selection if it's not this player's turn
        if (!isMyTurn()) {
            return;
        }

        disableStatCards();

        // Broadcast choice to opponent
        if (connection != null) {
            connection.sendMove(statisticPosition);
        }

        executeRound(statisticPosition);
    }

    private void executeRound(int statisticPosition) {
        disableStatCards();

        int winnerIndex = game.playRound(statisticPosition);

        if (game.isGameOver()) {
            int overallWinner = game.getWinner();
            new AlertDialog.Builder(GameActivity.this)
                    .setTitle("GAME OVER")
                    .setMessage("Player " + (overallWinner + 1) + " wins the game!")
                    .setCancelable(false)
                    .setPositiveButton("Finish", (d, w) -> finish())
                    .show();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this)
                .setTitle("ROUND RESULT")
                .setMessage("Player " + (winnerIndex + 1) + " won this round!")
                .setCancelable(false);

        // Only the player whose turn just ended controls the transition button
        if (isMyTurn()) {
            builder.setPositiveButton("Next Turn", (d, w) -> {
                if (connection != null) {
                    connection.sendNextRound();
                }
                advanceToNextRound();
            });
        } else {
            builder.setMessage("Player " + (winnerIndex + 1) + " won this round!\n\nWaiting for active player to continue...");
        }

        activeResultDialog = builder.create();
        activeResultDialog.show();
    }

    private void advanceToNextRound() {
        if (activeResultDialog != null && activeResultDialog.isShowing()) {
            activeResultDialog.dismiss();
        }
        displayCurrentCard();
        updateTurnUI();
    }

    private String formatValue(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    private void displayCurrentCard() {
        CardInfo currentCard = game.getCurrentCard();
        if (currentCard == null) return;

        TextView cardCode = findViewById(R.id.cardCode);
        cardCode.setText(currentCard.code);

        TextView cardName = findViewById(R.id.cardName);
        cardName.setText(currentCard.name);

        TextView cardType = findViewById(R.id.cardType);
        cardType.setText(currentCard.type);

        ImageView cardImage = findViewById(R.id.cardImage);
        cardImage.setImageResource(currentCard.image);

        for (int i = 0; i < 6; i++) {
            CardInfo.Statistic stat = currentCard.statistics[i];
            int labelId = getResources().getIdentifier("label" + (i + 1), "id", getPackageName());
            int valueId = getResources().getIdentifier("value" + (i + 1), "id", getPackageName());

            TextView label = findViewById(labelId);
            TextView value = findViewById(valueId);

            if (label != null) label.setText(stat.label);
            if (value != null) value.setText(formatValue(stat.value));
        }
    }

    private void disableStatCards() {
        findViewById(R.id.statCard1).setEnabled(false);
        findViewById(R.id.statCard2).setEnabled(false);
        findViewById(R.id.statCard3).setEnabled(false);
        findViewById(R.id.statCard4).setEnabled(false);
        findViewById(R.id.statCard5).setEnabled(false);
        findViewById(R.id.statCard6).setEnabled(false);
    }

    private void enableStatCards() {
        findViewById(R.id.statCard1).setEnabled(true);
        findViewById(R.id.statCard2).setEnabled(true);
        findViewById(R.id.statCard3).setEnabled(true);
        findViewById(R.id.statCard4).setEnabled(true);
        findViewById(R.id.statCard5).setEnabled(true);
        findViewById(R.id.statCard6).setEnabled(true);
    }
}