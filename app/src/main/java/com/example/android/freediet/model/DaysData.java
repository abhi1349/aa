package com.example.android.freediet.model;

public class DaysData {
    private String btname;
    private int btnId;

    public DaysData(String name, int btnId) {
        btname = name;
        this.btnId = btnId;
    }

    public String getBtname() {
        return btname;
    }

    public int getBtnId() {
        return btnId;
    }
}