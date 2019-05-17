package com.anew.merchapp.ifm_merachat;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

/**
 * Created by new on 20-01-2018.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());
//        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Uri soundUri=Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                + "://" + getPackageName() + "/raw/siren");
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(MyFirebaseMessagingService.this)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentTitle("Order Placed")
                        .setContentText("Check ur email")
                        .setSound(soundUri);


        // Gets an instance of the NotificationManager service//

        NotificationManager mNotificationManager =(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // When you issue multiple notifications about the same type of event,
        // it’s best practice for your app to try to update an existing notification
        // with this new information, rather than immediately creating a new notification.
        // If you want to update this notification at a later date, you need to assign it an ID.
        // You can then use this ID whenever you issue a subsequent notification.
        // If the previous notification is still visible, the system will update this existing notification,
        // rather than create a new one. In this example, the notification’s ID is 001//
//
        //              NotificationManager.notify().

        mNotificationManager.notify(001, mBuilder.build());
        int importance = NotificationManager.IMPORTANCE_HIGH;
//                String description = getString(R.string.channel_description);

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

    }
}