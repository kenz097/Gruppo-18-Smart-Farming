package com.example.smartfarming;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Homepage extends AppCompatActivity {
    private TextView logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        logout=findViewById(R.id.logout);
        logout.setPaintFlags(logout.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
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
