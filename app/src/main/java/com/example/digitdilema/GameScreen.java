package com.example.digitdilema;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreen extends AppCompatActivity {
    int result;

    public static int getRandom(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guessingscreen);

        int min = 1;
        int max = 20;
        result = getRandom(min, max);

        btn = findViewById(R.id.button2);
        EditText guessInt = findViewById(R.id.guessInt);
        int guess = Integer.parseInt(guessInt.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (guess < result) {
                    ((TextView) findViewById(R.id.answer)).setText("Too Low");
                } else if (guess > result) {
                    ((TextView) findViewById(R.id.answer)).setText("Too High");
                } else {
                    ((TextView) findViewById(R.id.answer)).setText("Correct Guess!");
                }
            }
        });
    }
}