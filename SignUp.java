package com.sandbox.mobilemech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    Button btnnext;
    EditText name, emailId, password, cpassword;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name = (EditText) findViewById(R.id.editText);
        emailId = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);
        cpassword = (EditText) findViewById(R.id.editText6);
        btnnext = (Button) findViewById(R.id.button);


        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();
                if (email.isEmpty()) {
                    emailId.setError("Please enter email id");
                    emailId.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please enter your password");
                    password.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(SignUp.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUp.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(SignUp.this, Ginfo.class));

                            }
                        }
                    });
                } else {
                    Toast.makeText(SignUp.this, "Error Occurred!", Toast.LENGTH_SHORT).show();

                }


            }
        });



    }
}

//    private void gotonext() {
//       Intent i=new Intent(this,Ginfo.class);
////        startActivity(i);
//    }

//            @Override
//            public void onClick(View view) {
//                goToNextScreen();
//            }
//        });
//    }
//    private void goToNextScreen()
//
//    {
//        Intent i=new Intent(this,Ginfo.class);
//        startActivity(i);
//    }
//}