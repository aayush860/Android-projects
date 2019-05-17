package com.example.anew.ifm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

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

import static com.example.anew.ifm.MainActivity.MyPREFERENCES;
import static com.example.anew.ifm.MainActivity.eml;
import static com.example.anew.ifm.MapsActivity.ord;
import static com.example.anew.ifm.manual_address.ordx;
import static com.example.anew.ifm.orderxx.outletsmail;
import static com.example.anew.ifm.totalc.tot;

public class lastcl extends AppCompatActivity {
    ProgressBar pbb;
    SharedPreferences sharedpreferences;
    static String mailll,kkk;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipt);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mailll=sharedpreferences.getString(eml,null);




        if(outletsmail.equals("indianfoodmart1@gmail.com")) {
            kkk = "https://indianfoodmrt.000webhostapp.com/alarm.php"; // here is your URL path
        }

        else if(outletsmail.equals("indianfoodmart2@gmail.com"))
        {
            kkk = "https://ifmifm2.000webhostapp.com/alarm.php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart3@gmail.com"))
        {
            kkk = "https://ifmifm3.000webhostapp.com/admin/alarm.php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart4@gmail.com"))
        {
            kkk = "https://ifmifm4.000webhostapp.com/admin/alarm.php"; // here is your URL path
        }
        else
        {
            kkk = "https://ifmifm6.000webhostapp.com/admin/alarm.php"; // here is your URL path
        }






        TextView tota=(TextView)findViewById(R.id.textView14ii);
        Button ex=(Button)findViewById(R.id.button9ii);
        pbb=(ProgressBar)findViewById(R.id.progressBar5);
        Button goback=(Button)findViewById(R.id.button11ii);
        tota.setText("Total:"+Integer.toString(tot));
        pbb.setVisibility(View.INVISIBLE);
        new SendPostRequest().execute();

        ex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finishAffinity();
                System.exit(0);

            }
            });

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dd=new Intent(lastcl.this,ImageViewerr.class);
                startActivity(dd);
            }
        });

    }
    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
            pbb.setVisibility(View.VISIBLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL(""+kkk); // here is your URL path

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("email", ""+mailll);

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
if(ord==null) {
    Toast.makeText(lastcl.this, ""+mailll, Toast.LENGTH_SHORT).show();
    sendmail2 sm = new sendmail2(lastcl.this, "" + mailll, "Order Confirmed", "" + ordx);
    sm.execute();
}
else
{    Toast.makeText(lastcl.this, ""+mailll, Toast.LENGTH_SHORT).show();
    sendmail2 sm = new sendmail2(lastcl.this, "" + mailll, "Order Confirmed", "" + ord);
    sm.execute();
}
            //SendMail sm1 = new SendMail(MapsActivity.this, mailll, "Order Confirmed", "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:" + "\n" + "07314966377" + "\n" + "07314966833" + "\n" + "Total Amount:\n" + Integer.toString(tot) + "\n" + "CASH ON DELIVERY" + "\n" + "Your Address:" + address.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING LASA");
            //sm1.execute();
            pbb.setVisibility(View.INVISIBLE);
          getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            //}
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
