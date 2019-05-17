package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static com.anew.merchapp.ifm_merachat.MainActivity.MyPREFERENCES;
import static com.anew.merchapp.ifm_merachat.MainActivity.namexxx;
import static com.anew.merchapp.ifm_merachat.page1.dat;


public class ImageViewerr extends AppCompatActivity {
    SharedPreferences sharedpreferences;

    static String xx,ccimg;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridmenu);

        GridView gridvieww = (GridView) findViewById(R.id.gridview);
        Button btxx=(Button)findViewById(R.id.button3);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        ccimg=sharedpreferences.getString(namexxx,null);


        btxx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString(namexxx,"");
  //              editor.putString(pswdxxx,(dat.get(j).getPsswrrd()));
    //            editor.putString(linkoff,(dat.get(j).getLinkx()));
                editor.commit();
                editor.apply();

                Intent icn=new Intent(ImageViewerr.this,page1.class);
            startActivity(icn);

            }
            });








        gridvieww.setAdapter(new ImageAdapter(this));
        final Intent in = new Intent(ImageViewerr.this, options.class);

        gridvieww.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        in.putExtra("but0", "list0");
                        xx="list0";
                        startActivity(in);
                        break;

                    case 1:
                        in.putExtra("but0", "list1");
                        xx="list1";
                        startActivity(in);
                        break;

                    case 2:
                        in.putExtra("but0", "list2");
                        xx="list2";
                        startActivity(in);
                        break;

                    case 3:
                        in.putExtra("but0", "list3");
                        xx="list3";
                        startActivity(in);
                        break;

                    case 4:
                        in.putExtra("but0", "list4");
                        xx="list4";
                        startActivity(in);
                        break;

                    case 5:
                        in.putExtra("but0", "list5");
                        xx="list5";
                        startActivity(in);
                        break;

                    case 6:
                        in.putExtra("but0", "list6");
                        xx="list6";
                        startActivity(in);
                        break;

                    case 7:
                        in.putExtra("but0", "list7");
                        xx="list7";
                        startActivity(in);
                        break;

                    case 8:
                        in.putExtra("but0", "list8");
                        xx="list8";
                        startActivity(in);
                        break;

                    case 9:
                        in.putExtra("but0", "list9");
                        xx="list9";
                        startActivity(in);
                        break;


                }
            }
        });
    }
boolean x=false;
    @Override
    public void onBackPressed() {
if(x) {
    super.onBackPressed();
    finishAffinity();
}
this.x=true;
        Toast.makeText(this, "Press Again to Exit...", Toast.LENGTH_SHORT).show();
new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        x=false;
    }
},2000);

    }


}

