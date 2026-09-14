package com.example.superultima;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import android.view.View;
import android.widget.Button;


public class GameActivity extends AppCompatActivity {

    private Game game;
    private List<CardInfo> deck;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card);
        deck = (List<CardInfo>) getIntent().getSerializableExtra("deck");
        Button prevButton = findViewById(R.id.prevButton);
        Button homeButton = findViewById(R.id.homeButton);
        Button nextButton = findViewById(R.id.nextButton);
        prevButton.setVisibility(View.GONE);
        homeButton.setVisibility(View.GONE);
        nextButton.setVisibility(View.GONE);

        MaterialCardView statCard1 = findViewById(R.id.statCard1);
        MaterialCardView statCard2 = findViewById(R.id.statCard2);
        MaterialCardView statCard3 = findViewById(R.id.statCard3);
        MaterialCardView statCard4 = findViewById(R.id.statCard4);
        MaterialCardView statCard5 = findViewById(R.id.statCard5);
        MaterialCardView statCard6 = findViewById(R.id.statCard6);

        statCard1.setOnClickListener(v -> {
            game.playRound(0);

        });
        statCard2.setOnClickListener(v -> {

        });
        statCard3.setOnClickListener(v -> {

        });
        statCard4.setOnClickListener(v -> {

        });
        statCard5.setOnClickListener(v -> {

        });
        statCard6.setOnClickListener(v -> {

        });


    }
}