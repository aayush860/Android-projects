package com.example.anew.ifm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by new on 03-03-2018.
 */

public class exitc extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactuss);

        finishAffinity();
        System.exit(0);

    }
    }
