package com.example.smartfarming;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Irrigazione2 extends FragmentActivity implements OnMapReadyCallback {
    private Button b1,b2;
    private Spinner spinner1,spinner2;
    private ImageView image1,image2;
    private ListView list;
    private GoogleMap mMap;
    private TextView nomeCampo;
    private String str;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_irrigazione);
        b1=(Button)findViewById(R.id.button_campo1);
        spinner1=(Spinner)findViewById(R.id.scelta1);
        image1=(ImageView)findViewById(R.id.image1);
        list=(ListView)findViewById(R.id.list);
        nomeCampo=(TextView)findViewById(R.id.text_campo1);


        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle b1 = getIntent().getExtras();
         str = b1.getString("campo");

        ArrayList<Campo> arrayList= new ArrayList<>();
        arrayList.add(new Campo(str));
        CustomAdapterIrrigazione custom= new CustomAdapterIrrigazione(this,arrayList);
        list.setAdapter(custom);

    }
    public void goBack(View view){
        Intent intent= new Intent(this, Homepage.class);
        startActivity(intent);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
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
            b2.setText("Collega");
        }
    }

    public void newLink(View v){
        spinner2=(Spinner)findViewById(R.id.scelta);
        image2=(ImageView)findViewById(R.id.image2);
        b2=(Button)findViewById(R.id.button_newCamp);
        int greenColor= Color.parseColor("#FF4CAF50");
        if(b2.getText()=="Collega"){
            b1.setEnabled(true);
            b2.setText("Avvia");
            spinner2.setEnabled(false);
            spinner1.setEnabled(true);
            b2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            image2.setImageResource(R.drawable.green_p);
            b1.setText("Collega");
            b1.setBackgroundTintList(ColorStateList.valueOf(greenColor));
        }else if(b2.getText()=="Avvia"){
            b2.setText("Avvia");
            spinner2.setEnabled(true);
            spinner1.setEnabled(false);
            b2.setBackgroundTintList(ColorStateList.valueOf(greenColor));
            image2.setImageResource(R.drawable.red_p);
            b1.setText("Collega");
            b1.setBackgroundTintList(ColorStateList.valueOf(greenColor));

        }else{
            b2.setText("Pause");
            spinner2.setEnabled(false);
            b2.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            image2.setImageResource(R.drawable.green_p);
            b1.setText("Collega");
            b1.setBackgroundTintList(ColorStateList.valueOf(greenColor));
        }
    }
}
