package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterSemina extends BaseAdapter {
    ArrayList<Prodotti_Semina_Table1> arrayList;
    Context context;

    public CustomAdapterSemina(Context context, ArrayList<Prodotti_Semina_Table1> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
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
        convertView= LayoutInflater.from(context).inflate(R.layout.element_list_semina,parent,false);
        TextView nomeProdotto=convertView.findViewById(R.id.row1);
        TextView percentuale=convertView.findViewById(R.id.row2);
        nomeProdotto.setText(arrayList.get(position).getNomeProdotto());
        percentuale.setText(arrayList.get(position).getPercentuale());
        return convertView;
    }

}
