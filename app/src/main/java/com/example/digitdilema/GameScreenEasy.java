package com.example.digitdilema;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameScreenEasy extends AppCompatActivity {
    int result;



    public static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void buttonClicked(View v) {
        //
        int guess;
        int score = 0;
        //
        EditText guessInt = (EditText) findViewById(R.id.guessInt);
        guess = Integer.parseInt(guessInt.getText().toString());
        //
        if (guess < result){
            ((TextView) findViewById(R.id.answer)).setText("Too Low");
        } else if (guess > result){
            ((TextView) findViewById(R.id.answer)).setText("Too High");
        } else {
            ((TextView) findViewById(R.id.answer)).setText("Correct Guess! Your new high-score is " + score);
            score++;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int min = 1;
        int max = 20;
        result = getRandom(min,max);

    }
}
