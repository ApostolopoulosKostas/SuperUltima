package com.example.superultima.cardgame;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;

import com.example.superultima.R;

import java.util.List;

import android.content.Intent;
import android.net.Uri;


/**
 * CardActivity is used to browse through a deck of cards.
 * It allows the user to see the details (image, name, stats)
 * of each card by navigating forward and backward through the list.
 */
public class CardActivity extends AppCompatActivity {

    // UI elements for displaying card details
    private TextView cardCode;
    private TextView cardName;
    private TextView cardType;
    private ImageView cardImage;

    // Arrays to hold references to the labels and value views for the 6 statistics
    private TextView[] labels = new TextView[6];
    private TextView[] values = new TextView[6];

    // Navigation buttons
    private Button homeButton;
    private Button prevButton;
    private Button nextButton;

    // The list of cards being browsed and the current index
    private List<CardInfo> cards;
    private int currentCard = 0;

    private TextView superUltimaLabel;
    private Button readMoreButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display
        EdgeToEdge.enable(this);

        setContentView(R.layout.card);

        // Initialize Super Ultima label
        superUltimaLabel = findViewById(R.id.superUltimaLabel);

        // Initialize UI component references
        homeButton = findViewById(R.id.homeButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        readMoreButton = findViewById(R.id.readMoreButton);

        cardCode = findViewById(R.id.cardCode);
        cardName = findViewById(R.id.cardName);
        cardType = findViewById(R.id.cardType);
        cardImage = findViewById(R.id.cardImage);

        // Bind statistic labels and values
        labels[0] = findViewById(R.id.label1);
        labels[1] = findViewById(R.id.label2);
        labels[2] = findViewById(R.id.label3);
        labels[3] = findViewById(R.id.label4);
        labels[4] = findViewById(R.id.label5);
        labels[5] = findViewById(R.id.label6);

        values[0] = findViewById(R.id.value1);
        values[1] = findViewById(R.id.value2);
        values[2] = findViewById(R.id.value3);
        values[3] = findViewById(R.id.value4);
        values[4] = findViewById(R.id.value5);
        values[5] = findViewById(R.id.value6);

        // Get the deck
        cards = (List<CardInfo>) getIntent().getSerializableExtra("deck");

        // Home button exits the browser and returns to the previous screen
        homeButton.setOnClickListener(v -> finish());

        // Read More button
        readMoreButton.setOnClickListener(v -> {

            String url = "https://en.wikipedia.org/w/index.php?search="
                    + Uri.encode(cards.get(currentCard).name);

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        // Next button
        nextButton.setOnClickListener(v -> {

            currentCard++;

            if (currentCard >= cards.size()) {
                currentCard = 0;
            }

            showCard(cards.get(currentCard));
        });

        // Previous button
        prevButton.setOnClickListener(v -> {

            currentCard--;

            if (currentCard < 0) {
                currentCard = cards.size() - 1;
            }

            showCard(cards.get(currentCard));
        });

        // Display the first card
        showCard(cards.get(currentCard));


        // ---------------------------------------------------------
        // Keep the card above the Android navigation / home bar
        // ---------------------------------------------------------

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.cardTemplate),
                (v, insets) -> {

                    Insets navigationBar = insets.getInsets(
                            WindowInsetsCompat.Type.navigationBars()
                    );

                    androidx.constraintlayout.widget.ConstraintLayout.LayoutParams params =
                            (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams)
                                    v.getLayoutParams();

                    // Original 16dp margin + Android navigation bar height
                    params.bottomMargin =
                            (int) (16 * getResources().getDisplayMetrics().density)
                                    + navigationBar.bottom;

                    v.setLayoutParams(params);

                    return insets;
                }
        );
    }


    /**
     * Updates the UI views with the data from the specified card.
     *
     * @param card The CardInfo object to display.
     */
    private void showCard(CardInfo card) {

        // Set basic card metadata
        cardCode.setText(card.code);
        cardName.setText(card.name);
        cardType.setText(card.type);

        // Load the card's illustration
        cardImage.setImageResource(card.image);


        // Super Ultima label
        if (card.superUltima) {
            superUltimaLabel.setVisibility(View.VISIBLE);
        } else {
            superUltimaLabel.setVisibility(View.GONE);
        }


        // Display the 6 statistics
        for (int i = 0; i < 6; i++) {

            CardInfo.Statistic statistic = card.statistics[i];

            if (statistic != null) {

                labels[i].setText(statistic.label);

                values[i].setText(
                        String.format(
                                "%.1f %s",
                                statistic.value,
                                statistic.unit
                        )
                );
            }
        }
    }
}