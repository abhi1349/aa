package com.example.android.freediet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;

import java.util.ArrayList;
import java.util.List;

public class CardViewActivity extends AppCompatActivity {

    private List<FreeDietRecyclerViewItem> freeDietItemList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        setTitle("Free Diet");
        initializeFreeDietItemList();


        RecyclerView freeDietRecyclerView = findViewById(R.id.card_view_recycler_list);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        freeDietRecyclerView.setLayoutManager(gridLayoutManager);

        FreeDietRecyclerViewDataAdapter carDataAdapter = new FreeDietRecyclerViewDataAdapter(this,freeDietItemList);
        freeDietRecyclerView.setAdapter(carDataAdapter);



    }

    private void initializeFreeDietItemList()
    {
        if(freeDietItemList == null)
        {
            freeDietItemList = new ArrayList<>();
            freeDietItemList.add(new FreeDietRecyclerViewItem( R.drawable.a));
            freeDietItemList.add(new FreeDietRecyclerViewItem( R.drawable.b));
            freeDietItemList.add(new FreeDietRecyclerViewItem( R.drawable.c));
            freeDietItemList.add(new FreeDietRecyclerViewItem( R.drawable.d));
        }
    }
}