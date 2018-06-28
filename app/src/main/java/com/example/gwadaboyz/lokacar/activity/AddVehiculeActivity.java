package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Map;

public class AddVehiculeActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    boolean disponible;
    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicule);

        //Permet l'ajout de photos
        mStorageRef = FirebaseStorage.getInstance().getReference();

    }


    public void addVehicule(View view)
    {


        EditText editTextMarque = view.getRootView().findViewById(R.id.editTextMarqueVehicule);
        EditText editTextModel = view.getRootView().findViewById(R.id.editTextModelVehicule);
        EditText  editTextImmatriculation= view.getRootView().findViewById(R.id.editTextImmatriculationVehicule);
        EditText editTextPrix= view.getRootView().findViewById(R.id.editTextPrixVehicule);
        Switch switchEtat = view.getRootView().findViewById(R.id.switchEtatVehicule);
        switchEtat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    disponible = true;

                }else{
                    disponible = false;

                }
            }
        });

        CollectionReference vehicules = db.collection("Agences").document("1").collection("Vehicules");
        Map<String,Object> car = new ArrayMap<>();
        if (editTextMarque.getText().toString().isEmpty() || editTextModel.getText().toString().isEmpty() ||
                editTextImmatriculation.getText().toString().isEmpty() || editTextPrix.getText().toString().isEmpty())
        {
            Toast.makeText(AddVehiculeActivity.this,"Les champs ne sont pas complet",Toast.LENGTH_LONG).show();
        }else
        {
            car.put("marque", editTextMarque.getText().toString());
            car.put("modele", editTextModel.getText().toString());
            car.put("immatriculation", editTextImmatriculation.getText().toString());
            car.put("prix", (Integer.parseInt( editTextPrix.getText().toString())));
            car.put("disponible", disponible);
            vehicules.document().set(car);
            Toast.makeText(AddVehiculeActivity.this,"Ajout réaliser",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(view.getContext(),VehiculeActivity.class);
            startActivity(intent);
        }




    }





}
