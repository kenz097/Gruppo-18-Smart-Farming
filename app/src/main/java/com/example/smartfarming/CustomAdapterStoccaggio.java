package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterStoccaggio extends BaseAdapter {
    Context context;
    ArrayList<Prodotti_Stoccaggio> arrayList;

    public CustomAdapterStoccaggio(Context context, ArrayList<Prodotti_Stoccaggio> arrayList){
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
        convertView= LayoutInflater.from(context).inflate(R.layout.element_list_stoccaggio,parent,false);
        TextView nomeProdotto=convertView.findViewById(R.id.nomeProdotto);
        TextView stato=convertView.findViewById(R.id.stato);

        nomeProdotto.setText(arrayList.get(position).getNomeProdotto());
        stato.setText(arrayList.get(position).getStato());
        return convertView;
    }
}
