package com.example.moneymanagement.model;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface MoneyDao {
   @Insert
    public void addIncome(Income income);
   @Insert
    public  void addExpense(Expense expense);
}
