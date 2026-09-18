package com.example.superultima;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.superultima.cardgame.CardActivity;
import java.util.ArrayList;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.example.superultima.decksdata.DeckInfo;
import com.example.superultima.decksdata.DecksRepository;

/**
 * The main menu activity for the Super Ultima application.
 * Provides options to start a new game, browse card decks, or read the game rules.
 */
public class MainActivity extends AppCompatActivity {
    private DeckInfo selectedDeck;
    private View selectedDeckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display to use the full screen area.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        GridLayout decksContainer = findViewById(R.id.decksContainer);

        List<DeckInfo> decks = DecksRepository.getDecks();

        selectedDeck = decks.get(0);

// Add more decks here...

        for (DeckInfo deck : decks) {

            View deckView = LayoutInflater.from(this)
                    .inflate(R.layout.decks, decksContainer, false);

            ImageView deckImage = deckView.findViewById(R.id.deckImage);
            TextView deckName = deckView.findViewById(R.id.deckName);

            deckImage.setImageResource(deck.image);
            deckName.setText(deck.name);
            // Highlight the selected deck.
            if (deck == selectedDeck) {
                selectedDeckView = deckView;

                MaterialCardView card =
                        deckView.findViewById(R.id.deckCard);

                card.setStrokeWidth(4);
            }
// Set a click listener to select the deck when clicked.
            deckView.setOnClickListener(v -> {

                if (selectedDeckView != null) {
                    MaterialCardView oldCard =
                            selectedDeckView.findViewById(R.id.deckCard);

                    oldCard.setStrokeWidth(1);
                }

                selectedDeck = deck;
                selectedDeckView = deckView;

                MaterialCardView card =
                        deckView.findViewById(R.id.deckCard);

                card.setStrokeWidth(4);
            });

            decksContainer.addView(deckView);
        }

        // Adjust view padding to account for system bars (status bar, navigation bar).
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );
                    return insets;
                }
        );

        // PLAY NOW button: Navigates to the GameSetupActivity to choose mode and deck.
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GameSetupActivity.class);
            startActivity(intent);
        });

        // BROWSE ALL CARDS button: Opens the CardActivity to view all cards in the Airplanes deck.
        Button browseCardsButton = findViewById(R.id.browseCardsButton);
        browseCardsButton.setOnClickListener(v -> {
            // Load the default deck for viewing.


            Intent intent = new Intent(MainActivity.this, CardActivity.class);
            intent.putExtra("deck", new ArrayList<>(selectedDeck.cards));
            startActivity(intent);
        });

        // RULES button: Displays a simple dialog explaining how to play the game.
        Button rulesButton = findViewById(R.id.rulesButton);
        rulesButton.setOnClickListener(v -> {
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("GAME RULES")
                    .setMessage(
                            "1. Select a stat from your active card.\n" +
                                    "2. The player with the highest stat value wins the round.\n" +
                                    "3. Collect all cards in the deck to win!"
                    )
                    .setPositiveButton("OK", null)
                    .show();
        });
    }
}