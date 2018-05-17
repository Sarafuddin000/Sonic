package org.bitleet.sonic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextName;
    private EditText editTextEmail;
    private EditText editTextMobile;
    private EditText editTextPassword;
    public Button btnSignup, goLogin;
    private FirebaseAuth mAuth;
    public RegisterActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextName = findViewById(R.id.editTextName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextMobile = findViewById(R.id.editTextMobile);
        editTextPassword = findViewById(R.id.editTextPassword);
        btnSignup = findViewById(R.id.buttonSignup);
        goLogin = findViewById(R.id.buttonGoLogin);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null){
            //checking user logged in or not
            finish();
            Intent intent = new Intent(RegisterActivity.this, Dashboard.class);
        }

        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterUser();
            }
        });


    }

    private void RegisterUser(){
        String name = editTextName.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String number = editTextMobile.getText().toString().trim();
        String Password = editTextPassword.getText().toString().trim();

        if (name.isEmpty()){
            editTextName.setError("Full Name required");
            editTextName.requestFocus();
            return;
        }

        if (email.isEmpty()){
            editTextEmail.setError("Enter Email address");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if (number.isEmpty()){
            editTextMobile.setError("Bangladeshi Mobile number required");
            editTextMobile.requestFocus();
            return;
        }
        if (number.length() < 11){
            editTextMobile.setError("Mobile number should be 11 digits");
            editTextMobile.requestFocus();
            return;
        }

        if (Password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (Password.length() < 6){
            editTextPassword.setError("Minimum length of password should be 6.");
            editTextPassword.requestFocus();
        }


        final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Please Wait", "Processing", true);
        (mAuth.createUserWithEmailAndPassword(editTextEmail.getText().toString(), editTextPassword.getText().toString()))
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();

                        if (task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, Dashboard.class);
                            startActivity(intent);
                            finish();
                        }
                        else {
                            Log.e("Error", task.getException().toString());
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
