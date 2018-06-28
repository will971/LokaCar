package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gwadaboyz.lokacar.R;
import com.example.gwadaboyz.lokacar.bo.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();

        getListeUser();


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
    }

        public void connexion ( final View view){
            EditText mail = view.getRootView().findViewById(R.id.editTextMail);
            EditText pwd = view.getRootView().findViewById(R.id.editTextPWD);

            mAuth.signInWithEmailAndPassword(mail.getText().toString(), pwd.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("connexion", "signInWithEmail:success");
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(view.getContext(), MenuActivity.class);
                                startActivity(intent);
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("connexion", "signInWithEmail:failure", task.getException());
                                Toast.makeText(MainActivity.this,"Identifiant ou mot de passe invalide",Toast.LENGTH_LONG).show();
                            }

                            // ...
                        }
                    });
        }



    /*public void addUser(){
      // CollectionReference users = db.collection("Agence").document("A1").collection("user");
       CollectionReference users=db.collection("User");
        Map<String, Object> user= new ArrayMap<>();
        user.put("nom", "Gerant1");
        user.put("prenom", "test");
        user.put("mot de passe", "test");
        user.put("mail", "test@test.fr");



    }*/
        public void addAgence () {
            //CollectionReference agences = db.collection("Agence");
            CollectionReference agences = db.collection("Agences");

            Map<String, Object> agence1 = new ArrayMap<>();
            agence1.put("nom", "St-Herblain");
            agence1.put("adresse", "123 rue moile 44200 St-Herblain");
            agence1.put("siret", "456882-5558-255-5");
            agences.document("A1").set(agence1);

            Map<String, Object> agence2 = new ArrayMap<>();
            agence2.put("nom", "Orvault");
            agence2.put("adresse", "52 rue poil 44300 NANTES");
            agence2.put("siret", "55-555656595-22626262-162");
            agences.document("A2").set(agence2);

            Map<String, Object> agence3 = new ArrayMap<>();
            agence3.put("nom", "Nantes");
            agence3.put("adresse", "233 rue lomp 44000 NANTES");
            agence3.put("siret", "5555-555-55-555225-2");
            agences.document("A3").set(agence3);

            Map<String, Object> agence4 = new ArrayMap<>();
            agence4.put("nom", "Guadeloupe");
            agence4.put("adresse", "36 rue dela 97100 Guadeloupe");
            agence4.put("siret", "654656-56566262-626262");
            agences.document("A4").set(agence4);
        }
        public void addVehicule () {
            CollectionReference cars = db.collection("Agences")
                    .document("A1").collection("Vehicules");

            Map<String, Object> car = new ArrayMap<>();
            car.put("Marque", "BMW");
            car.put("Modele", "M3");
            car.put("Immatriculation", "EZ-501-AB");
            car.put("kilometrage", 50000);
            car.put("Disponible", false);
            cars.document("V1").set(car);

            Map<String, Object> car2 = new ArrayMap<>();
            car2.put("Marque", "Audi");
            car2.put("Modele", "RS3");
            car2.put("Immatriculation", "EG-501-AB");
            car2.put("kilometrage", 75000);
            car2.put("Disponible", true);
            cars.document("V2").set(car2);
        }
        public void addClient () {
            CollectionReference clients = db.collection("Agences").document("A1")
                    .collection("Clients");
            Map<String, Object> client = new ArrayMap<>();
            client.put("nom", "Donald");
            client.put("prenom", "Marc");
            client.put("rue", "75 rue du valé");
            client.put("ville", "NANTES");
            client.put("codePostale", "44000");
            client.put("telephone", "0699002211");
            client.put("mail", "D.marc@gmail.com");
            clients.document("Client1").set(client);


            Map<String, Object> client2 = new ArrayMap<>();
            client2.put("nom", "Jean");
            client2.put("prenom", "Valjean");
            client2.put("rue", "12 rue duper");
            client2.put("ville", "St-Herblain");
            client2.put("codePostale", "44200");
            client2.put("telephone", "0690256598");
            client2.put("mail", "JeanValJean@gmail.com");
            clients.document("Client2").set(client2);
        }

        public void addLocation () {
            CollectionReference locations = db.collection("Agences").document("A1")
                    .collection("Locations");
            CollectionReference clients = db.collection("Agences").document("A1").collection("Clients");
            CollectionReference vehicules = db.collection("Agences").document("A1").collection("Vehicules");

            Map<String, Object> location1 = new ArrayMap<>();

            Date ddb = new Date(01 - 01 - 1995);
            Date ddf = new Date();
            SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yy");

            formater.format(ddf);
            location1.put("Client", clients.document("Client1"));
            location1.put("Vehicule", vehicules.document("V1"));
            location1.put("Date début", ddb);
            location1.put("Date fin", ddf);
            location1.put("Montant", 500);
            locations.document("Location 1").set(location1);
        }
        public void getListeUser () {
            db.collection("User").get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            if (queryDocumentSnapshots.isEmpty()) {
                                //addUser();
                                addAgence();
                                addVehicule();
                                addClient();
                                addLocation();
                            } else {
                                List<User> listUser = queryDocumentSnapshots.toObjects(User.class);
                                listUser.addAll(listUser);
                                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                                Log.i("listeUser", "onSuccess: " + listUser);
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

    }
