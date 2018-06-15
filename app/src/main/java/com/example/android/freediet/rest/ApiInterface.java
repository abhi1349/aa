package com.example.android.freediet.rest;

import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.DietResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/Diet/dietCategory")
    Call<List<DietResponseModel>> getDiet();

    @GET("api/Diet/getDiet")
    Call<List<DaysResponseModel>> getDays();
}
