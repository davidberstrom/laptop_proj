package com.axdav.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {
    FirebaseAuth auth;
    FirebaseUser user;
    TextView email,username,password;
    Button reg_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        reg_button = findViewById(R.id.reg_button);

        reg_button.setOnClickListener(v -> {
            String passTxt = password.getText().toString();
            String emailTxt = email.getText().toString();
            String userTxt = username.getText().toString();
            if(passTxt.isEmpty() || emailTxt.isEmpty() || userTxt.isEmpty()){
                Toast empty = Toast.makeText(RegisterActivity.this,"feilds cannot be empty",Toast.LENGTH_SHORT);
                empty.show();
            } else{
                createAcc(userTxt,emailTxt,passTxt);
            }
        });

    }

    private void createAcc(String username,String email,String password){
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(RegisterActivity.this,LoggedInActivity.class);
                    startActivity(intent);
                }else{
                    Toast failed = Toast.makeText(RegisterActivity.this,"Authentication failed",Toast.LENGTH_SHORT);
                   failed.show();
                }
            }
        });
    }
}