package com.example.allfree.conotan_bootstrap;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

public class ManualImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_image);

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
        double return_button_font = 0.025;

        //前のIntentから選択されたマニュアルのタイトルを取得
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("URL", url);
        WebView wv = (WebView)findViewById(R.id.webView);
        
        //リンクをタップしたときに標準ブラウザを起動させない
        wv.setWebViewClient(new WebViewClient(){
            ProgressDialog loading = new ProgressDialog(ManualImageActivity.this);
            public void onPageFinished(final WebView view, final String url) {
                if (loading.isShowing()) {
                    loading.dismiss();
                }
            };

            public void onPageStarted(WebView view, String url, android.graphics.Bitmap favicon) {
                loading.show();
            };
        });

        //. (1) 読み込み時にページ横幅を画面幅に無理やり合わせる
        wv.getSettings().setLoadWithOverviewMode( true );

        //. (2) ワイドビューポートへの対応
        wv.getSettings().setUseWideViewPort( true );

        wv.loadUrl(url);


        BootstrapButton main_button = (BootstrapButton) findViewById(R.id.main);
        main_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*return_button_font));
        lp = main_button.getLayoutParams();
        lp.height = (int)(height*return_button_height);
        lp.width = (int)(width*return_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/30, 0, 0);
        main_button.setLayoutParams(lp);
        main_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManualImageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
