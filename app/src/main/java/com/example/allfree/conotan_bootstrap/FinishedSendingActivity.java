package com.example.allfree.conotan_bootstrap;

import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

import android.content.Intent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class FinishedSendingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_sending);

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

        double return_button_width = 0.35;
        double return_button_height = 0.1;
        double return_button_font = 0.02;


//        BootstrapButton finish_button = (BootstrapButton)findViewById(R.id.send_finished);
//        finish_button.setTextSize(50);

        TextView help_text = (TextView)findViewById(R.id.help_text);
        Intent intent = getIntent();
        String data = intent.getStringExtra("help_text");
        help_text.setText(data);
        help_text.setTextSize(height/35);

        TextView help_title = (TextView)findViewById(R.id.help_title);
        help_title.setTextSize(height/40);

        TextView help_info = (TextView)findViewById(R.id.help_info);
        help_info.setTextSize(height/50);

        BootstrapButton main_button = (BootstrapButton) findViewById(R.id.main);
        main_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*return_button_font));
        lp = main_button.getLayoutParams();
        lp.height = (int)(height*return_button_height);
        lp.width = (int)(width*return_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/7, 0, 0);
        main_button.setLayoutParams(lp);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishedSendingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

}
