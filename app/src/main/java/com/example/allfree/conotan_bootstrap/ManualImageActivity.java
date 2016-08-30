package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ManualImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_image);

        //前のIntentから選択されたマニュアルのタイトルを取得
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        Log.d("URL", url);
        WebView wv = (WebView)findViewById(R.id.webView);
        
        //リンクをタップしたときに標準ブラウザを起動させない
        wv.setWebViewClient(new WebViewClient());

        //. (1) 読み込み時にページ横幅を画面幅に無理やり合わせる
        wv.getSettings().setLoadWithOverviewMode( true );

        //. (2) ワイドビューポートへの対応
        wv.getSettings().setUseWideViewPort( true );

        wv.loadUrl(url);
    }

}
