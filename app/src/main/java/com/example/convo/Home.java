package com.example.convo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Home extends AppCompatActivity {

    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        logout = findViewById(R.id.logout_button);

        logout.setVisibility(View.GONE);
    }

    private void signOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    public void show_menu(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.profile_menu, popup.getMenu());
        popup.show();

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                if ("Profile".equals(menuItem.toString())) {
                    Toast.makeText(Home.this, "Profile clicked", Toast.LENGTH_SHORT).show();
                    Toast.makeText(Home.this, Objects.requireNonNull(LoginActivity.mAuth.getCurrentUser()).getEmail() + LoginActivity.mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
                }else if("Logout".equals(menuItem.toString())){
                    Toast.makeText(Home.this, "Logout clicked", Toast.LENGTH_SHORT).show();
                    signOut();
                }

                return false;
            }
        });
    }
}