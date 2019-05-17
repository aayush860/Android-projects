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


public class adap1 extends BaseAdapter {
    public Context lcontext;
      static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
//    int counnt=0;
    public List<Product> dryfruits;

    public adap1(Context lcontext, List<Product> dryfruits) {
        this.lcontext = lcontext;
        this.dryfruits = dryfruits;

    }

    @Override
    public int getCount() {
        return dryfruits.size();
    }

    @Override
    public Object getItem(int i) {
        return dryfruits.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(lcontext,R.layout.slll,null);
        v.setTag(vh);
        vh.tv1=(TextView)v.findViewById(R.id.textView164);
        vh.tv2=(TextView)v.findViewById(R.id.textView174);
        vh.tv3=(TextView)v.findViewById(R.id.textView164x);
        final Button plus=(Button)v.findViewById(R.id.button5);


        if(dell.equals("delete")) {
    plus.setText("DELETE");
}


        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v= parent.getChildAt(i);

                //Intent inn=new Intent(lcontext,updatecl.class);
                Toast.makeText(lcontext, Integer.toString(i),Toast.LENGTH_SHORT).show();
                if(dell.equals("delete")) {
                    lcontext.startActivity(new Intent(lcontext, delit.class).putExtra("id", "dryfruits," + Integer.toString(i)));

                }
                else {
                    lcontext.startActivity(new Intent(lcontext, updatecl.class).putExtra("id", "dryfruits,"
                            + Integer.toString(i)+","+dryfruits.get(i).getPname()+","+dryfruits.get(i).getRatepk()+","+dryfruits.get(i).getDisc_per_prod()));
                }

            }
        });

        vh.tv1.setText(dryfruits.get(i).getPname());
        vh.tv2.setText(dryfruits.get(i).getRatepk());
        vh.tv3.setText(dryfruits.get(i).getDisc_per_prod());
        return v;
    }
    static class viewholder{
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        int ref;

    }
}
