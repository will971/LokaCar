package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gwadaboyz.lokacar.adapter.ClientAdapter;
import com.example.gwadaboyz.lokacar.bo.Client;
import com.example.gwadaboyz.lokacar.R;

import java.util.ArrayList;
import java.util.List;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        RecyclerView rcv = (RecyclerView)findViewById(R.id.liste_Client);
        rcv.setHasFixedSize(true);

        LinearLayoutManager llmg = new LinearLayoutManager(this);
        rcv.setLayoutManager(llmg);

        Client c1= new Client();
        c1.setNom(" Nom ");
        c1.setPrenom("Prenom");
        List<Client> clients = new ArrayList<>();
        clients.add(c1);

        ClientAdapter cAdapter = new ClientAdapter(clients);
rcv.setAdapter(cAdapter);


    }
    public void OnClickAddClient(View view){
        Intent intent = new Intent(this, AddClientActivity.class);
        startActivity(intent);
    }
}
