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
import android.text.format.Time;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by new on 14-04-2018.
 */

public class natlaogin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public static String unamee,Email, Password,Namee,Mobilee,gdorrx,reffff;
    String[] fiemail;
    String[] uname;
    String[] fipass;
    String[] finame;
    String[] fimob;
    String[] gdorx;
    String[] refrall;
    ProgressBar pbb;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String namexxx = "nameKey";
    public static final String pswdxxx = "phoneKey";

    public static final String mobbbb = "mob";
    public static final String gdorxxxx = "gdo";
    public static final String refffff = "ref";
    public static final String fnnn = "firstname";
    public static final String eml = "email";
    public static String c="";
    public static String d="";

    public static String e="";
    public static String f="";
    public static String g="";
    public static String h="";
//ProgressBar pbb;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activi_mainx);

     
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



        pbb = (ProgressBar) findViewById(R.id.progressBar3);
        final EditText name = (EditText) findViewById(R.id.editText);
        Button login = (Button) findViewById(R.id.buttonz);
        final EditText pswd = (EditText) findViewById(R.id.editText2);
        pbb.setVisibility(View.GONE);



        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        c=sharedpreferences.getString(namexxx,null);
        d=sharedpreferences.getString(pswdxxx,null);
        e=sharedpreferences.getString(mobbbb,null);
        f=sharedpreferences.getString(refffff,null);
        g=sharedpreferences.getString(fnnn,null);
        h=sharedpreferences.getString(gdorxxxx,null);

        try {
            if (c.equals("")) {
                name.setText(c);
                pswd.setText(d);
            } else {
                name.setText(c);
                pswd.setText(d);            }
        }
        catch (Exception e)
        {
            if (c==null) {
                name.setText(c);
                pswd.setText(d);
            } else {
                name.setText(c);
                pswd.setText(d);
            }
        }





        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                              unamee=name.getText().toString();
                            Password=pswd.getText().toString();

/*
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(namexxx, Email);
                editor.putString(pswdxxx,Password);
                editor.commit();
                editor.apply();
*/

//                new SendPostRequest().execute();
                Time t=new Time(Time.getCurrentTimezone());
                t.setToNow();
                Toast.makeText(natlaogin.this,"Please Wait Checking Credientials...",Toast.LENGTH_LONG).show();
                getJSON("https://indianfoodmrt.000webhostapp.com/fetcher.php");


            }
        });



    }







    public void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pbb.setVisibility(View.VISIBLE);
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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
        fiemail= new String[jsonArray.length()];
        fipass=new String[jsonArray.length()];
        finame= new String[jsonArray.length()];
        fimob=new String[jsonArray.length()];
        gdorx=new String[jsonArray.length()];
        uname=new String[jsonArray.length()];
        refrall=new String[jsonArray.length()];
        int cou=0;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            uname[i] = obj.getString("uname");
            fiemail[i] = obj.getString("email");
            fipass[i] = obj.getString("password");
            finame[i]=obj.getString("firstname");
            fimob[i]=obj.getString("mobile");
            refrall [i]=obj.getString("refral");
            try{
                gdorx[i]=obj.getString("got_disc_on_ref");
            }
            catch (Exception e)
            {

            }

            if(uname[i].equals(unamee))
            {cou++;
                if(fipass[i].equals(Password))
                {
                    Email=fiemail[i];
                    Namee=finame[i];
                    Mobilee=fimob[i];
                    gdorrx=gdorx[i];
                    reffff=refrall[i];
                    //Toast.makeText(natlaogin.this,gdorrx,Toast.LENGTH_SHORT).show();
                    Toast.makeText(natlaogin.this,"Login sucessful",Toast.LENGTH_SHORT).show();
                    pbb.setVisibility(View.GONE);
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    //psd=pswd.getText().toString();

                    editor.putString(namexxx, unamee);
                    editor.putString(pswdxxx,Password);
                    editor.putString(fnnn, Namee);
                    editor.putString(mobbbb,Mobilee);
                    editor.putString(gdorxxxx, gdorrx);
                    editor.putString(refffff,reffff);
                    editor.putString(eml, ""+Email);

                    Toast.makeText(this, ""+Email, Toast.LENGTH_SHORT).show();

                    //editor.putString(Email, e);
                    editor.commit();
                    editor.apply();


                    Intent iii=new Intent(natlaogin.this,ImageViewerr.class);
                    startActivity(iii);
                    break;
                }
                Toast.makeText(natlaogin.this,"Wrong Password",Toast.LENGTH_SHORT).show();
                break;
            }

        }
        if (cou == 0) {
            Toast.makeText(natlaogin.this,"Username not Found",Toast.LENGTH_SHORT).show();
        }
        pbb.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
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
        ComponentName mycomponent = new ComponentName("com.example.anew.ifm","com.example.anew.ifm.natlaogin");

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
            Intent in=new Intent(natlaogin.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(natlaogin.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(natlaogin.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(natlaogin.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(natlaogin.this,exitc.class);
            startActivity(in);
        }
//        else if (id == R.id.nav_exit) {
        //Intent in=new Intent(ImageViewerr.this,exit.class);
        //startActivity(in);
        //      }
//
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
