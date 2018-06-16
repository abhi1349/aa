package com.example.android.freediet.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
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
    List<DietResponseModel> dietList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        setTitle("Free Diet");
        recyclerView = findViewById(R.id.card_view_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        getData();
    }

    private void getData() {
        Call<List<DietResponseModel>> call = apiService.getDiet();
        call.enqueue(new Callback<List<DietResponseModel>>() {
            @Override
            public void onResponse(Call<List<DietResponseModel>> call, Response<List<DietResponseModel>> response) {
                dietList = response.body();

                dietDataAdapter = new DietDataAdapter(DietActivity.this, dietList);
                recyclerView.setAdapter(dietDataAdapter);

            }

            @Override
            public void onFailure(Call<List<DietResponseModel>> call, Throwable t) {
                Toast.makeText(DietActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class CustomCallBack<T> implements Callback<T> {

        private ProgressDialog mProgressDialog;
        Context context;

        CustomCallBack(Context context) {
            this.context = context;
            mProgressDialog = new ProgressDialog(context);
            ((Activity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.show();

        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        }
    }
}