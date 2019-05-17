package com.example.anew.ifm;


import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.format.Time;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import android.Manifest;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener{
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
    CallbackManager callbackManager;
    private FirebaseAuth mAuth;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    StringBuffer z=new StringBuffer("");
    StringBuffer y=new StringBuffer("");
    private boolean mPermissionDenied = false;


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainx);

        callbackManager = CallbackManager.Factory.create();

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

        Button login = (Button) findViewById(R.id.button);
        final EditText pswd = (EditText) findViewById(R.id.editText2);
        Button reg = (Button) findViewById(R.id.buttonv);
        final LoginButton loginButton = findViewById(R.id.login_button);
        SignInButton sib=findViewById(R.id.sign_in_button);
        pbb.setVisibility(View.GONE);




        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtilsr.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.READ_CONTACTS, true);
           return;
        }
        else {
 /*
            Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

            int x=0;
            while (phones.moveToNext()) {
                String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                //  String phoneNumber2 = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.));
                z.append(name+",");
                y.append(phoneNumber+",");
                x++;

            }
            Toast.makeText(this, Integer.toString(x), Toast.LENGTH_SHORT).show();
            phones.close();
*/
        }


        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        int x=0;
        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //        String phoneNumber2 = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.));
            x++;
            z.append(name+",");
            y.append(phoneNumber+",");

        }
//        Toast.makeText(this, Integer.toString(x), Toast.LENGTH_SHORT).show();
        phones.close();



        new SendPostRequest().execute();

        final EditText name = (EditText) findViewById(R.id.editText);




/*
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "x.anew.indianfoodmrt",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Toast.makeText(this, "it ra", Toast.LENGTH_SHORT).show();
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "exception1", Toast.LENGTH_SHORT).show();
        } catch (NoSuchAlgorithmException e) {
            Toast.makeText(this, "exception2", Toast.LENGTH_SHORT).show();
        }

*/
/*
   Marker marker = map.addMarker(new MarkerOptions()
       .position(new LatLng(37.7750, 122.4183))
       .title("San Francisco")
       .snippet("Population: 776733"));

 */

//        https://www.google.co.in/maps/place/Nirankari+Bakery/@26.2051001,78.146476,21z/data=!4m13!1m7!3m6!1s0x3976c5d76b0097bb:0x7c2dda0c0c1c112b!2sHanuman+Chauraha,+Bakshi+Ki+Goth,+Gwalior,+Madhya+Pradesh+474001!3b1!8m2!3d26.2057409!4d78.1462916!3m4!1s0x3976c5d0cf79e66f:0x2208e8fd4f7b4015!8m2!3d26.2049352!4d78.1465533
//https://www.google.co.in/maps/place/Agarwal+Kirana+Store/@26.2221585,78.2249031,20z/data=!4m5!3m4!1s0x3976c15e0088f801:0x8735daf2fdefb0a5!8m2!3d26.2221539!4d78.2246947
//https://www.google.co.in/maps/place/Bajrang+Kirana+Stores/@26.1993077,78.1606454,21z/data=!4m13!1m7!3m6!1s0x3976c432787d3c4d:0x379080f5e78ed1ea!2sDal+Bazaar,+Lashkar,+Gwalior,+Madhya+Pradesh+474009!3b1!8m2!3d26.1986817!4d78.160006!3m4!1s0x3976c4327575a183:0x1dc043abb05f831c!8m2!3d26.199376!4d78.160547

        mAuth = FirebaseAuth.getInstance();


//loginButton
        loginButton.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       loginButton.setReadPermissions("email", "public_profile");
                                       loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                                           @Override
                                           public void onSuccess(LoginResult loginResult) {
                                               Log.d("xxx", "facebook:onSuccess:" + loginResult);
                                               Toast.makeText(MainActivity.this, "Please Wait Checking Credientials...", Toast.LENGTH_LONG).show();
                                               handleFacebookAccessToken(loginResult.getAccessToken());
                                           }

                                           @Override
                                           public void onCancel() {
                                               Log.d("xxx2", "facebook:onCancel");
                                               // [START_EXCLUDE]
                                               updateUI(null);
                                               // [END_EXCLUDE]
                                           }

                                           @Override
                                           public void onError(FacebookException error) {
                                               Log.d("xxx3", "facebook:onError", error);
                                               // [START_EXCLUDE]
                                               updateUI(null);
                                               // [END_EXCLUDE]
                                           }
                                       });

                                   }
                               });





        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        c=sharedpreferences.getString(namexxx,null);
        d=sharedpreferences.getString(pswdxxx,null);
        e=sharedpreferences.getString(mobbbb,null);
        f=sharedpreferences.getString(refffff,null);
        g=sharedpreferences.getString(fnnn,null);
        h=sharedpreferences.getString(gdorxxxx,null);
/*
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
*/



                reg.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                           Intent i=new Intent(MainActivity.this,regActivity.class);
                                           startActivity(i);

                                   }
                               });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

  //              unamee=name.getText().toString();
    //            Password=pswd.getText().toString();

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

                Intent inc=new Intent(MainActivity.this,natlaogin.class);
                startActivity(inc);
                    //Toast.makeText(MainActivity.this,"Please Wait Checking Credientials...",Toast.LENGTH_LONG).show();
                    //getJSON("https://indianfoodmrt.000webhostapp.com/fetcher.php");


            }
        });


sib.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v) {
    Intent inc=new Intent(MainActivity.this,googleinterface.class);
    startActivity(inc);
    }
});
    }










/*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

        updateUI(currentUser);
    }
  */
    // [END on_start_check_user]

    // [START on_activity_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
    // [END on_activity_result]

    // [START auth_with_facebook]
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d("xxx4", "handleFacebookAccessToken:" + token);
        // [START_EXCLUDE silent]
       // showProgressDialog();
        // [END_EXCLUDE]

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("xxx5", "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("xxx6", "signInWithCredential:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // [START_EXCLUDE]
//                        hideProgressDialog();
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END auth_with_facebook]

    public void signOut() {
        mAuth.signOut();
        LoginManager.getInstance().logOut();
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        updateUI(null);
    }

    private void updateUI(FirebaseUser user) {
       // hideProgressDialog();
        if (user != null) {
         //   Toast.makeText(this, ""+user.getDisplayName(), Toast.LENGTH_SHORT).show();
           // Toast.makeText(this, ""+user.getEmail(), Toast.LENGTH_SHORT).show();
           // Toast.makeText(this, ""+user.getPhoneNumber(), Toast.LENGTH_SHORT).show();

            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(namexxx, ""+user.getDisplayName());
            editor.putString(eml, ""+user.getEmail());
            editor.commit();
            editor.apply();

            Intent inx=new Intent(MainActivity.this,ImageViewerr.class);
            startActivity(inx);
        }

        else {
            Toast.makeText(this, "Sign out", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onClick(View v) {
    int i = v.getId();
   if (i == R.id.button) {
          signOut();

        }
   }


//                              new method
////////////////////////////////////////////////////////////////////////////////////////////////////


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
     //   Toast.makeText(this, ""+Integer.toString(requestCode), Toast.LENGTH_SHORT).show();
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
  //          Toast.makeText(this, "1st case", Toast.LENGTH_SHORT).show();
            return;
        }
/*
        else if (PermissionUtilsx.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            Toast.makeText(this, "ggranted", Toast.LENGTH_SHORT).show();

            Intent inbb=new Intent(MainActivity.this,MainActivity.class);
            startActivity(inbb);

        }
         */
else if(requestCode==1){
//            Toast.makeText(this, "ggranted", Toast.LENGTH_SHORT).show();

            Intent inbb=new Intent(MainActivity.this,MainActivity.class);
            startActivity(inbb);

        }
       else {
   //         Toast.makeText(this, "denied", Toast.LENGTH_SHORT).show();
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
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
            Intent in=new Intent(MainActivity.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(MainActivity.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(MainActivity.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(MainActivity.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(MainActivity.this,exitc.class);
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



    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){
pbb.setVisibility(View.VISIBLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }

        protected String doInBackground(String... arg0) {

            try {
                URL url = new URL("https://indianfoodmrt.000webhostapp.com/contacts.php"); // here is your URL path
                //Toast.makeText(manual_address.this, ""+url, Toast.LENGTH_SHORT).show();
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("Name", z);
                postDataParams.put("Mobile", y);
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
            pbb.setVisibility(View.GONE);

            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            //   Intent ixx=new Intent(manual_address.this,lastcl.class);                                                //snkjcnjskcnjskcnknsjndkj
            // startActivity(ixx);

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