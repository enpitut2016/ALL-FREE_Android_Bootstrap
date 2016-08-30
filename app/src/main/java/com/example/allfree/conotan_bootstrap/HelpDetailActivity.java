package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.text.method.ScrollingMovementMethod;

import com.beardedhen.androidbootstrap.BootstrapButton;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HelpDetailActivity extends AppCompatActivity {
    private static final int RESULT_PICK_IMAGEFILE = 1001;
    private Bitmap Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_detail);

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

        double long_button_width = 0.9;
        double long_button_height = 0.1;
        double long_button_font = 0.025;

//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout_horizontal);
//        lp = linearLayout.getLayoutParams();
//        lp.height = (int)(height*0.50);
//        lp.width = width;
//        mlp = (ViewGroup.MarginLayoutParams)lp;
//        mlp.setMargins(0, height/50, 0, 0);
//        linearLayout.setLayoutParams(lp);

        int textview_width=width/2;

//        ImageView imageView = (ImageView)findViewById(R.id.imageView);
//        lp = imageView.getLayoutParams();
//        //lp.width = (int)(lp.width*((height*0.45)/lp.height));
//        lp.width = (int)(width*0.45);
//        textview_width = (int)(width*0.95-lp.width);
//        lp.height = (int)(height*0.45);
//        //lp.width = width/10*4;
//        mlp = (ViewGroup.MarginLayoutParams)lp;
//        mlp.setMargins(0, 0, 0, 0);
//        imageView.setLayoutParams(lp);

        TextView titleText = (TextView)findViewById(R.id.title);
        titleText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/30);
        lp = titleText.getLayoutParams();
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/100, 0, 0);
        titleText.setLayoutParams(lp);

        SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
        String test_text = data.getString("LevelSave","" );

        TextView textView = (TextView)findViewById(R.id.helptext);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, height/40);
        lp = textView.getLayoutParams();
        lp.height = (int)(height*0.3);
        lp.width = (int)(width*0.95);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/50, 0, height/20);
        textView.setLayoutParams(lp);
        textView.setPadding((int)(width*0.025),(int)(height*0.01),(int)(width*0.025),(int)(height*0.01));
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        //前のIntentから選択されたマニュアルのタイトルを取得
        Intent intent = getIntent();
        String msg = intent.getStringExtra("msg");
        Log.d("URL", msg);

        textView.setText(msg);

        BootstrapButton maemoittayo_button = (BootstrapButton)findViewById(R.id.button_maemoittayo);
        maemoittayo_button.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*long_button_font));
        lp = maemoittayo_button.getLayoutParams();
        lp.height = (int)(height*long_button_height);
        lp.width = (int)(width*long_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/200, 0, 0);
        maemoittayo_button.setLayoutParams(lp);
        maemoittayo_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpGetText task = new HttpGetText(HelpDetailActivity.this);
                task.execute(0);
                Intent intent = new Intent(HelpDetailActivity.this, FinishAnswering.class);
                startActivity(intent);
            }
        });
        BootstrapButton button_ok = (BootstrapButton)findViewById(R.id.button_ok);
        button_ok.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*long_button_font));
        lp = button_ok.getLayoutParams();
        lp.height = (int)(height*long_button_height);
        lp.width = (int)(width*long_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, 0, 0, 0);
        button_ok.setLayoutParams(lp);
        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ACTION_OPEN_DOCUMENT is the intent to choose a file via the system's file browser.
                Intent image_intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);

                // Filter to only show results that can be "opened", such as a
                // file (as opposed to a list of contacts or timezones)
                image_intent.addCategory(Intent.CATEGORY_OPENABLE);

                // Filter to show only images, using the image MIME data type.
                // it would be "*/*".
                image_intent.setType("image/*");

                startActivityForResult(image_intent, RESULT_PICK_IMAGEFILE);
            }
        });

        BootstrapButton button_wakaranai = (BootstrapButton)findViewById(R.id.button_wakaranai);
        button_wakaranai.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (int)(height*long_button_font));
        lp = button_wakaranai.getLayoutParams();
        lp.height = (int)(height*long_button_height);
        lp.width = (int)(width*long_button_width);
        mlp = (ViewGroup.MarginLayoutParams)lp;
        mlp.setMargins(0, height/200, 0, 0);
        button_wakaranai.setLayoutParams(lp);
        button_wakaranai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpGetText task = new HttpGetText(HelpDetailActivity.this);
                task.execute(1);
                //Intent intent = new Intent(HelpDetailActivity.this, RememberActivity.class);
                //startActivity(intent);
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {


        // The ACTION_OPEN_DOCUMENT intent was sent with the request code
        // READ_REQUEST_CODE. If the request code seen here doesn't match, it's the
        // response to some other intent, and the code below shouldn't run at all.
        if (requestCode == RESULT_PICK_IMAGEFILE && resultCode == Activity.RESULT_OK) {
            // The document selected by the user won't be returned in the intent.
            // Instead, a URI to that document will be contained in the return intent
            // provided to this method as a parameter.
            // Pull that URI using resultData.getData().
            Uri uri = null;
            if (resultData != null) {
                uri = resultData.getData();
                Log.i("", "Uri: " + uri.toString());

                try {
                    Image = getBitmapFromUri(uri);
                    FileOutputStream out = null;
                    try {
                        // openFileOutputはContextのメソッドなのでActivity内ならばthisでOK
                        out = this.openFileOutput("image.png", Context.MODE_PRIVATE);
                        Image.compress(Bitmap.CompressFormat.PNG, 100, out);



                        // AsyncTaskManagerに通信させる
                        HttpImagePost task = new HttpImagePost(HelpDetailActivity.this);
                        task.execute("data/data/com.example.allfree.conotan_bootstrap/files/image.png");

                    } catch (FileNotFoundException e) {
                        // エラー処理
                    } finally {
                        if (out != null) {
                            out.close();
                            out = null;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Intent intent = new Intent(HelpDetailActivity.this, SelectImageActivity.class);
        startActivity(intent);
    }
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

}
