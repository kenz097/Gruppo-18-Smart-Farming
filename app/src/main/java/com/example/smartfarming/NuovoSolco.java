package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class NuovoSolco extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_solco);
    }
    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
