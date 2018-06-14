package com.example.android.freediet.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.DietDataAdapter;
import com.example.android.freediet.model.DietResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DietActivity extends AppCompatActivity {

    DietDataAdapter dietDataAdapter;
    RecyclerView recyclerView;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<DietResponseModel> dietList =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        setTitle("Free Diet");
        getData();


        recyclerView = findViewById(R.id.card_view_recycler_list);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        dietDataAdapter = new DietDataAdapter(this,dietList);
        recyclerView.setAdapter(dietDataAdapter);



    }

    private void getData()
    {
        Call<List<DietResponseModel>> call = apiService.getDiet();
        call.enqueue(new Callback<List<DietResponseModel>>() {
            @Override
            public void onResponse(Call<List<DietResponseModel>> call, Response<List<DietResponseModel>> response) {




                Toast.makeText(DietActivity.this, "success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<DietResponseModel>> call, Throwable t) {
                Toast.makeText(DietActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}