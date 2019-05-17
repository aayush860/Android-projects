package com.example.anew.ifm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by new on 19-01-2018.
 */

public class offers extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.offers);
        Button cc=(Button)findViewById(R.id.button8);
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ss=new Intent(offers.this,ImageViewerr.class);
                startActivity(ss);
            }
        });




    }
}
