package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class FinishAnswering extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_answering);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        //ウィンドウサイズの取得
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        int width = size.x;
        int height = size.y;

        TextView textView = (TextView)findViewById(R.id.finishAnser );
        textView.setText("送信完了！");
        textView.setTextSize(70);

        BootstrapButton button_finish = (BootstrapButton)findViewById(R.id.main);
        button_finish.setTextSize(50);
        button_finish.setWidth(width/3);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishAnswering.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }


}
