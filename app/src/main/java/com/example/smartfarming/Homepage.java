package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
    }

    public void goRaccolta(View view) {
        Intent intent = new Intent(getApplicationContext(), Raccolta.class);
        startActivity(intent);
    }

    public void goStoccaggio(View view) {
        Intent intent = new Intent(getApplicationContext(), Stoccaggio.class);
        startActivity(intent);
    }

    public void goLogout(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void goIrrigazione(View view) {
        Intent intent = new Intent(getApplicationContext(), Irrigazione.class);
        startActivity(intent);
    }

    public void goSemina(View view) {
        Intent intent = new Intent(getApplicationContext(), Semina.class);
        startActivity(intent);
    }

    public void goDatiCampo(View view) {
        Intent intent = new Intent(getApplicationContext(), DatiCampo.class);
        startActivity(intent);
    }
}
