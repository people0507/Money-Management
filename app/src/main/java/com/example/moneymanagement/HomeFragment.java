package com.example.moneymanagement;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moneymanagement.model.ExpenseRecyclerAdapter;
import com.example.moneymanagement.model.MoneyDao;
import com.example.moneymanagement.model2.User;
import com.example.moneymanagement.ui1.AdapterFragment1;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    AdapterFragment1 adapterFragment1;

    TextView dmy,logoname;
    private User user;
    MoneyDao dao = MainActivity.moneyDatabaseClass.moneyDao();


    public HomeFragment() {
        // Required empty public constructor
    }
    


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM YYYY");
        String currentDate = sdf.format(calendar.getTime()).toUpperCase();
        dmy = view.findViewById(R.id.dmy);
        dmy.setText(currentDate);


        logoname = view.findViewById(R.id.logo_name_home);
        String userName = getArguments().getString("user_name");
        if(userName != null){
            logoname.setText(userName.toUpperCase());
        } else {
            logoname.setText("Emty");
        }

        dao.getValueSum().observe(this,sum->{
            TextView textView = view.findViewById(R.id.sumExpense);
            textView.setText(String.valueOf(sum));
        });
        dao.getValueIncomeSum().observe(this,sum->{
            TextView textView = view.findViewById(R.id.incomeSum);
            textView.setText(String.valueOf(sum));
        });
        dao.getIncomeMinusExpense().observe(this,sum->{
            TextView textView = view.findViewById(R.id.accBalans);
            textView.setText(String.valueOf(sum));
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tab_layout1);
        viewPager2 = view.findViewById(R.id.view_pager1);
        adapterFragment1 = new AdapterFragment1(this);
        viewPager2.setAdapter(adapterFragment1);
        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    tab.setText("Today");
                }
                else if (position == 1){
                    tab.setText("Week");
                }
                else if (position == 2){
                    tab.setText("Month");
                }
                else if (position == 3){
                    tab.setText("Year");
                }
            }
        });
        tabLayoutMediator.attach();
    }
}