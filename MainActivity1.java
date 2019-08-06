package com.sandbox.mobilemechanic;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity1 extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        button = (Button) findViewById(R.id.button);
        button = (Button) findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void  onClick(View view) {
                mechanic_signin_info();


            }
        });

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public  void  onClick(View view) {
                customer_signin_info();
            }
        });


    }

    private void mechanic_signin_info() {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }

    private void customer_signin_info() {
        Intent i=new Intent(this,MainActivity1.class);
        startActivity(i);
    }


}


