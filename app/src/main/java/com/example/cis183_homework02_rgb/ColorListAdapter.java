package com.example.cis183_homework02_rgb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter {
    Context context;
    ArrayList<MyColor> colorList;

    public ColorListAdapter(Context c, ArrayList<MyColor> cl){
        context = c;
        colorList = cl;
    }

    @Override
    public int getCount() {
        return colorList.size();
    }

    @Override
    public Object getItem(int i) {
        return colorList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null){
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.custom_cell, null);
        }

        TextView redNum = view.findViewById(R.id.tv_v_cc_rednum);
        TextView greenNum = view.findViewById(R.id.tv_v_cc_greennum);
        TextView blueNum = view.findViewById(R.id.tv_v_cc_bluenum);
        TextView hexNum = view.findViewById(R.id.tv_v_cc_hexnum);
        ConstraintLayout backround = view.findViewById(R.id.main_cc);

        MyColor color = colorList.get(i);

        redNum.setText(String.valueOf(color.getRed()));
        greenNum.setText(String.valueOf(color.getGreen()));
        blueNum.setText(String.valueOf(color.getBlue()));
        hexNum.setText(color.getHex());

        backround.setBackgroundColor(Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));


        return view;
    }
}
