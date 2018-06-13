package com.example.android.freediet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;


public class FreeDietRecyclerViewItemHolder extends RecyclerView.ViewHolder {

    private ImageView freeDietImageView = null;

    public FreeDietRecyclerViewItemHolder(View itemView) {
        super(itemView);

        if(itemView != null)
        {
            freeDietImageView = itemView.findViewById(R.id.card_view_image);
        }
    }

    public ImageView getCarImageView() {
        return freeDietImageView;
    }
}