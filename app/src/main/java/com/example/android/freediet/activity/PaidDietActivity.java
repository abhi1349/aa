package com.example.android.freediet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.model.DietResponseModel;
import com.example.android.freediet.model.PaidDaysData;
import com.example.android.freediet.model.PaidDaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaidDietActivity extends AppCompatActivity {

    ImageView imageView;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<PaidDaysResponseModel> paidDaysList;
    public String emailId="jaiiitg16@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_diet);
        imageView = findViewById(R.id.paidDiet_HeaderImg);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDaysData();
            }
        });
    }

    private void getDaysData() {
        Call<ArrayList<PaidDaysResponseModel>> call = apiService.getPaidDays(emailId);
        call.enqueue(new Callback<ArrayList<PaidDaysResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PaidDaysResponseModel>> call, Response<ArrayList<PaidDaysResponseModel>> response) {
                if(response.isSuccessful()) {
                    paidDaysList = response.body();
                Intent intent = new Intent(PaidDietActivity.this, PaidDaysActivity.class);
                intent.putExtra("paidDaysList", paidDaysList);
                startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PaidDaysResponseModel>> call, Throwable t) {
                Toast.makeText(PaidDietActivity.this, "Network Failure, Try again", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
