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
import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.ExpenseRecyclerAdapter;
import com.example.moneymanagement.model.TransactionRecyclerAdapter;

import java.util.List;
import java.util.MissingFormatArgumentException;

public class TranExpenseFragment extends Fragment {

     private RecyclerView recyclerView;
     private  RecyclerView.LayoutManager layoutManager;

     TransactionRecyclerAdapter transactionRecyclerAdapter;
    Button btnToday, btnMonth,btnYear,btnWeek;


    public TranExpenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_tran_expense, container, false);
        recyclerView = view.findViewById(R.id.transExpense);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthExpense();
        transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
        recyclerView.setAdapter(transactionRecyclerAdapter);
        btnToday = view.findViewById(R.id.Today);
        btnMonth = view.findViewById(R.id.Month);
        btnWeek = view.findViewById(R.id.Week);
        btnYear = view.findViewById(R.id.Year);
        btnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                recyclerView = view.findViewById(R.id.transExpense);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getExpense();
                transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
                recyclerView.setAdapter(transactionRecyclerAdapter);
            }
        });
        btnMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                recyclerView = view.findViewById(R.id.transExpense);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthExpense();
                transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
                recyclerView.setAdapter(transactionRecyclerAdapter);
            }
        });
        btnWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view3) {
                recyclerView = view.findViewById(R.id.transExpense);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getWeekExpense();
                transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
                recyclerView.setAdapter(transactionRecyclerAdapter);
            }
        });
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view4) {
                recyclerView = view.findViewById(R.id.transExpense);
                layoutManager = new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(layoutManager);
                List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getYearExpense();
                transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
                recyclerView.setAdapter(transactionRecyclerAdapter);
            }
        });
        return view;
    }
}