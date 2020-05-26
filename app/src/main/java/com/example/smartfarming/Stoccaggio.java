package com.example.smartfarming;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stoccaggio extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoccaggio);

       list=(ListView)findViewById(R.id.list);
        ArrayList<Prodotti_Stoccaggio> array=new ArrayList<>();
        array.add(new Prodotti_Stoccaggio("Zucchine","Pronto"));
        array.add(new Prodotti_Stoccaggio("Carote","Vuoto"));
        array.add(new Prodotti_Stoccaggio("Pomodori","Attendere"));

        CustomAdapterStoccaggio custom= new CustomAdapterStoccaggio(this, array);
        list.setAdapter(custom);
    }
}
