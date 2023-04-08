package com.example.moneymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.moneymanagement.model.MoneyDatabaseClass;

public class MainActivity extends AppCompatActivity {
    public static MoneyDatabaseClass moneyDatabaseClass;

    Button btnCon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnCon = findViewById(R.id.btnCon);

        moneyDatabaseClass = Room.databaseBuilder(getApplicationContext(),MoneyDatabaseClass.class,"moneyDb2").allowMainThreadQueries().build();
        btnCon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
            }
        });
    }
}