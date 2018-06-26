package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.bo.Agence;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getListeAgence();



    }

    public void connexion(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }

    public void addAgence()
    {
        CollectionReference agences = db.collection("Agence");

        Map<String,Object> agence1 = new ArrayMap<>();
        agence1.put("nom","St-Herblain");
        agence1.put("adresse","123 rue moile 44200 St-Herblain");
        agence1.put("siret","456882-5558-255-5");
        agences.document().set(agence1);

        Map<String,Object> agence2 = new ArrayMap<>();
        agence2.put("nom","Orvault");
        agence2.put("adresse","52 rue poil 44300 NANTES");
        agence2.put("siret","55-555656595-22626262-162");
        agences.document().set(agence2);

        Map<String,Object> agence3 = new ArrayMap<>();
        agence3.put("nom","Nantes");
        agence3.put("adresse","233 rue lomp 44000 NANTES");
        agence3.put("siret","5555-555-55-555225-2");
        agences.document().set(agence3);

        Map<String,Object> agence4 = new ArrayMap<>();
        agence4.put("nom","Guadeloupe");
        agence4.put("adresse","36 rue dela 97100 Guadeloupe");
        agence4.put("siret","654656-56566262-626262");
        agences.document().set(agence4);
    }




    public void getListeAgence()
    {
        db.collection("Agence").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if(queryDocumentSnapshots.isEmpty())
                        {
                            addAgence();
                            getListeAgence();
                        }else
                        {
                            List<Agence> listAgence = queryDocumentSnapshots.toObjects(Agence.class);
                            listAgence.addAll(listAgence);
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
                            Log.i("listeAgnce", "onSuccess: "+listAgence);
                        }

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"False",Toast.LENGTH_LONG).show();

                    }
                });
    }

}
