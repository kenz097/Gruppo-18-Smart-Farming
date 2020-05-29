package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;



public class Raccolta extends AppCompatActivity {
    private EditText nome_prodotto;
    private EditText posizione;
    private EditText quantita;
    private EditText numero_prodotti;
    private ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raccolta);
        nome_prodotto=(EditText)findViewById(R.id.nome_prodotto);
        posizione=(EditText)findViewById(R.id.posizione);
        quantita=(EditText)findViewById(R.id.quantita);
        numero_prodotti=(EditText)findViewById(R.id.numero_prodotti);
        list=(ListView)findViewById(R.id.list);




    }
    public void goBack(View view){
        Intent intent= new Intent(this, Homepage.class);
        startActivity(intent);
    }
    public void addProduct(View v){

        ArrayAdapter<Quantita_Raccolta_Table> adapter= new ArrayAdapter<Quantita_Raccolta_Table>(this,R.layout.element_list_raccolta);
        list.setAdapter(adapter);
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Inserimento quantità nel sistema");
        alert.setMessage("Quantità inserita correttamente nel sistema");
        alert.show();


    }
}
