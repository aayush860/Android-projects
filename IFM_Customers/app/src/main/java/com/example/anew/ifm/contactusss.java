package com.example.anew.ifm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.anew.ifm.orderxx.outletsmail;

/**
 * Created by new on 03-03-2018.
 */

public class contactusss extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactuss);
        TextView tvv=(TextView)findViewById(R.id.textView34);




        if(outletsmail.equals("indianfoodmart1@gmail.com")) {
            tvv.setText("Head Office Address:\n" +
                    "Bhavya Enterprises\n" +
                    "Alankar Hotel Wali Gali\n" +
                    "Dal Bazar, Lashkar, Gwalior – 474 009"+"\n\n"+"Branch Office Address:\n" +
                    "Bhavya Enterprises\n" +
                    "Siyaganj\n" +
                    "Indore – 452 001\n");
        }
        else if(outletsmail.equals("indianfoodmart2@gmail.com"))
        {
            tvv.setText("GOYAL KIRANA STORES\n"+
                    "Indore – 452 001\n");
        }

        else if(outletsmail.equals("indianfoodmart3@gmail.com"))
        {
            tvv.setText("BAKEBIHARI TRADERS\n"+
                    "NIRNAL AGRAWAL\n"+
                    "Indore – 452 001\n");
        }

        else
        {
            tvv.setText("Head Office Address:\n" +
                    "Bhavya Enterprises\n" +
                    "Alankar Hotel Wali Gali\n" +
                    "Dal Bazar, Lashkar, Gwalior – 474 009"+"\n\n"+"Branch Office Address:\n" +
                    "Bhavya Enterprises\n" +
                    "Siyaganj\n" +
                    "Indore – 452 001\n");

        }


        Button c1 = (Button) findViewById(R.id.button13I);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo="";
                if(outletsmail.equals("indianfoodmart1@gmail.com")) {
                    phoneNo = "7771008181";
                }
                else if(outletsmail.equals("indianfoodmart2@gmail.com"))
                {
                    phoneNo = "07514026558";
                }
                else if(outletsmail.equals("indianfoodmart3@gmail.com"))
                {
                    phoneNo = "8839212960";
                }
                else
                {
                    phoneNo = "7771008181";
                }
                if (!TextUtils.isEmpty(phoneNo)) {
                    String dial = "tel:" + phoneNo;
                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                } else {
//                    Toast.makeText(Intent2.this, "Enter a phone number", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
