package com.example.anew.ifm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by new on 08-04-2018.
 */
//905275218045-ag8l6403su7uofo238t3fbs1008f1lg3.apps.googleusercontent.com
public class fbauth extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fba);
        Button bx=findViewById(R.id.button12);
        bx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
