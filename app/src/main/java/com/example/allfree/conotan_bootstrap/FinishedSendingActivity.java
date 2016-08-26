package com.example.allfree.conotan_bootstrap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;

import android.content.Intent;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;

public class FinishedSendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_sending);


//        BootstrapButton finish_button = (BootstrapButton)findViewById(R.id.send_finished);
//        finish_button.setTextSize(50);

        TextView help_text = (TextView)findViewById(R.id.help_text);
        Intent intent = getIntent();
        String data = intent.getStringExtra("help_text");
        help_text.setText(data);

        BootstrapButton main_button = (BootstrapButton) findViewById(R.id.main);
        main_button.setTextSize(30);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedSendingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
