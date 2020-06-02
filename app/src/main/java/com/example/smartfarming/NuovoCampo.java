package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NuovoCampo extends AppCompatActivity {
    private EditText nomeCampo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_campo);
        nomeCampo = findViewById(R.id.campo);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Irrigazione.class);
        startActivity(intent);
    }

    public void addNewDispositive(View v) {
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        ComponentName cn = new ComponentName("com.android.settings",
                "com.android.settings.bluetoothSettings");
        intent.setComponent(cn);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
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