package com.example.moneymanagement.model2;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;

import com.example.moneymanagement.model2.User;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);
    @Query("SELECT * FROM User where email= :mail and password= :password")
    User getUser(String mail, String password);

}
