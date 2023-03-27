package com.example.moneymanagement.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Income.class,Expense.class},version = 2)
public abstract class MoneyDatabaseClass extends RoomDatabase {
    public abstract MoneyDao moneyDao();
}
