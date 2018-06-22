package com.example.android.freediet.activity;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.DaysDataAdapter;
import com.example.android.freediet.application.ConnectivityReceiver;
import com.example.android.freediet.application.MyApplication;
import com.example.android.freediet.model.DaysData;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

public class DaysActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

//    private static final String TAG = "DaysActivity";
//    private static final int NUM_COL = 2;
//    private static final int NUM_ROWS = 15;
RecyclerView recyclerView;
    List<DaysData> dayData;

    public int diet_Category ;
    public int day_id;

    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<DaysResponseModel> mylist = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        diet_Category = getIntent().getIntExtra("key",0);
        day_id = getIntent().getIntExtra("dayId",1);

        dayData = fill_with_data();
        recyclerView = findViewById(R.id.recyclerview);
        DaysDataAdapter adapter = new DaysDataAdapter(dayData, DaysActivity.this,diet_Category);
        recyclerView.setAdapter(adapter);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
    }

    public List<DaysData> fill_with_data() {
        List<DaysData> data = new ArrayList<>();
        for(int i=1;i<=30;i++) {
            data.add(new DaysData("Day "+i,i));
        }
        return data;
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
