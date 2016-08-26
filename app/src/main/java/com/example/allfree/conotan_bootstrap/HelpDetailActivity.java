package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class HelpDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView)findViewById(R.id.helptext);
        textView.setText("LINEスタンプの使い方教えて");
        textView.setTextSize(50);

        BootstrapButton parent_button = (BootstrapButton)findViewById(R.id.button_maemoittayo);
        parent_button.setTextSize(50);
        parent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDetailActivity.this, RememberActivity.class);
                startActivity(intent);
            }
        });
        BootstrapButton button_ok = (BootstrapButton)findViewById(R.id.button_ok);
        button_ok.setTextSize(50);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HelpDetailActivity.this, SelectImageActivity.class);
                startActivity(intent);
            }
        });





        BootstrapButton button_wakaranai = (BootstrapButton)findViewById(R.id.button_wakaranai);
        button_wakaranai.setTextSize(50);
        button_wakaranai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(HelpDetailActivity.this, RememberActivity.class);
                //startActivity(intent);
            }
        });



    }

}
