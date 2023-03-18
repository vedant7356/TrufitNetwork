package com.vedant.trufitnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainDashboardLogin extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard_login);
        getSupportActionBar().hide();

        btn = (Button)findViewById(R.id.go_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (autoCompleteTextView.getText().toString().equals("User")){

                    startActivity(new Intent(getApplicationContext() , UserLogin.class));

                }

                else if (autoCompleteTextView.getText().toString().equals("Fitness Trainer")){

                    Toast.makeText(MainDashboardLogin.this, "Hello", Toast.LENGTH_SHORT).show();

                }

                else{

                    Toast.makeText(MainDashboardLogin.this, "Bye", Toast.LENGTH_SHORT).show();
                }
            }
        });

        autoCompleteTextView = findViewById(R.id.AutoCompleteTextview);
        String[] roles = new String[]{"User","Fitness Trainer","Admin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.dropdown_item, roles);
        autoCompleteTextView.setAdapter(adapter);

//        autoCompleteTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//            }
//        });
    }
}