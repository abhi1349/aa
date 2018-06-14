package com.example.android.freediet;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class DaysActivity extends AppCompatActivity {

    private static final int NUM_COL = 2;
    private static final int NUM_ROWS = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
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
                        Toast.makeText(getApplicationContext(),""+button.getId(),Toast.LENGTH_LONG).show();
                        startActivity(new Intent(DaysActivity.this,FullDayChart.class));
                    }
                });
            }
        }
    }
}
