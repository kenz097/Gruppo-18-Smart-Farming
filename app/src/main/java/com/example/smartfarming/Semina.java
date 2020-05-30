package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Semina extends AppCompatActivity {
    private ListView list;
    private String st1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semina);
        list=(ListView)findViewById(R.id.list);
        ArrayList<Prodotti_Semina_Table1> arrayList= new ArrayList<>();
        arrayList.add(new Prodotti_Semina_Table1("Pomodori","30%"));
        arrayList.add(new Prodotti_Semina_Table1("Fagioli","50%"));
        arrayList.add(new Prodotti_Semina_Table1("Patate","30%"));
        arrayList.add(new Prodotti_Semina_Table1("Zucchine","45%"));
        arrayList.add(new Prodotti_Semina_Table1("Lattuga","70%"));
        CustomAdapterSemina custom=new CustomAdapterSemina(this,arrayList);
        list.setAdapter(custom);


    }
    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

}
