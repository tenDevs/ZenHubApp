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

public class AlertsActivity extends AppCompatActivity {

    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);

        /* Modified by Lunghile on 19 August 2022 */


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(AlertsActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(AlertsActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(AlertsActivity.this, OurAppActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(AlertsActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
                Intent intent = new Intent(AlertsActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlertsActivity.this, ProfileActivity.class);
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