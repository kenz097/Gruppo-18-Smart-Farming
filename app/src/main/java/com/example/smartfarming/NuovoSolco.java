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

import java.util.Timer;
import java.util.TimerTask;

public class NuovoSolco extends AppCompatActivity {
    private EditText nomeSolco;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_solco);
        nomeSolco = (EditText) findViewById(R.id.solco);

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, DatiCampo.class);
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

    public void addNewSolco(View v) {
        if (nomeSolco.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(NuovoSolco.this, "Una e-mail è stata inviata", Toast.LENGTH_LONG).show();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(NuovoSolco.this);
            final View views = LayoutInflater.from(NuovoSolco.this).inflate(R.layout.form_done, null);
            TextView title = views.findViewById(R.id.title_add);
            TextView body = views.findViewById(R.id.full_text);
            title.setText("Inserimento dispositivo nel sistema");
            body.setText("Dispositivo inserito correttamente\n              nel sistema");
            builder.setView(views);
            builder.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in1 = new Intent(getApplicationContext(), DatiCampo2.class);
                    in1.putExtra("solco", nomeSolco.getText().toString());
                    startActivity(in1);
                }
            }, 3000);

        }
    }
}
