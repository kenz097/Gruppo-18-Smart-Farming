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
    private ListView list;
    private String st1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_dati_campo);
        list=(ListView)findViewById(R.id.list);



    }
    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
    public void addSolco(View v){
        Intent intent=new Intent(this,NuovoSolco.class);
        startActivity(intent);
    }

}
