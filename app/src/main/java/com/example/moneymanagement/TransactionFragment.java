package com.example.moneymanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.TransactionRecyclerAdapter;

import java.util.List;


public class TransactionFragment extends Fragment {

   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   TransactionRecyclerAdapter transactionRecyclerAdapter;

    public TransactionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        recyclerView = view.findViewById(R.id.transactionRecycler);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Expense> list = MainActivity.moneyDatabaseClass.moneyDao().getMonthExpense();
        transactionRecyclerAdapter = new TransactionRecyclerAdapter(list);
        recyclerView.setAdapter(transactionRecyclerAdapter);
        return view;
    }
}