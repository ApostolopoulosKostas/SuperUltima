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

import com.example.superultima.Decks.AirplanesDeck;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(
                                    WindowInsetsCompat.Type.systemBars()
                            );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // PLAY NOW
        Button playButton =
                findViewById(R.id.playButton);

        playButton.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            GameSetupActivity.class
                    );

            startActivity(intent);
        });

        // BROWSE ALL CARDS
        Button browseCardsButton =
                findViewById(R.id.browseCardsButton);

        browseCardsButton.setOnClickListener(v -> {

            List<CardInfo> deck =
                    new AirplanesDeck().getCards();

            Intent intent =
                    new Intent(
                            MainActivity.this,
                            CardActivity.class
                    );

            intent.putExtra(
                    "deck",
                    new ArrayList<>(deck)
            );

            startActivity(intent);
        });

        // RULES
        Button rulesButton =
                findViewById(R.id.rulesButton);

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