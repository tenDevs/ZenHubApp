package com.zenhub.zenhubapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.zenhub.zenhubapp.R;
import com.zenhub.zenhubapp.adapters.HomeItemsAdapter;
import com.zenhub.zenhubapp.fragments.ForumFragment;
import com.zenhub.zenhubapp.fragments.HomeFragment;
import com.zenhub.zenhubapp.fragments.InternshipFragment;
import com.zenhub.zenhubapp.fragments.OurAppsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> listTitles;
    List<Integer> listIcons;
    RecyclerView recyclerView;
    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    ImageView toolbarMenuBars;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Modified by Lunghile on 19 August 2022 */

        listTitles = new ArrayList<>();
        listIcons = new ArrayList<>();
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);
        toolbarMenuBars = findViewById(R.id.toolbar_bars);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(MainActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(MainActivity.this, OurAppActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_forum:
                        intent = new Intent(MainActivity.this, ForumActivity.class);
                        startActivity(intent);
                        break;
                }
                return true;
            }
        });

        toolbarUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        toolbarAlertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // got alerts intent
                Intent intent = new Intent(MainActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

        toolbarMenuBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, toolbarMenuBars);
                popupMenu.getMenu().add("Logout");
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getTitle() == "Logout"){
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(MainActivity.this, SignInActivity.class));
                            finish();
                            return true;
                        }
                        return false;
                    }
                });
            }
        });

        listTitles.add(getString(R.string.about_zensar));
        listTitles.add(getString(R.string.work_shop));
        listTitles.add(getString(R.string.faqs));
        listTitles.add("Service Desk");

        listIcons.add(R.drawable.ic_baseline_info_24);
        listIcons.add(R.drawable.ic_baseline_store_24);
        listIcons.add(R.drawable.ic_baseline_help_24);
        listIcons.add(R.drawable.ic_baseline_phone_enabled_24);

        recyclerView = findViewById(R.id.HomeRecyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        HomeItemsAdapter homeItemsAdapter = new HomeItemsAdapter(MainActivity.this, listTitles, listIcons);
        recyclerView.setAdapter(homeItemsAdapter);
        homeItemsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}