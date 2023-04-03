package com.example.moneymanagement;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moneymanagement.model.Expense;
import com.example.moneymanagement.model.Income;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AddFragment extends Fragment {

    private EditText inputCategory, inputDescribe, inputDate,inputValue;
    private Button btnIncome, btnExpense;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = sdf.format(calendar.getTime());
        inputCategory = view.findViewById(R.id.category);
        inputDescribe = view.findViewById(R.id.describe);
        inputDate = view.findViewById(R.id.date);
        inputDate.setText(currentDate);
        inputValue = view.findViewById(R.id.value);
        btnIncome = view.findViewById(R.id.income);
        btnExpense = view.findViewById(R.id.expense);
        btnIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputValue.getText().toString().isEmpty() || inputCategory.getText().toString().isEmpty() || inputDescribe.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "You haven't typed anything", Toast.LENGTH_SHORT).show();
                }
                else {
                    String category = inputCategory.getText().toString();
                    String describe = inputDescribe.getText().toString();
                    String date = inputDate.getText().toString();
                    Float value = Float.parseFloat(inputValue.getText().toString());
                    Income income = new Income();
                    income.setCategory(category);
                    income.setDescribe(describe);
                    income.setValue(value);
                    income.setDate(date);
                    MainActivity.moneyDatabaseClass.moneyDao().addIncome(income);
                    Toast.makeText(getActivity(), "Add Data Successfully", Toast.LENGTH_SHORT).show();
                    inputCategory.setText("");
                    inputDescribe.setText("");
                    inputValue.setText("");
                }
            }
        });
        btnExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputValue.getText().toString().isEmpty() || inputCategory.getText().toString().isEmpty() || inputDescribe.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "You haven't typed anything", Toast.LENGTH_SHORT).show();
                }
                else {
                    String category = inputCategory.getText().toString();
                    String describe = inputDescribe.getText().toString();
                    String date = inputDate.getText().toString();
                    Float value = Float.parseFloat(inputValue.getText().toString());
                    Expense expense = new Expense();
                    expense.setCategory(category);
                    expense.setDescribe(describe);
                    expense.setValue(value);
                    expense.setDate(date);
                    MainActivity.moneyDatabaseClass.moneyDao().addExpense(expense);
                    Toast.makeText(getActivity(), "Add Data Successfully", Toast.LENGTH_SHORT).show();
                    inputCategory.setText("");
                    inputDescribe.setText("");
                    inputValue.setText("");
                }

            }
        });
        return view;
    }
}