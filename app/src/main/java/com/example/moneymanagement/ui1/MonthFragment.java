package com.example.moneymanagement.ui1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanagement.MainActivity;
import com.example.moneymanagement.R;
import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.ExpenseRecyclerAdapter;
import com.example.moneymanagement.model.Income;
import com.example.moneymanagement.model.IncomeRecyclerAdapter;

import java.util.List;


public class MonthFragment extends Fragment {

    private RecyclerView recyclerView,recyclerView2;
    private RecyclerView.LayoutManager layoutManager,layoutManager2;
    IncomeRecyclerAdapter incomeRecyclerAdapter;
    ExpenseRecyclerAdapter expenseRecyclerAdapter;
    public MonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_today, container, false);
        recyclerView = view.findViewById(R.id.incomeRecycleView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Income> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthIncome();
        incomeRecyclerAdapter = new IncomeRecyclerAdapter(list);
        recyclerView.setAdapter(incomeRecyclerAdapter);


        recyclerView2 = view.findViewById(R.id.expenseRecycleView);
        layoutManager2 = new LinearLayoutManager((getActivity()));
        recyclerView2.setLayoutManager(layoutManager2);
        List<Expense> list1 = MainActivity.moneyDatabaseClass.moneyDao().getMonthExpense();
        expenseRecyclerAdapter =new ExpenseRecyclerAdapter(list1);
        recyclerView2.setAdapter(expenseRecyclerAdapter);

        return view;
    }
}