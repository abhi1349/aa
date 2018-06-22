package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.activity.FullDayChartActivity;
import com.example.android.freediet.model.DaysData;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.model.PaidDaysData;
import com.example.android.freediet.model.PaidDaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaidDaysAdapter extends RecyclerView.Adapter<PaidDaysAdapter.View_Holder>{

    Activity context;
    ArrayList<PaidDaysResponseModel> paidDietData;
    String emailId;


    public PaidDaysAdapter(ArrayList<PaidDaysResponseModel> paidDietData, Activity context,String emailId) {
        this.paidDietData = paidDietData;
        this.context = context;
        this.emailId = emailId;
     }

    @NonNull
    @Override
    public View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.paid_days_row_layout,parent,false);
        View_Holder view_holder = new View_Holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final View_Holder holder, final int position) {

 //       String dtStart = paidDietData.get(position).getDateAssign();




        holder.btn.setText(paidDietData.get(position).getDateAssign());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "aaaaaa", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,FullDayChartActivity.class);
//                Bundle bundle = new Bundle();
//                bundle.putSerializable("paidDietData",paidDietData);
//                intent.putExtras(bundle);
//                intent.putExtra("aaa",1);
//                context.startActivity(intent);
//            }

//            private void getPaidDaysData(String emailId) {
  //              Call<ArrayList<PaidDaysResponseModel>> call = apiService.getPaidDays("jaiiitg16@gmail.com");
  //              call.enqueue(new Callback<ArrayList<PaidDaysResponseModel>>() {
  //                  @Override
  //                  public void onResponse(Call<ArrayList<PaidDaysResponseModel>> call, Response<ArrayList<PaidDaysResponseModel>> response) {
  //                      paidDietData = response.body();
//                        Intent intent = new Intent(context,FullDayChartActivity.class);
//                        Bundle bundle = new Bundle();
//                        bundle.putSerializable("paidDietData",paidDietData);
//                        intent.putExtras(bundle);
//                        context.startActivity(intent);
  //                  }

  //                  @Override
  //                  public void onFailure(Call<ArrayList<PaidDaysResponseModel>> call, Throwable t) {

  //                  }
  //              });
            }
        });

    }

    @Override
    public int getItemCount() {
        return paidDietData.size();
    }

    class View_Holder extends RecyclerView.ViewHolder{

        Button btn;
        public View_Holder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.paid_days_btn);
        }
    }
}
