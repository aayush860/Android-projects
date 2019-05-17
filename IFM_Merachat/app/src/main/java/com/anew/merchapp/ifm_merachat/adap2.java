package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.anew.merchapp.ifm_merachat.options.dell;


public class adap2 extends BaseAdapter {
    public Context mcontext;
    static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
    //    int counnt=0;
    public List<Product> flour;

    public adap2(Context mcontext, List<Product> flour) {
        this.mcontext = mcontext;
        this.flour = flour;

    }

    @Override
    public int getCount() {
        return flour.size();
    }

    @Override
    public Object getItem(int i) {
        return flour.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(mcontext,R.layout.slll,null);
        vh.tv1=(TextView)v.findViewById(R.id.textView164);
        vh.tv2=(TextView)v.findViewById(R.id.textView174);
        vh.tv3=(TextView)v.findViewById(R.id.textView164x);
        final Button plus=(Button)v.findViewById(R.id.button5);

        v.setTag(vh);

        if(dell.equals("delete")) {
            plus.setText("DELETE");
        }



        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v= parent.getChildAt(i);
                Toast.makeText(mcontext, Integer.toString(i),Toast.LENGTH_SHORT).show();
                if(dell.equals("delete")) {
                    mcontext.startActivity(new Intent(mcontext, delit.class).putExtra("id", "flour," + Integer.toString(i)));

                }
                else {

                    mcontext.startActivity(new Intent(mcontext, updatecl.class).putExtra("id", "flour," + Integer.toString(i)
                            + "," + flour.get(i).getPname() + "," + flour.get(i).getRatepk() + "," + flour.get(i).getDisc_per_prod()));
                }
            }
        });


        vh.tv1.setText(flour.get(i).getPname());
        vh.tv2.setText(flour.get(i).getRatepk());
        vh.tv3.setText(flour.get(i).getDisc_per_prod());

        return v;
    }
    static class viewholder{
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        int ref;

    }
}
