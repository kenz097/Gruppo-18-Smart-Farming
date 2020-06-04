package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterDatiCampo extends BaseAdapter {
    Context context;
    ArrayList<Solco> arrayList;

    public CustomAdapterDatiCampo(Context context,ArrayList<Solco> arrayList){
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
        convertView= LayoutInflater.from(context).inflate(R.layout.element_list_daticampo,parent,false);
        TextView nomeSolco=convertView.findViewById(R.id.row1);
        TextView profondita=convertView.findViewById(R.id.row2);
        nomeSolco.setText(arrayList.get(position).getNomeSolco());
        profondita.setText(arrayList.get(position).getProfondita());
        return convertView;

    }
}
