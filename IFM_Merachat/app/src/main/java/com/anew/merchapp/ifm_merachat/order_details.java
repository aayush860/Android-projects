package com.anew.merchapp.ifm_merachat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.anew.merchapp.ifm_merachat.orderhis.xpr;

/**
 * Created by new on 23-03-2018.
 */

public class order_details extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jdbcjh);
        TextView tv1n=(TextView)findViewById(R.id.textView9);
        TextView tv2m=(TextView)findViewById(R.id.textView10);
        TextView tv3p=(TextView)findViewById(R.id.textView12);
        TextView tv4d=(TextView)findViewById(R.id.textView14);
        TextView tv5a=(TextView)findViewById(R.id.textView20);
        Intent inn = getIntent();
        if (inn != null) {
            String cli = inn.getStringExtra("ival");
            int y=Integer.parseInt(cli);
            tv1n.setText((xpr.get(y).getName()).toString());
            tv2m.setText((xpr.get(y).getMobileno()).toString());
            tv3p.setText((xpr.get(y).getPrice()).toString());
            tv4d.setText((xpr.get(y).getDetails()).toString());
            tv5a.setText((xpr.get(y).getAddrrr()).toString());

        }
        }
}
