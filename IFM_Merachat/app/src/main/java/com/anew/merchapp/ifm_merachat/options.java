package com.anew.merchapp.ifm_merachat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.anew.merchapp.ifm_merachat.ImageViewerr.xx;

/**
 * Created by new on 18-03-2018.
 */

public class options extends AppCompatActivity {
    static String dell;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.optionss);
        Button add=(Button)findViewById(R.id.button4);
        Button update=(Button)findViewById(R.id.button5);
        Button delete=(Button)findViewById(R.id.button6);
        Button oh=(Button)findViewById(R.id.button11);
        Button regis=(Button)findViewById(R.id.button13);
dell="";
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(options.this,listview1.class);
                inn.putExtra("but0",""+xx);
                startActivity(inn);

            }});

    add.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent inn=new Intent(options.this,addit.class);
            inn.putExtra("but0",""+xx);
            startActivity(inn);

        }});
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(options.this,listview1.class);
                inn.putExtra("but0",""+xx);
                startActivity(inn);
dell="delete";
            }});

        oh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(options.this, orderhis.class);
                //inn.putExtra("but0", "" + xx);
                startActivity(inn);
            }});

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn = new Intent(options.this, ddd.class);
                //inn.putExtra("but0",""+xx);
                startActivity(inn);
            }});
}

    @Override
    public void onBackPressed() {
        Intent inb=new Intent(options.this, ImageViewerr.class);
        startActivity(inb);
        super.onBackPressed();

    }
}
