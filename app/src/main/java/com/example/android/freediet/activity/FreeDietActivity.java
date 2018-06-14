package com.example.android.freediet.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.FreeDietDataAdapter;
import com.example.android.freediet.model.FreeDietModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

public class FreeDietActivity extends AppCompatActivity {

    FreeDietDataAdapter freeDietDataAdapter;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<FreeDietModel> freeDietModels=new ArrayList<>();
    private static final String JSON_URL = "";
    ListView listView;

    private List<FreeDietModel> freeDietItemList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_diet);
        setTitle("Free Diet");
        initializeFreeDietItemList();


        RecyclerView freeDietRecyclerView = findViewById(R.id.card_view_recycler_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        freeDietRecyclerView.setLayoutManager(gridLayoutManager);

        FreeDietDataAdapter carDataAdapter = new FreeDietDataAdapter(this,freeDietItemList);
        freeDietRecyclerView.setAdapter(carDataAdapter);



    }

    private void initializeFreeDietItemList()
    {
        if(freeDietItemList == null)
        {
            freeDietItemList = new ArrayList<>();
            freeDietItemList.add(new FreeDietModel( R.drawable.a));
            freeDietItemList.add(new FreeDietModel( R.drawable.b));
            freeDietItemList.add(new FreeDietModel( R.drawable.c));
            freeDietItemList.add(new FreeDietModel( R.drawable.d));
        }
    }
}