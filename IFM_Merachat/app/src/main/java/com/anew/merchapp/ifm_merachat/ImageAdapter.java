package com.anew.merchapp.ifm_merachat;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        View grid;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            grid = new View(mContext);
            grid = inflater.inflate(R.layout.singlegrid, parent,false);
            TextView textView = (TextView) grid.findViewById(R.id.textView11);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView);
            //imageView.setLayoutParams(800,800);

            //textView.setText(mThumbdetail[position]);
            //            "VEG MAIN COURSE","VEG SNACK AND SOUP","VEG WRAPS","VEG BIRIYANI",
            //"NONVEG MAIN COURSE","NONVEG SNACK AND SOUP","NONVEG WRAPS","CHICKEN BIRIYANI",
            //        "SALAD","DESSERT"
                textView.setText(mThumbdetail[position]);

            imageView.setImageResource(mThumbIds[position]);
        } else {
            grid = (View) convertView;
            TextView textView = (TextView) grid.findViewById(R.id.textView11);
            ImageView imageView = (ImageView)grid.findViewById(R.id.imageView);
            //textView.setText(mThumbdetail[position]);
                textView.setText(mThumbdetail[position]);
            imageView.setImageResource(mThumbIds[position]);
            //notifyDataSetChanged();
        }

        return grid;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.dryfruits,R.drawable.flour,R.drawable.grainsabut,R.drawable.hebs
            ,R.drawable.kirana,R.drawable.pooja,R.drawable.pulses,R.drawable.pulsessabut
            ,R.drawable.spices,R.drawable.upwas
    };
    public String[] mThumbdetail = {
            "DRY FRUITS","FLOUR","GRAIN SABUT","HERBS","KIRANA","POOJA SAMAGRI",
            "PULSES","PULSES SABUT","SPICES","UPWAS SAMAGRI"
            };
}
