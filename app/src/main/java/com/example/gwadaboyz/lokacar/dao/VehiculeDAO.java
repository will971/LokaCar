package com.example.gwadaboyz.lokacar.dao;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class VehiculeDAO {

    VehiculeDAO vehiculedao = new VehiculeDAO();
    FirebaseFirestore db = FirebaseFirestore.getInstance();
CollectionReference vehicules=db.collection("Agence").document("A1").collection("Vehicule");
    public VehiculeDAO() {


    }

    public VehiculeDAO getVehiculedao() {
        return vehiculedao;
    }
}
