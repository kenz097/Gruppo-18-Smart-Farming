package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class DatiCampo extends AppCompatActivity {
    private EditText solco;
    private String st1;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_dati_campo);
        solco=(EditText)findViewById(R.id.solco);
        list=(ListView)findViewById(R.id.list1);
        ArrayList<Solco> arrayList= new ArrayList<>();
        st1=solco.getText().toString();
        arrayList.add(new Solco(st1,"profondita del solco : 40cm"));
        CustomAdapterDatiCampo custom =new CustomAdapterDatiCampo(this,arrayList);
        list.setAdapter(custom);
    }
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
