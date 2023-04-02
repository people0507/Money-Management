package com.example.moneymanagement.ui;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanagement.MainActivity;
import com.example.moneymanagement.R;
import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.MoneyDao;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class ExpenseFragment extends Fragment {

    private final int bg = 0xFFFFF6E5;
    MoneyDao dao = MainActivity.moneyDatabaseClass.moneyDao();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expense, container, false);
        PieChart pieChart = (PieChart)view.findViewById(R.id.ex_pie_chart);


        dao.getChartExpense().observe(this, new Observer<List<Expense>>() {
            @Override
            public void onChanged(List<Expense> list) {
                ArrayList<PieEntry> entries = new ArrayList<>();
                for(Expense expense:list){
                    entries.add(new PieEntry(expense.getValue(),expense.getCategory()));
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

            }
        });
        dao.getValueSum().observe(this,sum->pieChart.setCenterText(String.valueOf(sum)));
        return view;
    }
}