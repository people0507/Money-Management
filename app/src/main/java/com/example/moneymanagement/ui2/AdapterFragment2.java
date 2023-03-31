package com.example.moneymanagement.ui2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.moneymanagement.ui.IncomeFragment;
import com.example.moneymanagement.ui1.MonthFragment;
import com.example.moneymanagement.ui1.TodayFragment;
import com.example.moneymanagement.ui1.WeekFragment;
import com.example.moneymanagement.ui1.YearFragment;

public class AdapterFragment2 extends FragmentStateAdapter {
    public AdapterFragment2(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :return new TranExpenseFragment();
            case 1 : return new TranIncomeFragment();
        }
        return new TranExpenseFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
