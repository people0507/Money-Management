package com.example.moneymanagement.ui2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        return view;
    }
}