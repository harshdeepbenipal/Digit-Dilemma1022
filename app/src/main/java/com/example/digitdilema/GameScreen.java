package com.example.digitdilema;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class GameScreen extends AppCompatActivity {
    int max = getMax();
    int l;


    public int getMax(){
        if(x.getLevel()==1){
            l = 0;
            return 20;
        }else if(x.getLevel()==2){
            l = 1;
            return 50;
        }else{
            l=2;
            return 100;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guessingscreen);
        TextView level = (TextView) findViewById(R.id.displayLevel);
        if(l == 0){
            level.setText("Level: Easy");
        }else if(l == 1){
            level.setText("Level: Medium");
        }else if(l == 2){
            level.setText("Level: Hard");
        }
    }

    private static ScoreBoard x = InputNameActivity.getCurrent();
    int min = 1;
    int result = 2;

            //getRandom(min, max);
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
            ((TextView) findViewById(R.id.answer)).setText("Too Low");
        } else if (guess > result) {
            ((TextView) findViewById(R.id.answer)).setText("Too High");
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


}
