/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.appusagestatistics;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Provide views to RecyclerView with the directory entries.
 */
public class UsageListAdapter extends RecyclerView.Adapter<UsageListAdapter.ViewHolder> {

    private List<CustomUsageStats> mCustomUsageStatsList = new ArrayList<>();
    private DateFormat mDateFormat = new SimpleDateFormat();

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mPackageName;
        //private final TextView mLastTimeUsed;
        private final ImageView mAppIcon;
        private final TextView mTotalTimeUsed;
      //  private final TextView totalTimeUsed;
        public ViewHolder(View v) {
            super(v);
            mPackageName = (TextView) v.findViewById(R.id.textview_package_name);
            //mLastTimeUsed = (TextView) v.findViewById(R.id.textview_last_time_used);
           // totalTimeUsed  = (TextView) v.findViewById(R.id.textview_total_time_used);
            mTotalTimeUsed = (TextView) v.findViewById(R.id.textview_total_time_used);
            mAppIcon = (ImageView) v.findViewById(R.id.app_icon);
        }

        /*public TextView getLastTimeUsed() {
            return mLastTimeUsed;
        }*/

        public TextView getTotalTimeInForeground()  {
            return mTotalTimeUsed;
                   // return totalTimeUsed;
        }

        public TextView getPackageName() {
            return mPackageName;
        }

        public ImageView getAppIcon() {
            return mAppIcon;
        }
    }

    public UsageListAdapter() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.usage_row, viewGroup, false);
        return new ViewHolder(v);
    }

    /*@Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getPackageName().setText(
                mCustomUsageStatsList.get(position).usageStats.getPackageName());
        long lastTimeUsed = mCustomUsageStatsList.get(position).usageStats.getLastTimeUsed();
        viewHolder.getLastTimeUsed().setText(mDateFormat.format(new Date(lastTimeUsed)));
        viewHolder.getAppIcon().setImageDrawable(mCustomUsageStatsList.get(position).appIcon);
    }*/

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getPackageName().setText(
                mCustomUsageStatsList.get(position).usageStats.getPackageName());
        long totalTimeUsed = mCustomUsageStatsList.get(position).usageStats.getTotalTimeInForeground();


 //String tt = String.valueOf(totalTimeUsed);


      //  minutes = (int) ((TimeInforground / (1000*60)) % 60);

      //  seconds = (int) (TimeInforground / 1000) % 60 ;

       // hours   = (int) ((TimeInforground / (1000*60*60)) % 24);


        long hours = ((totalTimeUsed / (1000*60*60)) % 24);
      //  long h1 = totalTimeUsed % 3600000;
        long minutes =  ((totalTimeUsed / (60*1000))%60);
      //  long m1 = h1 % 60;m
        long seconds = (totalTimeUsed/1000)%60;
        String minute = String.valueOf(minutes);
        String second = String.valueOf(seconds);
        String hour   = String.valueOf(hours);
        viewHolder.getTotalTimeInForeground().setText(hour + ":" + minute + ":" + second);

      //  viewHolder.getTotalTimeInForeground().setText(tt);

        viewHolder.getAppIcon().setImageDrawable(mCustomUsageStatsList.get(position).appIcon);

    /*  if((minutes < 5 ))

        {


           PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0, discoverableIntent, PendingIntent.FLAG_CANCEL_CURRENT);

            Notification.Builder builder = new Notification.Builder(ctx)
                    .setContentIntent(contentIntent)
                    .setTicker("Требуется действие пользователя")
                    .setContentTitle("Требуется действие пользователя")
                    .setContentText("Необходимо подтвердить включение обнаружения устройства Bluetooth.")
                    .setSmallIcon(R.mipmap.ic_launcher_main)
                    .setWhen(System.currentTimeMillis())
                    .setDefaults(Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                    .setAutoCancel(true);
            Notification notification = builder.getNotification();
            nm.notify(NOTIFY_ID, notification);
            Log.d(LOG_TAG, "Device set up as discoverable")

          // addNotification();
           // displayNotification();



        } */




}



    @Override
    public int getItemCount() {
        return mCustomUsageStatsList.size();
    }

    public void setCustomUsageStatsList(List<CustomUsageStats> customUsageStats) {
        mCustomUsageStatsList = customUsageStats;
    }
}



  /*  private void addNotification() {

     android.support.v7.app.NotificationCompat.Builder mBuilder = (android.support.v7.app.NotificationCompat.Builder)
                    new android.support.v7.app.NotificationCompat.Builder( this)
                            .setSmallIcon(R.drawable.ic_launcher)
                            .setContentTitle("My notification")
                            .setContentText("Hello World!");

            Intent resultIntent = new Intent();

// Because clicking the notification opens a new ("special") activity, there's
// no need to create an artificial back stack.
            PendingIntent resultPendingIntent =
                    PendingIntent.getActivity(this, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT );



            mBuilder.setContentIntent(resultPendingIntent);



// Sets an ID for the notification
            int mNotificationId = 001;
// Gets an instance of the NotificationManager service
            NotificationManager mNotifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// Builds the notification and issues it.
            mNotifyMgr.notify(mNotificationId, mBuilder.build());

/*


        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");

        Intent notificationIntent = new Intent(this, this.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }




    protected void displayNotification() {
        int numMessages=0;
        int notificationID =1;


        Log.i("Start", "notification");

    Invoking the default notification service
        NotificationCompat.Builder  mBuilder = new NotificationCompat.Builder(this);

        mBuilder.setContentTitle("New Message");
        mBuilder.setContentText("You've received new message.");
        mBuilder.setTicker("New Message Alert!");
        //    mBuilder.setSmallIcon(R.drawable.tech5);

   Increase notification number every time a new notification arrives
        mBuilder.setNumber(++numMessages);

    Add Big View Specific Configuration
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();

        String[] events = new String[6];
        events[0] = new String("This is first line....");
        events[1] = new String("This is second line...");
        events[2] = new String("This is third line...");
        events[3] = new String("This is 4th line...");
        events[4] = new String("This is 5th line...");
        events[5] = new String("This is 6th line...");

        // Sets a title for the Inbox style big view
        inboxStyle.setBigContentTitle("Big Title Details:");

        // Moves events into the big view
        for (int i=0; i < events.length; i++) {
            inboxStyle.addLine(events[i]);
        }

        mBuilder.setStyle(inboxStyle);

    Creates an explicit intent for an Activity in your app
     //   Intent resultIntent = new Intent(this, Notificationiew.class);

     //   TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
      //  stackBuilder.addParentStack(Notificationiew.class);

    Adds the Intent that starts the Activity to the top of the stack
      //  stackBuilder.addNextIntent(resultIntent);
     //   PendingIntent resultPendingIntent =stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);

      //  mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


    notificationID allows you to update the notification later on.
        manager.notify(notificationID, mBuilder.build());
    }
*/