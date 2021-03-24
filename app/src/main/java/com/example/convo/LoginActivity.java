package com.example.convo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login_button;
    EditText email, password;

    LinearLayout animation_view, login_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_field);
        password = findViewById(R.id.password_field);

        animation_view = findViewById(R.id.animation_layout);
        login_layout = findViewById(R.id.login_layout);

        login_button = findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Clicked!", Toast.LENGTH_SHORT).show();
                animation_view.setVisibility(View.VISIBLE);
                login_layout.setVisibility(View.GONE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        startActivity(new Intent(getApplicationContext(), Home.class));
                    }
                }, 5500);

            }
        });
    }
}