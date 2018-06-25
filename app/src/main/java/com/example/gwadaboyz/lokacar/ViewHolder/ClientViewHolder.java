package com.example.gwadaboyz.lokacar.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.gwadaboyz.lokacar.R;

public class ClientViewHolder extends RecyclerView.ViewHolder {
    public TextView textViewNom, textViewPrenom;


    public ClientViewHolder(View itemView) {
        super(itemView);

        textViewNom = itemView.findViewById(R.id.TexteViewNom);
        textViewPrenom = itemView.findViewById(R.id.TexteViewPrenom);
    }
}
