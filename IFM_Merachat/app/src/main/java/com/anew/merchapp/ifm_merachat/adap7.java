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


public class adap7 extends BaseAdapter {
    public Context rcontext;
    static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
    //    int counnt=0;
    public List<Product> pulses;

    public adap7(Context rcontext, List<Product> pulses) {
        this.rcontext = rcontext;
        this.pulses = pulses;

    }

    @Override
    public int getCount() {
        return pulses.size();
    }

    @Override
    public Object getItem(int i) {
        return pulses.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(rcontext,R.layout.slll,null);
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
                Toast.makeText(rcontext, Integer.toString(i),Toast.LENGTH_SHORT).show();
                if(dell.equals("delete")) {
                    rcontext.startActivity(new Intent(rcontext, delit.class).putExtra("id", "pulses," + Integer.toString(i)));

                }
                else {

                    rcontext.startActivity(new Intent(rcontext, updatecl.class).putExtra("id", "pulses," + Integer.toString(i)
                            + "," + pulses.get(i).getPname() + "," + pulses.get(i).getRatepk() + "," + pulses.get(i).getDisc_per_prod()));
                }
            }
        });


        vh.tv1.setText(pulses.get(i).getPname());
        vh.tv2.setText(pulses.get(i).getRatepk());
        vh.tv3.setText(pulses.get(i).getDisc_per_prod());

        return v;
    }
    static class viewholder{
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        int ref;

    }
}
