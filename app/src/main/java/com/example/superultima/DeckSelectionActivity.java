package com.example.superultima;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.card.MaterialCardView;
import java.util.ArrayList;
import java.util.List;

public class DeckSelectionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_selection);


        MaterialCardView airplanesDeck = findViewById(R.id.airplanesDeck);

        airplanesDeck.setOnClickListener(v -> {

            List<CardInfo> selectedDeck = new AirplanesDeck().getCards();

            Intent intent = new Intent(DeckSelectionActivity.this, GameLobbyActivity.class);
            intent.putExtra("deck", new ArrayList<>(selectedDeck));
            startActivity(intent);

        });
    }
}