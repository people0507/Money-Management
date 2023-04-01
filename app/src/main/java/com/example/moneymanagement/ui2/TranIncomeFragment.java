package com.example.moneymanagement.ui2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.moneymanagement.MainActivity;
import com.example.moneymanagement.R;
import com.example.moneymanagement.model.Income;
import com.example.moneymanagement.model.TransIncomeRecyclerAdapter;
import com.example.moneymanagement.model.TransactionRecyclerAdapter;

import java.util.List;


public class TranIncomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    TransIncomeRecyclerAdapter transIncomeRecyclerAdapter;
    Button btnToday, btnMonth,btnYear,btnWeek;


    public TranIncomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tran_income, container, false);
        recyclerView = view.findViewById(R.id.transIncome);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthIncome();
        transIncomeRecyclerAdapter = new TransIncomeRecyclerAdapter(list);
        recyclerView.setAdapter(transIncomeRecyclerAdapter);
        btnToday = view.findViewById(R.id.Today);
        btnMonth = view.findViewById(R.id.Month);
        btnWeek = view.findViewById(R.id.Week);
        btnYear = view.findViewById(R.id.Year);

        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView = view.findViewById(R.id.transIncome);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getIncome();
                transIncomeRecyclerAdapter = new TransIncomeRecyclerAdapter(list);
                recyclerView.setAdapter(transIncomeRecyclerAdapter);
            }
        });
        btnMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                recyclerView = view.findViewById(R.id.transIncome);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthIncome();
                transIncomeRecyclerAdapter = new TransIncomeRecyclerAdapter(list);
                recyclerView.setAdapter(transIncomeRecyclerAdapter);
            }
        });
        btnWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                recyclerView = view.findViewById(R.id.transIncome);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getWeekIncome();
                transIncomeRecyclerAdapter = new TransIncomeRecyclerAdapter(list);
                recyclerView.setAdapter(transIncomeRecyclerAdapter);
            }
        });
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                recyclerView = view.findViewById(R.id.transIncome);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getYearIncome();
                transIncomeRecyclerAdapter = new TransIncomeRecyclerAdapter(list);
                recyclerView.setAdapter(transIncomeRecyclerAdapter);
            }
        });
        return view;
    }
}