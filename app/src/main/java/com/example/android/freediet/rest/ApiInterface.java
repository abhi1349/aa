package com.example.android.freediet.rest;

import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.DietResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/Diet/dietCategory")
    Call<List<DietResponseModel>> getDiet();

    @GET("api/Diet/getDiet")
    Call<List<DaysResponseModel>> getDays(@Query("prakriti") int prakriti,
                                          @Query("preference")int preference,
                                          @Query("day")int day,
                                          @Query("dietCategory")int dietCategory);
}
