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

public class EasyScoreboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easyscoreboard);

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
                        TableLayout layout = findViewById(R.id.easy_scoreboard);
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
        // creates the scoreboard table
        String[] x = new String[10];
        for(int i = 0;i<x.length;i++){
            if(ScoreBoard.getScoreboard(1)[i]==null){
                x[i] = "---";
            }else{
                x[i] = ScoreBoard.getScoreboard(1)[i].getName();
            }
        }
        ((TextView) findViewById(R.id.name1)).setText(x[0]);
        ((TextView) findViewById(R.id.name2)).setText(x[1]);
        ((TextView) findViewById(R.id.name3)).setText(x[2]);
        ((TextView) findViewById(R.id.name4)).setText(x[3]);
        ((TextView) findViewById(R.id.name5)).setText(x[4]);
        ((TextView) findViewById(R.id.name6)).setText(x[5]);
        ((TextView) findViewById(R.id.name7)).setText(x[6]);
        ((TextView) findViewById(R.id.name8)).setText(x[7]);
        ((TextView) findViewById(R.id.name9)).setText(x[8]);
        ((TextView) findViewById(R.id.name10)).setText(x[9]);
        for(int i = 0;i<x.length;i++){
            if(ScoreBoard.getScoreboard(1)[i]==null){
                x[i] = "--/--/----";
            }else{
                x[i] = ScoreBoard.getScoreboard(1)[i].getDate();
            }
        }
        ((TextView) findViewById(R.id.d1)).setText(x[0]);
        ((TextView) findViewById(R.id.d2)).setText(x[1]);
        ((TextView) findViewById(R.id.d3)).setText(x[2]);
        ((TextView) findViewById(R.id.d4)).setText(x[3]);
        ((TextView) findViewById(R.id.d5)).setText(x[4]);
        ((TextView) findViewById(R.id.d6)).setText(x[5]);
        ((TextView) findViewById(R.id.d7)).setText(x[6]);
        ((TextView) findViewById(R.id.d8)).setText(x[7]);
        ((TextView) findViewById(R.id.d9)).setText(x[8]);
        ((TextView) findViewById(R.id.d10)).setText(x[9]);
        for(int i = 0;i<x.length;i++){
            if(ScoreBoard.getScoreboard(1)[i]==null){
                x[i] = "---";
            }else{
                x[i] = ScoreBoard.getScoreboard(1)[i].getScore()+"";
            }
        }
        ((TextView) findViewById(R.id.escore1)).setText(x[0]);
        ((TextView) findViewById(R.id.escore2)).setText(x[1]);
        ((TextView) findViewById(R.id.escore3)).setText(x[2]);
        ((TextView) findViewById(R.id.escore4)).setText(x[3]);
        ((TextView) findViewById(R.id.escore5)).setText(x[4]);
        ((TextView) findViewById(R.id.escore6)).setText(x[5]);
        ((TextView) findViewById(R.id.escore7)).setText(x[6]);
        ((TextView) findViewById(R.id.escore8)).setText(x[7]);
        ((TextView) findViewById(R.id.escore9)).setText(x[8]);
        ((TextView) findViewById(R.id.escore10)).setText(x[9]);

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