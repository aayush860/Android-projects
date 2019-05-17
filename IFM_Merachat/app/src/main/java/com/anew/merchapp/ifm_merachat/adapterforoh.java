package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;
import static com.anew.merchapp.ifm_merachat.options.dell;
import static com.anew.merchapp.ifm_merachat.orderhis.ccccadap;
import static com.anew.merchapp.ifm_merachat.page1.dryfruits;
import static com.anew.merchapp.ifm_merachat.page1.flour;
import static com.anew.merchapp.ifm_merachat.page1.fulllist;


public class adapterforoh extends BaseAdapter {
    public Context llcontext;
    ProgressBar pbbb;
    static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
    //    int counnt=0;
    public List<xprod> xpr;
String xxxx,urllll;


    public adapterforoh(Context llcontext, List<xprod> xpr) {
        this.llcontext = llcontext;
        this.xpr = xpr;

    }

    @Override
    public int getCount() {
        return xpr.size();
    }

    @Override
    public Object getItem(int i) {
        return xpr.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(llcontext,R.layout.togadapsingle,null);
        v.setTag(vh);

        //vh.pbb=(ProgressBar)v.findViewById(R.id.progressBar5);

        pbbb=(ProgressBar)v.findViewById(R.id.progressBar5);
        pbbb.setVisibility(View.GONE);
vh.plus=(Button)v.findViewById(R.id.button12);
vh.plus.setText("Order "+Integer.toString(i));
        Switch sw=(Switch)v.findViewById(R.id.switch1);


        if(ccccadap.equals("outlet1"))
        {
            urllll="https://indianfoodmrt.000webhostapp.com/admin/orderupdater.php";
        }
        else if(ccccadap.equals("outlet2"))
        {
            urllll="https://ifmifm2.000webhostapp.com/orderupdater.php";
        }
        else if(ccccadap.equals("outlet3"))
        {
            urllll="https://ifmifm3.000webhostapp.com/admin/orderupdater.php";
        }
        else if(ccccadap.equals("outlet4"))
        {
            urllll="https://ifmifm4.000webhostapp.com/admin/orderupdater.php";
        }

        else if(ccccadap.equals("outlet5"))
        {
            urllll="https://ifmifm6.000webhostapp.com/admin/orderupdater.php";
        }



        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
         //       View v=lv.getChildAt(4);
xxxx=xpr.get(i).getIdoo();

                new SendPostRequest().execute();
            }
        });

        vh.plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v= parent.getChildAt(i);
                llcontext.startActivity(new Intent(llcontext, order_details.class).putExtra("ival", ""+Integer.toString(i)));

            }
        });

        return v;
    }
    static class viewholder{
        Button plus;
        //ProgressBar pbb;
        int ref;

    }

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
        pbbb.setVisibility(View.VISIBLE);
        }

        protected String doInBackground(String... arg0) {
            try {
                URL url = new URL(""+urllll); // here is your URL path
                //Toast.makeText(manual_address.this, ""+url, Toast.LENGTH_SHORT).show();
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("deli", "Delivered");
                postDataParams.put("ido", ""+xxxx);

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
//                Toast.makeText(MapsActivity.this, "Step1", Toast.LENGTH_LONG).show();
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
pbbb.setVisibility(View.GONE);
            Toast.makeText(llcontext, "updated", Toast.LENGTH_SHORT).show();
            llcontext.startActivity(new Intent(llcontext, orderhis.class));
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
