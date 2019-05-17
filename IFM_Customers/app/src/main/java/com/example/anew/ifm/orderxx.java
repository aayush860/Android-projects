package com.example.anew.ifm;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

import static com.example.anew.ifm.MainActivity.Mobilee;
import static com.example.anew.ifm.MainActivity.MyPREFERENCES;
import static com.example.anew.ifm.MainActivity.Namee;
import static com.example.anew.ifm.MainActivity.c;
import static com.example.anew.ifm.MainActivity.d;
import static com.example.anew.ifm.MainActivity.fnnn;
import static com.example.anew.ifm.MainActivity.gdorrx;
import static com.example.anew.ifm.MainActivity.gdorxxxx;
import static com.example.anew.ifm.MainActivity.mobbbb;
import static com.example.anew.ifm.MainActivity.namexxx;
import static com.example.anew.ifm.MainActivity.pswdxxx;
import static com.example.anew.ifm.MainActivity.reffff;
import static com.example.anew.ifm.MainActivity.refffff;


public class orderxx extends AppCompatActivity
        implements
        OnMyLocationButtonClickListener,
        OnMyLocationClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private boolean mPermissionDenied = false;
public static String loc,lockche="";
    private GoogleMap mMap;
    float refrr;
    int indexxx;
static List<shtdis> lixx=new ArrayList<>();
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
    SharedPreferences sharedpreferences;
    ProgressBar pbb;

    Spinner xx;
    public static String Emaili, Passwordi,Nameei,Mobileei,gdorrxi,reffffi,linkkkk,outletsmail,pswrdddd;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapsact1);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button refresh=findViewById(R.id.button13);
        Button csm=findViewById(R.id.button14);
        pbb=findViewById(R.id.progressBar7);


        pbb.setVisibility(View.INVISIBLE);

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

        Toast.makeText(this, "Please wait while fetching store closest to you...", Toast.LENGTH_SHORT).show();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent innn=new Intent(orderxx.this,orderxx.class);
                startActivity(innn);
            }
        });

        csm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent innn=new Intent(orderxx.this,page1.class);
                startActivity(innn);
            }
        });




    }








    @SuppressLint("SetTextI18n")


    @Override
    public void onMapReady(GoogleMap map) {
            mMap = map;
            //tv = (TextView) findViewById(R.id.editText3i);
            enableMyLocation();
            LocationManager mng = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }


        try {


//double xxp = 0;
                double lat=0;
                double lon=0;

  //  Location ln = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), true));
            Location ln;


         ln = mng.getLastKnownLocation(mng.NETWORK_PROVIDER);

            Toast.makeText(this, "init", Toast.LENGTH_SHORT).show();




     lat = ln.getLatitude();


    lon = ln.getLongitude();
    CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 13);
    mMap.animateCamera(cu);
    lixx.clear();
    Toast.makeText(this, "Fetched", Toast.LENGTH_SHORT).show();

            Marker marker = map.addMarker(new MarkerOptions()
                    .position(new LatLng(26.2221585, 78.2249031))
                    .title("Goyal Kirana")
                    .snippet("IFM OUTLET"));
//            marker.showInfoWindow();
            float[] res = new float[3];

            ln.distanceBetween(lat,lon,26.2221585,78.2249031,res);
            lixx.add(new shtdis("Goyal Kirana",res[0]));
   //         Toast.makeText(this, ""+Float.toString(res[0]), Toast.LENGTH_SHORT).show();

            Marker marker2 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(26.2051001, 78.146476))
                    .title("Pragati Traders")
                    .snippet("IFM OUTLET"));
            float[] res2 = new float[3];
            ln.distanceBetween(lat,lon,26.2051001,78.146476,res2);
            lixx.add(new shtdis("Pragati Traders",res2[0]));


            Marker marker3 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(26.1997505, 78.1612422))
                    .title("Bakebihari Dryfruits")
                    .snippet("IFM OUTLET"));
            float[] res3 = new float[3];
            ln.distanceBetween(lat,lon,26.1997505,78.1612422,res3);
            lixx.add(new shtdis("Bakebihari Dryfruits",res3[0]));

            Marker marker4 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(26.2003582, 78.1602431))
                    .title("Tamanna Traders")
                    .snippet("IFM OUTLET"));
            float[] res4 = new float[3];
            ln.distanceBetween(lat,lon,26.2003582,78.1602431,res4);
            lixx.add(new shtdis("Tamanna Traders",res4[0]));


            Marker marker5 = map.addMarker(new MarkerOptions()
                    .position(new LatLng(26.2144618, 78.2017719))
                    .title("Jai maa kaila devi store")
                    .snippet("IFM OUTLET"));
            marker5.showInfoWindow();
            float[] res5 = new float[3];
            ln.distanceBetween(lat,lon,26.1333489,78.1051689,res5);
            lixx.add(new shtdis("Jai maa kaila devi store",res5[0]));
 //           Toast.makeText(this, ""+Float.toString(res5[0]), Toast.LENGTH_SHORT).show();


            refrr= lixx.get(0).getShrtdist();;
for(int z=0;z<lixx.size();z++)
{
   // Toast.makeText(this, ""+Float.toString(lixx.get(z).getShrtdist()), Toast.LENGTH_SHORT).show();
    if(lixx.get(z).getShrtdist()<refrr)
    {
        refrr=lixx.get(z).getShrtdist();
        indexxx=z;
    }

}
     //       Toast.makeText(this, ""+Float.toString(refrr)+"\t"+Integer.toString(indexxx), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, ""+lixx.get(indexxx).getNameofloc(), Toast.LENGTH_SHORT).show();






final Handler handler=new Handler();
handler.postDelayed(new Runnable() {
public void run()
{
    //            Toast.makeText(page1.this, lixx.get(indexxx).getNameofloc(), Toast.LENGTH_SHORT).show();
    if (lixx.get(indexxx).getNameofloc().equals("Pragati Traders")) {
        //                  Toast.makeText(page1.this, "1", Toast.LENGTH_SHORT).show();
//            lixx.get(indexxx).getNameofloc()="https://indianfoodmrt.000webhostapp.com/prodfetcher.php";
        getJSON("https://indianfoodmrt.000webhostapp.com/prodfetcher.php");
        outletsmail="indianfoodmart1@gmail.com";
        pswrdddd="xxxxxxx";

    } else if (lixx.get(indexxx).getNameofloc().equals("Goyal Kirana")) {
        getJSON("https://ifmifm2.000webhostapp.com/prodfetcher.php");
        outletsmail="indianfoodmart2@gmail.com";
        pswrdddd="Indianfoodmrt@24";
//                    Toast.makeText(page1.this, "122", Toast.LENGTH_SHORT).show();

    } else if (lixx.get(indexxx).getNameofloc().equals("Bakebihari Dryfruits")) {
        getJSON("https://ifmifm3.000webhostapp.com/prodfetcher.php");
        outletsmail="indianfoodmart3@gmail.com";
        pswrdddd="Indianfoodmrt@24";
    }
    else if (lixx.get(indexxx).getNameofloc().equals("Tamanna Traders")) {
        getJSON("https://ifmifm4.000webhostapp.com/prodfetcher.php");
        outletsmail="indianfoodmart4@gmail.com";
        pswrdddd="Indianfoodmrt@24";
    }
    else if (lixx.get(indexxx).getNameofloc().equals("Jai maa kaila devi store")) {
      //  Toast.makeText(orderxx.this, "launched", Toast.LENGTH_SHORT).show();
        getJSON("https://ifmifm6.000webhostapp.com/prodfetcher.php");
        outletsmail="indianfoodmart6@gmail.com";
        pswrdddd="Indianfoodmrt@24";
    }
    else {
        Intent innn=new Intent(orderxx.this,orderxx.class);
        startActivity(innn);

    }


}},5000);









        } catch (Exception e) {
                Toast.makeText(this, "GPS is Not Functioning Properly on this Device", Toast.LENGTH_SHORT).show();
            Intent ing=new Intent(orderxx.this,page1.class);
            startActivity(ing);
                //Toast.makeText(this, "Try Turning on GPS or Click Refresh", Toast.LENGTH_SHORT).show();
            }
//        onMyLocationButtonClick();
//        mMap.setOnMyLocationClickListener(this);
        }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission to access the location is missing.
            PermissionUtilsx.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);
        }
        else
        {
            Toast.makeText(this, "not ready", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    @Override
    public boolean onMyLocationButtonClick() {
        //tv = (TextView) findViewById(R.id.editText3i);
        enableMyLocation();
        LocationManager mng = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        @SuppressLint("MissingPermission")
        Location ln = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), false));
        double lat = ln.getLatitude();
        double lon = ln.getLongitude();
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 20);
        mMap.animateCamera(cu);
        HashMap itemAddress;

        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        enableMyLocation();
        LocationManager mng = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        @SuppressLint("MissingPermission") Location ln = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), false));
        double lat = ln.getLatitude();
        double lon = ln.getLongitude();
    //    Toast.makeText(this, "thiss", Toast.LENGTH_SHORT).show();
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 15);
        mMap.animateCamera(cu);



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtilsx.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
            Intent inbb=new Intent(orderxx.this,orderxx.class);
            startActivity(inbb);

        } else {
            // Display the missing permission error dialog when the fragments resume.
            mPermissionDenied = true;
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (mPermissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError();
            mPermissionDenied = false;
        }
    }




    /**
     * Displays a dialog with error message explaining that the location permission is missing.
     */
    private void showMissingPermissionError() {
        PermissionUtilsx.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
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
                Intent in = new Intent(orderxx.this, MainActivity.class);
                startActivity(in);
            } else {
                Intent in = new Intent(orderxx.this, ImageViewerr.class);
                startActivity(in);
            }
        }
        catch (Exception e)
        {
            if (c==null) {
                Intent in=new Intent(orderxx.this,MainActivity.class);
                startActivity(in);

            } else {
                Intent in=new Intent(orderxx.this,ImageViewerr.class);
                startActivity(in);
            }
        }
    }











}