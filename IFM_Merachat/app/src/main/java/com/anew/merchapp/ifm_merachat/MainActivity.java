package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
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

import static com.anew.merchapp.ifm_merachat.page1.cclink;
import static com.anew.merchapp.ifm_merachat.page1.dat;
import static com.anew.merchapp.ifm_merachat.page1.dryfruits;
import static com.anew.merchapp.ifm_merachat.page1.flour;
import static com.anew.merchapp.ifm_merachat.page1.fulllist;
import static com.anew.merchapp.ifm_merachat.page1.grainsabut;
import static com.anew.merchapp.ifm_merachat.page1.herbs;
import static com.anew.merchapp.ifm_merachat.page1.kirana;
import static com.anew.merchapp.ifm_merachat.page1.poojasamagri;
import static com.anew.merchapp.ifm_merachat.page1.pulses;
import static com.anew.merchapp.ifm_merachat.page1.pulsessabut;
import static com.anew.merchapp.ifm_merachat.page1.spices;
import static com.anew.merchapp.ifm_merachat.page1.upwassam;

public class MainActivity extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String namexxx = "nameKey";
    public static final String pswdxxx = "phoneKey";
    public static final String linkoff = "link";
    SharedPreferences sharedpreferences;
    public static String c="";
    public static String d="";
    public static String e="";
/*
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
*/
    ProgressBar pbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi);
        final EditText name = (EditText) findViewById(R.id.editText);
        Button login = (Button) findViewById(R.id.button);
        pbb=(ProgressBar)findViewById(R.id.progressBar3);
        pbb.setVisibility(View.INVISIBLE);
        final EditText pswd = (EditText) findViewById(R.id.editText2);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        c=sharedpreferences.getString(namexxx,null);
        d=sharedpreferences.getString(pswdxxx,null);
        e=sharedpreferences.getString(linkoff,null);
//        Toast.makeText(this, ""+dat.get(1).getUname(), Toast.LENGTH_SHORT).show();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int j=0;j<dat.size();j++)
                {
                    if((dat.get(j).getUname()).equals(name.getText().toString()))
                    {
                        Toast.makeText(MainActivity.this, "mkkmkm", Toast.LENGTH_SHORT).show();
                        if((dat.get(j).getPsswrrd()).equals(pswd.getText().toString()))
                        {
                            SharedPreferences.Editor editor = sharedpreferences.edit();

                            editor.putString(namexxx, (dat.get(j).getUname()));
                            editor.putString(pswdxxx,(dat.get(j).getPsswrrd()));
                            editor.putString(linkoff,(dat.get(j).getLinkx()));
                            editor.commit();
                            editor.apply();

                            fulllist.clear();
                            dryfruits.clear();
                            flour.clear();
                            grainsabut.clear();
                            herbs.clear();
                            kirana.clear();
                            poojasamagri.clear();
                            pulses.clear();
                            pulsessabut.clear();
                            spices.clear();
                            upwassam.clear();


                            getJSON(""+dat.get(j).getLinkx());
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                            break;
                        }

                    }
                    else
                    {
//                        if(j==(dat.size()-1))
//                        {
                            Toast.makeText(MainActivity.this, ""+j, Toast.LENGTH_SHORT).show();
  //                      }
                    }
                }




            }});






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
                pbb.setVisibility(View.INVISIBLE);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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
        int[] idd = new int[jsonArray.length()];
        String[] name = new String[jsonArray.length()];
        String[] rate = new String[jsonArray.length()];
        String[] code = new String[jsonArray.length()];
        String[] dipp = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            idd[i] = obj.getInt("id");
            name[i] = obj.getString("name");
            rate[i] = obj.getString("rate");
            code[i] = obj.getString("Code");
            dipp[i] = obj.getString("dipp");
            ;

            fulllist.add(new Product(i, code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));


            if (code[i].equals("dry_fruits")) {
                dryfruits.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("flour")) {
                flour.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("grain_sabut")) {
                grainsabut.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("herbs")) {
                herbs.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("kirana")) {
                kirana.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("pooja_samagri")) {
                poojasamagri.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("pulses")) {
                pulses.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("pulses_sabut")) {
                pulsessabut.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("spices")) {
                //  Toast.makeText(getApplicationContext(), name[i],Toast.LENGTH_SHORT).show();
                spices.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else if (code[i].equals("upwas_samagri")) {
                upwassam.add(new Product(idd[i], code[i], name[i], rate[i], dipp[i], 0, 0, 0, 0, 0, 0));
            } else {

            }


        }
        Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_LONG).show();
        Intent in=new Intent(MainActivity.this,ImageViewerr.class);
        startActivity(in);

    }
}
