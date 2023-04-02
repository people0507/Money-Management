package com.example.moneymanagement.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanagement.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class IncomeFragment extends Fragment {



    private final int bg = 0xFFFFF6E5;


    public IncomeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        PieChart pieChart = (PieChart)view.findViewById(R.id.in_pie_chart);
        ArrayList<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(0.5f, "Shopping"));
        entries.add(new PieEntry(0.15f, "Subcription"));
        entries.add(new PieEntry(0.10f, "Food"));

        PieDataSet dataSet = new PieDataSet(entries, "Categories");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("9400.0");
        pieChart.setHoleColor(bg);
        pieChart.animateY(2000);
        return view;
    }
}