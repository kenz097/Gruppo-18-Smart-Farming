package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class Raccolta extends AppCompatActivity {
    private EditText nome_prodotto;
    private EditText posizione;
    private EditText quantita;
    private EditText numero_prodotti;
    private ListView list;
    private String el1, el2, el3, el4;
    private ArrayList<Quantita_Raccolta_Table> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raccolta);
        nome_prodotto = (EditText) findViewById(R.id.nome_prodotto);
        posizione = (EditText) findViewById(R.id.posizione);
        quantita = (EditText) findViewById(R.id.quantita);
        numero_prodotti = (EditText) findViewById(R.id.numero_prodotti);
        list = (ListView) findViewById(R.id.list);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void addProduct(View v) {

        el1 = nome_prodotto.getText().toString();
        el2 = posizione.getText().toString();
        el3 = quantita.getText().toString();
        el4 = numero_prodotti.getText().toString();

        if (el1.equalsIgnoreCase("")) {
            Toast.makeText(Raccolta.this, "Hai dimenticato il nome del prodotto", Toast.LENGTH_LONG).show();
        } else if (el2.equalsIgnoreCase("")) {
            Toast.makeText(Raccolta.this, "Hai dimenticato la posizione del prodotto", Toast.LENGTH_LONG).show();
        } else if (el3.equalsIgnoreCase("")) {
            Toast.makeText(Raccolta.this, "Hai dimenticato la quantita' del prodotto", Toast.LENGTH_LONG).show();
        } else if (el4.equalsIgnoreCase("")) {
            Toast.makeText(Raccolta.this, "Hai dimenticato il numero del prodotto", Toast.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(Raccolta.this);
            final View views = LayoutInflater.from(Raccolta.this).inflate(R.layout.form_done, null);
            TextView title = views.findViewById(R.id.title_add);
            TextView body = views.findViewById(R.id.full_text);
            title.setText("Inserimento quantità nel sistema");
            body.setText("Quantita' inserita correttamente\n              nel sistema");
            builder.setView(views);
            builder.show();

            arrayList = new ArrayList<>();
            arrayList.add(new Quantita_Raccolta_Table(el1, el2, el3 + "kg", el4));
            CustomAdapterRaccolta custom = new CustomAdapterRaccolta(this, arrayList);
            list.setAdapter(custom);
            nome_prodotto.setText("");
            posizione.setText("");
            quantita.setText("");
            numero_prodotti.setText("");

        }

    }

    public void deleteItem(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Raccolta.this);
        builder.setTitle("Cancellazione prodotto");
        builder.setMessage("Sei sicuro di voler eliminare il prodotto?");
        builder.setPositiveButton("Elimina prodotto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(0);
                CustomAdapterRaccolta custom = new CustomAdapterRaccolta(Raccolta.this, arrayList);
                list.setAdapter(custom);
                Toast.makeText(Raccolta.this, "Prodotto eliminato con successo", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNeutralButton("Annulla", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();

        // Finally, display the alert dialog
        dialog.show();

        // Get the alert dialog buttons reference
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);

        // Change the alert dialog buttons text and background color
        positiveButton.setTextColor(Color.parseColor("#FFFFFF"));
        positiveButton.setTextSize(10);
        positiveButton.setBackgroundResource(R.drawable.border_button);
        neutralButton.setTextColor(Color.parseColor("#FFFFFF"));
        neutralButton.setTextSize(10);
        neutralButton.setBackgroundResource(R.drawable.border_button);
    }

    public void modItem(View v) {
        nome_prodotto.setText(el1);
        posizione.setText(el2);
        quantita.setText(el3);
        numero_prodotti.setText(el4);
        Toast.makeText(Raccolta.this, "Modifica i parametri del prodotto", Toast.LENGTH_LONG).show();
    }
}
