package com.example.anew.ifm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import static com.example.anew.ifm.MainActivity.Email;
import static com.example.anew.ifm.MainActivity.Mobilee;
import static com.example.anew.ifm.MainActivity.MyPREFERENCES;
import static com.example.anew.ifm.MainActivity.Namee;
import static com.example.anew.ifm.MainActivity.eml;
import static com.example.anew.ifm.MainActivity.mobbbb;
import static com.example.anew.ifm.MainActivity.namexxx;
import static com.example.anew.ifm.listview1.ssublist;
import static com.example.anew.ifm.orderxx.outletsmail;
import static com.example.anew.ifm.totalc.comments;
import static com.example.anew.ifm.totalc.tot;

/**
 * Created by new on 02-02-2018.
 */

public class manual_address extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    RadioGroup rg;
    RadioButton r1;
    RadioButton r2;
//    RadioButton r3;
//    RadioButton r4;
    static String ordx;
    String modee;
    ProgressBar pbb;
    EditText mobilenu;
    EditText tv;
    EditText pincodee;
    StringBuffer z=new StringBuffer("");
    SharedPreferences sharedpreferences;
    static String mailll,currentaddre;
    static String moppp,urlxx;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mnxxx);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//getSupportActionBar().

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        if(outletsmail.equals("indianfoodmart1@gmail.com")) {
            urlxx = "https://indianfoodmrt.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }

        else if(outletsmail.equals("indianfoodmart2@gmail.com"))
        {
            urlxx = "https://ifmifm2.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart3@gmail.com"))
        {
            urlxx = "https://ifmifm3.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart4@gmail.com"))
        {
            urlxx = "https://ifmifm4.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else
        {
            urlxx = "https://ifmifm6.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }




        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        mailll=sharedpreferences.getString(eml,null);
        moppp=sharedpreferences.getString(mobbbb,null);
      //  Toast.makeText(this, mailll, Toast.LENGTH_SHORT).show();
        tv=(EditText)findViewById(R.id.editTextB3i);
        mobilenu=(EditText)findViewById(R.id.editText7inn);
        Button sensms=(Button)findViewById(R.id.button10m);

        rg=(RadioGroup)findViewById(R.id.radioButtonnn);
        r2=(RadioButton)findViewById(R.id.carodnn);
       r1=(RadioButton)findViewById(R.id.codn);
  //      r4=(RadioButton)findViewById(R.id.carodx);
    //    r3=(RadioButton)findViewById(R.id.codx);
        pbb=(ProgressBar)findViewById(R.id.progressBarim);
        pbb.setVisibility(View.INVISIBLE);


        for(int i=0;i<ssublist.size();i++)
        {
            z.append("NAME:"+ssublist.get(i).getPname()+"\t"+"KGS:"
                    +Integer.toString(ssublist.get(i).getKgsx())+"\t"+"GRAMS:"+Integer.toString(ssublist.get(i).getGmsx())+"\n");
        }



        sensms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    if ((tv.getText().toString()).equals("") || (mobilenu.getText().toString()).equals("")) {
                        Toast.makeText(manual_address.this, "Please fill all the details correctly", Toast.LENGTH_LONG).show();
                    }


                    else {
                        try {
                            if (r1.isChecked() == true) {
                                try {
                                    modee = "cash";
//                                    if(r3.isChecked()==true) {
                                    SendMail sm = new SendMail(manual_address.this, ""+outletsmail, "DELIVERY ORDER",
                                            "Customers Email Address:" + mailll + "\n" + z + "\n\n\n" +
                                                    "Total Amount:\n" + Integer.toString(tot) + "\n" + "Comments:" + "\n"
                                                    + comments + "\n" + "CASH ON DELIVERY" + "\n" + "Location:" + "INDORE" + "\n\n" + "Customers Address:" + tv.getText() +
                                                    "\n" +
                                                    "Customers Mobile Number:" + mobilenu.getText() + "\n" +
                                                    "Customers Database Regestired Mobile Number:" + moppp);

                                    currentaddre=""+(tv.getText().toString());


                                    ordx = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                            + "\n" + "7771008181"
                                            + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                            "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                            "CASH ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";

                                    sm.execute();

                                    new SendPostRequest().execute();
                               // }

/*
                                    else if(r4.isChecked()==true) {
                                        SendMail sm = new SendMail(manual_address.this, "indianfoodmart1@gmail.com", "DELIVERY ORDER",
                                                "Customers Email Address:" + mailll + "\n" + z + "\n\n\n" +
                                                        "Total Amount:\n" + Integer.toString(tot) + "\n" + "Comments:" + "\n"
                                                        + comments + "\n" + "CASH ON DELIVERY" + "\n" + "Location:" +"GWALIOR"+"\n\n"+ "Customers Address:" + tv.getText() +
                                                        "\n" +
                                                        "Customers Mobile Number:" + mobilenu.getText() + "\n" +
                                                        "Customers Database Regestired Mobile Number:" + moppp);

                                        ordx = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                                + "\n" + "7771008181"
                                                + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                                "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                                "CASH ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";

                                        sm.execute();

                                        new SendPostRequest().execute();

                                    }
                                    */
                                }

                                catch (Exception e) {
                                   // Toast.makeText(manual_address.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }


                            else if (r2.isChecked() == true) {
                                try {
                                    modee = "card";
  //                                  if(r3.isChecked()==true) {
                                        SendMail sm = new SendMail(manual_address.this, ""+outletsmail, "DELIVERY ORDER",
                                                "Customers Email Address:" + mailll + "\n" + z + "\n\n\n" +
                                                        "Total Amount:\n" + Integer.toString(tot) + "\n" + "Comments:" + "\n"
                                                        + comments + "\n" + "CASH ON DELIVERY" + "\n" + "Customers Address:" + tv.getText() +
                                                        "\n" +
                                                        "Customers Mobile Number:" + mobilenu.getText() + "\n" +
                                                        "Customers Database Regestired Mobile Number:" + moppp);

                                    currentaddre=""+(tv.getText().toString());


                                        ordx = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                                + "\n" + "7771008181"
                                                + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                                "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                                "CASH ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";

                                        sm.execute();

                                        new SendPostRequest().execute();

    //                                }

/*
//                                    else if(r4.isChecked()==true) {
                                        SendMail sm = new SendMail(manual_address.this, "indianfoodmart1@gmail.com", "DELIVERY ORDER",
                                                "Customers Email Address:" + mailll + "\n" + z + "\n\n\n" +
                                                        "Total Amount:\n" + Integer.toString(tot) + "\n" + "Comments:" + "\n"
                                                        + comments + "\n" + "CASH ON DELIVERY" + "\n" + "Location:"+
                                                        "GWALIOR"+"\n\n"+ "Customers Address:" + tv.getText() +
                                                        "\n" +
                                                        "Customers Mobile Number:" + mobilenu.getText() + "\n" +
                                                        "Customers Database Regestired Mobile Number:" + moppp);

                                        ordx = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                                + "\n" + "7771008181"
                                                + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                                "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                                "CASH ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";

                                        sm.execute();

                                        new SendPostRequest().execute();

//                                    }
*/

                                } catch (Exception e) {
                                //    Toast.makeText(manual_address.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }


                        }



                        catch (Exception e) {
                            //Toast.makeText(manual_address.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }
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
                URL url = new URL(""+urlxx); // here is your URL path
                //Toast.makeText(manual_address.this, ""+url, Toast.LENGTH_SHORT).show();
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("Name", Namee);
                postDataParams.put("Mobile", moppp);
                postDataParams.put("Modeofpayment", modee);
                postDataParams.put("Details", z);
                postDataParams.put("Price", tot);
                postDataParams.put("Address", currentaddre);
                postDataParams.put("Delivery", "Pending");

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
            Intent ixx=new Intent(manual_address.this,lastcl.class);                                                //snkjcnjskcnjskcnknsjndkj
            startActivity(ixx);

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





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        // Assumes current activity is the searchable activity
        ComponentName mycomponent = new ComponentName("com.example.anew.ifm","com.example.anew.ifm.MainActivity");

        searchView.setSearchableInfo(searchManager.getSearchableInfo(mycomponent));
        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

        return true;

   //     return super.onCreateOptionsMenu(menu);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.aboutus) {
            Intent in=new Intent(manual_address.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(manual_address.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(manual_address.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(manual_address.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(manual_address.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }







}
