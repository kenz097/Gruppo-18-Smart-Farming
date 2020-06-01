package com.example.smartfarming;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;


import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Irrigazione extends FragmentActivity implements OnMapReadyCallback {
    private Button b1,b2,b3;
    private ImageView image1,image2,image3;
    private Spinner spinner1, spinner2, spinner3;
    private GoogleMap mMap;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrigazione);
        b1=(Button)findViewById(R.id.button_campo1);
        b2=(Button)findViewById(R.id.button_campo2);
        b3=(Button)findViewById(R.id.button_campo3);
        image1=(ImageView)findViewById(R.id.image1);
        image2=(ImageView)findViewById(R.id.image2);
        image3=(ImageView)findViewById(R.id.image3);
        spinner1=(Spinner)findViewById(R.id.scelta1);
        spinner2=(Spinner)findViewById(R.id.scelta2);
        spinner3=(Spinner)findViewById(R.id.scelta3);



        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public void goBack(View view){
        Intent intent= new Intent(this, Homepage.class);
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
        LatLng campi= new LatLng(40.780981, 14.792098);
        mMap.addMarker(new MarkerOptions().position(campi).title("Coltiviamo!"));
        mMap.animateCamera(CameraUpdateFactory.newLatLng(campi));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    public void play1(View v){
        int greenColor= Color.parseColor("#FF4CAF50");
        if(b1.getText()=="Avvia") {
            b1.setText("Pausa");
            spinner1.setEnabled(false);
            b1.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            image1.setImageResource(R.drawable.green_p);
        }else{
            b1.setText("Avvia");
            spinner1.setEnabled(true);
            b1.setBackgroundTintList(ColorStateList.valueOf(greenColor));
            image1.setImageResource(R.drawable.red_p);
        }
    }

    public void play2(View v){
        int greenColor= Color.parseColor("#FF4CAF50");
        if(b2.getText()=="Avvia") {
            b2.setText("Pausa");
            spinner2.setEnabled(false);
            b2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            image2.setImageResource(R.drawable.green_p);
        }else{
            b2.setText("Avvia");
            spinner2.setEnabled(true);
            b2.setBackgroundTintList(ColorStateList.valueOf(greenColor));
            image2.setImageResource(R.drawable.red_p);
        }
    }

    public void play3(View v){
        int greenColor= Color.parseColor("#FF4CAF50");
        if(b3.getText()=="Avvia") {
            b3.setText("Pausa");
            spinner3.setEnabled(false);
            b3.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            image3.setImageResource(R.drawable.green_p);
        }else{
            b3.setText("Avvia");
            spinner3.setEnabled(true);
            b3.setBackgroundTintList(ColorStateList.valueOf(greenColor));
            image3.setImageResource(R.drawable.red_p);
        }
    }

    public void addNewCampo(View view) {
        Intent intent = new Intent(getApplicationContext(), NuovoCampo.class);
        startActivity(intent);
    }
}
