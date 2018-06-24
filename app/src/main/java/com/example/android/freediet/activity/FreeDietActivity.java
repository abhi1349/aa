package com.example.android.freediet.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.freediet.R;
import com.example.android.freediet.adapter.FreeDietAdapter;
import com.example.android.freediet.application.ConnectivityReceiver;
import com.example.android.freediet.application.MyApplication;
import com.example.android.freediet.model.FreeDietResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FreeDietActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    FreeDietAdapter dietDataAdapter;
    RecyclerView recyclerView;
//    AlertDialog.Builder alertDialogBuilder;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    List<FreeDietResponseModel> dietList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet_free);
        setTitle("Free Diet");

        recyclerView = findViewById(R.id.card_view_recycler_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    private void getData() {
        Call<List<FreeDietResponseModel>> call = apiService.getDiet();
        call.enqueue(new Callback<List<FreeDietResponseModel>>() {
            @Override
            public void onResponse(Call<List<FreeDietResponseModel>> call, Response<List<FreeDietResponseModel>> response) {
                dietList = response.body();
                dietDataAdapter = new FreeDietAdapter(FreeDietActivity.this, dietList);
                recyclerView.setAdapter(dietDataAdapter);
            }

            @Override
            public void onFailure(Call<List<FreeDietResponseModel>> call, Throwable t) {

                Toast.makeText(FreeDietActivity.this, "No Internet Connection, Please check your internet settings", Toast.LENGTH_SHORT).show();
//                alertDialogBuilder = new AlertDialog.Builder(FreeDietActivity.this);
//                alertDialogBuilder.setTitle("Warning...");
//                alertDialogBuilder.setIcon(R.drawable.warning);
//                alertDialogBuilder.setMessage("No Internet, Check your connection and try again.");
//                alertDialogBuilder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FreeDietActivity.this, "try again", Toast.LENGTH_SHORT).show();
//                        Intent in = new Intent(android.provider.Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
//                        startActivity(in);
//
//                    }
//                });
//                alertDialogBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        Toast.makeText(FreeDietActivity.this, "Cancle", Toast.LENGTH_SHORT).show();
//                        AlertDialog alertDialog = alertDialogBuilder.create();
//                        alertDialog.dismiss();
//                    }
//                });
//                AlertDialog alertDialog = alertDialogBuilder.create();
//      //          alertDialog.show();
            }
        });
    }


    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showSnack(isConnected);
    }

    private void showSnack(boolean isConnected) {
        String message;
        int color;
        if (isConnected) {
            message = "Good! Connected to Internet";
            color = Color.WHITE;
        } else {
            message = "Sorry! Not connected to internet";
            color = Color.RED;
        }

        Snackbar snackbar = Snackbar
                .make(recyclerView, message, Snackbar.LENGTH_LONG);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(color);
        snackbar.show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // register connection status listener
        MyApplication.getInstance().setConnectivityListener(this);
    }
}