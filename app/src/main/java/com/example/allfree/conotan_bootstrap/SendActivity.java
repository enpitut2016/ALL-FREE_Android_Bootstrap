package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.beardedhen.androidbootstrap.api.defaults.ButtonMode;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;

public class SendActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

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

        double form_button_width = 0.45;
        double form_button_height = 0.15;
        double form_button_font = 0.03;

        BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
        send_text.setTextSize(height/40);
        lp = send_text.getLayoutParams();
        lp.height = height/3;
        lp.width = width*9/10;
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/25, 0, 0);
        send_text.setLayoutParams(lp);

        BootstrapButton send_button = (BootstrapButton) findViewById(R.id.send);
        send_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*form_button_font));
        lp = send_button.getLayoutParams();
        lp.height = (int)(height*form_button_height);
        lp.width = (int)(width*form_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/20, 0, 0);
        send_button.setLayoutParams(lp);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BootstrapEditText send_text = (BootstrapEditText) findViewById(R.id.send_text);
                SpannableStringBuilder sp = (SpannableStringBuilder) send_text.getText();
                Log.v("onCreate", sp.toString());
                Intent intent = new Intent(SendActivity.this, FinishedSendingActivity.class);
                intent.putExtra("help_text", sp.toString());
                startActivity(intent);
            }
        });


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Send Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.allfree.conotan_bootstrap/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Send Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.allfree.conotan_bootstrap/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
