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

import com.example.gwadaboyz.lokacar.adapter.LocationAdapter;
import com.example.gwadaboyz.lokacar.bo.Client;
import com.example.gwadaboyz.lokacar.bo.Location;
import com.example.gwadaboyz.lokacar.bo.Vehicule;
import com.example.gwadaboyz.lokacar.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.reflect.TypeToken;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LocationActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference agences = db.collection("Agences");
    String agenceref = "1";
    CollectionReference locations = db.collection("Agences").document(agenceref).collection("Locations");
    Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        final RecyclerView rcv = (RecyclerView) findViewById(R.id.liste_location);
        rcv.setHasFixedSize(true);

        LinearLayoutManager llmg = new LinearLayoutManager(this);
        rcv.setLayoutManager(llmg);

        getListeLocations(new OnResult() {
            @Override
            public void onGetLocation(List<Location> liste) {
                LocationAdapter lAdapter = new LocationAdapter(liste);
                rcv.setAdapter(lAdapter);
            }
        });
    }

    public void getListeLocations(final LocationActivity.OnResult listener) {
        locations.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {


                            final List<Location> listeLocation = new ArrayList<Location>();

                            for (QueryDocumentSnapshot qds : queryDocumentSnapshots) {

                                final Location location = new Location();
                                Client c = null;
                                final DocumentReference refVoiture = ((DocumentReference) qds.get("vehicule"));
                                DocumentReference refClient = ((DocumentReference) qds.get("client"));
                                final Date datedebut = ((Date) qds.get("date_debut"));
                                final Date datefin = ((Date) qds.get("date_fin"));
                                final int montant = Integer.parseInt(qds.get("montant").toString());


                                location.setMontant(montant);

                                // Type typeToken = new TypeToken<Client>() { }.getType();
                                //  Client c = new Gson().fromJson( refClient.getPath(), typeToken);
                                


                                Task<DocumentSnapshot> ds = refClient.get() /*db.collection(path1[0]).document(path1[1]).collection(path1[2]).document(path1[3]).get()*/;


                                ds.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                    @Override
                                    public void onSuccess(DocumentSnapshot documentSnapshot) {


                                        final Client c = documentSnapshot.toObject(Client.class);
                                        Log.i("Client", c.toString());
                                        Task<DocumentSnapshot> ds2 = refVoiture.get();
                                        ds2.addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                                            @Override
                                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                                Vehicule v = documentSnapshot.toObject(Vehicule.class);
                                                Log.i("Vehicule", v.toString());
                                                location.setDate_début(datedebut);
                                                location.setDate_fin(datefin);
                                                location.setClient(c);
                                                location.setVehicule(v);
                                                listeLocation.add(location);


                                                System.out.println();
                                                listener.onGetLocation(listeLocation);



                                            }
                                        });
                                    }
                                });




                            }
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

    public interface OnResult {
        void onGetLocation(List<Location> liste);
    }


    public void OnClickAddLocation(View view) {
        Intent intent = new Intent(this, AddLocationActivity.class);
        startActivity(intent);
    }
}
