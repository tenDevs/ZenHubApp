package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.adapters.OurAppsAdapter;
import com.zenhub.zenhubapp.fragments.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class OurAppsActivity extends AppCompatActivity {

    List<String> ourAppsTitles;
    RecyclerView recyclerView;
    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_apps);


        /* Modified by Lunghile on 19 August 2022 */

        ourAppsTitles = new ArrayList<>();

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
                        intent = new Intent(OurAppsActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(OurAppsActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(OurAppsActivity.this, OurAppsActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(OurAppsActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurAppsActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
                Intent intent = new Intent(OurAppsActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.ourAppsRecycleView);

        ourAppsTitles.add("ZenLounge+");
        ourAppsTitles.add("ZenFulcrum");
        ourAppsTitles.add("ZenDeavor");
        ourAppsTitles.add("ZenApp");
        ourAppsTitles.add("ZenApp");
        ourAppsTitles.add("ZenApp");

        recyclerView.setLayoutManager(new GridLayoutManager(OurAppsActivity.this, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        OurAppsAdapter ourAppsAdapter = new OurAppsAdapter(OurAppsActivity.this, ourAppsTitles);
        recyclerView.setAdapter(ourAppsAdapter);
        ourAppsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}