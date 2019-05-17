package com.example.anew.ifm;

/**
 * Created by new on 11-12-2017.
 */
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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


public class listview1 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public static List<Product> ssublist=new ArrayList<>();
    ListView lv;
    adap10 adapterxu;
    adap9 adapterxt;
    adap8 adapterxs;
    adap7 adapterxr;
    adap6 adapterxq;
    adap5 adapterxp;
    adap4 adapterxo;
    adap3 adapterxn;
    adap2 adapterxm;
    adap1 adapterxl;
    //finaladapclas finaadap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listtx);




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





        lv= (ListView) findViewById(R.id.listview);





        Intent inn = getIntent();
        if (inn != null) {
            String cli = inn.getStringExtra("but0");

//            Toast.makeText(this, cli, Toast.LENGTH_SHORT).show();


            if (cli.equals("list0")) {
                adapterxl = new adap1(this, fulllist.subList(0,dryfruits.size()));
                lv.setAdapter(adapterxl);
            }

            else if (cli.equals("list1"))
            {
                adapterxm = new adap2(this, fulllist.subList(dryfruits.size(),dryfruits.size()+flour.size()));
                lv.setAdapter(adapterxm);
            }

            else if (cli.equals("list2"))
            {
                adapterxn = new adap3(this, fulllist.subList(dryfruits.size()+flour.size(),flour.size()+grainsabut.size()+dryfruits.size()));
                lv.setAdapter(adapterxn);
            }

            else if (cli.equals("list3"))
            {
                adapterxo = new adap4(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size(),
                        flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()));
                lv.setAdapter(adapterxo);
            }

            else if (cli.equals("list4"))
            {
                adapterxp = new adap5(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()));
                lv.setAdapter(adapterxp);
            }

            else if (cli.equals("list5"))
            {
                adapterxq = new adap6(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()));
                lv.setAdapter(adapterxq);
            }

            else if (cli.equals("list6"))
            {
                adapterxr = new adap7(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()));
                lv.setAdapter(adapterxr);
            }

            else if (cli.equals("list7"))
            {
                adapterxs = new adap8(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()+pulsessabut.size()));
                lv.setAdapter(adapterxs);
            }

            else if (cli.equals("list8"))
            {
                adapterxt = new adap9(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()+pulsessabut.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()+pulsessabut.size()+spices.size()));
                lv.setAdapter(adapterxt);
            }


            else if (cli.equals("list9"))
            {
                adapterxu = new adap10(this, fulllist.subList(flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()+pulsessabut.size()+spices.size()
                        ,flour.size()+grainsabut.size()+dryfruits.size()+ herbs.size()+kirana.size()+poojasamagri.size()+pulses.size()+pulsessabut.size()+spices.size()+upwassam.size()));
                lv.setAdapter(adapterxu);
            }


            
            Button finalize=(Button)findViewById(R.id.button6);
            finalize.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        int count = 0;
                        for (int ttt = 0; ttt < fulllist.size(); ttt++) {
                            if (Integer.parseInt(String.valueOf(fulllist.get(ttt).getKgsx())) > 0 || Integer.parseInt(String.valueOf(fulllist.get(ttt).getGmsx())) > 0) {
                                try {
                                    ssublist.set(count, fulllist.get(ttt));
                                    count++;
                                } catch (Exception e) {
                                    ssublist.add(count, fulllist.get(ttt));
                                    count++;
                                }
                            }
                        }

                    if(ssublist.size()==0)
                    {
                        Toast.makeText(listview1.this, "Please select atleast one product", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        Time t=new Time(Time.getCurrentTimezone());
                        t.setToNow();

                        if((t.hour)>6 && (t.hour)<22)
                        {
                            Intent ixx = new Intent(listview1.this, confirmc.class);
                            startActivity(ixx);
                        }
                        else
                        {
//                                           Toast.makeText(MainActivity.this, "Closed", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(listview1.this,clos.class);
                            startActivity(i);

                        }

                    }

                        //                    finaadap=new finaladapclas(listview1.this,ssublist);
//                    lv.setAdapter(finaadap);
                }
            });




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
            Intent in=new Intent(listview1.this,abtus.class);
            startActivity(in);
        }
        else if (id == R.id.contus) {
            Intent in=new Intent(listview1.this,contactusss.class);
            startActivity(in);
        }
        else if (id == R.id.reff) {
            Intent in=new Intent(listview1.this,refff.class);
            startActivity(in);
        }
        else if (id == R.id.logoutt) {
            Intent in=new Intent(listview1.this,logout.class);
            startActivity(in);
        }
        else if (id == R.id.exit) {
            Intent in=new Intent(listview1.this,exitc.class);
            startActivity(in);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }












}
