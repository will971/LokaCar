package com.example.gwadaboyz.lokacar.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gwadaboyz.lokacar.R;

public class LocationViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewID;
    public TextView textViewMontant;
    public TextView textViewClient;
    public TextView textViewVehicule;
    public LocationViewHolder(View itemView) {
        super(itemView);

        textViewID = itemView.findViewById(R.id.TexteViewID);
        textViewMontant = itemView.findViewById(R.id.TexteViewMontant);
        textViewClient= itemView.findViewById(R.id.TexteViewClient);
        textViewVehicule = itemView.findViewById(R.id.TexteViewVehicule);
    }
}
