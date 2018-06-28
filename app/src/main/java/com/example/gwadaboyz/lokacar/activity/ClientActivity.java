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

import com.example.gwadaboyz.lokacar.adapter.ClientAdapter;
import com.example.gwadaboyz.lokacar.bo.Client;
import com.example.gwadaboyz.lokacar.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference agences= db.collection("Agences");
    String agenceref ="1";
    CollectionReference clients = db.collection("Agences").document(agenceref).collection("Clients");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        final RecyclerView rcv = (RecyclerView)findViewById(R.id.liste_Client);
        rcv.setHasFixedSize(true);

        LinearLayoutManager llmg = new LinearLayoutManager(this);
        rcv.setLayoutManager(llmg);

        getListeClients(new OnResult() {
            @Override
            public void onGetClient(List<Client> liste) {
                ClientAdapter cAdapter = new ClientAdapter(liste);
                rcv.setAdapter(cAdapter);
            }
        });

        


    }


    public void getListeClients (final ClientActivity.OnResult listener) {
        clients.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {

                        } else {
                            List<Client> consumers = queryDocumentSnapshots.toObjects(Client.class);
                            Log.i("Liste client", "onSuccess: " + consumers);
                            listener.onGetClient(consumers);
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
    public interface OnResult{
        void onGetClient(List<Client> liste);
    }

    public void OnClickAddClient(View view){
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }

}
