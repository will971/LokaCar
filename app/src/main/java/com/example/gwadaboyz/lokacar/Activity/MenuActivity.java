package com.example.gwadaboyz.lokacar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gwadaboyz.lokacar.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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

}
