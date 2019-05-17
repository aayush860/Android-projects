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


public class adap8 extends BaseAdapter {
    public Context scontext;
    static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
    //    int counnt=0;
    public List<Product> pulsessabut;

    public adap8(Context scontext, List<Product> pulsessabut) {
        this.scontext = scontext;
        this.pulsessabut = pulsessabut;

    }

    @Override
    public int getCount() {
        return pulsessabut.size();
    }

    @Override
    public Object getItem(int i) {
        return pulsessabut.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(scontext,R.layout.slll,null);
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
                Toast.makeText(scontext, Integer.toString(i),Toast.LENGTH_SHORT).show();
                if(dell.equals("delete")) {
                    scontext.startActivity(new Intent(scontext, delit.class).putExtra("id", "pulsessabut," + Integer.toString(i)));

                }
                else {

                    scontext.startActivity(new Intent(scontext, updatecl.class).putExtra("id", "pulsessabut," + Integer.toString(i)
                            + "," + pulsessabut.get(i).getPname() + "," + pulsessabut.get(i).getRatepk() + "," + pulsessabut.get(i).getDisc_per_prod()));
                }
            }
        });


        vh.tv1.setText(pulsessabut.get(i).getPname());
        vh.tv2.setText(pulsessabut.get(i).getRatepk());
        vh.tv3.setText(pulsessabut.get(i).getDisc_per_prod());

        return v;
    }
    static class viewholder{
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        int ref;

    }
}
