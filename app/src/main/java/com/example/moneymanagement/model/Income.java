package com.example.moneymanagement.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Income {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "category")
    private String category;
    @ColumnInfo(name = "describe")
    private String describe;
    @ColumnInfo(name="date")
    private String date;
    @ColumnInfo(name="value")
    private Float value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}
