package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android.freediet.R;

public class FullDayChartActivity extends AppCompatActivity {

    TextView breakfast,lunch,snacks,dinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_day_chart);

        breakfast = findViewById(R.id.fullday_breakfast);
        lunch = findViewById(R.id.fullday_lunch);
        snacks = findViewById(R.id.fullday_snacks);
        dinner = findViewById(R.id.fullday_dinner);
    }
}
