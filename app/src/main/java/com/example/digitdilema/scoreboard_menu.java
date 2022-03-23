package com.example.digitdilema;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.digitdilema.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ScoreboardMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoreboard_menu);

        Button mediumscoreboardbutton = (Button) findViewById(R.id.mediumscoreboardbutton);
        mediumscoreboardbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MediumScoreBoard.class);
                startActivity(intent);
            }
        });
    }
}

