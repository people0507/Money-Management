package com.example.moneymanagement.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moneymanagement.MainActivity;
import com.example.moneymanagement.R;
import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.Income;
import com.example.moneymanagement.model.MoneyDao;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class IncomeFragment extends Fragment {

    private final int bg = 0xFFFFF6E5;


    MoneyDao dao = MainActivity.moneyDatabaseClass.moneyDao();
    public IncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_income, container, false);
        PieChart pieChart = (PieChart)view.findViewById(R.id.in_pie_chart);
        Button button1 = view.findViewById(R.id.ThreeMonthIC);
        Button button2 = view.findViewById(R.id.SixMonthIC);
        Button button3 = view.findViewById(R.id.NineMonthIC);
        Button button4 = view.findViewById(R.id.TwelveMonthIC);

        dao.get3MonthChartIncome().observe(this, new Observer<List<Income>>() {
            @Override
            public void onChanged(List<Income> list) {
                ArrayList<PieEntry> entries = new ArrayList<>();
                for(Income income:list){
                    entries.add(new PieEntry(income.getValue(),income.getCategory()));
                }
                PieDataSet dataSet = new PieDataSet(entries, "Categories");
                dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                dataSet.setValueTextColor(Color.BLACK);
                dataSet.setValueTextSize(16f);
                PieData data = new PieData(dataSet);
                pieChart.setData(data);
                pieChart.getDescription().setEnabled(false);
                pieChart.setHoleColor(bg);
                pieChart.animateY(2000);
                dao.getValueSum3MonthIC().observe(IncomeFragment.this,sum->pieChart.setCenterText(String.valueOf(sum)));
                pieChart.setCenterTextSize(40f);

            }
    });

        button1.setOnClickListener(view1 -> {
            dao.get3MonthChartIncome().observe(this, new Observer<List<Income>>() {
                @Override
                public void onChanged(List<Income> list) {
                    ArrayList<PieEntry> entries = new ArrayList<>();
                    for(Income income:list){
                        entries.add(new PieEntry(income.getValue(),income.getCategory()));
                    }
                    PieDataSet dataSet = new PieDataSet(entries, "Categories");
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    dataSet.setValueTextColor(Color.BLACK);
                    dataSet.setValueTextSize(16f);
                    PieData data = new PieData(dataSet);
                    pieChart.setData(data);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setHoleColor(bg);
                    pieChart.animateY(2000);
                    dao.getValueSum3MonthIC().observe(IncomeFragment.this,sum->pieChart.setCenterText(String.valueOf(sum)));
                }
            });
        });

        button2.setOnClickListener(view2 -> {
            dao.get6MonthChartIncome().observe(this, new Observer<List<Income>>() {
                @Override
                public void onChanged(List<Income> list) {
                    ArrayList<PieEntry> entries = new ArrayList<>();
                    for(Income income:list){
                        entries.add(new PieEntry(income.getValue(),income.getCategory()));
                    }
                    PieDataSet dataSet = new PieDataSet(entries, "Categories");
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    dataSet.setValueTextColor(Color.BLACK);
                    dataSet.setValueTextSize(16f);
                    PieData data = new PieData(dataSet);
                    pieChart.setData(data);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setHoleColor(bg);
                    pieChart.animateY(2000);
                    dao.getValueSum6MonthIC().observe(IncomeFragment.this,sum->pieChart.setCenterText(String.valueOf(sum)));
                }
            });
        });

        button3.setOnClickListener(view3 -> {
            dao.get9MonthChartIncome().observe(this, new Observer<List<Income>>() {
                @Override
                public void onChanged(List<Income> list) {
                    ArrayList<PieEntry> entries = new ArrayList<>();
                    for(Income income:list){
                        entries.add(new PieEntry(income.getValue(),income.getCategory()));
                    }
                    PieDataSet dataSet = new PieDataSet(entries, "Categories");
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    dataSet.setValueTextColor(Color.BLACK);
                    dataSet.setValueTextSize(16f);
                    PieData data = new PieData(dataSet);
                    pieChart.setData(data);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setHoleColor(bg);
                    pieChart.animateY(2000);
                    dao.getValueSum9MonthIC().observe(IncomeFragment.this,sum->pieChart.setCenterText(String.valueOf(sum)));
                }
            });
        });

        button4.setOnClickListener(view4 -> {
            dao.get12MonthChartIncome().observe(this, new Observer<List<Income>>() {
                @Override
                public void onChanged(List<Income> list) {
                    ArrayList<PieEntry> entries = new ArrayList<>();
                    for(Income income:list){
                        entries.add(new PieEntry(income.getValue(),income.getCategory()));
                    }
                    PieDataSet dataSet = new PieDataSet(entries, "Categories");
                    dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
                    dataSet.setValueTextColor(Color.BLACK);
                    dataSet.setValueTextSize(16f);
                    PieData data = new PieData(dataSet);
                    pieChart.setData(data);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setHoleColor(bg);
                    pieChart.animateY(2000);
                    dao.getValueSum12MonthIC().observe(IncomeFragment.this,sum->pieChart.setCenterText(String.valueOf(sum)));
                }
            });
        });


        return view;
    }
}