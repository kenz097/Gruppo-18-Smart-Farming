package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Registrazione extends AppCompatActivity {

    private EditText nome;
    private EditText cognome;
    private EditText email;
    private EditText password;
    private EditText carta;
    private EditText cvv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);
        nome = findViewById(R.id.nome);
        cognome = findViewById(R.id.cognome);
        email = findViewById(R.id.e_mail);
        password = findViewById(R.id.pass);
        carta = findViewById(R.id.numberCard);
        cvv = findViewById(R.id.cvv);


    }

    public void goLogin(View view) {
        if (nome.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(Registrazione.this, "Hai dimenticato il nome", Toast.LENGTH_LONG).show();
        } else if (cognome.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(Registrazione.this, "Hai dimenticato il cognome", Toast.LENGTH_LONG).show();
        } else if (email.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(Registrazione.this, "Hai dimenticato l'e-mail", Toast.LENGTH_LONG).show();
        } else if (password.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(Registrazione.this, "Hai dimenticato la password", Toast.LENGTH_LONG).show();
        } else if (carta.getText().toString().equalsIgnoreCase("")) {
            Toast.makeText(Registrazione.this, "Hai dimenticato il cvv", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Registrazione.this, "Ti sei registrato correttamente", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

    }
}
