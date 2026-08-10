package com.example.superultima;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Button;

public class AirplanesCardActivity extends AppCompatActivity {

    private TextView cardCode;
    private TextView airplaneName;
    private TextView airplaneType;

    private ImageView airplaneImage;

    private TextView speedValue;
    private TextView autonomyValue;
    private TextView wingsValue;
    private TextView lengthValue;
    private TextView weightValue;
    private TextView maxHeightValue;

    private Button homeButton;
    private Button prevButton;
    private Button nextButton;

    private AirplanesDeck deck;
    private int currentCard = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);



        setContentView(R.layout.activity_airplanes1);

        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> finish());

        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        deck = new AirplanesDeck();

        nextButton.setOnClickListener(v -> {
            currentCard++;

            if (currentCard >= deck.getCards().size()) {
                currentCard = 0;
            }

            showAirplane(deck.getCards().get(currentCard));
        });

        prevButton.setOnClickListener(v -> {
            currentCard--;

            if (currentCard < 0) {
                currentCard = deck.getCards().size() - 1;
            }

            showAirplane(deck.getCards().get(currentCard));
        });

        cardCode = findViewById(R.id.cardCode);
        airplaneName = findViewById(R.id.airplaneName);
        airplaneType = findViewById(R.id.airplaneType);

        airplaneImage = findViewById(R.id.airplaneImage);

        speedValue = findViewById(R.id.speedValue);
        autonomyValue = findViewById(R.id.autonomyValue);
        wingsValue = findViewById(R.id.wingsValue);
        lengthValue = findViewById(R.id.lengthValue);
        weightValue = findViewById(R.id.weightValue);
        maxHeightValue = findViewById(R.id.maxHeightValue);

        deck = new AirplanesDeck();
        showAirplane(deck.getCards().get(currentCard));

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {

                    Insets systemBars =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars());

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    }

    private void showAirplane(CardInfo airplane) {
        cardCode.setText(airplane.code);
        airplaneName.setText(airplane.name);
        airplaneType.setText(airplane.type);
        airplaneImage.setImageResource(airplane.image);
        speedValue.setText(String.format("%.0f km/h", airplane.speed));
        autonomyValue.setText(String.format("%.0f km", airplane.autonomy));
        wingsValue.setText(String.format("%.1f m", airplane.wings));
        lengthValue.setText(String.format("%.1f m", airplane.length));
        weightValue.setText(String.format("%.0f kg", airplane.weight));
        maxHeightValue.setText(String.format("%.0f m", airplane.maxHeight)); }
    }
