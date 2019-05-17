package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;

/**
 * Created by new on 21-03-2018.
 */

public class orderhis extends AppCompatActivity {
    ProgressBar pbb;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    static String urladap;
    static String ccccadap="";

    static List<xprod> xpr=new ArrayList<>();
    ListView lv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listofoh);
pbb=(ProgressBar)findViewById(R.id.progressBar6);
        lv=(ListView)findViewById(R.id.ll);
        xpr.clear();

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ccccadap=sharedpreferences.getString(namexxx,null);

        if(ccccadap.equals("outlet1"))
        {
            urladap="https://indianfoodmrt.000webhostapp.com/admin/orderhis.php";
        }
        else if(ccccadap.equals("outlet2"))
        {
            urladap="https://ifmifm2.000webhostapp.com/orderhis.php";
        }
        else if(ccccadap.equals("outlet3"))
        {
            urladap="https://ifmifm3.000webhostapp.com/admin/orderhis.php";
        }
        else if(ccccadap.equals("outlet4"))
        {
            urladap="https://ifmifm4.000webhostapp.com/admin/orderhis.php";
        }

        else if(ccccadap.equals("outlet5"))
        {
            urladap="https://ifmifm6.000webhostapp.com/admin/orderhis.php";
        }


        getJSON(""+urladap);


    }
    @Override
    public void onBackPressed() {
        Intent inb=new Intent(orderhis.this, options.class);
        startActivity(inb);
        super.onBackPressed();
    }


    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                pbb.setVisibility(View.VISIBLE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

//                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
                try {
                    loadIntoListView(s);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e) {
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }


    public void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] name = new String[jsonArray.length()];
        String[] mobv = new String[jsonArray.length()];
        String[] pricv = new String[jsonArray.length()];
        String[] detailv = new String[jsonArray.length()];
        String[] deliv = new String[jsonArray.length()];
        String[] addrr = new String[jsonArray.length()];
        String[] idov = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            name[i] = obj.getString("name");
            mobv[i] = obj.getString("mobile");
            pricv[i] = obj.getString("price");
            detailv[i] = obj.getString("details");
            deliv[i] = obj.getString("delivery");
            idov[i] = obj.getString("id");
            addrr[i]=obj.getString("address");
            xpr.add(new xprod(i,name[i],pricv[i],detailv[i],mobv[i],deliv[i],idov[i],addrr[i]));
            //Toast.makeText(this, ""+name[i], Toast.LENGTH_SHORT).show();
        }
        pbb.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        adapterforoh adapterxlv;
        adapterxlv = new adapterforoh(this, xpr);
        lv.setAdapter(adapterxlv);
    }

}