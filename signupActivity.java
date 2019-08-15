package com.sandbox.ak;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class signupActivity extends AppCompatActivity implements View.OnClickListener {

        //defining view objects
        private EditText editTextName;
        private EditText editTextEmail;
        private EditText editTextPassword;
        private EditText editTextphone;
        private EditText editTextconfirmPassword;
        private Button buttonSignup;
        private ProgressDialog progressDialog;


        //defining firebaseauth object
        private FirebaseAuth firebaseAuth;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);

            //initializing firebase auth object
            firebaseAuth = FirebaseAuth.getInstance();

            //initializing views
            editTextName = (EditText) findViewById(R.id.name);
            editTextEmail = (EditText) findViewById(R.id.email);
            editTextPassword = (EditText) findViewById(R.id.psw);
            editTextphone = (EditText) findViewById(R.id.phn);
            editTextconfirmPassword  = (EditText) findViewById(R.id.cpsw);
            buttonSignup = (Button) findViewById(R.id.button);

            progressDialog = new ProgressDialog(this);

            //attaching listener to button
            buttonSignup.setOnClickListener(this);
        }

        private void registerUser(){

            //getting email and password from edit texts
            String email = editTextEmail.getText().toString().trim();
            String password  = editTextPassword.getText().toString().trim();
            String name  = editTextName.getText().toString().trim();
            String phone  = editTextphone.getText().toString().trim();
            String confirmpassword  = editTextconfirmPassword.getText().toString().trim();
            //checking if email and passwords are empty
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                return;
            }
            if(TextUtils.isEmpty(name)){
                Toast.makeText(this,"Please enter name",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(phone)){
                Toast.makeText(this,"Please enter phone",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(confirmpassword)){
                Toast.makeText(this,"Please enter cofirmpassword",Toast.LENGTH_LONG).show();
                return;
            }


            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            //creating a new user
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if(task.isSuccessful()){
                                //display some message here
                                Toast.makeText(signupActivity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                            }else{
                                //display some message here
                                Toast.makeText(signupActivity.this,"Registration Error", Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();
                        }
                    });

        }

        @Override
        public void onClick(View view) {
            //calling register method on click
            registerUser();
        }
    }




