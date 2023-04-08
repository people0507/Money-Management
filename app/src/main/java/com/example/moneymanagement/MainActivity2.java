package com.example.moneymanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.moneymanagement.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("user_name");
        Bundle bundle = new Bundle();
        bundle.putString("user_name", userName);



        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());
        binding.navView.setOnItemSelectedListener(item ->
        {
            switch (item.getItemId()){
                case R.id.home_icon:
                    HomeFragment homeFragment = new HomeFragment();
                    homeFragment.setArguments(bundle);
                    replaceFragment(homeFragment);
                    break;
                case R.id.tran_icon:
                    replaceFragment(new TransactionFragment());
                    break;
                case R.id.add_icon:
                    replaceFragment(new AddFragment());
                    break;
                case R.id.sta_icon:
                    replaceFragment(new StatiticsFragment());
                    break;
                case R.id.pro_icon:
                    ProfileFragment profileFragment =new ProfileFragment();
                    profileFragment.setArguments(bundle);
                    replaceFragment(new ProfileFragment());
                    break;

            }
            return true;
        });

    }


    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Truyền bundle từ Activity sang Fragment
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            fragment.setArguments(bundle);
        }

        fragmentTransaction.replace(R.id.nav_flayout,fragment);
        fragmentTransaction.commit();
    }

}