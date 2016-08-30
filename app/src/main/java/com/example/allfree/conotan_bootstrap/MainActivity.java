package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.beardedhen.androidbootstrap.BootstrapButton;
import android.widget.ImageView;

import android.view.Display;
import android.view.WindowManager;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.LayoutParams;

import android.content.SharedPreferences;
import android.content.Context;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ウィンドウサイズの取得
        WindowManager wm = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display disp = wm.getDefaultDisplay();
        Point size = new Point();
        disp.getSize(size);
        int width = size.x;
        int height = size.y;
        //マージン設定用
        LayoutParams lp;
        MarginLayoutParams mlp;

        //このたんロゴ
        ImageView img = (ImageView) findViewById(R.id.imageView);
        lp = img.getLayoutParams();
        lp.height = height/6;
        lp.width = lp.height*3; //ロゴの縦横比が1:3
        mlp = (MarginLayoutParams)lp;
        mlp.setMargins(0, height/20, 0, 0);
        img.setLayoutParams(lp);

        //Help画面に遷移するボタン
        BootstrapButton parent_button = (BootstrapButton)findViewById(R.id.parent);
        parent_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/25);
        lp = parent_button.getLayoutParams();
        lp.height = height/5;
        lp.width = width*2/3;
        mlp = (MarginLayoutParams)lp;
        mlp.setMargins(0, height/15, 0, 0);
        parent_button.setLayoutParams(lp);
        parent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SendActivity.class);
                startActivity(intent);
            }
        });

        //マニュアル一覧画面に遷移するボタン
        BootstrapButton manual_button = (BootstrapButton)findViewById(R.id.manual);
        manual_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/25);
        manual_button.setHeight(height/5);
        manual_button.setWidth(width*2/3);
        //マージン
        lp = manual_button.getLayoutParams();
        mlp = (MarginLayoutParams)lp;
        mlp.setMargins(mlp.leftMargin, height/20, mlp.rightMargin, mlp.bottomMargin);
        manual_button.setLayoutParams(mlp);
        //マージン終わり
        manual_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ManualListActivity.class);
                startActivity(intent);
            }
        });

//        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
//        String test = data.getString("LevelSave","");
//        if(test=="") {
//            SharedPreferences.Editor editor = data.edit();
//            editor.putString("LevelSave", "test");
//            editor.apply();
//        }
//
//        String test_text = data.getString("LevelSave","" );
//
//        //通知画面に遷移するボタン
//        BootstrapButton notifications_button = (BootstrapButton)findViewById(R.id.notifications);
//        notifications_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/30);
//        //notifications_button.setText(test_text);
//        lp = notifications_button.getLayoutParams();
//        lp.height = height/7;
//        lp.width = width*2/3;
//        mlp = (MarginLayoutParams)lp;
//        mlp.setMargins(0, height/15, 0, 0);
//        notifications_button.setLayoutParams(lp);
//        notifications_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, HelpDetailActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
