package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button accedi;
    private EditText email;
    private EditText password;
    private TextView smarrita;
    private TextView registrazione;
    private EditText sendEmail;

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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final View views = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_layout, null);
                sendEmail = views.findViewById(R.id.sendEmail);
                builder.setPositiveButton("Conferma e-mail", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (!sendEmail.getText().toString().equalsIgnoreCase("")) {
                            Toast.makeText(MainActivity.this, "Una e-mail è stata inviata", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Non hai inserito la tua e-mail correttamente", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setNeutralButton("Annulla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                builder.setView(views);
                AlertDialog dialog = builder.create();

                // Finally, display the alert dialog
                dialog.show();

                // Get the alert dialog buttons reference
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                Button neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);

                // Change the alert dialog buttons text and background color
                positiveButton.setTextColor(Color.parseColor("#FFFFFF"));
                positiveButton.setTextSize(10);
                positiveButton.setBackgroundResource(R.drawable.border_button);
                neutralButton.setTextColor(Color.parseColor("#FFFFFF"));
                neutralButton.setTextSize(10);
                neutralButton.setBackgroundResource(R.drawable.border_button);
            }
        });

    }


    public void checkLogin(View view) {
        if ((email.getText().toString().equalsIgnoreCase("giacomomancini@gmail.com")) && (password.getText().toString().equalsIgnoreCase("ciaociao"))) {
                Intent intent = new Intent(this, Homepage.class);
                startActivity(intent);
                Toast.makeText(this,"Benvenuto!",Toast.LENGTH_LONG).show();
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
