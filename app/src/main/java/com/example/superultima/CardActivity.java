package com.example.superultima;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.superultima.CardInfo;

import java.util.List;

public class CardActivity extends AppCompatActivity {

    private TextView cardCode;
    private TextView cardName;
    private TextView cardType;

    private ImageView cardImage;

    private TextView[] labels = new TextView[6];
    private TextView[] values = new TextView[6];

    private Button homeButton;
    private Button prevButton;
    private Button nextButton;

    private List<CardInfo> cards;
    private int currentCard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.card);

        homeButton = findViewById(R.id.homeButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);

        cardCode = findViewById(R.id.cardCode);
        cardName = findViewById(R.id.cardName);
        cardType = findViewById(R.id.cardType);

        cardImage = findViewById(R.id.cardImage);

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

        homeButton.setOnClickListener(v -> finish());

        AirplanesDeck deck = new AirplanesDeck();
        cards = deck.getCards();

        nextButton.setOnClickListener(v -> {

            currentCard++;

            if (currentCard >= cards.size()) {
                currentCard = 0;
            }

            showCard(cards.get(currentCard));
        });

        prevButton.setOnClickListener(v -> {

            currentCard--;

            if (currentCard < 0) {
                currentCard = cards.size() - 1;
            }

            showCard(cards.get(currentCard));
        });

        showCard(cards.get(currentCard));

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
    }

    private void showCard(CardInfo card) {

        cardCode.setText(card.code);
        cardName.setText(card.name);
        cardType.setText(card.type);

        cardImage.setImageResource(card.image);

        for (int i = 0; i < 6; i++) {

            CardInfo.Statistic statistic =
                    card.statistics[i];

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