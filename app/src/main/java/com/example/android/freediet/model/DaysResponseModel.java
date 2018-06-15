package com.example.android.freediet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DaysResponseModel {
//    public DaysResponseModel(Integer id, Integer dietCategoryId, Integer days, String breakfast, String midMorning, String lunch, String evening, String dinner, Object herbs, String prakritiId, Integer veg, Integer nonVeg, Integer egg, String createdAt, String updatedAt) {
//        this.id = id;
//        this.dietCategoryId = dietCategoryId;
//        this.days = days;
//        this.breakfast = breakfast;
//        this.midMorning = midMorning;
//        this.lunch = lunch;
//        this.evening = evening;
//        this.dinner = dinner;
//        this.herbs = herbs;
//        this.prakritiId = prakritiId;
//        this.veg = veg;
//        this.nonVeg = nonVeg;
//        this.egg = egg;
//        this.createdAt = createdAt;
//        this.updatedAt = updatedAt;
//    }

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("diet_category_id")
    @Expose
    private Integer dietCategoryId;
    @SerializedName("days")
    @Expose
    private Integer days;
    @SerializedName("breakfast")
    @Expose
    private String breakfast;
    @SerializedName("midMorning")
    @Expose
    private String midMorning;
    @SerializedName("lunch")
    @Expose
    private String lunch;
    @SerializedName("evening")
    @Expose
    private String evening;
    @SerializedName("dinner")
    @Expose
    private String dinner;
    @SerializedName("herbs")
    @Expose
    private Object herbs;
    @SerializedName("Prakriti_id")
    @Expose
    private String prakritiId;
    @SerializedName("veg")
    @Expose
    private Integer veg;
    @SerializedName("non-veg")
    @Expose
    private Integer nonVeg;
    @SerializedName("egg")
    @Expose
    private Integer egg;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDietCategoryId() {
        return dietCategoryId;
    }

    public void setDietCategoryId(Integer dietCategoryId) {
        this.dietCategoryId = dietCategoryId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getMidMorning() {
        return midMorning;
    }

    public void setMidMorning(String midMorning) {
        this.midMorning = midMorning;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Object getHerbs() {
        return herbs;
    }

    public void setHerbs(Object herbs) {
        this.herbs = herbs;
    }

    public String getPrakritiId() {
        return prakritiId;
    }

    public void setPrakritiId(String prakritiId) {
        this.prakritiId = prakritiId;
    }

    public Integer getVeg() {
        return veg;
    }

    public void setVeg(Integer veg) {
        this.veg = veg;
    }

    public Integer getNonVeg() {
        return nonVeg;
    }

    public void setNonVeg(Integer nonVeg) {
        this.nonVeg = nonVeg;
    }

    public Integer getEgg() {
        return egg;
    }

    public void setEgg(Integer egg) {
        this.egg = egg;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}