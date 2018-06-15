package com.example.android.freediet.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.DietResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaysActivity extends AppCompatActivity {

    private static final String TAG = "DaysActivity";
    private static final int NUM_COL = 2;
    private static final int NUM_ROWS = 15;

    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    List<DaysResponseModel> daysList;
    ArrayList<DaysResponseModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

        String test = getIntent().getStringExtra("key");
        Toast.makeText(this, ""+test, Toast.LENGTH_SHORT).show();

        populateButtons();
    }

    private void populateButtons() {
        int day = 1;
        TableLayout layout = findViewById(R.id.tableLayout);
        for (int row = 0; row< NUM_ROWS; row++){
            TableRow tableRow = new TableRow(this);
            layout.addView(tableRow);
            for (int col = 0; col<NUM_COL; col++){
                final Button button = new Button(this);
                button.setText("Day "+day);
                button.setId(day);
 //               button.setPadding(8,8,8,8);
                button.setTextColor(getResources().getColor(R.color.colorPrimary));
  //              button.setBackgroundColor(getResources().getColor(R.color.colorAccent));
   //             button.setBackgroundColor(0xFFFF0000);
                day++;
                tableRow.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        getDaysData();

                        Toast.makeText(getApplicationContext(),""+button.getId(),Toast.LENGTH_LONG).show();
                        startActivity(new Intent(DaysActivity.this,FullDayChartActivity.class));
                    }
                });
            }
        }
    }

    private void getDaysData() {

        Call<List<DaysResponseModel>> call = apiService.getDays();
        call.enqueue(new Callback<List<DaysResponseModel>>() {
            @Override
            public void onResponse(Call<List<DaysResponseModel>> call, Response<List<DaysResponseModel>> response) {
             //   Toast.makeText(DaysActivity.this, "success", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "AAA_onResponse: ");

               //   daysList = response.body();


            }

            @Override
            public void onFailure(Call<List<DaysResponseModel>> call, Throwable t) {
              //  Toast.makeText(DaysActivity.this, "failed", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "BBB_onFailure: ");
            }
        });
    }
}
