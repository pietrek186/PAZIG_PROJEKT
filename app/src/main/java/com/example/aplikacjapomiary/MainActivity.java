package com.example.aplikacjapomiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button przypomnienie_button = findViewById(R.id.przypomnienie_button);
        Button tabela_button = findViewById(R.id.tabela_button);
        Button pomiary_button = findViewById(R.id.pomiary_button);
        Button wykresy_button = findViewById(R.id.wykresy_button);

        przypomnienie_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ustaw_przypomnienie.class);
                startActivity(intent);
            }
        });


        tabela_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Tabela.class);
                startActivity(intent);
            }
        });


        pomiary_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Pomiary.class);
                startActivity(intent);
            }
        });


        wykresy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Wykresy.class);
                startActivity(intent);
            }
        });
    }
}