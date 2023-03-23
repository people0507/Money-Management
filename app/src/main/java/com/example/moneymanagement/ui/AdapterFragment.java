package com.example.moneymanagement.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class AdapterFragment extends FragmentStateAdapter {
    public AdapterFragment(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0 :return new ExpenseFragment();
            case 1 : return new IncomeFragment();
        }
        return new ExpenseFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
