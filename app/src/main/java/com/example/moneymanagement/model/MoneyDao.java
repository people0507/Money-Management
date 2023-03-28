package com.example.moneymanagement.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MoneyDao {
   @Insert
    public void addIncome(Income income);
   @Insert
    public  void addExpense(Expense expense);
   @Query("select * from Income  where date=DATE('now') limit 2")
   public List<Income>getIncome();
   @Query("select * from Expense  where date=DATE('now') limit 2")
    public List<Expense>getExpense();
   @Query("SELECT * FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now')")
    public List<Expense>getYearExpense();
    @Query("SELECT * FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now')")
    public List<Income>getYearIncome();
    @Query("SELECT * FROM Expense WHERE strftime('%m', date) = strftime('%m', 'now')")
    public List<Expense>getMonthExpense();
    @Query("SELECT * FROM Income WHERE strftime('%m', date) = strftime('%m', 'now')")
    public List<Income>getMonthIncome();
    @Query("SELECT * FROM Expense WHERE strftime('%W', date) = strftime('%W', 'now')")
    public List<Expense>getWeekExpense();
    @Query("SELECT * FROM Income WHERE strftime('%W', date) = strftime('%W', 'now')")
    public List<Income>getWeekIncome();
}
