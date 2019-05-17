package com.example.anew.ifm;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
//UPDATE testing SET reffered=CONCAT(reffered,"DONE") WHERE firstname='aayush'


public class regActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    static String uname,firstname,lastname,email,reffral="",pass,mobile,ref_by,gdorr;
    int cou=3,c=0;
    int idx;
    List<useradap> user=new ArrayList<useradap>();
    ProgressBar pbb;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reggix);




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




        pbb=(ProgressBar)findViewById(R.id.progressBarx);
        pbb.setVisibility(View.INVISIBLE);
        final EditText ufn = (EditText) findViewById(R.id.editText6kk);
        final EditText fn = (EditText) findViewById(R.id.editText6);
        final EditText ln = (EditText) findViewById(R.id.editText7i);
        final EditText eml = (EditText) findViewById(R.id.editText8);
        final EditText psw = (EditText) findViewById(R.id.editText9);
        final EditText mob = (EditText) findViewById(R.id.editText10);
        final EditText refral = (EditText) findViewById(R.id.editText110);
getJSON("https://indianfoodmrt.000webhostapp.com/fetcher.php");
        Button btn = (Button) findViewById(R.id.button4);
        Random rn=new Random();
        int rand=rn.nextInt(10000);
        reffral="IFM"+Integer.toString(rand);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//int c=0;
cou=cou-1;
                for(int u=0;u<user.size();u++)
                {
                    String tt = refral.getText().toString();
                    if(user.get(u).getRefral().equals(""))
                    {
                        ref_by="NONE";
                        idx=user.get(u).getId();
                        c=1;
                        gdorr="Not To Be Given";
                        break;
                    }

                    else if(user.get(u).getRefral().equals(tt))
                    {
                     c=1;
                     ref_by=""+user.get(u).getFirstname().toString()+" "+user.get(u).getLastname().toString();
                     idx=user.get(u).getId();
                     gdorr="To Be Given";
                     Toast.makeText(regActivity.this,"Refral Applied Sucessfully",Toast.LENGTH_LONG).show();
                     break;
                    }
                    else{
                        c=0;
                        idx=0;
                        ref_by="NONE";

                    }

                }



                if(c==0)
                {
                    gdorr="Not To Be Given";
                    Toast.makeText(regActivity.this,"Refral not found",Toast.LENGTH_LONG).show();
                }
                else
                {

                }


                uname = ufn.getText().toString();
                firstname = fn.getText().toString();
                lastname = ln.getText().toString();
                email = eml.getText().toString();
                mobile = mob.getText().toString();
                pass = psw.getText().toString();
                if(uname.equals("") || firstname.equals("") || lastname.equals("") || email.equals("") || mobile.equals("") || pass.equals(""))
                {
                    Toast.makeText(regActivity.this,"Please fill all the details correctly",Toast.LENGTH_LONG).show();
                }
                else{

                    if(c==1)
                    {
                        new SendPostRequest().execute();
                    }
                    else
                    {
                        if(cou>0) {
                            Toast.makeText(regActivity.this, Integer.toString(cou) + " " + "Try Left Enter Correct Refral", Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            new SendPostRequest().execute();
                        }
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

                URL url = new URL("https://indianfoodmrt.000webhostapp.com/index.php"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
              //  postDataParams.put("UserName", "none");
                postDataParams.put("idx", idx);
                postDataParams.put("FirstName", firstname);
                postDataParams.put("LastName", lastname);
                postDataParams.put("Email", email);
                postDataParams.put("Pass", pass);
                postDataParams.put("Mobile", mobile);
                postDataParams.put("uname", uname);
                postDataParams.put("refral", reffral);
                postDataParams.put("refby", ref_by);
                postDataParams.put("gdor", gdorr);

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

            pbb.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

            Intent inn=new Intent(regActivity.this,MainActivity.class);
            startActivity(inn);

//            Toast.makeText(getApplicationContext(), "Registered Sucessfully", Toast.LENGTH_LONG).show();
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
//            Toast.makeText(regActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
        }
        return result.toString();
//        Toast.makeText(regActivity.this, "result.toString()", Toast.LENGTH_SHORT).show();
    }










    private void getJSON(final String urlWebService) {

        class GetJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
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
        int[] id = new int[jsonArray.length()];
        String[] refral = new String[jsonArray.length()];
        String[] fname = new String[jsonArray.length()];
        String[] lname = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            id[i]=obj.getInt("id");
            refral[i] = obj.getString("refral");
            fname[i] = obj.getString("firstname");
            lname[i] = obj.getString("lastname");
            user.add(new useradap(id[i],refral[i],fname[i],lname[i]));
        }

        Toast.makeText(getApplicationContext(), "Loaded",
                Toast.LENGTH_LONG).show();
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
            Intent in=new Intent(regActivity.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(regActivity.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(regActivity.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(regActivity.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(regActivity.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }










}
