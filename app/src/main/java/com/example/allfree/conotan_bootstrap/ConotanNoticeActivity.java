package com.example.allfree.conotan_bootstrap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import android.content.Intent;

public class ConotanNoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conotan_notice);

        BootstrapButton main_button = (BootstrapButton) findViewById(R.id.main);
        main_button.setTextSize(35);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConotanNoticeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        BootstrapButton manual_button = (BootstrapButton) findViewById(R.id.manual);
        manual_button.setTextSize(35);
        manual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConotanNoticeActivity.this, ManualListActivity.class);
                startActivity(intent);
            }
        });

    }

}
