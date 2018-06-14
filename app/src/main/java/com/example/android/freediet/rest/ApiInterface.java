package com.example.android.freediet.rest;

import com.example.android.freediet.model.FreeDietModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface ApiInterface {

    @GET("")
    Call<FreeDietModel> t( String token);
}
