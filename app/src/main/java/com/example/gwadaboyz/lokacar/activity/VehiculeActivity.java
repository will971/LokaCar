package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.adapter.VehiculeAdapter;
import com.example.gwadaboyz.lokacar.bo.Agence;
import com.example.gwadaboyz.lokacar.bo.Vehicule;
import com.example.gwadaboyz.lokacar.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class VehiculeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference agences= db.collection("Agences");
   String agenceref ="1";
    CollectionReference vehicules = db.collection("Agences").document(agenceref).collection("Vehicules");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule);

        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.liste_véhicule);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



        //VehiculeAdapter vehiculeAdapter = new VehiculeAdapter((listVehicule));
        getListeVehicules(new OnResult() {
            @Override
            public void onGetVoiture(List<Vehicule> liste) {
                VehiculeAdapter vehiculeAdapter = new VehiculeAdapter(liste);
                recyclerView.setAdapter(vehiculeAdapter);
            }
        });



    }


    public void getListeVehicules (final OnResult listener) {
        vehicules.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {
                            List<Vehicule> voitures = queryDocumentSnapshots.toObjects(Vehicule.class);
                            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                            Log.i("Liste voitures", "onSuccess: " + voitures);
                            listener.onGetVoiture(voitures);
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(), "False", Toast.LENGTH_LONG).show();

                    }
                });

    }
    //useless
/*
    public List<Vehicule> getListVehicule(){

        agences.whereEqualTo("Gerant", mAuth.getCurrentUser().getUid()).get().addOnSuccessListener();

      return null ;
    }
*/


    public void OnClickAddVehicule(View view){
        Intent intent = new Intent(this, AddVehiculeActivity.class);
        startActivity(intent);
    }

    public interface OnResult{
        void onGetVoiture(List<Vehicule> liste);
    }
}
