package com.example.allfree.conotan_bootstrap;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import android.content.Intent;
import android.view.ViewGroup;
import android.view.WindowManager;

import android.widget.TextView;
import android.widget.ImageView;

public class ConotanNoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conotan_notice);

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

        double long_button_width = 0.90;
        double long_button_height = 0.1;
        double long_button_font = 0.025;

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/30);
        lp = textView.getLayoutParams();
        lp.height = height/4;
        lp.width = width;
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/100, 0, 0);
        textView.setLayoutParams(lp);

        ImageView imageView = (ImageView) findViewById(R.id.image);
        lp = imageView.getLayoutParams();
        lp.height = height/3;
        lp.width = width/3;
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(lp);

        BootstrapButton main_button = (BootstrapButton) findViewById(R.id.main);
        main_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*long_button_font));
        lp = main_button.getLayoutParams();
        lp.height = (int)(height*long_button_height);
        lp.width = (int)(width*long_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, 0, 0, height/50);
        main_button.setLayoutParams(lp);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConotanNoticeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        BootstrapButton manual_button = (BootstrapButton) findViewById(R.id.manual);
        manual_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*long_button_font));
        lp = manual_button.getLayoutParams();
        lp.height = (int)(height*long_button_height);
        lp.width = (int)(width*long_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, 0, 0, height/100);
        manual_button.setLayoutParams(lp);
        manual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConotanNoticeActivity.this, ManualListActivity.class);
                startActivity(intent);
            }
        });

    }

}
