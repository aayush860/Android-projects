package com.example.anew.ifm;

import android.app.Activity;
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
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

import static com.example.anew.ifm.MainActivity.Email;
import static com.example.anew.ifm.MainActivity.Mobilee;
import static com.example.anew.ifm.MainActivity.MyPREFERENCES;
import static com.example.anew.ifm.MainActivity.Namee;
import static com.example.anew.ifm.MainActivity.c;
import static com.example.anew.ifm.MainActivity.d;
import static com.example.anew.ifm.MainActivity.e;
import static com.example.anew.ifm.MainActivity.f;
import static com.example.anew.ifm.MainActivity.g;
import static com.example.anew.ifm.MainActivity.h;
import static com.example.anew.ifm.MainActivity.gdorrx;
import static com.example.anew.ifm.MainActivity.fnnn;
import static com.example.anew.ifm.MainActivity.gdorxxxx;
import static com.example.anew.ifm.MainActivity.mobbbb;
import static com.example.anew.ifm.MainActivity.namexxx;
import static com.example.anew.ifm.MainActivity.pswdxxx;
import static com.example.anew.ifm.MainActivity.reffff;
import static com.example.anew.ifm.MainActivity.refffff;

import static com.example.anew.ifm.orderxx.dryfruits;
import static com.example.anew.ifm.orderxx.flour;
import static com.example.anew.ifm.orderxx.fulllist;
import static com.example.anew.ifm.orderxx.grainsabut;
import static com.example.anew.ifm.orderxx.herbs;
import static com.example.anew.ifm.orderxx.kirana;
import static com.example.anew.ifm.orderxx.poojasamagri;
import static com.example.anew.ifm.orderxx.pulses;
import static com.example.anew.ifm.orderxx.pulsessabut;
import static com.example.anew.ifm.orderxx.spices;
import static com.example.anew.ifm.orderxx.upwassam;
import static com.example.anew.ifm.orderxx.outletsmail;
import static com.example.anew.ifm.orderxx.pswrdddd;

public class page1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    SharedPreferences sharedpreferences;
    ProgressBar pbb;

    Spinner xx;
    public static String Emaili, Passwordi,Nameei,Mobileei,gdorrxi,reffffi,linkkkk;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stoselxx);




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









        xx=(Spinner)findViewById(R.id.spinner);

        pbb=(ProgressBar)findViewById(R.id.progressBar6);
        pbb.setVisibility(View.INVISIBLE);



        int yy=0;
        List<String> pkg = new ArrayList<>();
        pkg.add("Goyal Kirana");
        pkg.add("Pragati Traders");
        pkg.add("Bakebihari Dryfruits");
        pkg.add("Tamanna Traders");
        pkg.add("Jai maa kaila devi store");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, pkg);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        xx.setAdapter(adapter);
        Button btn=(Button)findViewById(R.id.button78);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


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







                linkkkk = String.valueOf(xx.getSelectedItemId());
    //            Toast.makeText(page1.this, linkkkk, Toast.LENGTH_SHORT).show();
                if (linkkkk.equals("0")) {
  //                  Toast.makeText(page1.this, "1", Toast.LENGTH_SHORT).show();
//            linkkkk="https://indianfoodmrt.000webhostapp.com/prodfetcher.php";
                    getJSON("https://indianfoodmrt.000webhostapp.com/prodfetcher.php");
                    outletsmail="indianfoodmart1@gmail.com";
                    pswrdddd="xxxxxxx";

                } else if (linkkkk.equals("1")) {
                    getJSON("https://ifmifm2.000webhostapp.com/prodfetcher.php");
                    outletsmail="indianfoodmart2@gmail.com";
                    pswrdddd="Indianfoodmrt@24";
//                    Toast.makeText(page1.this, "122", Toast.LENGTH_SHORT).show();

                } else if (linkkkk.equals("2")) {
                    getJSON("https://ifmifm3.000webhostapp.com/prodfetcher.php");
                    outletsmail="indianfoodmart3@gmail.com";
                    pswrdddd="Indianfoodmrt@24";
                }
                else if (linkkkk.equals("3")) {
                    getJSON("https://ifmifm4.000webhostapp.com/prodfetcher.php");
                    outletsmail="indianfoodmart4@gmail.com";
                    pswrdddd="Indianfoodmrt@24";
                }
                else if (linkkkk.equals("4")) {
                    getJSON("https://ifmifm6.000webhostapp.com/prodfetcher.php");
                    outletsmail="indianfoodmart6@gmail.com";
                    pswrdddd="Indianfoodmrt@24";
                }
//Intent
            }
            });









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
            idd[i]=obj.getInt("id");
            name[i] = obj.getString("name");
            rate[i] = obj.getString("rate");
            code[i] = obj.getString("Code");
            dipp[i]=obj.getString("dipp");;

            fulllist.add(new Product(idd[i],code[i],name[i],rate[i],dipp[i],0,0,0,0,0,0));


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
        Toast.makeText(getApplicationContext(), "Welcome",Toast.LENGTH_LONG).show();
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        c=sharedpreferences.getString(namexxx,null);
        d=sharedpreferences.getString(pswdxxx,null);
        Mobilee=sharedpreferences.getString(mobbbb,null);
        reffff=sharedpreferences.getString(refffff,null);
        Namee=sharedpreferences.getString(fnnn,null);
        gdorrx=sharedpreferences.getString(gdorxxxx,null);

        try {
            if (c.equals("")) {
                Intent in = new Intent(page1.this, MainActivity.class);
                startActivity(in);
            } else {
                Intent in = new Intent(page1.this, ImageViewerr.class);
                startActivity(in);
            }
        }
        catch (Exception e)
        {
            if (c==null) {
                Intent in=new Intent(page1.this,MainActivity.class);
                startActivity(in);

            } else {
                Intent in=new Intent(page1.this,ImageViewerr.class);
                startActivity(in);
            }
        }
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
            Intent in=new Intent(page1.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(page1.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(page1.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(page1.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(page1.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
