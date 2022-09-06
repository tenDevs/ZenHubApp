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
import com.zenhub.zenhubapp.fragments.ForumFragment;
import com.zenhub.zenhubapp.fragments.HomeFragment;
import com.zenhub.zenhubapp.fragments.InternshipFragment;
import com.zenhub.zenhubapp.fragments.OurAppsFragment;

public class ProfileActivity extends AppCompatActivity {

    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        /* Modified by Lunghile on 19 August 2022 */


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);

        // Replacing the default layout on screen with the Home fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(ProfileActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(ProfileActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(ProfileActivity.this, OurAppsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(ProfileActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
                Intent intent = new Intent(ProfileActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}