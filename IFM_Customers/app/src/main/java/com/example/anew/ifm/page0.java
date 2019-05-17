package com.example.anew.ifm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;

import static com.example.anew.ifm.MainActivity.c;
import static com.example.anew.ifm.MainActivity.namexxx;
import static com.example.anew.ifm.MainActivity.MyPREFERENCES;

/**
 * Created by new on 01-03-2018.
 */

public class page0 extends Activity {
    SharedPreferences sharedpreferences;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagee1);
    //Time.sleep(3);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        c=sharedpreferences.getString(namexxx,null);
new CountDownTimer(3000,1000)
{
    @Override
    public void onTick(long millisUntilFinished) {

    }

    @Override
    public void onFinish() {

        try {
            if (c.equals("")) {
                Intent in = new Intent(page0.this, orderxx.class);
                startActivity(in);
            } else {
                Intent in = new Intent(page0.this, orderxx.class);
                startActivity(in);
            }
        }
        catch (Exception e)
        {
            if (c==null) {
                Intent in=new Intent(page0.this,orderxx.class);
                startActivity(in);

            } else {
                Intent in=new Intent(page0.this,orderxx.class);
                startActivity(in);
            }
        }
    }
}.start();

    }
}
