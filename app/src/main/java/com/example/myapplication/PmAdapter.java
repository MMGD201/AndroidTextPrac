package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PmAdapter extends BaseAdapter {

    private LayoutInflater flater;
    private ArrayList<PmItem> list;

    public PmAdapter(Context context, ArrayList<PmItem> list1){
        flater=LayoutInflater.from(context);
        list=list1;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view=flater.inflate(R.layout.item_pm, viewGroup, false);

        PmItem item = list.get(i);
        TextView county=view.findViewById(R.id.item_county);
        TextView site=view.findViewById(R.id.item_site);
        TextView pm=view.findViewById(R.id.item_pm);
        county.setText(item.getCounty());
        site.setText(item.getSite());
        pm.setText(item.getPm());

        return view;
    }


}
