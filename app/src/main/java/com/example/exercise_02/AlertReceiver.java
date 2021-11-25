package com.example.exercise_02;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper mNotificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = mNotificationHelper.getChannelNotification("What time is it?", "Shister reminder notification time");
        mNotificationHelper.getManager().notify(1, nb.build());
    }
}
