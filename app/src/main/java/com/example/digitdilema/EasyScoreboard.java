package com.example.digitdilema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EasyScoreboard extends AppCompatActivity {
    //private static ScoreBoard x = InputNameActivity.getCurrent();
    //private Player player = x.getPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easyscoreboard);
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
        String[] x = new String[10];
        for(int i = 0;i<x.length;i++){//Doesn't work rn crashes the app, i'll look at it
            if(ScoreBoard.getScoreboard(1)[i]==null){
                x[i] = "---";
            }else{
                x[i] = ScoreBoard.getScoreboard(1)[i].getName();//adds the name
            }
        }
        ((TextView) findViewById(R.id.name1)).setText(x[0]);//should work in theory
        ((TextView) findViewById(R.id.name2)).setText(x[1]);
        ((TextView) findViewById(R.id.name3)).setText(x[2]);
        ((TextView) findViewById(R.id.name4)).setText(x[3]);
        ((TextView) findViewById(R.id.name5)).setText(x[4]);
        ((TextView) findViewById(R.id.name6)).setText(x[5]);
        ((TextView) findViewById(R.id.name7)).setText(x[6]);
        ((TextView) findViewById(R.id.name8)).setText(x[7]);
        ((TextView) findViewById(R.id.name9)).setText(x[8]);
        ((TextView) findViewById(R.id.name10)).setText(x[9]);

        //((TextView) findViewById(R.id.d2)).setText(x.getPlayer().getDate());

        //((TextView) findViewById(R.id.name1)).setText(x.getPlayer().getName());

    }







}