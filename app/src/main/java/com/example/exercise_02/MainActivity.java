package com.example.exercise_02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button starkButton = findViewById(R.id.button1);
        Button lannisterButton = findViewById(R.id.button2);

        starkButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), StarkActivity.class);
            startActivity(intent);
        });

        lannisterButton.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), LannisterActivity.class);
            startActivity(intent);
        });


    }
}