package com.example.digitdilema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HardScoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hardscoreboard);

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
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.help:
                        TableLayout layout = findViewById(R.id.hard_scoreboard);
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


        String[] x = new String[10];
        for (int i = 0; i < x.length; i++) {//Doesn't work rn crashes the app, i'll look at it
            if (ScoreBoard.getScoreboard(3)[i] == null) {
                x[i] = "---";
            } else {
                x[i] = ScoreBoard.getScoreboard(3)[i].getName();//adds the name
            }
        }
        ((TextView) findViewById(R.id.hname1)).setText(x[0]);//should work in theory
        ((TextView) findViewById(R.id.hname2)).setText(x[1]);
        ((TextView) findViewById(R.id.hname3)).setText(x[2]);
        ((TextView) findViewById(R.id.hname4)).setText(x[3]);
        ((TextView) findViewById(R.id.hname5)).setText(x[4]);
        ((TextView) findViewById(R.id.hname6)).setText(x[5]);
        ((TextView) findViewById(R.id.hname7)).setText(x[6]);
        ((TextView) findViewById(R.id.hname8)).setText(x[7]);
        ((TextView) findViewById(R.id.hname9)).setText(x[8]);
        ((TextView) findViewById(R.id.hname10)).setText(x[9]);
        for (int i = 0; i < x.length; i++) {//Doesn't work rn crashes the app, i'll look at it
            if (ScoreBoard.getScoreboard(3)[i] == null) {
                x[i] = "--/--/----";
            } else {
                x[i] = ScoreBoard.getScoreboard(3)[i].getDate();//adds the name
            }
        }
        ((TextView) findViewById(R.id.hd1)).setText(x[0]);//should work in theory
        ((TextView) findViewById(R.id.hd2)).setText(x[1]);
        ((TextView) findViewById(R.id.hd3)).setText(x[2]);
        ((TextView) findViewById(R.id.hd5)).setText(x[3]);
        ((TextView) findViewById(R.id.hd5)).setText(x[4]);
        ((TextView) findViewById(R.id.hd6)).setText(x[5]);
        ((TextView) findViewById(R.id.hd7)).setText(x[6]);
        ((TextView) findViewById(R.id.hd8)).setText(x[7]);
        ((TextView) findViewById(R.id.hd9)).setText(x[8]);
        ((TextView) findViewById(R.id.hd10)).setText(x[9]);
        for (int i = 0; i < x.length; i++) {//Doesn't work rn crashes the app, i'll look at it
            if (ScoreBoard.getScoreboard(3)[i] == null) {
                x[i] = "---";
            } else {
                x[i] = ScoreBoard.getScoreboard(3)[i].getScore() + "";//adds the name
            }
        }
        ((TextView) findViewById(R.id.hscore1)).setText(x[0]);
        ((TextView) findViewById(R.id.hscore2)).setText(x[1]);
        ((TextView) findViewById(R.id.hscore3)).setText(x[2]);
        ((TextView) findViewById(R.id.hscore4)).setText(x[3]);
        ((TextView) findViewById(R.id.hscore5)).setText(x[4]);
        ((TextView) findViewById(R.id.hscore6)).setText(x[5]);
        ((TextView) findViewById(R.id.hscore7)).setText(x[6]);
        ((TextView) findViewById(R.id.hscore8)).setText(x[7]);
        ((TextView) findViewById(R.id.hscore9)).setText(x[8]);
        ((TextView) findViewById(R.id.hscore10)).setText(x[9]);

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