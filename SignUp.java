package com.sandbox.mobilemech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth. FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private Button btnnext;
    private  EditText username, emailId, password, confirmpwd;
    private TextView textView;
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = (EditText) findViewById(R.id.editText);
        emailId = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        textView=(TextView)findViewById(R.id.textView6);
        btnnext = (Button) findViewById(R.id.button5);
        confirmpwd=(EditText)findViewById(R.id.editText6);



        firebaseAuth=FirebaseAuth.getInstance();
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()){

                    //add data to database
                    String user_email = emailId.getText().toString().trim();
                    String user_password = password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(SignUp.this, Garageinfo.class));
                            }else{
                                    Toast.makeText(SignUp.this, "Login Failed", Toast.LENGTH_SHORT).show();
                                }
                        }
                    });
                }
            }
        });


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,SignIn.class));
            }
        });
    }

    private boolean validate() {

            boolean  result = false;
            String name = username.getText().toString();
            String email = emailId.getText().toString();
            String pwd = password.getText().toString();
            String c_pwd= confirmpwd.getText().toString();
            if (name.isEmpty()) {
                username.setError("Please enter your name");
                username.requestFocus();
            } else if (email.isEmpty()) {
                emailId.setError("Please enter your email id");
                emailId.requestFocus();
            } else if (pwd.isEmpty()) {
                password.setError("Please enter your password");
                password.requestFocus();
            } else if (c_pwd.isEmpty()) {
                confirmpwd.setError("Please confirm your password");
                confirmpwd.requestFocus();
            }else if(!c_pwd .equals(pwd )) {
                confirmpwd.setError("Please confirm your password");
                confirmpwd.requestFocus();
            }
            else {
                result = true;
            }
            return result;


    }
}





