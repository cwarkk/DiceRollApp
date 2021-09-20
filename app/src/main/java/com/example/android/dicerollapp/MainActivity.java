package com.example.android.dicerollapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDice1, imageViewDice2;
    Button rollBtn;

    public static final Random dice = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollBtn = (Button) findViewById(R.id.rollBtn);
        imageViewDice1 = (ImageView) findViewById(R.id.image_view1);
        imageViewDice2 = (ImageView) findViewById(R.id.image_view2);
        rollBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value1 = randomDice();
                int value2 = randomDice();

                int result1 = getResources().getIdentifier("dice" + value1, "drawable", "com.example.android.dicerollapp");
                int result2 = getResources().getIdentifier("dice" + value2, "drawable", "com.example.android.dicerollapp");
                imageViewDice1.setImageResource(result1);
                imageViewDice2.setImageResource(result2);
            }
        });
    }

    public static int randomDice() {
        return dice.nextInt(6) + 1;
    }
}