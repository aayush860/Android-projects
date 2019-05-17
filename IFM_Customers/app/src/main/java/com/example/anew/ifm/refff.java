package com.example.anew.ifm;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.anew.ifm.MainActivity.reffff;

/**
 * Created by new on 03-02-2018.
 */

public class refff extends AppCompatActivity {

    String x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reff);

        TextView tv=(TextView)findViewById(R.id.textView2oo);
        tv.setText(reffff);

        Button btn=(Button)findViewById(R.id.button9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager cp=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData cd=ClipData.newPlainText("Copied Text",reffff);
                cp.setPrimaryClip(cd);
                Toast.makeText(refff.this, "Copied", Toast.LENGTH_SHORT).show();
            }
        });
        }
}
