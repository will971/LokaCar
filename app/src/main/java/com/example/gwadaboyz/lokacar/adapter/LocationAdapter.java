package com.example.gwadaboyz.lokacar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwadaboyz.lokacar.bo.Location;
import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.viewholder.LocationViewHolder;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    private List<Location> locations;

public LocationAdapter(List<Location> locations){
    this.locations=locations;
}

@Override
    public LocationViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
       View viewLocation = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_item_location, parent, false);

        return new LocationViewHolder(viewLocation);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {




//holder.textViewID.setText("N° : "+locations.get(position).getId());
holder.textViewClient.setText("Nom du client : "+locations.get(position).getClient().getNom());
holder.textViewVehicule.setText("Modele du Véhicule : "+locations.get(position).getVehicule().getModele());
holder.textViewMontant.setText("Montant de la location : "+locations.get(position).getMontant()+" €");
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
