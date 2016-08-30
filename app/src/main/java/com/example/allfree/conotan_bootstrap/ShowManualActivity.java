package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.beardedhen.androidbootstrap.AwesomeTextView;

public class
ShowManualActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_manual);

        //前のIntentから選択されたマニュアルのタイトルを取得
        Intent intent = getIntent();
        String manualTitle = intent.getStringExtra("ManualTitle");
        AwesomeTextView manualTitleTv = (AwesomeTextView)findViewById(R.id.manualtitle);
        manualTitleTv.setText(manualTitle);
        //manualTitleTv.setTextSize(30);
    }
}
