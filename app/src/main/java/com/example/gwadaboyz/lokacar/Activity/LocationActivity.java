package com.example.gwadaboyz.lokacar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gwadaboyz.lokacar.Adapter.LocationAdapter;
import com.example.gwadaboyz.lokacar.BO.Client;
import com.example.gwadaboyz.lokacar.BO.Location;
import com.example.gwadaboyz.lokacar.BO.Vehicule;
import com.example.gwadaboyz.lokacar.R;

import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        RecyclerView rcv = (RecyclerView)findViewById(R.id.liste_location);
        rcv.setHasFixedSize(true);

        LinearLayoutManager llmg = new LinearLayoutManager(this);
        rcv.setLayoutManager(llmg);

        Vehicule v1= new Vehicule();
        v1.setModele("M3 2018");


        Client c1= new Client();
        c1.setNom("Clotaire");
        c1.setPrenom("Prenom du client");

        Location l1 = new Location();
        l1.setClient(c1);
        l1.setId(1);
        l1.setMontant(500);
        l1.setVehicule(v1);

        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        LocationAdapter ladapter = new LocationAdapter(locations);
        rcv.setAdapter(ladapter);
    }
}
