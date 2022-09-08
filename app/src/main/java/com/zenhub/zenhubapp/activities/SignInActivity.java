package com.zenhub.zenhubapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.utilities.Utility;

public class SignInActivity extends AppCompatActivity {

    EditText emailEditText,passwordEditText;
    Button loginBtn;

    TextView createAccountTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailEditText = findViewById(R.id.user_email);
        passwordEditText= findViewById(R.id.password_edit_text);
        loginBtn= findViewById(R.id.login_icon_btn);

        createAccountTextView= findViewById(R.id.create_account_btn);


        loginBtn.setOnClickListener((v)-> loginUser());
        createAccountTextView.setOnClickListener((v)->startActivity(new Intent(SignInActivity.this,SignUpActivity.class)));
    }
    void loginUser(){


        String email = emailEditText.getText().toString();
        String password= passwordEditText.getText().toString();

        boolean isValidated = validateData(email,password);
        if(!isValidated){
            return;
        }
        loginAccountInFirebase(email,password);
    }

    void loginAccountInFirebase(String email,String password){
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    //login successful
                    if(firebaseAuth.getCurrentUser().isEmailVerified()){
                        //go to the main activity
                        startActivity(new Intent(SignInActivity.this,MainActivity.class));
                    }else{
                        Utility.showToast(SignInActivity.this,"Email not verified,Please check email and verify");
                    }
                }else{
                    //login failed
                    Utility.showToast(SignInActivity.this,task.getException().getLocalizedMessage());
                }
            }

        });
    }

    boolean validateData(String email,String password){
        //Validate user s data

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email is invalid");
            return false;
        }
        if(password.length()<6){
            passwordEditText.setError("Password length must be 6 or more");
            return false;
        }

        return true;
    }

}