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

    private int selectedStatistic = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);

        deck = (List<CardInfo>) getIntent().getSerializableExtra("deck");

        game = new Game(2, deck);

        displayCurrentCard();

        // Hide the navigation buttons
        Button prevButton = findViewById(R.id.prevButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button nextButton = findViewById(R.id.nextButton);

        prevButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        // Statistics
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
    }

    private void selectStatistic(int statisticPosition) {
        selectedStatistic = statisticPosition;

        CardInfo.Statistic statistic = game.getCurrentStatistic(statisticPosition);

        new AlertDialog.Builder(this)
                .setTitle("STATISTIC SELECTED")
                .setMessage(statistic.label + "\n" + formatValue(statistic.value))
                .setPositiveButton("OK", (dialog, which) -> {
                    // 1. Play the round & get the round winner
                    int winnerIndex = game.playRound(statisticPosition);

                    // 2. Check if the game is over
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

                    // 3. Show round winner dialog & display next card
                    new AlertDialog.Builder(GameActivity.this)
                            .setTitle("ROUND RESULT")
                            .setMessage("Player " + (winnerIndex + 1) + " won this round!")
                            .setPositiveButton("Next Turn", (d, w) -> {
                                displayCurrentCard();
                            })
                            .show();
                })
                .show();
    }

    private String formatValue(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }

    private void displayCurrentCard() {
        CardInfo currentCard = game.getCurrentCard();

        // Card code
        TextView cardCode = findViewById(R.id.cardCode);
        cardCode.setText(currentCard.code);

        // Card name
        TextView cardName = findViewById(R.id.cardName);
        cardName.setText(currentCard.name);

        // Card type
        TextView cardType = findViewById(R.id.cardType);
        cardType.setText(currentCard.type);

        // Card image
        ImageView cardImage = findViewById(R.id.cardImage);
        cardImage.setImageResource(currentCard.image);

        // Statistics
        CardInfo.Statistic statistic1 = currentCard.statistics[0];
        CardInfo.Statistic statistic2 = currentCard.statistics[1];
        CardInfo.Statistic statistic3 = currentCard.statistics[2];
        CardInfo.Statistic statistic4 = currentCard.statistics[3];
        CardInfo.Statistic statistic5 = currentCard.statistics[4];
        CardInfo.Statistic statistic6 = currentCard.statistics[5];

        // Statistic 1
        TextView label1 = findViewById(R.id.label1);
        label1.setText(statistic1.label);
        TextView value1 = findViewById(R.id.value1);
        value1.setText(formatValue(statistic1.value));

        // Statistic 2
        TextView label2 = findViewById(R.id.label2);
        label2.setText(statistic2.label);
        TextView value2 = findViewById(R.id.value2);
        value2.setText(formatValue(statistic2.value));

        // Statistic 3
        TextView label3 = findViewById(R.id.label3);
        label3.setText(statistic3.label);
        TextView value3 = findViewById(R.id.value3);
        value3.setText(formatValue(statistic3.value));

        // Statistic 4
        TextView label4 = findViewById(R.id.label4);
        label4.setText(statistic4.label);
        TextView value4 = findViewById(R.id.value4);
        value4.setText(formatValue(statistic4.value));

        // Statistic 5
        TextView label5 = findViewById(R.id.label5);
        label5.setText(statistic5.label);
        TextView value5 = findViewById(R.id.value5);
        value5.setText(formatValue(statistic5.value));

        // Statistic 6
        TextView label6 = findViewById(R.id.label6);
        label6.setText(statistic6.label);
        TextView value6 = findViewById(R.id.value6);
        value6.setText(formatValue(statistic6.value));
    }

    private void disableStatCards() {
        findViewById(R.id.statCard1).setEnabled(false);
        findViewById(R.id.statCard2).setEnabled(false);
        findViewById(R.id.statCard3).setEnabled(false);
        findViewById(R.id.statCard4).setEnabled(false);
        findViewById(R.id.statCard5).setEnabled(false);
        findViewById(R.id.statCard6).setEnabled(false);
    }
}