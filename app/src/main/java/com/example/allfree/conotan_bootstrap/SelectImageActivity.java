package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapThumbnail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SelectImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);

        //アプリ内に保存した選択された画像を取得
        InputStream input = null;
        try {
            input = this.openFileInput("image.png");
        } catch (FileNotFoundException e) {
            // エラー処理
        }
        //Bitmapに変換
        Bitmap image = BitmapFactory.decodeStream(input);
        ImageView iv = (ImageView)findViewById(R.id.manual_image);
        iv.setImageBitmap(image);

        //Help画面に遷移するボタン
        BootstrapButton manual_send_button = (BootstrapButton)findViewById(R.id.manual_send);
        manual_send_button.setTextSize(50);
        manual_send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(SelectImageActivity.this, SendActivity.class);
            startActivity(intent);
            }
        });
    }
}
