package com.example.anew.ifm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.example.anew.ifm.orderxx.dryfruits;

/**
 * Created by new on 13-01-2018.
 */

public class listviewerr extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listt);
        adap1 adapx;
        ListView lv=(ListView)findViewById(R.id.listview);
        adapx = new adap1(this, dryfruits);
        lv.setAdapter(adapx);






    }
}