package com.example.android.freediet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DietResponseModel {

    @SerializedName("id")
    private int dietImageId;

    @SerializedName("url")
    private String dietImageUrl;


    public int getDietImageId() {
        return dietImageId;
    }

    public void setDietImageId(int dietImageId) {
        this.dietImageId = dietImageId;
    }

    public String getDietImageUrl() {
        return dietImageUrl;
    }

    public void setDietImageUrl(String dietImageUrl) {
        this.dietImageUrl = dietImageUrl;
    }
}