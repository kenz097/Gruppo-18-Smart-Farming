package com.example.smartfarming;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CustomAdapterRaccolta extends BaseAdapter {
    Context context;
    ArrayList<Quantita_Raccolta> arrayList;

    public CustomAdapterRaccolta(Context context, ArrayList<Quantita_Raccolta> arrayList){
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
        convertView= LayoutInflater.from(context).inflate(R.layout.element_list_raccolta,parent,false);
        TextView nomeProdotto= convertView.findViewById(R.id.row1);
        TextView posizione= convertView.findViewById(R.id.row2);
        TextView quantita= convertView.findViewById(R.id.row3);
        TextView numeroProdotti= convertView.findViewById(R.id.row4);

        nomeProdotto.setText(arrayList.get(position).getNomeProdotto());
        posizione.setText(arrayList.get(position).getPosizione());
        quantita.setText(arrayList.get(position).getQuantita());
        numeroProdotti.setText(arrayList.get(position).getNumProdotti());
        return convertView;
    }
}
