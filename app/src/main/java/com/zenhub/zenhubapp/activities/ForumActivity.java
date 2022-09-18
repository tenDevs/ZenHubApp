package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.zenhub.zenhubapp.R;

public class ForumActivity extends AppCompatActivity {

    private static final String TAG = "Forum Activity -------- ";
    ImageView toolbarUserBtn;
    ImageView toolbarAlertBtn;
    ImageView toolbarMenuBars;
    View faqLayout;
    ImageButton faqBtn;
    TextView faqDesc;
    boolean isVisible;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        /* Modified by Lunghile on 19 August 2022 */

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        toolbarUserBtn = findViewById(R.id.toolbar_user);
        toolbarAlertBtn = findViewById(R.id.toolbar_alert);
        toolbarMenuBars = findViewById(R.id.toolbar_bars);

        faqLayout = findViewById(R.id.faq_layout);
        faqBtn = findViewById(R.id.faq_layout_btn);
        faqDesc = findViewById(R.id.faq_desc);

        isVisible = false;

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(ForumActivity.this, MainActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_Internships:
                        intent = new Intent(ForumActivity.this, InternshipaActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_our_apps:
                        intent = new Intent(ForumActivity.this, OurAppActivity.class);
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
                Intent intent = new Intent(ForumActivity.this, AlertsActivity.class);
                startActivity(intent);
            }
        });

        toolbarMenuBars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(ForumActivity.this, toolbarMenuBars);
                popupMenu.getMenu().add("Logout");
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getTitle() == "Logout"){
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(ForumActivity.this, SignInActivity.class));
                            finish();
                            return true;
                        }
                        return false;
                    }
                });
            }
        });

        faqLayout.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View view) {
                Log.d(TAG, "you clicked the constarit layout");

                if (faqDesc.getVisibility() == View.GONE) {
                    faqDesc.setVisibility(View.VISIBLE);
                    faqBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24);
                } else if(faqDesc.getVisibility() == View.VISIBLE){
                    faqDesc.setVisibility(View.GONE);
                    faqBtn.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
                }
            }

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}