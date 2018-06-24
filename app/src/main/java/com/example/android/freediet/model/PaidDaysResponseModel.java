package com.example.android.freediet.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class PaidDaysResponseModel implements Serializable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("date_assign")
    @Expose
    private String dateAssign;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("early_morning")
    @Expose
    private Object earlyMorning;
    @SerializedName("breakfast")
    @Expose
    private String breakfast;
    @SerializedName("mid_morning")
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
    @SerializedName("post_dinner")
    @Expose
    private Object postDinner;
    @SerializedName("herbs")
    @Expose
    private String herbs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(String dateAssign) {
        this.dateAssign = dateAssign;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getEarlyMorning() {
        return earlyMorning;
    }

    public void setEarlyMorning(Object earlyMorning) {
        this.earlyMorning = earlyMorning;
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

    public Object getPostDinner() {
        return postDinner;
    }

    public void setPostDinner(Object postDinner) {
        this.postDinner = postDinner;
    }

    public String getHerbs() {
        return herbs;
    }

    public void setHerbs(String herbs) {
        this.herbs = herbs;
    }

}
