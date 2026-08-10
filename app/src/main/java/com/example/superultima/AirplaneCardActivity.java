package com.example.superultima;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AirplaneCardActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_airplanes1);

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

    private void showAirplane(Airplane airplane) {
        cardCode.setText(airplane.code);
        airplaneName.setText(airplane.name);
        airplaneType.setText(airplane.type);
        airplaneImage.setImageResource(airplane.image);
        speedValue.setText("Mach " + airplane.speed);
        autonomyValue.setText(String.format("%.0f km", airplane.autonomy));
        wingsValue.setText(String.format("%.1f m", airplane.wings));
        lengthValue.setText(String.format("%.1f m", airplane.length));
        weightValue.setText(String.format("%.0f kg", airplane.weight));
        maxHeightValue.setText(String.format("%.3f km", airplane.maxHeight)); }
    }
