package com.sandbox.mobilemech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.MapView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Garageinfo extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private Button button;
    private EditText address, phone,nameofshop;

    //private FirebaseAuth mFirebaseAuth;
    //private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ginfo);
        address = (EditText) findViewById(R.id.editText7);
        phone = (EditText) findViewById(R.id.editText);
        nameofshop=(EditText)findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button5);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Garageinfo.this, MLOc_map.class));
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Garageinfo.this,PlacePickerActivity.class));
            }
        });

    }
}









