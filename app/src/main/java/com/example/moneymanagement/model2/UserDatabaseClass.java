package com.example.moneymanagement.model2;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.moneymanagement.model2.User;

@Database(entities = {User.class},version = 2)
public abstract class UserDatabaseClass extends RoomDatabase {
    public abstract UserDao getUserDao();
}
