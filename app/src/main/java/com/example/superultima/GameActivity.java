package com.example.superultima;

import android.os.Bundle;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {

    private Game game;
    private List<CardInfo> deck;

    // Initialize the game and display the first card
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);
        deck = (List<CardInfo>) getIntent().getSerializableExtra("deck");

        game = new Game(2, deck);
        displayCurrentCard();

         // Hide the buttons
        Button prevButton = findViewById(R.id.prevButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button nextButton = findViewById(R.id.nextButton);
        prevButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

         // Set up the click listeners for the statistics
        MaterialCardView statCard1 = findViewById(R.id.statCard1);
        MaterialCardView statCard2 = findViewById(R.id.statCard2);
        MaterialCardView statCard3 = findViewById(R.id.statCard3);
        MaterialCardView statCard4 = findViewById(R.id.statCard4);
        MaterialCardView statCard5 = findViewById(R.id.statCard5);
        MaterialCardView statCard6 = findViewById(R.id.statCard6);


        statCard1.setOnClickListener(v -> {
            game.playRound(0);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();

                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        statCard2.setOnClickListener(v -> {
            game.playRound(1);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }

        });
        statCard3.setOnClickListener(v -> {
            game.playRound(2);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        statCard4.setOnClickListener(v -> {
            game.playRound(3);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        statCard5.setOnClickListener(v -> {
            game.playRound(4);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
        statCard6.setOnClickListener(v -> {
            game.playRound(5);
            displayCurrentCard();
            if (game.isGameOver()) {

                disableStatCards();

                int winner = game.getWinner();
                new AlertDialog.Builder(this)
                        .setTitle("GAME OVER")
                        .setMessage("Player " + (winner + 1) + " wins!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });
    }
    // Helper method to format the value based on its type
    private String formatValue(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }

        return String.valueOf(value);
    }
    // Helper method to display the current card
    private void displayCurrentCard() {
        CardInfo currentCard = game.getCurrentCard();
        // Update the UI with the current card's information
        TextView cardCode = findViewById(R.id.cardCode);
        cardCode.setText(currentCard.code);

        TextView cardName = findViewById(R.id.cardName);
        cardName.setText(currentCard.name);

        TextView cardType = findViewById(R.id.cardType);
        cardType.setText(currentCard.type);

        ImageView cardImage = findViewById(R.id.cardImage);
        cardImage.setImageResource(currentCard.image);
         // Update the statistics
        CardInfo.Statistic statistic1 = currentCard.statistics[0];
        CardInfo.Statistic statistic2 = currentCard.statistics[1];
        CardInfo.Statistic statistic3 = currentCard.statistics[2];
        CardInfo.Statistic statistic4 = currentCard.statistics[3];
        CardInfo.Statistic statistic5 = currentCard.statistics[4];
        CardInfo.Statistic statistic6 = currentCard.statistics[5];
        // Update the UI with the statistics
        TextView label1 = findViewById(R.id.label1);
        label1.setText(statistic1.label);
        TextView value1 = findViewById(R.id.value1);
        value1.setText(formatValue(statistic1.value));

        TextView label2 = findViewById(R.id.label2);
        label2.setText(statistic2.label);
        TextView value2 = findViewById(R.id.value2);
        value2.setText(formatValue(statistic2.value));

        TextView label3 = findViewById(R.id.label3);
        label3.setText(statistic3.label);
        TextView value3 = findViewById(R.id.value3);
        value3.setText(formatValue(statistic3.value));

        TextView label4 = findViewById(R.id.label4);
        label4.setText(statistic4.label);
        TextView value4 = findViewById(R.id.value4);
        value4.setText(formatValue(statistic4.value));

        TextView label5 = findViewById(R.id.label5);
        label5.setText(statistic5.label);
        TextView value5 = findViewById(R.id.value5);
        value5.setText(formatValue(statistic5.value));

        TextView label6 = findViewById(R.id.label6);
        label6.setText(statistic6.label);
        TextView value6 = findViewById(R.id.value6);
        value6.setText(formatValue(statistic6.value));
    }
      // Disable the statistics after the game is over
    private void disableStatCards() {
        findViewById(R.id.statCard1).setEnabled(false);
        findViewById(R.id.statCard2).setEnabled(false);
        findViewById(R.id.statCard3).setEnabled(false);
        findViewById(R.id.statCard4).setEnabled(false);
        findViewById(R.id.statCard5).setEnabled(false);
        findViewById(R.id.statCard6).setEnabled(false);
    }




    }
