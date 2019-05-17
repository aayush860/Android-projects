package com.anew.merchapp.ifm_merachat;

/**
 * Created by new on 11-12-2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.nio.InvalidMarkException;
import java.util.ArrayList;
import java.util.List;

import static com.anew.merchapp.ifm_merachat.page1.dryfruits;
import static com.anew.merchapp.ifm_merachat.page1.flour;
import static com.anew.merchapp.ifm_merachat.page1.fulllist;
import static com.anew.merchapp.ifm_merachat.page1.grainsabut;
import static com.anew.merchapp.ifm_merachat.page1.herbs;
import static com.anew.merchapp.ifm_merachat.page1.kirana;
import static com.anew.merchapp.ifm_merachat.page1.poojasamagri;
import static com.anew.merchapp.ifm_merachat.page1.pulses;
import static com.anew.merchapp.ifm_merachat.page1.pulsessabut;
import static com.anew.merchapp.ifm_merachat.page1.spices;
import static com.anew.merchapp.ifm_merachat.page1.upwassam;


public class listview1 extends AppCompatActivity{
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
        setContentView(R.layout.listt);

        lv= (ListView) findViewById(R.id.listview);

        Intent inn = getIntent();
        if (inn != null) {
            String cli = inn.getStringExtra("but0");


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



                }
    }

    @Override
    public void onBackPressed() {
Intent inb=new Intent(listview1.this, options.class);
startActivity(inb);
            super.onBackPressed();
    }

}
