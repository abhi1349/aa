package com.example.android.freediet.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.android.freediet.R;

import java.util.ArrayList;

public class PrakritiAdapter extends RecyclerView.Adapter<PrakritiAdapter.ItemViewHolder> {
    private int mNumberItems;
    ArrayList<ModelPrakriti> prakrtiQuestions;
    Activity activity;

    public PrakritiAdapter(ArrayList<ModelPrakriti> prakrtiQuestions, Activity activity) {
        this.prakrtiQuestions = prakrtiQuestions;
        this.activity = activity;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.layout_prakriti_analysis;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        PrakritiAdapter.ItemViewHolder viewHolder = new PrakritiAdapter.ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final PrakritiAdapter.ItemViewHolder holder, int position) {
        ModelPrakriti modelPrakriti = prakrtiQuestions.get(position);
        holder.question.setText(modelPrakriti.getQuestions());
        holder.vita.setText(modelPrakriti.getVata());
        holder.kapha.setText(modelPrakriti.getKapha());
        holder.pitta.setText(modelPrakriti.getPitta());
//        holder.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                holder.radioGroup.getCheckedRadioButtonId();
//                radioButton = (RadioButton) findViewById(selectedId);
//            }
//        });
//        holder.vita.setText(position);
//        holder.pitta.setText(position);
//        holder.kapha.setText(position);

    }
    @Override
    public int getItemCount() {
        return prakrtiQuestions.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        protected TextView question;
        RadioGroup radioGroup;
        RadioButton vita, pitta, kapha;

        public ItemViewHolder(View itemView) {
            super(itemView);
            question = (TextView) itemView.findViewById(R.id.pk_question);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.pk_radiogp);
            vita = (RadioButton) itemView.findViewById(R.id.pk_vata);
            pitta = (RadioButton) itemView.findViewById(R.id.pk_pitta);
            kapha = (RadioButton) itemView.findViewById(R.id.pk_kapha);
        }
    }
}