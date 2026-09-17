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

import com.example.superultima.cardgame.CardInfo;
import com.example.superultima.decks.AirplanesDeck;

import java.util.ArrayList;
import java.util.List;

/**
 * The main menu activity for the Super Ultima application.
 * Provides options to start a new game, browse card decks, or read the game rules.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Enable edge-to-edge display to use the full screen area.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

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
            List<CardInfo> deck = new AirplanesDeck().getCards();

            Intent intent = new Intent(MainActivity.this, CardActivity.class);
            // Pass the deck to the viewer activity.
            intent.putExtra("deck", new ArrayList<>(deck));
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
