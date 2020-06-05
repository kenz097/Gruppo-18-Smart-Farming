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

public class NuovoCampo extends AppCompatActivity {
    private EditText nomeCampo;
    private Button bluetooth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_campo);
        nomeCampo = findViewById(R.id.campo);
        bluetooth=findViewById(R.id.buttonDisp);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Irrigazione.class);
        startActivity(intent);
    }

    public void addNewDispositive(View v) {
        int blue= Color.parseColor("#7BC7FF");
        bluetooth.setBackgroundColor(blue);
        Toast.makeText(this,"Il dispositivo è stato inserito",Toast.LENGTH_LONG).show();
    }

    public void addNuovoValore(View v) {
        if (nomeCampo.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(NuovoCampo.this, "Inserisci il nome del dispositivo", Toast.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(NuovoCampo.this);
            final View views = LayoutInflater.from(NuovoCampo.this).inflate(R.layout.form_done, null);
            TextView title = views.findViewById(R.id.title_add);
            TextView body = views.findViewById(R.id.full_text);
            title.setText("Inserimento dispositivo nel sistema");
            body.setText("Dispositivo inserito correttamente\n              nel sistema");
            builder.setView(views);
            builder.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in1 = new Intent(getApplicationContext(), Irrigazione2.class);
                    in1.putExtra("campo", nomeCampo.getText().toString());
                    startActivity(in1);
                }
            }, 2000);

        }
    }
}