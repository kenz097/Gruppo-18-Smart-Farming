package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NuovoSolco extends AppCompatActivity {
    private EditText nomeSolco;
    private Button bluetooth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_solco);
        nomeSolco = findViewById(R.id.solco);
        bluetooth=findViewById(R.id.button1);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, DatiCampo.class);
        startActivity(intent);
    }

    public void addNewDispositive(View v) {
        int blue= Color.parseColor("#7BC7FF");
        bluetooth.setBackgroundColor(blue);
        Toast.makeText(this,"Il dispositivo è stato inserito",Toast.LENGTH_LONG).show();
    }

    public void addNewSolco(View v) {
        if (nomeSolco.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(NuovoSolco.this, "Inserisci il nome del dispositivo", Toast.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(NuovoSolco.this);
            final View views = LayoutInflater.from(NuovoSolco.this).inflate(R.layout.form_done, null);
            TextView title = views.findViewById(R.id.title_add);
            TextView body = views.findViewById(R.id.full_text);
            title.setText("Inserimento dispositivo nel sistema");
            body.setText("\tDispositivo inserito correttamente\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tnel sistema");
            builder.setView(views);
            builder.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in1 = new Intent(getApplicationContext(), DatiCampo2.class);
                    in1.putExtra("solco", nomeSolco.getText().toString());
                    startActivity(in1);
                }
            }, 2000);

        }
    }
}