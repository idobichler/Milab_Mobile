package com.example.exercise_02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    boolean active = false;
    Button startButton;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);
        stopButton.setVisibility(View.GONE);
    }

    @Override
    protected void onStart() {
        super.onStart();


        Spinner intervalSpinner = findViewById(R.id.interval);
        int[] intervalIntArray = getResources().getIntArray(R.array.IntTime);

        startButton.setOnClickListener(view -> {
            int intervalMinutes = intervalIntArray[(int) intervalSpinner.getSelectedItemId()];
            startAlarm(intervalMinutes);
            startButton.setVisibility(View.GONE);
            stopButton.setVisibility(View.VISIBLE);
        });

        stopButton.setOnClickListener(view -> {
            stopAlarm();
            startButton.setVisibility(View.VISIBLE);
            stopButton.setVisibility(View.GONE);
        });

    }



    private void startAlarm(int intervalMinutes){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        int interval = intervalMinutes * 60000;
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), interval, pendingIntent);
    }


    private void stopAlarm(){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);
        alarmManager.cancel(pendingIntent);
    }


}