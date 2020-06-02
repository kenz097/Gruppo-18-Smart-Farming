package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
            AlertDialog.Builder builder = new AlertDialog.Builder(Registrazione.this);
            final View views = LayoutInflater.from(Registrazione.this).inflate(R.layout.form_done, null);
            TextView title = views.findViewById(R.id.title_add);
            TextView body = views.findViewById(R.id.full_text);
            title.setText("Registrazione nel sistema");
            body.setText("Registazione effettuata con successo");
            builder.setView(views);
            builder.show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent in1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in1);
                }
            }, 3000);
        }

    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
