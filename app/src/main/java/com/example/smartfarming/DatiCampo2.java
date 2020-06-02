package com.example.smartfarming;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class DatiCampo2 extends AppCompatActivity {
    private ListView list;

    BarChart barChart;
    ArrayList<Solco> arrayList;
    ArrayList<Materiali_Grafici_DatiCampo> arrayMaterialiGraficiDatiCampo = new ArrayList<>();
    ArrayList<String> tipo = new ArrayList<>();
    ArrayList<BarEntry> barEntries = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dati_campo);
        list = (ListView) findViewById(R.id.list);

        Bundle b1 = getIntent().getExtras();
        String str = b1.getString("solco");


        ArrayList<Solco> arrayList = new ArrayList<>();
        arrayList.add(new Solco(str, "Profondità del solco: 40cm."));
        CustomAdapterDatiCampo custom = new CustomAdapterDatiCampo(this, arrayList);
        list.setAdapter(custom);


        barChart = (BarChart) findViewById(R.id.Datcam);

        fillMateriali();
        for (int i = 0; i < arrayMaterialiGraficiDatiCampo.size(); i++) {
            String materia = arrayMaterialiGraficiDatiCampo.get(i).getTipo();
            int percentuale = arrayMaterialiGraficiDatiCampo.get(i).getPercentuale();
            barEntries.add(new BarEntry(i, percentuale));
            tipo.add(materia);
        }
        BarDataSet barDataSet = new BarDataSet(barEntries, "Materiali_Grafici_DatiCampo");
        BarData barData = new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(tipo));
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(tipo.size());
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        barData.setBarWidth(1f);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barChart.setDrawGridBackground(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.getDescription().setText("Materiali_Grafici_DatiCampo all'interno del terreno");
        barChart.animateY(2000);
        barChart.invalidate();


    }

    private void fillMateriali() {
        arrayMaterialiGraficiDatiCampo.clear();
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Sabbia", 20));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Acqua", 60));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Argilla", 20));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Limo", 40));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Ferro", 80));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Ghiaia", 35));
        arrayMaterialiGraficiDatiCampo.add(new Materiali_Grafici_DatiCampo("Silicio", 23));
    }

    public void deleteItem(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(DatiCampo2.this);
        builder.setTitle("Cancellazione campo");
        builder.setMessage("Sei sicuro di voler eliminare il solco?");
        builder.setPositiveButton("Elimina solco", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(DatiCampo2.this, DatiCampo.class);
                startActivity(intent);
            }
        });
        builder.setNeutralButton("Annulla", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();

        // Finally, display the alert dialog
        dialog.show();

        // Get the alert dialog buttons reference
        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button neutralButton = dialog.getButton(AlertDialog.BUTTON_NEUTRAL);

        // Change the alert dialog buttons text and background color
        positiveButton.setTextColor(Color.parseColor("#FFFFFF"));
        positiveButton.setBackgroundResource(R.drawable.border_button);
        neutralButton.setTextColor(Color.parseColor("#FFFFFF"));
        neutralButton.setBackgroundResource(R.drawable.border_button);
    }

    public void modItem(View v) {
        Intent intent = new Intent(this, NuovoSolco.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

    public void addSolco(View v) {
        Intent intent = new Intent(this, NuovoSolco.class);
        startActivity(intent);
    }
}
