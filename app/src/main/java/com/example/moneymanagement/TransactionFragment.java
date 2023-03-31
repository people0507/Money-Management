package com.example.moneymanagement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.TransactionRecyclerAdapter;
import com.example.moneymanagement.ui2.AdapterFragment2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;


public class TransactionFragment extends Fragment {

   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   TransactionRecyclerAdapter transactionRecyclerAdapter;

   TabLayout tabLayout;
   ViewPager2 viewPager2;
   AdapterFragment2 adapterFragment2;

    public TransactionFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout_tran);
        viewPager2 = view.findViewById(R.id.view_pager_tran);
        adapterFragment2 = new AdapterFragment2(this);
        viewPager2.setAdapter(adapterFragment2);
        TabLayoutMediator tabLayoutMediator =  new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position==0){
                    tab.setText("Expense");
                }
                else if (position == 1){
                    tab.setText("Income");
                }
            }
        });
        tabLayoutMediator.attach();
    }
}