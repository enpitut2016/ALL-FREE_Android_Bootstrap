package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class FinishAnswering extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_answering);

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

        TextView textView = (TextView)findViewById(R.id.finishAnser );
        textView.setText("送信完了！");
        textView.setTextSize(height/30);

        BootstrapButton button_finish = (BootstrapButton)findViewById(R.id.main);
        button_finish.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*return_button_font));
        lp = button_finish.getLayoutParams();
        lp.height = (int)(height*return_button_height);
        lp.width = (int)(width*return_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/5, 0, 0);
        button_finish.setLayoutParams(lp);
        button_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinishAnswering.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }


}
