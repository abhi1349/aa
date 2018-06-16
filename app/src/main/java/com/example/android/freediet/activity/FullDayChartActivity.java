package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.model.DaysResponseModel;

import java.util.List;

public class FullDayChartActivity extends AppCompatActivity {

    TextView breakfast,lunch,snacks,dinner,midMorning;
    DaysResponseModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_day_chart);

        breakfast = findViewById(R.id.fullday_breakfast);
        lunch = findViewById(R.id.fullday_lunch);
        snacks = findViewById(R.id.fullday_snacks);
        dinner = findViewById(R.id.fullday_dinner);
        midMorning = findViewById(R.id.fullday_midMorning);

        String[] d = getIntent().getStringArrayExtra("data");
        breakfast.setText(d[0]);
        lunch.setText(d[4]);
        snacks.setText(d[3]);
        dinner.setText(d[1]);
        midMorning.setText(d[2]);
    }
}
