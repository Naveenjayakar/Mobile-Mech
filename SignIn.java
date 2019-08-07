package com.sandbox.mobilemech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignIn extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private EditText email,pwd;
    private Button button;
    private TextView textView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email = (EditText) findViewById(R.id.editText);
        pwd=(EditText)findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button5);
        textView=(TextView)findViewById(R.id.textView20);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user= firebaseAuth.getCurrentUser();
        if (user != null) {                 //checks weather user has already logged in or not
            finish();
            startActivity(new Intent(SignIn.this, Garageinfo.class));
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if ( validate()){
                  progressDialog.setMessage("Logging-In");
                  progressDialog.show();


                  String user_email = email.getText().toString().trim();
                  String user_password = pwd.getText().toString().trim();
                  firebaseAuth.signInWithEmailAndPassword(email.toString(),pwd.toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                      @Override
                      public void onComplete(@NonNull Task<AuthResult> task) {
                          if(task.isSuccessful()) {
                              progressDialog.dismiss();
                              Toast.makeText(SignIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                              startActivity(new Intent(SignIn.this, Garageinfo.class));
                          }else{
                              progressDialog.dismiss();
                              Toast.makeText(SignIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                          }

                      }
                  });
              }

            }


        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignIn.this,SignUp.class));
            }
        });


    }

    private boolean validate() {
        boolean  result = false;
        String e_mail = email.getText().toString();
        String pd = pwd.getText().toString();
        if (e_mail.isEmpty()) {
            email.setError("Please enter your email id");
            email.requestFocus();
        } else if (pd.isEmpty()) {
            pwd.setError("Please enter your password");
            pwd.requestFocus();
        } else {
            result = true;
        }
        return result;
    }


}
