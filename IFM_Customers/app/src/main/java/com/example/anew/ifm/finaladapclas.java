package com.example.anew.ifm;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class finaladapclas extends BaseAdapter {
    public Context finaallcontext;
    public List<Product> finaallproduct;

    public finaladapclas(Context finaallcontext, List<Product> finaallproduct) {
        this.finaallcontext = finaallcontext;
        this.finaallproduct = finaallproduct;

    }

    @Override
    public int getCount() {
        return finaallproduct.size();
    }

    @Override
    public Object getItem(int i) {
        return finaallproduct.get(i);
    }


    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int i, View convertView, final ViewGroup parent) {

        final viewholder vh = new viewholder();
        vh.ref = i;

        //LayoutInflater Vi=(LayoutInflater)get;
        View v = View.inflate(finaallcontext, R.layout.confirmmm, null);


        vh.tv1 = (TextView) v.findViewById(R.id.textView13);
        vh.tv2 = (TextView) v.findViewById(R.id.textView14);
        vh.tv3 = (TextView) v.findViewById(R.id.textView20);
        vh.tv4 = (TextView) v.findViewById(R.id.textView22);
        v.setTag(vh);

        int pric = Integer.parseInt(finaallproduct.get(i).getRatepk());
        int weigh=Integer.parseInt(String.valueOf(finaallproduct.get(i).getKgsx()));
        int grmsss=Integer.parseInt(String.valueOf(finaallproduct.get(i).getGmsx()));




        float pric1=pric*weigh;
        float pric2=(float)pric*(float)(grmsss);
        pric2=pric2/1000;
        float tx=pric1+pric2;
//        int qua = Integer.parseInt(String.valueOf(finaallproduct.get(i).getPquanx()));
//  int dippr=Integer.parseInt(String.valueOf(finaallproduct.get(i).getDisc_per_prod()));





 int dippr=0;









  int ccc=(dippr*(int)tx)/100;
  int tot = (int)tx - ccc;
//        String cc = Integer.toString(pric) + " X " + Integer.toString(qua) + " = " + Integer.toString(tot);


        String txx=Integer.toString((int)tx);

if(grmsss>99)
{
    String zzz=String.valueOf(finaallproduct.get(i).getKgsx())+"."+String.valueOf(finaallproduct.get(i).getGmsx());
    vh.tv2.setText(finaallproduct.get(i).getRatepk()+"X"+zzz+"="+txx);
}
else
{
    String zzz=String.valueOf(finaallproduct.get(i).getKgsx())+".0"+String.valueOf(finaallproduct.get(i).getGmsx());
    vh.tv2.setText(finaallproduct.get(i).getRatepk()+"X"+zzz+"="+txx);
}
        vh.tv1.setText(finaallproduct.get(i).getPname());

        vh.tv3.setText(finaallproduct.get(i).getDisc_per_prod()+"%");








        vh.tv3.setText("0%");













        vh.tv4.setText(Integer.toString(tot));
        return v;
    }

    static class viewholder {
        TextView tv1 = null;
        TextView tv2 = null;
        TextView tv3 = null;
        TextView tv4 = null;
        int ref;

    }
}
