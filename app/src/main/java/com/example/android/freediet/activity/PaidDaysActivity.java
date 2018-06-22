package com.example.android.freediet.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.DaysDataAdapter;
import com.example.android.freediet.adapter.PaidDaysAdapter;
import com.example.android.freediet.model.DaysData;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.PaidDaysData;
import com.example.android.freediet.model.PaidDaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PaidDaysActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    int dayCount;
   Activity activity;
    public String emailId="jaiiitg16@gmail.com";
//    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<PaidDaysResponseModel> paidDaysList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_days);
 //       paidDaysList = (ArrayList<PaidDaysResponseModel>) getIntent().getSerializableExtra("paidDaysList");
 //       Toast.makeText(this, "Result: "+paidDaysList.size(), Toast.LENGTH_SHORT).show();

        dayCount = paidDaysList.size();
        recyclerView = findViewById(R.id.paid_days_recyclerView);
        PaidDaysAdapter adapter = new PaidDaysAdapter(paidDaysList,activity,emailId);
        recyclerView.setAdapter(adapter);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));

//        public ArrayList<paidDaysList> fill_with_data() {
//            ArrayList<paidDaysList> data = new ArrayList<>();
//            for(int i=1;i<=30;i++) {
//               data.add(new DaysData("Day "+i,i));
//            }
//            return data;
//        }

    }
}
