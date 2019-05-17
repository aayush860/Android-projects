package com.anew.merchapp.ifm_merachat;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
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

import org.json.JSONObject;

import static com.anew.merchapp.ifm_merachat.MainActivity.MyPREFERENCES;
import static com.anew.merchapp.ifm_merachat.MainActivity.linkoff;
import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;

/**
 * Created by new on 17-03-2018.
 */

public class page1  extends Activity {
    ProgressBar pbb;
    SharedPreferences sharedpreferences;
    static List<Product> fulllist=new ArrayList<>();
    static List<Product> dryfruits=new ArrayList<>();
    static List<Product> flour=new ArrayList<>();
    static List<Product> grainsabut=new ArrayList<>();
    static List<Product> herbs=new ArrayList<>();
    static List<Product> kirana=new ArrayList<>();
    static List<Product> poojasamagri=new ArrayList<>();
    static List<Product> pulses=new ArrayList<>();
    static List<Product> pulsessabut=new ArrayList<>();
    static List<Product> spices=new ArrayList<>();
    static List<Product> upwassam=new ArrayList<>();

    public static String cc="";
    public static String cclink="";
    static List<comoncla> dat =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagee1);

        pbb = (ProgressBar) findViewById(R.id.progressBar2);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        cc=sharedpreferences.getString(namexxx,null);
        cclink=sharedpreferences.getString(linkoff,null);


        try {
            if (cc.equals("")) {
                getJSON("https://indianfoodmrt.000webhostapp.com/admin/login.php");
            }
            else {
getJSONx(""+cclink);
            }
        }
        catch (Exception e)
        {
            if (cc==null) {
                getJSON("https://indianfoodmrt.000webhostapp.com/admin/login.php");

            } else {
                getJSONx(""+cclink);
            }
        }

    }



    private void getJSONx(final String urlWebService) {

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
                    loadIntoListViewx(s);
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


    public void loadIntoListViewx(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        int[] idd = new int[jsonArray.length()];
        String[] name = new String[jsonArray.length()];
        String[] rate = new String[jsonArray.length()];
        String[] code = new String[jsonArray.length()];
        String[] dipp = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            idd[i]=obj.getInt("id");
            name[i] = obj.getString("name");
            rate[i] = obj.getString("rate");
            code[i] = obj.getString("Code");
            dipp[i]=obj.getString("dipp");;

            fulllist.add(new Product(i,code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));


            if(code[i].equals("dry_fruits"))
            {
                dryfruits.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("flour"))
            {
                flour.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("grain_sabut"))
            {
                grainsabut.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("herbs"))
            {
                herbs.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("kirana"))
            {
                kirana.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("pooja_samagri"))
            {
                poojasamagri.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("pulses"))
            {
                pulses.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("pulses_sabut"))
            {
                pulsessabut.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("spices"))
            {
                //  Toast.makeText(getApplicationContext(), name[i],Toast.LENGTH_SHORT).show();
                spices.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }

            else if(code[i].equals("upwas_samagri"))
            {
                upwassam.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));
            }
            else
            {

            }



        }
        pbb.setVisibility(View.INVISIBLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                Intent in=new Intent(page1.this,ImageViewerr.class);
                startActivity(in);
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
        String[] linkk = new String[jsonArray.length()];
        String[] pswrrd = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            name[i] = obj.getString("uname");
            pswrrd[i] = obj.getString("password");
            linkk[i] = obj.getString("link");
            dat.add(new comoncla(name[i],pswrrd[i],linkk[i]));
            Toast.makeText(this, ""+name[i], Toast.LENGTH_SHORT).show();
        }
        pbb.setVisibility(View.INVISIBLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        Intent in = new Intent(page1.this, MainActivity.class);
        startActivity(in);
    }


}
