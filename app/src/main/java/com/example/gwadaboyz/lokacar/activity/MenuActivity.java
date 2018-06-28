package com.example.gwadaboyz.lokacar.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.gwadaboyz.lokacar.R;
import com.google.firebase.auth.FirebaseAuth;

public class MenuActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        mAuth = FirebaseAuth.getInstance();
    }


    //onclick
    public void clickCA(View view)
    {
        Intent intent = new Intent(this, CAActivity.class);
        startActivity(intent);
    }
    public void clickClient(View view)
    {
        Intent intent = new Intent(this, ClientActivity.class);
        startActivity(intent);
    }
    public void clickLocation(View view)
    {
        Intent intent = new Intent(this,LocationActivity.class);
        startActivity(intent);
    }
    public void clickVehicule(View view)
    {
        Intent intent = new Intent(this,VehiculeActivity.class);
        startActivity(intent);
    }

    public void deconexionUser(View view)
    {
        mAuth.signOut();
        startActivity(new Intent(MenuActivity.this, MainActivity.class));


    }

}
