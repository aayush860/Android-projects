package com.anew.merchapp.ifm_merachat;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import static com.anew.merchapp.ifm_merachat.MainActivity.linkoff;
import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;
import static com.anew.merchapp.ifm_merachat.MyFirebaseInstanceIdService.refreshedToken;


/**
 * Created by new on 19-01-2018.
 */

public class ddd extends AppCompatActivity {
    public static String msg,urlxxe;
    ProgressBar pbb;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    static String cccce="";
    static String dddde="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);
        Toast.makeText(this, refreshedToken, Toast.LENGTH_SHORT).show();
        Button btnn=(Button)findViewById(R.id.button3);
        Button reg=(Button)findViewById(R.id.button4);
        pbb=(ProgressBar)findViewById(R.id.progressBar7);
pbb.setVisibility(View.INVISIBLE);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        cccce=sharedpreferences.getString(namexxx,null);
        dddde=sharedpreferences.getString(linkoff,null);

        Toast.makeText(ddd.this, "Please Wait...", Toast.LENGTH_SHORT).show();
        Toast.makeText(ddd.this, "Proceed...", Toast.LENGTH_SHORT).show();


        if(cccce.equals("outlet1"))
        {
            urlxxe="https://indianfoodmrt.000webhostapp.com/register.php";
        }
        else if(cccce.equals("outlet2"))
        {
            urlxxe="https://ifmifm2.000webhostapp.com/register.php";
        }
        else if(cccce.equals("outlet3"))
        {
            urlxxe="https://ifmifm3.000webhostapp.com/admin/register.php";
        }
        else if(cccce.equals("outlet4"))
        {
            urlxxe="https://ifmifm4.000webhostapp.com/admin/register.php";
        }
        else if(cccce.equals("outlet5"))
        {
            urlxxe="https://ifmifm6.000webhostapp.com/admin/register.php";
        }

        btnn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                Uri soundUri=Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE
                        + "://" + getPackageName() + "/raw/siren");

//                Uri soundUri = RingtoneManager.getDefaultUri("android.resource://"+getPackageName()+"/"+R.raw.siren);

                NotificationCompat.Builder mBuilder =
                        new NotificationCompat.Builder(ddd.this)
                                .setSmallIcon(R.drawable.ic_launcher)
                                .setContentTitle("Order Placed")
                                .setContentText("Check your email or the app")
                                .setSound(soundUri)
                        .setVibrate(new long[]{1000,2000,500,1000,3000,6000})
                        .setLights(Color.RED,2000,500);


                // Gets an instance of the NotificationManager service//

                NotificationManager mNotificationManager =

                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

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

                String token = FirebaseInstanceId.getInstance().getToken();
                String ccc=FirebaseInstanceId.getInstance().getToken();
                msg=token;
                Toast.makeText(ddd.this, "xxxxxxxxxxxxxxxxxxxxxx"+ccc, Toast.LENGTH_SHORT).show();
                // Log and toast
//                String msg = getString("xxx", token);
                Log.d("TAG", msg);

            //    Toast.makeText(ddd.this, msg, Toast.LENGTH_SHORT).show();


            }
        });

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String token = FirebaseInstanceId.getInstance().getToken();
                msg=token;
                new SendPostRequest().execute();
            }

            });

        //           new SendPostRequest().execute();
}


    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
            pbb.setVisibility(View.VISIBLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL(""+urlxxe); // here is your URL path
                String token = FirebaseInstanceId.getInstance().getToken();
                msg=token;
                JSONObject postDataParams = new JSONObject();


                postDataParams.put("msg", msg);


                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute(String result) {
            pbb.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            Toast.makeText(ddd.this, "Registered", Toast.LENGTH_SHORT).show();
        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    }