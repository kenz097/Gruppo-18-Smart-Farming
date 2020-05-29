package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button accedi;
    private EditText email;
    private EditText password;
    private TextView smarrita;
    private TextView registrazione;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accedi = findViewById(R.id.accedi);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        smarrita = findViewById(R.id.smarrita);
        smarrita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                View views=LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_layout,null);
                builder.setPositiveButton("Conferma e-mail", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.setView(views);
                builder.show();
            }
        });

    }




    public void checkLogin(View view) {
        if (email.getText().toString().equalsIgnoreCase("giacomomancini@gmail.com")) {
            if (password.getText().toString().equalsIgnoreCase("ciaociao")) {
                Intent intent = new Intent(this, Homepage.class);

                startActivity(intent);
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Errore");
            alert.setMessage("Email o password errati");
            alert.show();
        }
    }

    public void goRegistrazione(View view) {
        Intent intent = new Intent(this, Registrazione.class);
        startActivity(intent);
    }
}
