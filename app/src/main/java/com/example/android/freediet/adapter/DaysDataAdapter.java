package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.activity.DaysActivity;
import com.example.android.freediet.activity.FullDayChartActivity;
import com.example.android.freediet.model.DaysData;
import com.example.android.freediet.model.DaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DaysDataAdapter extends RecyclerView.Adapter<DaysDataAdapter.View_Holder> {

    List<DaysData> list;
    Activity context;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<DaysResponseModel> mylist = new ArrayList<>();
    public int diet_Category ;

    public DaysDataAdapter(List<DaysData> list, Activity context, int diet_cat) {
        this.list = list;
        this.context = context;
        diet_Category = diet_cat;

    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.days_row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {
        holder.button.setText(list.get(position).getBtname());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+list.get(position).getBtnId(), Toast.LENGTH_SHORT).show();
                int id = list.get(position).getBtnId();
                getDaysData(id++,diet_Category);
//
//                Intent intent = new Intent(context.getApplicationContext(),FullDayChartActivity.class);
//                intent.putExtra("dayId",list.get(position).getBtnId());
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View_Holder extends RecyclerView.ViewHolder {
        CardView cv;
        Button button;

        View_Holder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cardView);
            button = itemView.findViewById(R.id.btn);
        }
    }


    public void getDaysData(int day_id, int diet_Category) {
        Call<ArrayList<DaysResponseModel>> call = apiService.getDays(3,0,day_id,diet_Category);
        call.enqueue(new Callback<ArrayList<DaysResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DaysResponseModel>> call, Response<ArrayList<DaysResponseModel>> response) {
                mylist = response.body();
                Intent intent = new Intent(context,FullDayChartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("mylist",mylist);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<ArrayList<DaysResponseModel>> call, Throwable t) {

            }
        });
    }

}