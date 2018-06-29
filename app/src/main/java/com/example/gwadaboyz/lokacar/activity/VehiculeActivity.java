package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.adapter.VehiculeAdapter;
import com.example.gwadaboyz.lokacar.bo.Vehicule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class VehiculeActivity extends AppCompatActivity {

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



        //teste a supprimer (comment recuprer l'id de l'utilisateur)
       FirebaseUser mAuth = FirebaseAuth.getInstance().getCurrentUser();
       String id = mAuth.getUid();

        db.collection("Agences")
                .whereEqualTo("Gerant", id)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("agence retrouvé", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("agence non retrouvé", "Error getting documents: ", task.getException());
                        }
                    }
                });


        Toast.makeText(VehiculeActivity.this,id,Toast.LENGTH_LONG).show();

    }


    public void getListeVehicules (final OnResult listener) {
        vehicules.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {
                            List<Vehicule> voitures = queryDocumentSnapshots.toObjects(Vehicule.class);
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



    public void OnClickAddVehicule(View view){
        Intent intent = new Intent(this, AddVehiculeActivity.class);
        startActivity(intent);
    }

    public interface OnResult{
        void onGetVoiture(List<Vehicule> liste);
    }
}
