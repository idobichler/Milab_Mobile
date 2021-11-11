package com.example.exercise_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

public class LannisterActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String lannisterNames[];
    int images[] = {R.drawable.sansa, R.drawable.tyrion, R.drawable.cersei, R.drawable.jaime, R.drawable.tywin, R.drawable.lancel, R.drawable.kevan, R.drawable.martyn};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lannister);

        recyclerView = findViewById(R.id.lannisterView);

        lannisterNames = getResources().getStringArray(R.array.Lanhister);

        MyAdaptar adapter = new MyAdaptar(this, lannisterNames, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}