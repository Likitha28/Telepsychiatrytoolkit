package com.example.android.appusagestatistics;

/**
 * Created by root on 18/3/17.
 */

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.widget.RecyclerView;


public class Notificationview extends Service {

    @Override
    public void onCreate()
    {
        Intent resultIntent=new Intent(this, RecyclerView.class);
        PendingIntent pIntent= PendingIntent.getActivity(this,0,resultIntent,0);
        Notification nBuilder= new Notification.Builder(this)
                .setContentTitle("This task is due!")
                .setContentIntent(pIntent)
                .setSmallIcon(R.drawable.ic_launcher)
                .build();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nBuilder.flags |=Notification.FLAG_AUTO_CANCEL;

        notificationManager.notify(1,nBuilder);

    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

