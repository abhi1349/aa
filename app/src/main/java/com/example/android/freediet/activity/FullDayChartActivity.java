package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.application.ConnectivityReceiver;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.PaidDaysResponseModel;

import java.util.ArrayList;

public class FullDayChartActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener{

    TextView breakfast,lunch,snacks,dinner,midMorning;
    ArrayList<DaysResponseModel> freeDietData;
    ArrayList<PaidDaysResponseModel> paidDietData;
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
       int a = getIntent().getIntExtra("aaa",0);
       if(a==1)
       {
         //  getPaidDietData();
           Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();
       }else
       {
           getFreeDietData();
       }
    }

    public void getFreeDietData()
    {
        bundle = getIntent().getExtras();
        freeDietData = (ArrayList<DaysResponseModel>) getIntent().getSerializableExtra("freeDietData");
        breakfast.setText(freeDietData.get(0).getBreakfast());
        lunch.setText(freeDietData.get(0).getLunch());
        snacks.setText(freeDietData.get(0).getEvening());
        dinner.setText(freeDietData.get(0).getDinner());
        midMorning.setText(freeDietData.get(0).getMidMorning());
    }
    public void getPaidDietData()
    {
        bundle = getIntent().getExtras();
        paidDietData = (ArrayList<PaidDaysResponseModel>) getIntent().getSerializableExtra("paidDietData");
        breakfast.setText(paidDietData.get(0).getBreakfast());
        lunch.setText(paidDietData.get(0).getLunch());
        snacks.setText(paidDietData.get(0).getEvening());
        dinner.setText(paidDietData.get(0).getDinner());
        midMorning.setText(paidDietData.get(0).getMidMorning());
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }
}
