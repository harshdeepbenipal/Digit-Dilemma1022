package com.example.digitdilema;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;

import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class GameScreen extends AppCompatActivity {
    int max = getMax();


    public int getMax(){
        if(x.getLevel()==1){
            return 20;
        }else if(x.getLevel()==2){
            return 50;
        }else{
            return 100;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guessingscreen);
        TextView level = (TextView) findViewById(R.id.displayLevel);
        if(x.getLevel() == 1){//don't need the l variable
            level.setText("Level: Easy");
        }else if(x.getLevel() == 2){
            level.setText("Level: Medium");
        }else if(x.getLevel() == 3){
            level.setText("Level: Hard");
        }
    }

    private static ScoreBoard x = InputNameActivity.getCurrent();
    int min = 1;
    int result = getRandom(min,max);

    private int score;
    private Player player = x.getPlayer();
    public static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }



    public void buttonClicked(View v) {

        int guess;
        //
        EditText guessInt = (EditText) findViewById(R.id.guessInt);
        guess = Integer.parseInt(guessInt.getText().toString());
        score++;
        //
        if (guess < result) {
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Is Too Low");
        } else if (guess > result) {
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Is Too High");
        } else {
            if (x.checkName() != -1) {
                if (player.getScore() < score) {
                    ((TextView) findViewById(R.id.answer)).setText("Correct Guess!\n");
                    player.setScore(score);
                } else {
                    ((TextView) findViewById(R.id.answer)).setText("Correct Guess!\n");
                }
            } else {
                player.setScore(score);
            }
        }
    }
    public void resetGame(View v){
        Intent intent = new Intent(getApplicationContext(), GameScreen.class);
        startActivity(intent);
        overridePendingTransition(0,0);

    }
}
