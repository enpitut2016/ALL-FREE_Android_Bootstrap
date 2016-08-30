package com.example.allfree.conotan_bootstrap;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.lang.reflect.Array;

/**
 * Created by MatsudaAtsuto on 2016/08/27.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final int NOTIFICATION_ID = 0;
    Intent intent;
    PendingIntent contentIntent;
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();
        //body = "hoge,http://~";
        String bodyMsg = "";
        String[] msg = body.split(",", 0);
        if(msg.length < 2){
            return;
        }
        bodyMsg = msg[1];
        switch (msg[0]){
            //教えろ通知
            case "0":
                intent = new Intent(MyFirebaseMessagingService.this, HelpDetailActivity.class);
                intent.putExtra("msg", msg[1]);
                contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
                break;
            //この前いったじゃん
            case "1":
                intent = new Intent(MyFirebaseMessagingService.this, ConotanNoticeActivity.class);
                intent.putExtra("msg", msg[1]);
                contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
                break;
            //マニュアル受信
            case "2":
                intent = new Intent(MyFirebaseMessagingService.this, ManualImageActivity.class);
                intent.putExtra("url", msg[2]);
                contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
                break;
        }

        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(title)
                        .setContentText(bodyMsg)
                        .setContentIntent(contentIntent);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());
    }
}