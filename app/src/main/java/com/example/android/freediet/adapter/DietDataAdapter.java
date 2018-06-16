package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
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

                Glide.with(context).
                load(dietItemList.get(position).getDietImageUrl()).
                        listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(holder.dietImageView);

        holder.dietImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DietResponseModel aa = dietItemList.get(position);

                Toast.makeText(context, "image id: "+aa.getDietImageId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context.getApplicationContext(),DaysActivity.class);

                intent.putExtra("key",aa.getDietImageId());
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
        public ProgressBar progressBar;

        public MyViewHolder(View itemView) {
            super(itemView);

            if (itemView != null) {
                dietImageView = itemView.findViewById(R.id.card_view_image);
                  progressBar = itemView.findViewById(R.id.progress);
            }
        }

    }
}