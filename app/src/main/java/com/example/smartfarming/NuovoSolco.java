package com.example.smartfarming;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NuovoSolco extends AppCompatActivity {
    private EditText nomeSolco;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_solco);
        nomeSolco=(EditText)findViewById(R.id.solco);

    }
    public void goBack(View view){
        Intent intent= new Intent(this, DatiCampo.class);
        startActivity(intent);
    }
    public void addNewSolco(View v){
        Intent in1=new Intent(this,DatiCampo2.class);
        in1.putExtra("solco",nomeSolco.getText().toString());
        startActivity(in1);
    }
}
