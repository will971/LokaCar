package com.example.gwadaboyz.lokacar.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gwadaboyz.lokacar.bo.Client;
import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.viewholder.ClientViewHolder;

import java.util.List;


public class ClientAdapter  extends RecyclerView.Adapter<ClientViewHolder>  {

    private List<Client> listClient;

    public ClientAdapter(List<Client> listClient){this.listClient = listClient;}

    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewClient = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_client, parent, false);
        return new ClientViewHolder(viewClient);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
            holder.textViewNom.setText(listClient.get(position).getNom());
            holder.textViewPrenom.setText(listClient.get(position).getPrenom());
    }

    @Override
    public int getItemCount() {return  listClient.size();
    }
}
