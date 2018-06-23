package com.example.android.freediet.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.freediet.R;
import com.example.android.freediet.activity.FullDayChartActivity;
import com.example.android.freediet.model.PaidDaysResponseModel;

import java.util.ArrayList;

public class PaidDaysAdapter extends RecyclerView.Adapter<PaidDaysAdapter.View_Holder>{
    private static final String TAG = "PaidDaysAdapter";
    Context context;
    ArrayList<PaidDaysResponseModel> paidDietData;
    String emailId;

//    view.getContext


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
        context = parent.getContext();
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final View_Holder holder, final int position) {
     holder.btn.setText(paidDietData.get(position).getDateAssign());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick: AAAAA");

                Intent intent = new Intent(holder.btn.getContext(), FullDayChartActivity.class);
                holder.btn.getContext().startActivity(intent);

                Toast.makeText(view.getContext(), "aaaaaa", Toast.LENGTH_SHORT).show();
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
