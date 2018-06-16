package com.example.android.freediet.activity;

import android.content.Intent;
import android.os.Parcelable;
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
    public int diet_Category ;

    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    List<DaysResponseModel> daysList;
//    ArrayList<DaysResponseModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);

        diet_Category = getIntent().getIntExtra("key",0);
        Toast.makeText(this, "diet_Category : "+diet_Category, Toast.LENGTH_SHORT).show();

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
                button.setTextColor(getResources().getColor(R.color.colorPrimary));
                day++;
                tableRow.addView(button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        getDaysData(button.getId(),diet_Category);

                        //                    int buttonId = button.getId();
                        button.setText("Day "+button.getId()+" done");
                        button.setTextColor(getResources().getColor(R.color.colorRed));

                        //           Toast.makeText(DaysActivity.this, "diet_Category : "+diet_Category, Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }
    }

    private void getDaysData(int day, int diet_Category) {



        Call<List<DaysResponseModel>> call = apiService.getDays(3,1,day,9);
        call.enqueue(new Callback<List<DaysResponseModel>>() {
            @Override
            public void onResponse(Call<List<DaysResponseModel>> call, Response<List<DaysResponseModel>> response) {
                daysList =  response.body();
                String[] data = {daysList.get(0).getBreakfast(),daysList.get(0).getDinner(),
                        daysList.get(0).getLunch(),daysList.get(0).getEvening(),daysList.get(0).getMidMorning()};

                Intent intent = new Intent(getApplicationContext(),FullDayChartActivity.class);
                intent.putExtra("data", data);
                startActivity(intent);
//                Toast.makeText(DaysActivity.this, ""+daysList.get(0).getBreakfast(), Toast.LENGTH_SHORT).show();
                //   daysList = response.body();
            }

            @Override
            public void onFailure(Call<List<DaysResponseModel>> call, Throwable t) {
                Toast.makeText(DaysActivity.this, "Network Problem, Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });

//        Call<ArrayList<DaysResponseModel>> call = apiService.getDays(3,0,day,diet_Category);
//        call.enqueue(new Callback<ArrayList<DaysResponseModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<DaysResponseModel>> call, Response<ArrayList<DaysResponseModel>> response) {
//               models = response.body();
//                Toast.makeText(DaysActivity.this, ""+models.get(0).getBreakfast(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<DaysResponseModel>> call, Throwable t) {
//
//            }
//        });
    }
}
