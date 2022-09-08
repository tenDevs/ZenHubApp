package com.zenhub.zenhubapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.utilities.Utility;

public class SignUpActivity extends AppCompatActivity {

    EditText emailEditText, passwordEditText, confirmPasswordEditText;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEditText = findViewById(R.id.inputUserEmail);
        passwordEditText = findViewById(R.id.inputUserPassword);
        confirmPasswordEditText = findViewById(R.id.inputConfirmPassword);
        registerBtn = findViewById(R.id.registerButton);

        registerBtn.setOnClickListener(v-> createAccount());
    }

    void createAccount(){
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String confirmPassword = confirmPasswordEditText.getText().toString();

        boolean isValidated = validateData(email, password, confirmPassword);
        if(!isValidated){
            return;
        }

        createAccountInFirebase(email,password);

    }

    void createAccountInFirebase(String email, String password){

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //changeInProgress(false);
                        if(task.isSuccessful()){
                            //creating acc is done
                            Utility.showToast(SignUpActivity.this, "The verification email has been sent to the provided email, please confirm");
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.signOut();
                            finish();
                        }
                        else{
                            //failure
                            Utility.showToast(SignUpActivity.this, task.getException().getLocalizedMessage());
                        }
                    }
                }
        );

    }

    boolean validateData(String email, String password, String confirmPassword){

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEditText.setError("Email is invalid");
            return false;
        }
        if(password.length()<6){
            passwordEditText.setError("Password should contain 6 or more letters");
            return false;
        }

        if(!password.equals(confirmPassword)){
            confirmPasswordEditText.setError("The passwords do not match");
            return false;
        }
        return true;
    }
}