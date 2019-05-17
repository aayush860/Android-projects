package com.example.anew.ifm;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.example.anew.ifm.MainActivity.gdorrx;
import static com.example.anew.ifm.MainActivity.h;
import static com.example.anew.ifm.listview1.ssublist;
import static com.example.anew.ifm.orderxx.outletsmail;
/**
 * Created by new on 13-12-2017.
 */

public class totalc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    ProgressBar pbb;
    public static String[] Line;
    public static String[] Disc;
    public static int tot=0;
    static String comments;
TextView total;
    TextView discount;
    TextView NETTOT;
    TextView lin,gstinx;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.totalcx);

gstinx=(TextView)findViewById(R.id.textView30i);
        if(outletsmail.equals("indianfoodmart1@gmail.com")) {
           gstinx.setText("");
        }
        else if(outletsmail.equals("indianfoodmart2@gmail.com"))
        {
            gstinx.setText("GSTIN:23AIRPG6014H1ZF");
        }
        else if(outletsmail.equals("indianfoodmart3@gmail.com"))
        {
            gstinx.setText("GSTIN:23ACGPA5025R1ZN");
        }
        else{
            gstinx.setText("");
        }


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






        total=(TextView)findViewById(R.id.textView29i);
        discount=(TextView)findViewById(R.id.textView93i);
        NETTOT=(TextView)findViewById(R.id.textView96i);
        lin=(TextView)findViewById(R.id.linee);
        pbb=(ProgressBar)findViewById(R.id.progressBar4);
        getJSON("https://indianfoodmrt.000webhostapp.com/disc.php");
        Button tm=(Button)findViewById(R.id.button77);
        tm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et=(EditText)findViewById(R.id.editText11i);
                comments=et.getText().toString();
                Intent il=new Intent(totalc.this,MapsActivity.class);
                startActivity(il);
            }
        });

    }



    public void getJSON(final String urlWebService) {

        @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
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
                //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

                try {
                    loadIntoListView(s);
//                    lin.setText(Line[0]);
tot=0;
                    for(int i=0;i<ssublist.size();i++)
                    {
                        int pric = Integer.parseInt(ssublist.get(i).getRatepk());
                        int weigh=Integer.parseInt(String.valueOf(ssublist.get(i).getKgsx()));
                        int grmsss=Integer.parseInt(String.valueOf(ssublist.get(i).getGmsx()));
                        float pric1=pric*weigh;
                        float pric2=(float)pric*(float)(grmsss);
                        pric2=pric2/1000;
                        float tx=pric1+pric2;
 //                       int dippr=Integer.parseInt(String.valueOf(ssublist.get(i).getDisc_per_prod()));







int dippr=0;










                        int ccc=(dippr*(int)tx)/100;

                        //int qua = Integer.parseInt(String.valueOf(ssublist.get(i).getPquanx()));
                        tot = tot+((int)tx -ccc);

                        //tot=tot+((Integer.parseInt(ssublist.get(i).getRatepk()))*((Integer.parseInt(String.valueOf(ssublist.get(i).getPquanx())))));
                        
                    }

                    total.setText(Integer.toString(tot));


                    int di=0;

                    discount.setText(Integer.toString(0));
/*
                    if(Integer.parseInt(Disc[0])>0){
try
{
    if (gdorrx.equals("To Be Given")) {
        di = ((tot * Integer.parseInt(Disc[0])) / 100);
        tot = tot - di;
        discount.setText(Integer.toString(di));
    } else {
        discount.setText(Integer.toString(0));
    }


}

catch(Exception e)
{
    if (gdorrx.equals("To Be Given")) {
        di = ((tot * Integer.parseInt(Disc[0])) / 100);
        tot = tot - di;
        discount.setText(Integer.toString(di));
    } else {
        discount.setText(Integer.toString(0));
    }
}

                    }


                    else{
                        discount.setText(Integer.toString(0));
                    }



int di=0;
if(tot<5000)
{
    di=((tot*5)/100);
    tot=tot-di;
    discount.setText(Integer.toString(di)+"(5%)");
}
else if(tot>5000 && tot<20000)
{
    di=((tot*10)/100);
    tot=tot-di;
    discount.setText(Integer.toString(di)+"(10%)");
}
else
{
    di=((tot*15)/100);
    tot=tot-di;
    discount.setText(Integer.toString(di)+"(15%)");
}
*/

                    NETTOT.setText(Integer.toString(tot));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public String doInBackground(Void... voids) {
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
        Line = new String[jsonArray.length()];
        Disc = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
             Line[i]= obj.getString("Line");
             Disc[i]= obj.getString("Disc");
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
            Intent in=new Intent(totalc.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(totalc.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(totalc.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(totalc.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(totalc.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}