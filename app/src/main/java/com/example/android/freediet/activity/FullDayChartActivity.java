package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.freediet.R;
import com.example.android.freediet.application.ConnectivityReceiver;
import com.example.android.freediet.model.DaysResponseModel;

import java.util.ArrayList;

public class FullDayChartActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    TextView breakfast,lunch,snacks,dinner,midMorning;
    ArrayList<DaysResponseModel> models;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_day_chart);
        breakfast = findViewById(R.id.fullday_breakfast);
        lunch = findViewById(R.id.fullday_lunch);
        snacks = findViewById(R.id.fullday_snacks);
        dinner = findViewById(R.id.fullday_dinner);
        midMorning = findViewById(R.id.fullday_midMorning);
        getData();
    }

    public void getData()
    {
        bundle = getIntent().getExtras();
        models = (ArrayList<DaysResponseModel>) getIntent().getSerializableExtra("mylist");
        breakfast.setText(models.get(0).getBreakfast());
        lunch.setText(models.get(0).getLunch());
        snacks.setText(models.get(0).getEvening());
        dinner.setText(models.get(0).getDinner());
        midMorning.setText(models.get(0).getMidMorning());
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }
}
