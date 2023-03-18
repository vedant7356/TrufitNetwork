package com.vedant.trufitnetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SampleAddData extends AppCompatActivity {
    TextInputEditText fullname,like_count,comment_count,caption;

    Button createPostBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_add_data);

        fullname = findViewById(R.id.fnameEt);
        like_count = findViewById(R.id.likeEt);
        comment_count = findViewById(R.id.commentEt);
        caption = findViewById(R.id.captionEt);
        createPostBtn = findViewById(R.id.postBtn);

        createPostBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullnameData = fullname.getText().toString();
                String captionData = caption.getText().toString();
                String like_countData = comment_count.getText().toString();
                String comment_countData = comment_count.getText().toString();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Posts").push();
                ref.child("full_name").setValue(fullnameData);
                ref.child("caption").setValue(captionData);
                ref.child("like_count").setValue(like_countData);
                ref.child("comment_count").setValue(comment_countData);
                Toast.makeText(SampleAddData.this, "Post Created", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void postActivity(View view) {
       // startActivity(new Intent(SampleAddData.this,PostActivity.class));
    }
}