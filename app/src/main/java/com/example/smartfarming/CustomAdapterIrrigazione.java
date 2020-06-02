package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterIrrigazione extends BaseAdapter {
     Context context;
     ArrayList<Campo> arrayList;
    public CustomAdapterIrrigazione(Context context, ArrayList<Campo> arrayList){
        this.context=context;
        this.arrayList=arrayList;
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.element_list_irrigazione,parent,false);
        TextView nomeCampo= convertView.findViewById(R.id.nomeCampo);
        nomeCampo.setText(arrayList.get(position).getNomeCampo());
        return convertView;
    }
}
