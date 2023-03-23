package com.example.moneymanagement.ui1;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanagement.ui.ExpenseFragment;
import com.example.moneymanagement.ui.IncomeFragment;

public class AdapterFragment1 extends FragmentStateAdapter {
    public AdapterFragment1(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :return new TodayFragment();
            case 1 : return new WeekFragment();
            case 2 : return new MonthFragment();
            case 3 : return new YearFragment();
        }
        return new ExpenseFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
