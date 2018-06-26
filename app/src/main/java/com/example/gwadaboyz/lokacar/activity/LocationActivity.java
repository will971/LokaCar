package com.example.gwadaboyz.lokacar.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gwadaboyz.lokacar.adapter.LocationAdapter;
import com.example.gwadaboyz.lokacar.bo.Client;
import com.example.gwadaboyz.lokacar.bo.Location;
import com.example.gwadaboyz.lokacar.bo.Vehicule;
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
        v1.setImamatriculation("ek-509-vn");
        v1.setMarque("BMW");
        v1.setPrix(500);
        v1.setStatut(true);

        Vehicule v2= new Vehicule();
        v2.setModele("M3 2015");
        v2.setImamatriculation("ea-410-ez");
        v2.setMarque("BMW");
        v2.setPrix(500);
        v2.setStatut(true);

        v1.setId(1);


        Client c1= new Client();
        c1.setNom("Clotaire");
        c1.setMail("bryan.clotaire2017@campus-eni.fr");
        c1.setCodePostal("44000");
        c1.setRue("69 boulevard des putes");
        c1.setVille("Nantes");
        c1.setTelephone("0000000000");
        c1.setPrenom("Bryan");

        Client c2= new Client();
        c2.setNom("Modeste");
        c2.setMail("modeste.williams2017@campus-eni.fr");
        c2.setCodePostal("44000");
        c2.setRue("666 la mort est un choix");
        c2.setVille("BLIIT");
        c2.setTelephone("66666666");
        c2.setPrenom("William's");


        Location l1 = new Location();
        l1.setClient(c1);
        l1.setId(1);
        l1.setMontant(500);
        l1.setVehicule(v1);
        l1.setRendu(true);

        Location l2 = new Location();
        l2.setClient(c2);
        l2.setId(2);
        l2.setMontant(500);
        l2.setVehicule(v2);
        l2.setRendu(false);



        List<Location> locations = new ArrayList<>();
        locations.add(l1);
        locations.add(l2);
        LocationAdapter ladapter = new LocationAdapter(locations);
        rcv.setAdapter(ladapter);
    }
}
