package com.example.android.freediet;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;


public class FreeDietDataAdapter extends RecyclerView.Adapter<FreeDietDataAdapter.FreeDietRecyclerViewItemHolder> {

    private List<FreeDietModel> freeDietItemList;
    Activity activity;

    public FreeDietDataAdapter(Activity activity, List<FreeDietModel> freeDietItemList) {
        this.freeDietItemList = freeDietItemList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FreeDietRecyclerViewItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_item,parent,false);

        return new FreeDietRecyclerViewItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FreeDietRecyclerViewItemHolder holder, int position) {
        FreeDietModel item = freeDietItemList.get(position);
        holder.freeDietImageView.setImageResource(item.getFreeDietImageId());
        final FreeDietModel items = freeDietItemList.get(position);
        holder.freeDietImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, items.getFreeDietImageId(), Toast.LENGTH_SHORT).show();
                activity.startActivity(new Intent(activity,DaysActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (freeDietItemList != null) {
            ret = freeDietItemList.size();
        }
        return ret;
    }

    class FreeDietRecyclerViewItemHolder extends RecyclerView.ViewHolder {

        private ImageView freeDietImageView = null;

        public FreeDietRecyclerViewItemHolder(View itemView) {
            super(itemView);

            if (itemView != null) {
                freeDietImageView = itemView.findViewById(R.id.card_view_image);
            }
        }

    }
}