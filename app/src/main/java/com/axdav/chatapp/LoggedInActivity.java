package com.axdav.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoggedInActivity extends AppCompatActivity {
    FirebaseUser currUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        currUser = FirebaseAuth.getInstance().getCurrentUser();
        Toast t = Toast.makeText(LoggedInActivity.this,"Welcome"+" " +currUser.getEmail(),Toast.LENGTH_LONG);
        t.show();
    }
}