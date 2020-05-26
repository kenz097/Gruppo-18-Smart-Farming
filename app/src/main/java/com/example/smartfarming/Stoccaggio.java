package com.example.smartfarming;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Stoccaggio extends AppCompatActivity {
    private ListView list,list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stoccaggio);

       list=(ListView)findViewById(R.id.list);
       list2=(ListView)findViewById(R.id.list2);

        ArrayList<Prodotti_Stoccaggio_Table1> array= new ArrayList<>();
        ArrayList<Prodotti_Stoccaggio_Table2> array2= new ArrayList<>();

        array.add(new Prodotti_Stoccaggio_Table1("Zucchine","Pronto"));
        array.add(new Prodotti_Stoccaggio_Table1("Carote","Vuoto"));
        array.add(new Prodotti_Stoccaggio_Table1("Pomodori","Attendere"));
        array.add(new Prodotti_Stoccaggio_Table1("",""));

        array2.add(new Prodotti_Stoccaggio_Table2("Zucchine","20%"));
        array2.add(new Prodotti_Stoccaggio_Table2("Carote","100%"));
        array2.add(new Prodotti_Stoccaggio_Table2("Pomodori","60%"));
        array2.add(new Prodotti_Stoccaggio_Table2("",""));

        CustomAdapterStoccaggio1 custom1= new CustomAdapterStoccaggio1(this, array);
        CustomAdapterStoccaggio2 custom2= new CustomAdapterStoccaggio2(this, array2);
        list.setAdapter(custom1);
        list2.setAdapter(custom2);
    }
}
