package com.example.gwadaboyz.lokacar.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gwadaboyz.lokacar.Adapter.VehiculeAdapter;
import com.example.gwadaboyz.lokacar.BO.Vehicule;
import com.example.gwadaboyz.lokacar.R;

import java.util.ArrayList;
import java.util.List;

public class VehiculeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.liste_véhicule);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Vehicule v1 = new Vehicule();
        Vehicule v3 = new Vehicule();
        Vehicule v2 = new Vehicule();

        v1.setMarque("seat");
        v1.setModele("q2");


        List<Vehicule> listVehicule = new ArrayList<>();
        listVehicule.add(v1);

        VehiculeAdapter vehiculeAdapter = new VehiculeAdapter((listVehicule));
        recyclerView.setAdapter(vehiculeAdapter);


    }
}
