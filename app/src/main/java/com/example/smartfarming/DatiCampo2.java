package com.example.smartfarming;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DatiCampo2 extends AppCompatActivity {
    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
    setContentView(R.layout.acitivity_dati_campo);
    list=(ListView)findViewById(R.id.list);

    Bundle b1 = getIntent().getExtras();
    String str = b1.getString("solco");


    ArrayList<Solco> arrayList= new ArrayList<>();
        arrayList.add(new Solco(str,"Profondità del solco: 40cm."));
    CustomAdapterDatiCampo custom=new CustomAdapterDatiCampo(this,arrayList);
        list.setAdapter(custom);

}
    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }
    public void addSolco(View v){
        Intent intent=new Intent(this,NuovoSolco.class);
        startActivity(intent);
    }
}
