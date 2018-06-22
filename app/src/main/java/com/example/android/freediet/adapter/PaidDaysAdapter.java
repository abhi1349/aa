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
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaidDaysAdapter extends RecyclerView.Adapter<PaidDaysAdapter.View_Holder>{

    ArrayList<PaidDaysResponseModel> list;
    Activity context;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<PaidDaysResponseModel> myPaidlist = new ArrayList<>();
    public String emailId;

    public PaidDaysAdapter(ArrayList<PaidDaysResponseModel> list, Activity context, String emailId) {
        this.list = list;
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
    public void onBindViewHolder(@NonNull View_Holder holder, final int position) {
 //       holder.btn.setText(list.get(position).getDietEmailid());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  //              Toast.makeText(context, ""+list.get(position).getBtnId(), Toast.LENGTH_SHORT).show();
  //               emailId = String.valueOf(list.get(position).getDietEmailid());
                getPaidDaysData(emailId);
            }

            private void getPaidDaysData(String emailId) {
                Call<ArrayList<PaidDaysResponseModel>> call = apiService.getPaidDays("jaiiitg16@gmail.com");
                call.enqueue(new Callback<ArrayList<PaidDaysResponseModel>>() {
                    @Override
                    public void onResponse(Call<ArrayList<PaidDaysResponseModel>> call, Response<ArrayList<PaidDaysResponseModel>> response) {
                        myPaidlist = response.body();
                        Intent intent = new Intent(context,FullDayChartActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("myPaidlist",myPaidlist);
                        intent.putExtras(bundle);
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<PaidDaysResponseModel>> call, Throwable t) {

                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View_Holder extends RecyclerView.ViewHolder{

        Button btn;
        public View_Holder(View itemView) {
            super(itemView);
            btn = itemView.findViewById(R.id.paid_days_btn);
        }
    }
}
