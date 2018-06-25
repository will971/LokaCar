package com.example.gwadaboyz.lokacar.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gwadaboyz.lokacar.R;

public class VehiculeViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewMarque;
    public TextView textViewModel;

    public VehiculeViewHolder(View itemView) {
        super(itemView);
        textViewMarque = itemView.findViewById(R.id.TexteViewMarque);
        textViewModel = itemView.findViewById(R.id.TexteViewModel);
    }
}
