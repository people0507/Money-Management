package com.example.moneymanagement.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.math.BigDecimal;
import java.util.List;

@Dao
public interface MoneyDao {
   @Insert
    public void addIncome(Income income);
   @Insert
    public  void addExpense(Expense expense);
   @Query("select * from Income  where date=DATE('now')")
   public List<Income>getIncome();
   @Query("select * from Expense  where date=DATE('now') ")
    public List<Expense>getExpense();
   @Query("SELECT * FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now') ")
    public List<Expense>getYearExpense();
    @Query("SELECT * FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now') ")
    public List<Income>getYearIncome();
    @Query("SELECT * FROM Expense WHERE strftime('%m', date) = strftime('%m', 'now') ")
    public List<Expense>getMonthExpense();
    @Query("SELECT * FROM Income WHERE strftime('%m', date) = strftime('%m', 'now') ")
    public List<Income>getMonthIncome();
    @Query("SELECT * FROM Expense WHERE strftime('%W', date) = strftime('%W', 'now') ")
    public List<Expense>getWeekExpense();
    @Query("SELECT * FROM Income WHERE strftime('%W', date) = strftime('%W', 'now')")
    public List<Income>getWeekIncome();
   @Query("Select SUM(value) from Expense")
   LiveData<Integer> getValueSum();
    @Query("Select SUM(value) from Income")
    LiveData<Integer> getValueIncomeSum();
    @Query("SELECT (SELECT SUM(value) FROM Income) - (SELECT SUM(value) FROM Expense) AS value")
    LiveData<Integer> getIncomeMinusExpense();

    @Query("SELECT SUM(value)  FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '03'")
    LiveData<Integer> getValueSum3MonthIC();
    @Query("SELECT SUM(value)  FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '03'")
    LiveData<Integer> getValueSum3MonthEX();

    @Query("SELECT SUM(value)  FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '06'")
    LiveData<Integer> getValueSum6MonthIC();
    @Query("SELECT SUM(value)  FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '06'")
    LiveData<Integer> getValueSum6MonthEX();

    @Query("SELECT SUM(value)  FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '09'")
    LiveData<Integer> getValueSum9MonthIC();

    @Query("SELECT SUM(value)  FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '09'")
    LiveData<Integer> getValueSum9MonthEX();

     @Query("SELECT SUM(value)  FROM Income WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '12'")
     LiveData<Integer> getValueSum12MonthIC();
     @Query("SELECT SUM(value)  FROM Expense WHERE strftime('%Y', date) = strftime('%Y', 'now')  AND strftime('%m', date) BETWEEN '01' AND '12'")
     LiveData<Integer> getValueSum12MonthEX();

    @Query("SELECT * FROM Expense " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '03'")
    LiveData<List<Expense>> get3MonthChartExpense();
    @Query("SELECT * FROM Income " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '03'")
    LiveData<List<Income>> get3MonthChartIncome();
    @Query("SELECT * FROM Expense " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '06'")
    public LiveData<List<Expense>>get6MonthChartExpense();
    @Query("SELECT * FROM Income " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '06'")
    public LiveData<List<Income>>get6MonthChartIncome();
    @Query("SELECT * FROM Expense " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '09'")
    public LiveData<List<Expense>>get9MonthChartExpense();
    @Query("SELECT * FROM Income " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '09' ")
    public LiveData<List<Income>>get9MonthChartIncome();
    @Query("SELECT * FROM Expense " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '12'")
    public LiveData<List<Expense>>get12MonthChartExpense();
    @Query("SELECT * FROM Income " + "WHERE strftime('%Y', date) = strftime('%Y', 'now') " + "AND strftime('%m', date) BETWEEN '01' AND '12'")
    public LiveData<List<Income>>get12MonthChartIncome();
}
