package com.example.sampletask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pieChart = findViewById(R.id.piechart);
        /*Pie Chart*/
        setPieChart();
    }

    private void setPieChart() {
        this.pieChart = pieChart;
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.9f);
        pieChart.setTransparentCircleRadius(2f);
        pieChart.setHoleColor(Color.BLACK);

        pieChart.setHoleRadius(80f);
        pieChart.setCenterText("2.1");
        pieChart.setCenterTextColor(Color.WHITE);
        pieChart.setCenterTextSize(20f);
        pieChart.getDescription().setTextAlign(Paint.Align.CENTER);

        /*If You need any text just add the text in the Empty String
        and you must enable the legend to show the text*/
        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(05f, ""));
        yValues.add(new PieEntry(10f, ""));
        yValues.add(new PieEntry(15f, ""));
        yValues.add(new PieEntry(20f, ""));

        /*Legend can be disabled using these Methods*/
        pieChart.getLegend().setEnabled(false);

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(0f);
        dataSet.setSelectionShift(5f);
        dataSet.setDrawValues(false);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData pieData = new PieData((dataSet));
        pieData.setValueTextSize(10f);
        pieData.setValueTextColor(Color.RED);
        pieChart.setData(pieData);
    }
}
