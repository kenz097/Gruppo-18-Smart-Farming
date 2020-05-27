package com.example.smartfarming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button accedi;
    private EditText email;
    private EditText password;
    MainActivity mainActivity;

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accedi = findViewById(R.id.accedi);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

    }


    public void checkLogin() {
        if (email.toString().equalsIgnoreCase("giacomomancini@gmail.com")) {
            if (password.toString().equalsIgnoreCase("ciaociao")) {
                Intent intent = new Intent(this, Homepage.class);
                startActivity(intent);
            }
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(mainActivity);
            alert.setTitle("Errore");
            alert.setMessage("Email o password errati");
            alert.show();
        }
    }
}
