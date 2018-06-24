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

import com.example.android.freediet.R;
import com.example.android.freediet.activity.FullDayChartActivity;
import com.example.android.freediet.model.PaidDaysResponseModel;

import java.util.ArrayList;

public class PaidDaysAdapter extends RecyclerView.Adapter<PaidDaysAdapter.View_Holder> {

    ArrayList<PaidDaysResponseModel> list;
    Activity context;
    public String email;

    public PaidDaysAdapter(ArrayList<PaidDaysResponseModel> list, Activity context, String email) {
        this.list = list;
        this.context = context;
        this.email = email;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_paid_days_row, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_Holder view_holder, int i) {
        final int menuId = (list.get(i).getId())-1;
        view_holder.button.setText(list.get(i).getDateAssign());
        view_holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,FullDayChartActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("paidDietData",list);
                intent.putExtras(bundle);
                intent.putExtra("aaa",1);
                intent.putExtra("menuId",menuId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class View_Holder extends RecyclerView.ViewHolder
    {
        Button button;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.paid_days_btn);
        }
    }
}
