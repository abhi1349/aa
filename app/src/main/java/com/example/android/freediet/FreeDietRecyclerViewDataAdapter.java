package com.example.android.freediet;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;


public class FreeDietRecyclerViewDataAdapter extends RecyclerView.Adapter<FreeDietRecyclerViewItemHolder> {

    private List<FreeDietRecyclerViewItem> freeDietItemList;

    public FreeDietRecyclerViewDataAdapter(List<FreeDietRecyclerViewItem> freeDietItemList) {
        this.freeDietItemList = freeDietItemList;
    }

    @Override
    public FreeDietRecyclerViewItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View freeDietItemView = layoutInflater.inflate(R.layout.activity_card_view_item, parent, false);
        final ImageView freeDietImageView = freeDietItemView.findViewById(R.id.card_view_image);
        freeDietImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar snackbar = Snackbar.make(freeDietImageView, "You click " +" image", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });

        FreeDietRecyclerViewItemHolder ret = new FreeDietRecyclerViewItemHolder(freeDietItemView);
        return ret;
    }

    @Override
    public void onBindViewHolder(FreeDietRecyclerViewItemHolder holder, int position) {
        if(freeDietItemList!=null) {
            // Get car item dto in list.
            FreeDietRecyclerViewItem carItem = freeDietItemList.get(position);

            if(carItem != null) {
                holder.getCarImageView().setImageResource(carItem.getFreeDietImageId());
            }
        }
    }

    @Override
    public int getItemCount() {
        int ret = 0;
        if(freeDietItemList!=null)
        {
            ret = freeDietItemList.size();
        }
        return ret;
    }
}