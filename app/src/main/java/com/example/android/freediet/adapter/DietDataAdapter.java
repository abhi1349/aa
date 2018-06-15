package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.freediet.activity.DaysActivity;
import com.example.android.freediet.R;
import com.example.android.freediet.model.DietResponseModel;
import com.squareup.picasso.Picasso;

import java.util.List;


public class DietDataAdapter extends RecyclerView.Adapter<DietDataAdapter.MyViewHolder> {

    private List<DietResponseModel> dietItemList;
    Context context;

    public DietDataAdapter(Context context, List<DietResponseModel> freeDietItemList) {
        this.dietItemList = freeDietItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card_view_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

     //  holder.dietTextView.setText(dietItemList.get(position).getDietImageId());

        Glide.with(context).load(dietItemList.get(position).getDietImageUrl()).into(holder.dietImageView);
        holder.dietImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "image id: "+dietItemList.get(position).getDietImageId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(),DaysActivity.class);

                intent.putExtra("key",dietItemList.get(position).getDietImageId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if (dietItemList != null) {
            ret = dietItemList.size();
        }
        return ret;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView dietImageView = null;
        private TextView dietTextView = null;

        public MyViewHolder(View itemView) {
            super(itemView);

            if (itemView != null) {
                dietImageView = itemView.findViewById(R.id.card_view_image);
                dietTextView = itemView.findViewById(R.id.card_view_id);
            }
        }

    }
}