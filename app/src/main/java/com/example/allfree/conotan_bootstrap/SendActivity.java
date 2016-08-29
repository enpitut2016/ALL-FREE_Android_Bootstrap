package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;

import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.WindowManager;

public class SendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        //ウィンドウサイズの取得
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        int width = size.x;
        int height = size.y;

        BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
        send_text.setTextSize(40);
        send_text.setHeight(height/5);

        BootstrapButton send_button = (BootstrapButton) findViewById(R.id.send);
        send_button.setTextSize(70);
        send_button.setWidth(width*2/3);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
                SpannableStringBuilder sp = (SpannableStringBuilder) send_text.getText();
                Log.v("onCreate", sp.toString());


                Intent intent = new Intent(SendActivity.this, FinishedSendingActivity.class);
                intent.putExtra("help_text", sp.toString());
                startActivity(intent);
            }
        });
    }
}
