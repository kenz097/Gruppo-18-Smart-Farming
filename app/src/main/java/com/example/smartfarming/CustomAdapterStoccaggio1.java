package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterStoccaggio1 extends BaseAdapter {
    Context context;
    ArrayList<Prodotti_Stoccaggio_Table1> arrayList;

    public CustomAdapterStoccaggio1(Context context, ArrayList<Prodotti_Stoccaggio_Table1> arrayList){
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
        TextView nomeProdotto=convertView.findViewById(R.id.row1);
        TextView stato=convertView.findViewById(R.id.row2);

        nomeProdotto.setText(arrayList.get(position).getNomeProdotto());
        stato.setText(arrayList.get(position).getStato());
        return convertView;
    }
}
