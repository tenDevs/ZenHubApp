package com.zenhub.zenhubapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zenhub.zenhubapp.R;

public class OurAppActivity extends AppCompatActivity {
    TextView talentText, successText, zenLoungeText, hrmsText, timesheetText, zenDevorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_app);

        talentText = findViewById(R.id.talent_text);
        successText = findViewById(R.id.success_text);
        zenLoungeText = findViewById(R.id.zenlounge_text);
        hrmsText = findViewById(R.id.hrms_text);
        timesheetText = findViewById(R.id.timesheet_text);
        zenDevorText = findViewById(R.id.zenD_text);

        talentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://zenebiz.zensar.com/OA_HTML/");

            }
        });
        successText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://performancemanager8.successfactors.com/");

            }
        });
        zenLoungeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://zenloungeplus.zensar.com/");

            }
        });
        hrmsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://zenebiz.zensar.com/OA_HTML/");

            }
        });
        timesheetText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://timesheet.zensar.com");

            }
        });
        zenDevorText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://zendeavor.zensar.com/zendeavor/dashboard");

            }
        });


    }
    private void gotoUrl(String s)
    {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}