package com.example.android.freediet.rest;

import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.DietResponseModel;
import com.example.android.freediet.model.PaidDaysResponseModel;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("api/Diet/dietCategory")
    Call<List<DietResponseModel>> getDiet();

    @GET("api/Diet/getDiet")
    Call<ArrayList<DaysResponseModel>> getDays(@Query("prakriti") int prakriti,
                                                    @Query("preference")int preference,
                                                    @Query("day")int day,
                                                    @Query("dietCategory")int dietCategory);

    @GET("api/getDiets")
    Call<ArrayList<PaidDaysResponseModel>> getPaidDays(@Query("email") String email);
}
