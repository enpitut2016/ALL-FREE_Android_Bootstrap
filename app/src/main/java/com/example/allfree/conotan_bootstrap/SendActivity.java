package com.example.allfree.conotan_bootstrap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.TypedValue;

import android.view.Display;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;

import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

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
        //マージン設定用
        ViewGroup.LayoutParams lp;
        ViewGroup.MarginLayoutParams mlp;

        double form_button_width = 0.45;
        double form_button_height = 0.15;
        double form_button_font = 0.0375;

        TextView titleText = (TextView)findViewById(R.id.title);
        titleText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/30);
        lp = titleText.getLayoutParams();
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/50, 0, 0);
        titleText.setLayoutParams(lp);

        BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
        send_text.setTextSize(height/40);
        lp = send_text.getLayoutParams();
        lp.height = height/3;
        lp.width = width*9/10;
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/25, 0, 0);
        send_text.setLayoutParams(lp);

        BootstrapButton send_button = (BootstrapButton) findViewById(R.id.send);
        send_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*form_button_font));
        lp = send_button.getLayoutParams();
        lp.height = (int)(height*form_button_height);
        lp.width = (int)(width*form_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/20, 0, 0);
        send_button.setLayoutParams(lp);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
                SpannableStringBuilder sp = (SpannableStringBuilder) send_text.getText();
                Log.v("onCreate", sp.toString());
                SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = data.edit();
                editor.putString("LevelSave", sp.toString());
                editor.apply();
                HttpPostText task = new HttpPostText(SendActivity.this);
                task.execute(sp.toString());

                Intent intent = new Intent(SendActivity.this, FinishedSendingActivity.class);
                intent.putExtra("help_text", sp.toString());
                startActivity(intent);
            }
        });
    }
}