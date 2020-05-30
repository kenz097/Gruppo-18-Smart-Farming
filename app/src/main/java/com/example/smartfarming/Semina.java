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
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Semina extends AppCompatActivity {
    private ListView list;
    BarChart barChart;


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
        CustomAdapterSemina custom=new CustomAdapterSemina(this,arrayList);
        list.setAdapter(custom);


        barChart=(BarChart)findViewById(R.id.Datcam);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(10, 30f));
        barEntries.add(new BarEntry(20, 50f));
        barEntries.add(new BarEntry(30, 30f));
        barEntries.add(new BarEntry(40, 45f));
        barEntries.add(new BarEntry(50, 70f));
        BarDataSet barDataSet1= new BarDataSet(barEntries,"Prodotti");


        BarData theData = new BarData(barDataSet1);
        theData.setBarWidth(9f);
        barDataSet1.setValueTextColor(Color.BLACK);

        barDataSet1.setValueTextSize(10f);
        barDataSet1.setColors(ColorTemplate.MATERIAL_COLORS);
        barChart.setDrawGridBackground(false);
        barChart.setDrawValueAboveBar(true);
        barChart.setData(theData);
        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.getDescription().setText("Prodotti consigliati per la semina");
        barChart.animateY(2000);

        String[] materiali= new String[] {"Pomodori","Fagioli","Patate","Zucchine","Lattuga"};
        XAxis xAxis= barChart.getXAxis();
        xAxis.setValueFormatter(new MyXAxisValueFormatter(materiali));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setCenterAxisLabels(true);
        xAxis.setAxisMinimum(1);
    }
    public class MyXAxisValueFormatter extends ValueFormatter {
        private String[] mValues;
        public MyXAxisValueFormatter(String[] values){
            this.mValues=values;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, Homepage.class);
        startActivity(intent);
    }

}
