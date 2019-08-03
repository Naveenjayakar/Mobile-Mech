package com.sandbox.mobilemech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class SignIn extends AppCompatActivity {
    DatabaseReference databaseMechanic;
    //EditText addText1;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Activity_signin);

        //addText1 = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);



        databaseMechanic = FirebaseDatabase.getInstance().getReference("Mechanic");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin_info();
            }
        });


    }

    private void signin_info() {
        Intent i=new Intent(this,Mobile_Mech_main.class);
        startActivity(i);



    }
}
