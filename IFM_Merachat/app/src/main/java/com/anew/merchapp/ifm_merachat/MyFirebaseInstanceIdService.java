package com.anew.merchapp.ifm_merachat;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by new on 20-01-2018.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {
    public static String refreshedToken;
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("x", "Refreshed token: " + refreshedToken);
      //  Toast.makeText(this,refreshedToken,Toast.LENGTH_SHORT).show();

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.

        //sendRegistrationToServer(refreshedToken);
    }
}
