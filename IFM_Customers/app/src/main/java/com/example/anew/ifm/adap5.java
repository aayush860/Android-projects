package com.example.anew.ifm;

import android.content.Context;
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
/*
        final Spinner pinkg=(Spinner)v.findViewById(R.id.spinner);
        final Spinner ping=(Spinner)v.findViewById(R.id.spinner2);
        final Spinner quant=(Spinner)v.findViewById(R.id.spinner9);
        vh.tv1=(TextView)v.findViewById(R.id.textView);
        vh.tv2=(TextView)v.findViewById(R.id.textView2);
*/
        v.setTag(vh);
        final Spinner pinkg=(Spinner)v.findViewById(R.id.spinner44);
        final Spinner ping=(Spinner)v.findViewById(R.id.spinner5);
        vh.tv1=(TextView)v.findViewById(R.id.textView164);
        vh.tv2=(TextView)v.findViewById(R.id.textView174);
        vh.tv3=(TextView)v.findViewById(R.id.textView164x);

        final Button plus=(Button)v.findViewById(R.id.button5);


        int yy=0;
        List<Integer> pkg =  new ArrayList<Integer>();
        for(int y=0;y<11;y++) {
            pkg.add(y);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(pcontext, android.R.layout.simple_spinner_item, pkg);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pinkg.setAdapter(adapter);

        pinkg.setSelection(kirana.get(i).getKgs(),true);


        int g=0;
        List<Integer> pg =  new ArrayList<Integer>();
        for(int y=0;y<11;y++) {
            pg.add(g);
            g=g+10;
        }
        int gg=200;
        for(int y=0;y<9;y++) {
            pg.add(gg);
            gg=gg+100;
        }

        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(pcontext, android.R.layout.simple_spinner_item, pg);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ping.setAdapter(adapter1);
        ping.setSelection(kirana.get(i).getGms());

/*
        List<Integer> qu =  new ArrayList<Integer>();
        for(int y=0;y<11;y++) {
            qu.add(y);
        }

        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(pcontext, android.R.layout.simple_spinner_item, qu);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        quant.setAdapter(adapter2);
        quant.setSelection(kirana.get(i).getPquan());
*/








        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                v= parent.getChildAt(i);
                int kgg = Integer.parseInt(String.valueOf(pinkg.getSelectedItemId()));
                int gmss = Integer.parseInt(String.valueOf(ping.getSelectedItemId()));
  //              int qua = Integer.parseInt(String.valueOf(quant.getSelectedItemId()));

                int kggx = Integer.parseInt(pinkg.getSelectedItem().toString());
                int gmssx = Integer.parseInt(ping.getSelectedItem().toString());
//                int quax = Integer.parseInt(quant.getSelectedItem().toString());

                kirana.get(i).setKgsx(kggx);
                kirana.get(i).setGmsx(gmssx);
//                kirana.get(i).setPquanx(quax);

                kirana.get(i).setKgs(kgg);
                kirana.get(i).setGms(gmss);
//                kirana.get(i).setPquan(qua);



                Toast.makeText(pcontext, "Product Added To Cart",Toast.LENGTH_SHORT).show();

/*
                Toast.makeText(lcontext, Integer.toString(kgg)+
                        "gms"+Integer.toString(gmss)+
                        "qua"+Integer.toString(qua),
                         Toast.LENGTH_SHORT).show();
*/
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
