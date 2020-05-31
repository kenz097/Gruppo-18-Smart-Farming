package com.example.smartfarming;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Semina extends AppCompatActivity {
    private ListView list;
    BarChart barChart;
    ArrayList<Prodotti_Grafico_Semina> arrayProdottiGraficoSemina = new ArrayList<>();
    ArrayList<String> prodotti= new ArrayList<>();
    ArrayList<BarEntry> barEntries = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semina);
        list=(ListView)findViewById(R.id.list);
        ArrayList<Prodotti_Semina_Table1> arrayList= new ArrayList<>();
        arrayList.add(new Prodotti_Semina_Table1("Pomodori","30%"));
        arrayList.add(new Prodotti_Semina_Table1("Fagioli","50%"));
        arrayList.add(new Prodotti_Semina_Table1("Patate","30%"));
        arrayList.add(new Prodotti_Semina_Table1("Zucchine","45%"));
        arrayList.add(new Prodotti_Semina_Table1("Lattuga","70%"));
        arrayList.add(new Prodotti_Semina_Table1("Ravanelli","50%"));
        arrayList.add(new Prodotti_Semina_Table1("Piselli","38%"));
        arrayList.add(new Prodotti_Semina_Table1("Finocchio","60%"));
        CustomAdapterSemina custom=new CustomAdapterSemina(this,arrayList);
        list.setAdapter(custom);
        barChart=(BarChart)findViewById(R.id.Datcam);

        fillProdotti();
        for(int i = 0; i< arrayProdottiGraficoSemina.size(); i++){
            String materia= arrayProdottiGraficoSemina.get(i).getProdotto();
            int percentuale= arrayProdottiGraficoSemina.get(i).getPercentuale();
            barEntries.add(new BarEntry(i, percentuale));
            prodotti.add(materia);
        }
        BarDataSet barDataSet= new BarDataSet(barEntries,"Materiali_Grafici_DatiCampo");
        BarData barData= new BarData(barDataSet);
        barChart.setData(barData);

        XAxis xAxis = barChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(prodotti));
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(prodotti.size());
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
    private void fillProdotti(){
        arrayProdottiGraficoSemina.clear();
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Pomodori",30));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Fagioli",50));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Patate",30));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Zucchine",45));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Lattuga",70));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Ravanelli",50));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Piselli",38));
        arrayProdottiGraficoSemina.add(new Prodotti_Grafico_Semina("Finocchio",60));
    }



    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

}
