package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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

        ImageView manualImage = (ImageView)findViewById(R.id.manual_img);
        switch (manualTitle){
            case "LINEの着せ替えの仕方教えて！":
                manualImage.setImageResource(R.drawable.line_kisekae);
                break;
            case "アラートを毎週に設定する方法教えて！":
                manualImage.setImageResource(R.drawable.alarm_maishu);
                break;
            case "カメラを内側にしたい！":
                manualImage.setImageResource(R.drawable.camera_incame);
                break;
            case "自撮りの仕方教えて！":
                manualImage.setImageResource(R.drawable.camera_self);
                break;
            case "LINEで画像を送信したい！":
                manualImage.setImageResource(R.drawable.line_gazou);
                break;
            case "マップで経路を検索したい！":
                manualImage.setImageResource(R.drawable.map_keiro);
                break;
        }
        //manualTitleTv.setTextSize(30);
    }
}
