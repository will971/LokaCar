package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.R;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class AddClientActivity extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);
    }

    public void addClient(View view)
    {


       EditText editTextnom = view.getRootView().findViewById(R.id.editTextNomClient);
       EditText editTextprenom = view.getRootView().findViewById(R.id.editTextPrenomClient);
       EditText editTextmail = view.getRootView().findViewById(R.id.editTextEmailClient);
       EditText editTexttelephone = view.getRootView().findViewById(R.id.editTextTelephoneClient);
       EditText editTextrue=view.getRootView().findViewById(R.id.editTextRueClient);
       EditText editTextville =view.getRootView().findViewById(R.id.editTextVilleClient);
       EditText editTextcp =view.getRootView().findViewById(R.id.editTextCodePostaleClient);

        CollectionReference clients = db.collection("Agences").document("1").collection("Clients");
        Map<String,Object> client = new ArrayMap<>();
        if(editTextnom.getText().toString().isEmpty() || editTextcp.getText().toString().isEmpty() || editTextmail.getText().toString().isEmpty() ||
                editTextprenom.getText().toString().isEmpty() || editTextrue.getText().toString().isEmpty() || editTexttelephone.getText().toString().isEmpty()
                || editTextville.getText().toString().isEmpty()){
            Toast.makeText(AddClientActivity.this,"Les champs ne sont pas complet",Toast.LENGTH_LONG).show();
        }else{
            client.put("nom", editTextnom.getText().toString());
            client.put("prenom", editTextprenom.getText().toString());
            client.put("rue", editTextrue.getText().toString());
            client.put("ville", editTextville.getText().toString());
            client.put("codePostale", editTextcp.getText().toString());
            client.put("telephone", editTexttelephone.getText().toString());
            client.put("mail", editTextmail.getText().toString());
            clients.document().set(client);
            Log.i("addclient", "addClient: "+editTextnom);
            Toast.makeText(AddClientActivity.this,"Ajout réaliser",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(view.getContext(),ClientActivity.class);
            startActivity(intent);
        }








    }
}
