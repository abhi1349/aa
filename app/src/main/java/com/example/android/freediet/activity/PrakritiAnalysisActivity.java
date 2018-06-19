package com.example.android.freediet.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.android.freediet.R;
import com.example.android.freediet.adapter.DaysDataAdapter;
import com.example.android.freediet.model.DaysData;

import java.util.ArrayList;
import java.util.List;

public class PrakritiAnalysisActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PrakritiAdapter adapter;
    ArrayList<ModelPrakriti> mylist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prakriti_analysis);

   //     quizData = fill_with_data();
        recyclerView = findViewById(R.id.rv_qus);
        adapter = new PrakritiAdapter();
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}
