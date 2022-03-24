package com.example.digitdilema;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboardmenu);


        Button easybutton = (Button) findViewById(R.id.button1);
        Button medbutton = (Button) findViewById(R.id.button2);
        Button hardbutton = (Button) findViewById(R.id.button3);

        easybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, EasyScoreboard.class );
                startActivity(intent); }
        });




        medbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MediumScoreboard.class );
                startActivity(intent); }

        });


        hardbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, HardScoreboard.class );
                startActivity(intent); }
        });
    }

}
