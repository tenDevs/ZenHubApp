package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();
                        break;
                    case R.id.nav_Internships:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new InternshipFragment()).commit();
                        break;
                    case R.id.nav_our_apps:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new OurAppsFragment()).commit();
                        break;
                    case R.id.nav_forum:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new ForumFragment()).commit();
                        break;
                }
                return true;
            }
        });

    }


}