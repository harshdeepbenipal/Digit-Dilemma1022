package com.example.digitdilema;
import android.content.Intent;
import android.os.Bundle;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
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
    private int max = getMax();
    private static Player x = new Player();

    public int getMax(){
        if(InputNameActivity.getCurrent().getLevel()==1){
            return 20;
        }else if(InputNameActivity.getCurrent().getLevel()==2){
            return 50;
        }else if(InputNameActivity.getCurrent().getLevel()==3){
            return 100;
        }
        return -1;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guessingscreen);
        TextView level = (TextView) findViewById(R.id.displayLevel);
        x.setLevel(InputNameActivity.getCurrent().getLevel());
        x.setDate(InputNameActivity.getCurrent().getDate());
        x.setName(InputNameActivity.getCurrent().getName());
        x.setHighscore(InputNameActivity.getCurrent().getHighscore());

        if(x.getLevel() == 1){//don't need the l variable
            level.setText("Level: Easy");
        }else if(x.getLevel() == 2){
            level.setText("Level: Medium");
        }else if(x.getLevel() == 3){
            level.setText("Level: Hard");
        }
        ((TextView) findViewById(R.id.displayName)).setText("Name: "+player.getName());
        ((TextView) findViewById(R.id.displayHighScore)).setText("Highscore: "+highScore);
        ((TextView) findViewById(R.id.displayScore)).setText("Score: "+score);

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
                        player.clearPlayer(0);
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

    //int min = 1;
    int result = getRandom(1,max);

    private int score;
    private Player player = x;
    private int highScore = player.getScore();
    public static int getRandom(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }




    public void buttonClicked(View v) {
        Button btn = (Button) findViewById(R.id.button2);
        int guess;
        System.out.println(result);
        //
        try{
        EditText guessInt = (EditText) findViewById(R.id.guessInt);
        guess = Integer.parseInt(guessInt.getText().toString());
        //
        if (guess < result) {
            score++;
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Is Too Low");
        } else if (guess > result && guess <= max) {
            score++;
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Is Too High");
        } else if (guess > max){
            ((TextView) findViewById(R.id.answer)).setText("Your Guess Must Be Between 1 and " + max);
        } else if (guess == result){
            guessInt.setEnabled(false);
            btn.setEnabled(false);
            ((TextView) findViewById(R.id.answer)).setText("Correct Guess!\n");
            score++;
            player.setScore(score);
            if (score < highScore || highScore == 0){
                highScore = score;
                player.setHighscore(score);
            }
            if(player.getLevel() == 1){
                for (int i = 0; i < 10; i++){
                    if(ScoreBoard.getScoreboard(1)[i] != null){
                        if(ScoreBoard.getScoreboard(1)[i].getName().equals(player.getName())){
                            if(ScoreBoard.getScoreboard(1)[i].getScore() >= highScore){
                                ScoreBoard.getScoreboard(1)[i].setScore(highScore);
                                ScoreBoard.getScoreboard(1)[i].setDate();
                                break;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    else{
                        ScoreBoard.addPlayer(player);
                        break;
                    }
                }
            }

            else if(player.getLevel() == 2){
                for (int i = 0; i < 10; i++){
                    if(ScoreBoard.getScoreboard(2)[i] != null){
                        if(ScoreBoard.getScoreboard(2)[i].getName().equals(player.getName())){
                            if(ScoreBoard.getScoreboard(2)[i].getScore() >= highScore){
                                ScoreBoard.getScoreboard(2)[i].setScore(highScore);
                                ScoreBoard.getScoreboard(2)[i].setDate();
                                break;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    else{
                        ScoreBoard.addPlayer(player);
                        break;
                    }
                }
            }

            else{
                for (int i = 0; i < 10; i++){
                    if(ScoreBoard.getScoreboard(3)[i] != null){
                        if(ScoreBoard.getScoreboard(3)[i].getName().equals(player.getName())){
                            if(ScoreBoard.getScoreboard(3)[i].getScore() >= highScore){
                                ScoreBoard.getScoreboard(3)[i].setScore(highScore);
                                ScoreBoard.getScoreboard(3)[i].setDate();
                                break;
                            }
                            else{
                                break;
                            }
                        }
                    }
                    else{
                        ScoreBoard.addPlayer(player);
                        break;
                    }
                }
            }



        }
        } catch (NumberFormatException nfe){
            ((TextView) findViewById(R.id.answer)).setText("You Must Guess A Number");
        }
        ((TextView) findViewById(R.id.displayHighScore)).setText("Highscore: "+highScore);
        ((TextView) findViewById(R.id.displayScore)).setText("Score: "+score);
    }

    public void resetGame(View v){
        Intent intent = new Intent(getApplicationContext(), GameScreen.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        x.clearPlayer(1);
    }
    public void changeLevel(View v){
        Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
        startActivity(intent);
        overridePendingTransition(0,0);
        x.clearPlayer(0);
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
                player.clearPlayer(0);
                break;



        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
    }

}
