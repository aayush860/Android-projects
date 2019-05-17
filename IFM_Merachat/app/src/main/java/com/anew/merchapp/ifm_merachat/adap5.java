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


public class adap5 extends BaseAdapter {
    public Context pcontext;
    static ArrayList<Integer> lquant=new ArrayList<Integer>(Collections.nCopies(110,0));
    //    int counnt=0;
    public List<Product> kirana;

    public adap5(Context pcontext, List<Product> kirana) {
        this.pcontext = pcontext;
        this.kirana = kirana;

    }

    @Override
    public int getCount() {
        return kirana.size();
    }

    @Override
    public Object getItem(int i) {
        return kirana.get(i);
    }



    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh=new viewholder();
        vh.ref=i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v= View.inflate(pcontext,R.layout.slll,null);
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
                v = parent.getChildAt(i);
                Toast.makeText(pcontext, Integer.toString(i), Toast.LENGTH_SHORT).show();
                if(dell.equals("delete")) {
                    pcontext.startActivity(new Intent(pcontext, delit.class).putExtra("id", "kirana," + Integer.toString(i)));

                }
                else {

                    pcontext.startActivity(new Intent(pcontext, updatecl.class).putExtra("id", "kirana," + Integer.toString(i)
                        + "," + kirana.get(i).getPname() + "," + kirana.get(i).getRatepk() + "," + kirana.get(i).getDisc_per_prod()));
            }
            }
        });


        vh.tv1.setText(kirana.get(i).getPname());
        vh.tv2.setText(kirana.get(i).getRatepk());
        vh.tv3.setText(kirana.get(i).getDisc_per_prod());

        return v;
    }
    static class viewholder{
        TextView tv1=null;
        TextView tv2=null;
        TextView tv3=null;
        int ref;

    }
}
