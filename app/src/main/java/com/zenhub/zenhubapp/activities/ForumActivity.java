package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.fragments.HomeFragment;

public class ForumActivity extends AppCompatActivity {

    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        /* Modified by Lunghile on 19 August 2022 */


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);

        // Replacing the default layout on screen with the Home fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(ForumActivity.this, AboutZensarActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(ForumActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(ForumActivity.this, OurAppsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(ForumActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForumActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
            }
        });
    }
}