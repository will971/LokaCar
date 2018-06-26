package com.example.gwadaboyz.lokacar.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwadaboyz.lokacar.BO.Location;
import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.ViewHolder.LocationViewHolder;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationViewHolder> {
    private List<Location> locations;

public LocationAdapter(List<Location> locations){
    this.locations=locations;
}
    @Override
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View viewLocation = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_item_location, parent, false);

        return new LocationViewHolder(viewLocation);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {

    String montant = ""+locations.get(position).getMontant();
holder.textViewID.setText(locations.get(position).getId());
holder.textViewClient.setText(locations.get(position).getClient().getNom());
holder.textViewVehicule.setText(locations.get(position).getVehicule().getModele());
holder.textViewMontant.setText(montant);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }
}
