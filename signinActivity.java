package com.sandbox.ak;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


  public class signinActivity extends AppCompatActivity implements View.OnClickListener {


        //defining views
        private Button buttonSignIn;
        private EditText editTextEmail;
        private EditText editTextPassword;
        private TextView textView8;

        //firebase auth object
        private FirebaseAuth firebaseAuth;

        //progress dialog
        private ProgressDialog progressDialog;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signin);

            //getting firebase auth object
            firebaseAuth = FirebaseAuth.getInstance();

            //if the objects getcurrentuser method is not null
            //means user is already logged in

            //initializing views
            editTextEmail = (EditText) findViewById(R.id.pgemail);
            editTextPassword = (EditText) findViewById(R.id.pgpsw);
            buttonSignIn = (Button) findViewById(R.id.pgbtn);
            textView8  = (TextView) findViewById(R.id.textView8);

            progressDialog = new ProgressDialog(this);

            //attaching click listener
            buttonSignIn.setOnClickListener(this);
            textView8.setOnClickListener(this);
        }

        //method for user login
        private void userLogin(){
            String email = editTextEmail.getText().toString().trim();
            String password  = editTextPassword.getText().toString().trim();


            //checking if email and passwords are empty
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
                return;
            }

            if(TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
                return;
            }

            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();

            //logging in the user
            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            //if the task is successfull
                            if(task.isSuccessful()){
                                //start the profile activity
                                finish();
                              startActivity(new Intent(getApplicationContext(), MainActivity3.class));
                            }
                        }
                    });

        }

        @Override
        public void onClick(View view) {
            if(view == buttonSignIn){
                userLogin();
            }

            if(view == textView8){
                finish();
                startActivity(new Intent(this, signupActivity.class));
            }
        }
    }