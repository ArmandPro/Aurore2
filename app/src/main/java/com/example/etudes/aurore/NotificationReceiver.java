package com.example.etudes.aurore;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import com.google.android.gms.fido.u2f.api.common.ChannelIdValue;

public class NotificationReceiver extends BroadcastReceiver {


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {

        System.out.println("Hello from NotificationReceiver");

        //Get asynchron data of forecast
        Forecast forecast = new Forecast();
        forecast.upDateForecast();

        int kpAt18 = ForecastValue.FORECAST[0][7];


        if(kpAt18 >= 3){

            String Body="This is Aurore";
            if(kpAt18 == 3){
                Body = "This evening kp index is 3, it's pretty low.";
            }else if(kpAt18 == 4){
                Body = "This evening kp index is 4, you can see aurore.";
            }else if(kpAt18 == 5){
                Body = "This evening kp index is 5, it's pretty high!";
            }else if(kpAt18 > 5){
                Body = "This evening kp index is very very high!!";
            }



            final NotificationManager mNotific=
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            CharSequence name="Aurore";
            String desc="Forecast for this evening";
            int imp=NotificationManager.IMPORTANCE_HIGH;
            final String ChannelID="my_channel_01";

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
            {
                NotificationChannel mChannel = new NotificationChannel(ChannelID, name,
                        imp);
                mChannel.setDescription(desc);
                mChannel.setLightColor(Color.CYAN);
                mChannel.canShowBadge();
                mChannel.setShowBadge(true);
                mNotific.createNotificationChannel(mChannel);
            }
            final int ncode=101;

            Notification n = new Notification.Builder(context,ChannelID)
                    .setContentTitle("Aurore")
                    .setContentText(Body)
                    .setBadgeIconType(R.mipmap.ic_launcher)
                    .setNumber(5)
                    .setSmallIcon(R.mipmap.ic_launcher_round)
                    .setAutoCancel(true)
                    .build();

            mNotific.notify(ncode, n);

        }//else any notif



    }
}
