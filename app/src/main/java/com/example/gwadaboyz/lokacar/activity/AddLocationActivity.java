package com.example.gwadaboyz.lokacar.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.gwadaboyz.lokacar.R;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class AddLocationActivity extends AppCompatActivity {

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        //Permet l'ajout de photos
        mStorageRef = FirebaseStorage.getInstance().getReference();

    }
}
