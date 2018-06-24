package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.freediet.R;
import com.example.android.freediet.activity.FullDayChartActivity;
import com.example.android.freediet.model.FreeDaysData;
import com.example.android.freediet.model.FreeDaysResponseModel;
import com.example.android.freediet.rest.ApiClient;
import com.example.android.freediet.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FreeDaysAdapter extends RecyclerView.Adapter<FreeDaysAdapter.View_Holder> {

    List<FreeDaysData> list;
    Activity context;
    private ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    ArrayList<FreeDaysResponseModel> freeDietData = new ArrayList<>();
    public int diet_Category ;

    public FreeDaysAdapter(List<FreeDaysData> list, Activity context, int diet_cat) {
        this.list = list;
        this.context = context;
        diet_Category = diet_cat;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_free_days_row, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {
        holder.button.setText(list.get(position).getBtname());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(context, ""+list.get(position).getBtnId(), Toast.LENGTH_SHORT).show();
                int id = list.get(position).getBtnId();
                holder.button.setText("Done");
                holder.button.setTextColor(Color.parseColor("#ff0000"));
              //  holder.button.setBackgroundResource(R.color.persianGreeen);
                getDaysData(id++,diet_Category);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View_Holder extends RecyclerView.ViewHolder {
        Button button;

        View_Holder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.btn);
        }
    }

    public void getDaysData(int day_id, int diet_Category) {
        Call<ArrayList<FreeDaysResponseModel>> call = apiService.getDays(3,0,day_id,diet_Category);
        call.enqueue(new Callback<ArrayList<FreeDaysResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<FreeDaysResponseModel>> call, Response<ArrayList<FreeDaysResponseModel>> response) {
                freeDietData = response.body();
                Intent intent = new Intent(context,FullDayChartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("freeDietData",freeDietData);
                intent.putExtras(bundle);
                intent.putExtra("aaa",2);
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<ArrayList<FreeDaysResponseModel>> call, Throwable t) {

            }
        });
    }

}
