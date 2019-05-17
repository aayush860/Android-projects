package com.example.anew.ifm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by new on 03-03-2018.
 */

public class abtus extends AppCompatActivity{
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.aboutus);

            TextView tvv=(TextView) findViewById(R.id.textView15);
            tvv.setText("Indian foodmart operate under the philosophy of superior service, quality products and competitive prices. Our primary concern is to serve you — our dedicated customer. That’s why we are proud to offer the fresh produce, highest quality Grocery Products and most personable service. Our carryout tradition is one of our signature traits — representing our desire to make shopping with us a great experience."
            +"\n\n"+"We think you’ll be impressed with our friendly service and engaging atmosphere. Our people are here to make your food and shopping experience about more than just putting dinner on the table. We’re proud to be your neighborhood grocery store!");
        }
}
