package com.example.yes;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        Button loginButton = findViewById(R.id.loginButton);
        EditText txtName = findViewById(R.id.usernameField);
        EditText password = findViewById(R.id.passwordField);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = txtName.getText().toString();
                String pass = password.getText().toString();

                if(name.length() == 0){
                    txtName.setError(" Username must be filled!");}
                else if(name.length() <= 3){
                    txtName.setError("Username length must be greater than 3!");}
                else if(pass.length() == 0){
                    password.setError("Password must be filled");}
                else{
                    Intent toHome = new Intent(MainActivity.this,Homepage.class);
                    toHome.putExtra("name", name);
                    startActivity(toHome);
                }



            }
        });
    }
}