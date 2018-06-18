package com.example.android.freediet.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.DaysDataAdapter;
import com.example.android.freediet.model.DaysData;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaysActivity extends AppCompatActivity {

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
//        Toast.makeText(this, "diet_Category : "+diet_Category, Toast.LENGTH_SHORT).show();
//        populateButtons();

//        getDaysData(day_id,diet_Category);
    }
    public List<DaysData> fill_with_data() {
        List<DaysData> data = new ArrayList<>();
        for(int i=1;i<=30;i++) {
            data.add(new DaysData("Day "+i,i));
        }
        return data;
    }


//    private void populateButtons() {
//        int day = 1;
//        TableLayout layout = findViewById(R.id.tableLayout);
//        for (int row = 0; row< NUM_ROWS; row++){
//            TableRow tableRow = new TableRow(this);
//            layout.addView(tableRow);
//            for (int col = 0; col<NUM_COL; col++){
//                final Button button = new Button(this);
//                button.setText("Day "+day);
//                button.setId(day);
//                button.setTextColor(getResources().getColor(R.color.colorPrimary));
//                day++;
//                tableRow.addView(button);
//                button.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                        getDaysData(button.getId(),diet_Category);
//
//                        //                    int buttonId = button.getId();
//                        button.setText("Day "+button.getId()+" done");
//                        button.setTextColor(getResources().getColor(R.color.colorRed));
//
//                        //           Toast.makeText(DaysActivity.this, "diet_Category : "+diet_Category, Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//            }
//        }
//    }

//    public void getDaysData(int day_id, int diet_Category) {
//        Call<ArrayList<DaysResponseModel>> call = apiService.getDays(3,0,day_id,diet_Category);
//        call.enqueue(new Callback<ArrayList<DaysResponseModel>>() {
//            @Override
//            public void onResponse(Call<ArrayList<DaysResponseModel>> call, Response<ArrayList<DaysResponseModel>> response) {
//                mylist = response.body();
//               Intent intent = new Intent(getApplicationContext(),FullDayChartActivity.class);
//               Bundle bundle = new Bundle();
//               bundle.putSerializable("mylist",mylist);
//               intent.putExtras(bundle);
//               startActivity(intent);
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<DaysResponseModel>> call, Throwable t) {
//
//            }
//        });
//    }
}
