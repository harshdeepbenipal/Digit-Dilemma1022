package com.example.digitdilema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

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

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class EasyScoreboard extends AppCompatActivity {
    private static ScoreBoard x = InputNameActivity.getCurrent();
    private Player player = x.getPlayer();


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
                        return true;
                    case R.id.help:
                        ConstraintLayout layout = findViewById(R.id.main);
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
        for(int i = 0;i<x.length;i++){
            x[i] = ScoreBoard.getScoreboard(1)[i].getPlayer().getDate();//adds the date to the array
        }
        ((TextView) findViewById(R.id.date1)).setText(x[0]);//should work in theory
        ((TextView) findViewById(R.id.date2)).setText(x[1]);
        ((TextView) findViewById(R.id.date2)).setText(x[2]);
        ((TextView) findViewById(R.id.date2)).setText(x[3]);
        ((TextView) findViewById(R.id.date2)).setText(x[4]);
        ((TextView) findViewById(R.id.date2)).setText(x[5]);
        ((TextView) findViewById(R.id.date2)).setText(x[6]);
        ((TextView) findViewById(R.id.date2)).setText(x[7]);
        ((TextView) findViewById(R.id.date2)).setText(x[8]);
        ((TextView) findViewById(R.id.date2)).setText(x[9]);

        ((TextView) findViewById(R.id.d2)).setText(x.getPlayer().getDate());

        ((TextView) findViewById(R.id.name1)).setText(x.getPlayer().getName());

    }







}