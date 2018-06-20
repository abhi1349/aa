package com.example.android.freediet.activity;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import com.example.android.freediet.R;
import java.util.ArrayList;

public class PrakritiAnalysisActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PrakritiAdapter adapter;
    ArrayList<ModelPrakriti> mylist = new ArrayList<>();
    PrakritiDbHelper helper;
    ModelPrakriti modelPrakriti;
    Button btnSave,btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prakriti_analysis);

        btnSave = findViewById(R.id.save);
        btnReset =findViewById(R.id.reset);
        recyclerView = findViewById(R.id.rv_qus);
        helper = new PrakritiDbHelper(this);
        helper.insert();


        if (helper.getAll() != null){
            Cursor cursor = helper.getAll();
            cursor.moveToFirst();
            do {
                String q = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_PRAKRITI_QUESTION));
                String v = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_VATA));
                String p = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_PITTA));
                String k = cursor.getString(cursor.getColumnIndexOrThrow(PrakritiContract.PrakritiQuestion.COLUMN_KAPHA));
//                Toast.makeText(this, q, Toast.LENGTH_SHORT).show();
                modelPrakriti = new ModelPrakriti(q,v,p,k);
                mylist.add(modelPrakriti);
            }while (cursor.moveToNext());
        }
//
        adapter = new PrakritiAdapter(mylist,PrakritiAnalysisActivity.this);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }
}
