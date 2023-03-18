package com.vedant.trufitnetwork;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserLogin extends AppCompatActivity {

    private TextInputEditText etEmail, etPassword;
    private String email, password;
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        getSupportActionBar().hide();

        etEmail = findViewById(R.id.etEmail);
        etPassword= findViewById(R.id.etPassword);

        progressBar = findViewById(R.id.progressBar);
    }
    public void tvSignupClick(View v)
    {
        startActivity(new Intent(this, SignUpActivityUser.class));
    }
    public void btnLoginClick(View v) {
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (email.equals("")) {
            etEmail.setError(getString(R.string.enter_email));
        } else if (password.equals("")) {
            etPassword.setError(getString(R.string.enter_password));
        } else {
            if (Util.connectionAvailable(this)) {
                progressBar.setVisibility(View.VISIBLE);
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            startActivity(new Intent(UserLogin.this, UserDashboard.class));
                            finish();
                        } else {
                            Toast.makeText(UserLogin.this, "Login Failed : " +
                                    task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            } else {
                startActivity(new Intent(UserLogin.this, UserDashboard.class));
            }

        }

    }


    public  void tvResetPasswordClick(View view){
        startActivity(new Intent(UserLogin.this , ResetPasswordActivity.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        if(firebaseUser!=null)
        {
            startActivity(new Intent(UserLogin.this, UserDashboard.class));
            finish();


        }
    }
}
