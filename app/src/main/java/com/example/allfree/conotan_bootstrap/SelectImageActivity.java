package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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

        double form_button_width = 0.45;
        double form_button_height = 0.15;
        double form_button_font = 0.03;

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

        //送信完了画面に遷移するボタン
        BootstrapButton manual_send_button = (BootstrapButton)findViewById(R.id.manual_send);
        manual_send_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*form_button_font));
        lp = manual_send_button.getLayoutParams();
        lp.height = (int)(height*form_button_height);
        lp.width = (int)(width*form_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/20, 0, 0);
        manual_send_button.setLayoutParams(lp);
        manual_send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(SelectImageActivity.this, FinishAnswering.class);
            startActivity(intent);
            }
        });
    }
}
