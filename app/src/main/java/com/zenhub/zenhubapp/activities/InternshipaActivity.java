package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.adapters.InternshipsAdapter;

import java.util.ArrayList;
import java.util.List;

public class InternshipaActivity extends AppCompatActivity {

    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    Intent intent;

    List<String> internshipTitle;
    List<String> internshipCompany;
    List<String> internshipLocation;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internshipa);


        /* Modified by Lunghile on 19 August 2022 */


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);

        internshipTitle = new ArrayList<>();
        internshipCompany = new ArrayList<>();
        internshipLocation = new ArrayList<>();

        // Replacing the default layout on screen with the Home fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new HomeFragment()).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(InternshipaActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(InternshipaActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(InternshipaActivity.this, OurAppActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(InternshipaActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InternshipaActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
                Intent intent = new Intent(InternshipaActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

        internshipTitle.add("Android Developer");
        internshipTitle.add("Java Developer");
        internshipTitle.add("Mainframe developer");
        internshipTitle.add("Web Developer");

        internshipCompany.add("Zensar Technologies");
        internshipCompany.add("FNB");
        internshipCompany.add("Discovery");
        internshipCompany.add("Deloitte");

        internshipLocation.add("JHB");
        internshipLocation.add("Cape Town");
        internshipLocation.add("Durban");
        internshipLocation.add("JHB");

        recyclerView = findViewById(R.id.internshipsRecycleView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        InternshipsAdapter internshipsAdapter = new InternshipsAdapter(InternshipaActivity.this, internshipTitle, internshipCompany, internshipLocation);
        recyclerView.setAdapter(internshipsAdapter);
        internshipsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}