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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.digitdilema.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class scoreboard_menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboardmenu);

        // footer menu, add to every oncreate method
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView2);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.help:
                        ConstraintLayout layout = findViewById(R.id.scoreboardMenu);
                        // inflate the layout of the popup window
                        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.activity_info, null);

                        // create the popup window
                        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                        boolean focusable = true; // lets taps outside the popup close the window
                        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                        popupWindow.showAtLocation(layout, Gravity.CENTER, 0,0);

                        popupView.setOnTouchListener(new View.OnTouchListener(){
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



    public static ScoreBoard temp = new ScoreBoard();

    public void buttonClicked(View v) {
        switch (v.getId()) {
            case R.id.easy://sets the level given the case for the scoreboard
                Intent intent = new Intent(getApplicationContext(), ScoreboardMenuActivity.class);
                startActivity(intent);
                overridePendingTransition(0,0);
                break;
            case R.id.medium:
                Intent intent2 = new Intent(getApplicationContext(), MediumScoreboard.class);
                startActivity(intent2);
                overridePendingTransition(0,0);
                break;

            case R.id.hard:
                temp.setLevel(3);
                break;
        }
    }



}