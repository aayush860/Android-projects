package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import static com.anew.merchapp.ifm_merachat.MainActivity.MyPREFERENCES;
import static com.anew.merchapp.ifm_merachat.MainActivity.linkoff;
import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;
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

/**
 * Created by new on 19-03-2018.
 */

public class delit extends AppCompatActivity {
    ProgressBar pbb;
    static String tn,npn,pc,rx,bx,urlxxc,valx;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    static String cccc="";
    static String dddd="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delitt);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        cccc=sharedpreferences.getString(namexxx,null);
        dddd=sharedpreferences.getString(linkoff,null);
        pbb=(ProgressBar)findViewById(R.id.progressBar4);
        Button btx=(Button)findViewById(R.id.button9);
        Button nooo=(Button)findViewById(R.id.button10);
pbb.setVisibility(View.INVISIBLE);
        if(cccc.equals("outlet1"))
        {
            urlxxc="https://indianfoodmrt.000webhostapp.com/admin/delete.php";
        }
        else if(cccc.equals("outlet2"))
        {
            urlxxc="https://ifmifm2.000webhostapp.com/delete.php";
        }
        else if(cccc.equals("outlet3"))
        {
            urlxxc="https://ifmifm3.000webhostapp.com/admin/delete.php";
        }
        else if(cccc.equals("outlet4"))
        {
            urlxxc="https://ifmifm4.000webhostapp.com/admin/delete.php";
        }
        else if(cccc.equals("outlet5"))
        {
            urlxxc="https://ifmifm6.000webhostapp.com/admin/delete.php";
        }




        nooo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent inp=new Intent(delit.this,listview1.class);
            inp.putExtra("but0",""+valx);
            }});

        btx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent inn = getIntent();

                if (inn != null) {
                    String cli = inn.getStringExtra("id");
                    String ar1[] = cli.split(",");
                    if (ar1[0].equals("dryfruits")) {
                        for (int x = 0; x < dryfruits.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Dry-Fruits";
                                valx="list0";
                                pc = dryfruits.get(x).getPname();
                            }
                        }
                    } else if (ar1[0].equals("flour")) {
                        for (int x = 0; x < flour.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Flour";
                                pc = flour.get(x).getPname();
                                valx="list1";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }



                    else if (ar1[0].equals("grainsabut")) {
                        for (int x = 0; x < grainsabut.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Grain (Sabut)";
                                pc = grainsabut.get(x).getPname();
                                valx="list2";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                    else if (ar1[0].equals("herbs")) {
                        for (int x = 0; x < herbs.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Herbs";
                                pc = herbs.get(x).getPname();
                                valx="list3";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                    else if (ar1[0].equals("kirana")) {
                        for (int x = 0; x < kirana.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Kirana";
                                pc = kirana.get(x).getPname();
                                valx="list4";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                    else if (ar1[0].equals("poojasamagri")) {
                        for (int x = 0; x < poojasamagri.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Pooja-Samagri";
                                pc = poojasamagri.get(x).getPname();
                                valx="list5";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                    else if (ar1[0].equals("pulses")) {
                        for (int x = 0; x < pulses.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Pulses";
                                pc = pulses.get(x).getPname();
                                valx="list6";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }


                    else if (ar1[0].equals("pulsessabut")) {
                        for (int x = 0; x < pulsessabut.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Pulses (Sabut)";
                                pc = pulsessabut.get(x).getPname();
                                valx="list7";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }



                    else if (ar1[0].equals("spices")) {
                        for (int x = 0; x < spices.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Spices";
                                pc = spices.get(x).getPname();
                                valx="list8";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }



                    else if (ar1[0].equals("upwassam")) {
                        for (int x = 0; x < upwassam.size(); x++) {
                            if (ar1[1].equals(Integer.toString(x))) {
                                tn = "Upwas-Samagri";
                                pc = upwassam.get(x).getPname();
                                valx="list9";

                                //Toast.makeText(this, "" + flour.get(x).getPname(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }




                }
                new SendPostRequest().execute();
            }});
    }


    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
            pbb.setVisibility(View.VISIBLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        protected String doInBackground(String... arg0) {

            try {
                URL url = new URL(""+urlxxc); // here is your URL path
                //Toast.makeText(manual_address.this, ""+url, Toast.LENGTH_SHORT).show();
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("tablename", tn);
                postDataParams.put("prodchg", pc);

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

            //SendMail sm1 = new SendMail(MapsActivity.this, Email, "Order Confirmed", "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:" + "\n" + "07314966377" + "\n" + "07314966833" + "\n" + "Total Amount:\n" + Integer.toString(tot) + "\n" + "CASH ON DELIVERY" + "\n" + "Your Address:" + address.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING LASA");
            //sm1.execute();
            pbb.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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

            getJSON(dddd);
            //Intent ixx=new Intent(manual_address.this,lastcl.class);                                                //snkjcnjskcnjskcnknsjndkj
            //startActivity(ixx);

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
        Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_LONG).show();
        Intent in=new Intent(delit.this,listview1.class);
      //  Toast.makeText(this, ""+fulllist.get(0).getPname(), Toast.LENGTH_LONG).show();

        in.putExtra("but0",""+valx);
        startActivity(in);

    }


}
