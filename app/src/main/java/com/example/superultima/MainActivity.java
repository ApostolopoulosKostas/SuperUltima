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

import com.google.android.material.card.MaterialCardView;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MaterialCardView airplanesPack1 =
                findViewById(R.id.airplanesPack1);

        airplanesPack1.setOnClickListener(v -> {

            Intent intent =
                    new Intent(MainActivity.this, AirplanesCardActivity.class);
            startActivity(intent);
        });

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
        Button playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("PLAY GAME");

            builder.setItems(
                    new String[]{"CREATE GAME", "JOIN GAME"},
                    (dialog, which) -> {
                        if (which == 0) {
                            createGAME() ;
                        } else {
                            joinGAME();
                        }

                    });
            builder.setNegativeButton("Cancel", null);
            builder.show();
        });

    }
    private void createGAME(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("CREATE GAME");
        builder.setMessage("Host");
        builder.setPositiveButton("Start Hosting",(dialog,which)->{
           //connections will go here
        });
        builder.setNegativeButton("Cancel",null);
        builder.show();
    }
    private void joinGAME (){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("JOIN GAME");
        builder.setMessage("SEARCH FOR AVAILABLE GAMES");
        builder.setPositiveButton("SEARCH",(dialog,which)->{
            //discovery will go here
        });
        builder.setNegativeButton("Cancel",null);
        builder.show();
    }
}
