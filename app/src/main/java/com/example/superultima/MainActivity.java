package com.example.superultima;

import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import java.util.List;

import com.google.android.material.card.MaterialCardView;

/**
 * Main activity for the SuperUltima application.
 * Handles the initial screen, pack selection, and starting or joining games.
 */
public class MainActivity extends AppCompatActivity {

    private List<CardInfo> selectedDeck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display for a modern look.
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        // Setup the Airplanes Pack 1 card click listener to navigate to its card activity.
        MaterialCardView airplanesPack1 = findViewById(R.id.airplanesPack1);

        //only for viewing the deck/cards.

        //AIRPLANES
        airplanesPack1.setOnClickListener(v -> {
            selectedDeck = new AirplanesDeck().getCards();
            Intent intent = new Intent(MainActivity.this, CardActivity.class);
            startActivity(intent);
        });

        // Handle window insets for edge-to-edge display to prevent UI overlap with system bars.
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

        // Setup the Play button to show an options dialog (Create or Join Game).
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("PLAY GAME");

            builder.setItems(
                    new String[]{"CREATE GAME", "JOIN GAME"},
                    (dialog, which) -> {
                        if (which == 0) {
                            createGame();
                        } else {
                            joinGame();
                        }
                    });
            builder.setNegativeButton("Cancel", null);
            builder.show();
        });
    }

    /**
     * Initiates the process to host a new game session.
     */
    private void createGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CREATE GAME");
        builder.setMessage("Host");
        builder.setPositiveButton("Start Hosting", (dialog, which) -> {
            Intent intent = new Intent(MainActivity.this, GameActivity.class);

            intent.putExtra("deck", new ArrayList<>(selectedDeck));

            startActivity(intent);
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    /**
     * Initiates the process to search for and join an existing game session.
     */
    private void joinGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("JOIN GAME");
        builder.setMessage("SEARCH FOR AVAILABLE GAMES");
        builder.setPositiveButton("SEARCH", (dialog, which) -> {
            // TODO: Implement Nearby Connections discovery logic.
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
}
