package com.example.anew.ifm;

import com.example.anew.ifm.PermissionUtils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

//import static com.example.anew.indianfoodmart.MainActivity.Email;
//import static com.example.anew.indianfoodmart.MainActivity.Mobilee;
import static com.example.anew.ifm.MainActivity.MyPREFERENCES;
import static com.example.anew.ifm.MainActivity.Namee;
import static com.example.anew.ifm.MainActivity.eml;
import static com.example.anew.ifm.MainActivity.mobbbb;
import static com.example.anew.ifm.listview1.ssublist;
import static com.example.anew.ifm.page1.linkkkk;
import static com.example.anew.ifm.orderxx.outletsmail;
import static com.example.anew.ifm.totalc.comments;
import static com.example.anew.ifm.totalc.tot;


public class MapsActivity extends AppCompatActivity
        implements
        OnMyLocationButtonClickListener,
        OnMyLocationClickListener,
        OnMapReadyCallback,
        ActivityCompat.OnRequestPermissionsResultCallback {

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    private boolean mPermissionDenied = false;
public static String loc,lockche="";
    private GoogleMap mMap;
    RadioGroup rg;
    RadioButton r1;
    RadioButton r2;
    static String ord;
    String modee;
    ProgressBar pbb;
    EditText mobilenu;
    EditText tv;
    EditText pincodee;
    StringBuffer z=new StringBuffer("");
    static String Email,lll,currentadd;
    static String Mobilee,urlx;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Email=sharedpreferences.getString(eml,null);
        Mobilee=sharedpreferences.getString(mobbbb,null);

        tv=(EditText)findViewById(R.id.editText3i);
        mobilenu=(EditText)findViewById(R.id.editText7i);
        Button sensms=(Button)findViewById(R.id.button10);
        Button refresh=(Button)findViewById(R.id.button11);
        rg=(RadioGroup)findViewById(R.id.radioButton);
        r2=(RadioButton)findViewById(R.id.carod);
        r1=(RadioButton)findViewById(R.id.cod);
        pbb=(ProgressBar)findViewById(R.id.progressBari);
        pbb.setVisibility(View.INVISIBLE);







        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent innn=new Intent(MapsActivity.this,MapsActivity.class);
startActivity(innn);
            }
        });



        if(outletsmail.equals("indianfoodmart1@gmail.com")) {
            urlx = "https://indianfoodmrt.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }

        else if(outletsmail.equals("indianfoodmart2@gmail.com"))
        {
            urlx = "https://ifmifm2.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart3@gmail.com"))
        {
            urlx = "https://ifmifm3.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else if(outletsmail.equals("indianfoodmart4@gmail.com"))
        {
            urlx = "https://ifmifm4.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }
        else
        {
            urlx = "https://ifmifm6.000webhostapp.com/upload%20(1).php"; // here is your URL path
        }




        for(int i=0;i<ssublist.size();i++)
        {
            z.append("NAME:"+ssublist.get(i).getPname()+"\t"+"KGS:"
                    +Integer.toString(ssublist.get(i).getKgsx())+"\t"+"GRAMS"+Integer.toString(ssublist.get(i).getGmsx())+"\n");
        }
        sensms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          //      Toast.makeText(MapsActivity.this, ""+outletsmail, Toast.LENGTH_SHORT).show();
// t               if(loc.equals("Indore")||loc.equals("Gwalior")) {
                    if ((tv.getText().toString()).equals("") || (mobilenu.getText().toString()).equals("")) {
                        Toast.makeText(MapsActivity.this, "Please fill all the details correctly", Toast.LENGTH_LONG).show();
                    } else {
                        try {
                            if (r1.isChecked() == true) {
                                try {
                                    modee = "cash";
                                    SendMail sm = new SendMail(MapsActivity.this, ""+outletsmail, "DELIVERY ORDER",
                                            "Delivery Email Address:" + Email + "\n" + z + "\n\n\n" +
                                                    "Total Amount:\n" + Integer.toString(tot) + "\n" + "Comments:" + "\n"
                                                    + comments + "\n" + "CASH ON DELIVERY" + "\n" + "Customers Address:" + tv.getText() +
                                                    "\n" +
                                                    "Customers Mobile Number:" + mobilenu.getText() + "\n" +
                                                    "Customers Database Regestired Mobile Number:" + mobilenu.getText().toString());

                                    currentadd=""+(tv.getText().toString());

                                    ord = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                            + "\n" + "7771008181"
                                            + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                            "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                            "CASH ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";

                                    sm.execute();

                                    new SendPostRequest().execute();
                                } catch (Exception e) {
                                    Toast.makeText(MapsActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                try {
                                    modee = "card";
                                    SendMail sm = new SendMail(MapsActivity.this, ""+outletsmail, "DELIVERY ORDER", "Delivery Email Address:" + Email + "\n" + z + "\n\n\n"
                                            + "Total Amount:\n" + Integer.toString(tot) + "\n" + "CARD ON DELIVERY" + "\n"
                                            + "Customers Address:" + tv.getText() + "\n"
                                            + "Customers Mobile Number To Call:" + mobilenu.getText() + "\n"
                                            + "Customers Database Regestired Mobile Number:" + Mobilee);


                                    currentadd=""+(tv.getText().toString());



                                    ord = "Your order has been confirmed" + "\n" + "In case you dont get a call from us you can contact us at:"
                                            + "\n" + "7771008181"
                                            + "\n\n" + "Order Summary:" + "\n" + z + "\n" +
                                            "Total Amount:\n" + Integer.toString(tot) + "\n" +
                                            "CARD ON DELIVERY" + "\n" + "Your Address:" + tv.getText() + "\n\n\n" + "THANK YOU FOR CHOOSING IFM";
                                    sm.execute();

                                    new SendPostRequest().execute();
                                } catch (Exception e) {
                                    Toast.makeText(MapsActivity.this, "", Toast.LENGTH_SHORT).show();
                                }
                            }


                        } catch (Exception e) {
                            Toast.makeText(MapsActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }

                    }
//t                }
// t               else
//  t              {
//   t                 Toast.makeText(MapsActivity.this, "Sorry We Do Not Deliver Our Products In Your City", Toast.LENGTH_LONG).show();
//    t            }
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
                URL url=new URL(""+urlx);

              //  Toast.makeText(MapsActivity.this, ""+url, Toast.LENGTH_SHORT).show();
                JSONObject postDataParams = new JSONObject();
                postDataParams.put("Name", Namee);
                postDataParams.put("Mobile", (""+mobilenu.getText().toString()));
                postDataParams.put("Modeofpayment", modee);
                postDataParams.put("Details", z);
                postDataParams.put("Price", tot);
                postDataParams.put("Address",currentadd);
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
            Intent ixx=new Intent(MapsActivity.this,lastcl.class);                                                //snkjcnjskcnjskcnknsjndkj
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

//    Location ln = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), false));

     Location ln = mng.getLastKnownLocation(mng.GPS_PROVIDER);

    lat = ln.getLatitude();

    lon = ln.getLongitude();
    CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 15);
    mMap.animateCamera(cu);
  //  Toast.makeText(this, "hbjhyhyjhjb", Toast.LENGTH_SHORT).show();


    HashMap itemAddress;
                Geocoder gcd = new Geocoder(MapsActivity.this, Locale.getDefault());
                List<Address> addresses = null;
                try {
                    addresses = gcd.getFromLocation(lat, lon, 1);
                //    Toast.makeText(this, "gcd", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (addresses.size() > 0) {
                    loc = addresses.get(0).getLocality();
                }

                ArrayList itemList = new ArrayList<HashMap<String, String>>();
                for (int i = 0; i < addresses.size(); i++) {
                    itemAddress = new HashMap<String, String>();
                    Address address = addresses.get(i);
                    String addressline = "";
                    for (int n = 0; n <= address.getMaxAddressLineIndex(); n++) {
                        addressline += address.getAddressLine(n);
                    }

                    tv.setText(addressline.toString());
                    lockche = addressline;
                }
                Toast.makeText(this, "Press Refresh if Address is Not Accurate or Empty", Toast.LENGTH_LONG).show();


            } catch (Exception e) {
                Toast.makeText(this, "GPS is Not Functioning Properly on this Device", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Please Enter Address Manually", Toast.LENGTH_SHORT).show();
                Intent innn = new Intent(MapsActivity.this, manual_address.class);
                startActivity(innn);
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
            PermissionUtils.requestPermission(this, LOCATION_PERMISSION_REQUEST_CODE,
                    Manifest.permission.ACCESS_FINE_LOCATION, true);
        } else if (mMap != null) {
            // Access to the location has been granted to the app.
            mMap.setMyLocationEnabled(true);

        }
        else
        {
       //     Toast.makeText(this, "not readyy", Toast.LENGTH_SHORT).show();
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
        Geocoder gcd = new Geocoder(MapsActivity.this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gcd.getFromLocation(lat,lon,1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList itemList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < addresses.size(); i++) {
            itemAddress = new HashMap<String, String>();
            Address address = addresses.get(i);
            String addressline = "";
            for (int n = 0; n <= address.getMaxAddressLineIndex(); n++) {
                addressline += address.getAddressLine(n);
            }
            Toast.makeText(this, addressline, Toast.LENGTH_SHORT).show();
            tv.setText(addressline);
        }

        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        enableMyLocation();
        LocationManager mng = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        @SuppressLint("MissingPermission") Location ln = mng.getLastKnownLocation(mng.getBestProvider(new Criteria(), false));
        double lat = ln.getLatitude();
        double lon = ln.getLongitude();
       // Toast.makeText(this, "thiss", Toast.LENGTH_SHORT).show();
        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lon), 15);
        mMap.animateCamera(cu);
        HashMap itemAddress;
        Geocoder gcd = new Geocoder(MapsActivity.this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = gcd.getFromLocation(lat,lon,1);
        } catch (IOException e) {
            e.printStackTrace();
        }


        ArrayList itemList = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < addresses.size(); i++) {
            itemAddress = new HashMap<String, String>();
            Address address = addresses.get(i);
            String addressline = "";
            for (int n = 0; n <= address.getMaxAddressLineIndex(); n++) {
                addressline += address.getAddressLine(n);
            }
      //      Toast.makeText(this, addressline, Toast.LENGTH_SHORT).show();
            tv.setText(addressline);
        }



    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return;
        }

        if (PermissionUtils.isPermissionGranted(permissions, grantResults,
                Manifest.permission.ACCESS_FINE_LOCATION)) {
            // Enable the my location layer if the permission has been granted.
            enableMyLocation();
            //Object map;
//            onMapReady(GoogleMap);
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
        PermissionUtils.PermissionDeniedDialog
                .newInstance(true).show(getSupportFragmentManager(), "dialog");
    }

    
}