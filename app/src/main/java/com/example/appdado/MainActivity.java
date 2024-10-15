package com.example.appdado;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Dado dado;
    private Button roll;
    private ImageView diceImage;
    private TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        dado = new Dado();

        roll = findViewById(R.id.roll);
        diceImage = findViewById(R.id.dice_image);
        scoreView = findViewById(R.id.turn_score);

        diceImage.setImageResource(R.drawable.dice_random);

        scoreView.setText(String.valueOf(0));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setDiceRoll();
    }

    private void setDiceRoll() {
        roll.setOnClickListener(view -> {
            int rolledValue = dado.play();
            scoreView.setText(String.valueOf(dado.getScoreRound()));

            switch (rolledValue) {
                case 1:
                    diceImage.setImageResource(R.drawable.dice_one);
                    Toast.makeText(MainActivity.this, "Fallo", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    diceImage.setImageResource(R.drawable.dice_two);
                    break;
                case 3:
                    diceImage.setImageResource(R.drawable.dice_three);
                    break;
                case 4:
                    diceImage.setImageResource(R.drawable.dice_four);
                    break;
                case 5:
                    diceImage.setImageResource(R.drawable.dice_five);
                    break;
                case 6:
                    diceImage.setImageResource(R.drawable.dice_six);
                    break;
            }

        });
    }


}
