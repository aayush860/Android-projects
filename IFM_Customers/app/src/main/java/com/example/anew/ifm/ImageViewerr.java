package com.example.anew.ifm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.support.v7.app.AppCompatActivity;


public class ImageViewerr extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gvmainx);


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






        GridView gridvieww = (GridView) findViewById(R.id.gridview);
        Button btxx=(Button)findViewById(R.id.button3);




        btxx.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
            Intent innn=new Intent(ImageViewerr.this,refff.class);
//            startActivity(innn);
                                   }
                               });







        gridvieww.setAdapter(new ImageAdapter(this));
        final Intent in = new Intent(ImageViewerr.this, listview1.class);

        gridvieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        in.putExtra("but0", "list0");
                        startActivity(in);
                        break;

                    case 1:
                        in.putExtra("but0", "list1");
                        startActivity(in);
                        break;

                    case 2:
                        in.putExtra("but0", "list2");
                        startActivity(in);
                        break;

                    case 3:
                        in.putExtra("but0", "list3");
                        startActivity(in);
                        break;

                    case 4:
                        in.putExtra("but0", "list4");
                        startActivity(in);
                        break;

                    case 5:
                        in.putExtra("but0", "list5");
                        startActivity(in);
                        break;

                    case 6:
                        in.putExtra("but0", "list6");
                        startActivity(in);
                        break;

                    case 7:
                        in.putExtra("but0", "list7");
                        startActivity(in);
                        break;

                    case 8:
                        in.putExtra("but0", "list8");
                        startActivity(in);
                        break;

                    case 9:
                        in.putExtra("but0", "list9");
                        startActivity(in);
                        break;


                }
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
            Intent in=new Intent(ImageViewerr.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(ImageViewerr.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(ImageViewerr.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(ImageViewerr.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(ImageViewerr.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}

