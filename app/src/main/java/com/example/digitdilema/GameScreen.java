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

import java.util.logging.Level;


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

        // footer menu, add to every oncreate method
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView2);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem item = menu.getItem(0);
        item.setChecked(true);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.help:
                        ConstraintLayout layout = findViewById(R.id.guess);
                        // inflate the layout of the popup window
                        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.activity_info, null);

                        // create the popup window
                        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                        boolean focusable = true; // lets taps outside the popup close the window
                        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                        popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

                        popupView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });
                        return true;
                }
                return false;
            }
        });
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
        } else if (guess > result && guess < max) {
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Is Too High");
        } else if (guess > max){
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Must Be Between 1 and " + max);
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
    public void changeLevel(View v){
        Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
    }


    // header menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header, menu);
        return true;
    }

    //header menu items
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.scoreboard:
                Intent intent = new Intent(getApplicationContext(), ScoreboardMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                break;



        }
        return super.onOptionsItemSelected(item);
    }
}
