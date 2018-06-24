package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.PaidDaysAdapter;
import com.example.android.freediet.model.PaidDaysResponseModel;

import java.util.ArrayList;



public class PaidDaysActivity extends AppCompatActivity {

    ImageView imageView;
    RecyclerView recyclerView;
    ArrayList<PaidDaysResponseModel> paidDaysList = new ArrayList<>();
    private String emailId="jaiiitg16@gmail.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_paid);
        imageView = findViewById(R.id.paid_days_imgView);
        paidDaysList = (ArrayList<PaidDaysResponseModel>) getIntent().getSerializableExtra("paidDaysList");

        recyclerView = findViewById(R.id.paid_days_recyclerView);
        PaidDaysAdapter adapter = new PaidDaysAdapter(paidDaysList,PaidDaysActivity.this,emailId);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setAdapter(adapter);
    }
}
