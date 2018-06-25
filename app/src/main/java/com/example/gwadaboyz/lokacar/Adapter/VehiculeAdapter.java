package com.example.gwadaboyz.lokacar.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwadaboyz.lokacar.BO.Vehicule;
import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.ViewHolder.VehiculeViewHolder;

import java.util.List;

public class VehiculeAdapter extends RecyclerView.Adapter<VehiculeViewHolder> {

    private List<Vehicule> listeVehicule;

    public VehiculeAdapter(List<Vehicule> listeVehicule)
    {
        this.listeVehicule = listeVehicule;
    }


    @Override
    public VehiculeViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View viewVehicule = LayoutInflater.from(parent.getContext())
                                            .inflate(R.layout.liste_item_vehicule,parent,false);
        return new VehiculeViewHolder(viewVehicule);
    }

    @Override
    public void onBindViewHolder( VehiculeViewHolder holder, int position) {

        holder.textViewModel.setText(listeVehicule.get(position).getModele());
        holder.textViewMarque.setText(listeVehicule.get(position).getMarque());
    }

    @Override
    public int getItemCount() {
        return listeVehicule.size();
    }
}
