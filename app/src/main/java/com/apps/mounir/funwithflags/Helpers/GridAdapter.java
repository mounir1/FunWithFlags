package com.apps.mounir.funwithflags.Helpers;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.apps.mounir.funwithflags.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Flag> flaglist;


    public GridAdapter(Context c, ArrayList<Flag> list) {
        this.mContext = c;
        this.flaglist = list;
    }

    @Override
    public int getCount() {
        return flaglist.size();
    }

    @Override
    public Object getItem(int position) {
        return flaglist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class Vieholder {
        ImageView imbtn;

        Vieholder(View v) {
            imbtn = (ImageView) v.findViewById(R.id.imageButton);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        Vieholder vieholder = null;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.image, parent, false);
            vieholder = new Vieholder(row);
            row.setTag(vieholder);
        } else {
            vieholder= (Vieholder) row.getTag();
        }

        vieholder.imbtn.setImageResource(flaglist.get(position).getImagId());
        return row;
//        Log.d("4", "getView: ");
//        ImageButton image;
////        if (convertView == null) {
//        image = new ImageButton(mContext);
//        image.setImageResource(flaglist.get(position).getImagId());
//        image.setScaleType(ImageButton.ScaleType.CENTER_CROP);
//        image.setLayoutParams(new GridView.LayoutParams(85, 70));
////            image.setPadding(4, 4, 4, 4);
////        } else {
////            image = (ImageButton) convertView;
//
////        }
//        return image;
    }
}