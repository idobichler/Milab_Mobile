package com.example.exercise_02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class StarkActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    String starkNames[];
    int images[] = {R.drawable.sansa, R.drawable.arya, R.drawable.bran, R.drawable.robb, R.drawable.eddard, R.drawable.lyanna, R.drawable.catelyn, R.drawable.rickon, R.drawable.john};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stark);

        recyclerView = findViewById(R.id.starkView);

        starkNames = getResources().getStringArray(R.array.Stark);

        MyAdaptar adapter = new MyAdaptar(this, starkNames, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}