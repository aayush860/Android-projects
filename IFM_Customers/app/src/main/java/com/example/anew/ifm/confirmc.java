package com.example.anew.ifm;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.List;

import static com.example.anew.ifm.listview1.ssublist;


/**
 * Created by new on 13-12-2017.
 */

public class confirmc extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    finaladapclas finaadap;
    ListView lvv;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confxx);



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






        lvv=(ListView)findViewById(R.id.menlistv);
        Button conf=(Button)findViewById(R.id.button7);
        finaadap=new finaladapclas(confirmc.this,ssublist);
        lvv.setAdapter(finaadap);


        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ie= new Intent(confirmc.this,totalc.class);
                startActivity(ie);
            }
            });

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
            Intent in=new Intent(confirmc.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(confirmc.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(confirmc.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(confirmc.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(confirmc.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}