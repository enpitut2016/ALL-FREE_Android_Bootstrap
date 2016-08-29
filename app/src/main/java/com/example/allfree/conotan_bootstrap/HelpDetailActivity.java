package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

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

        TextView textView = (TextView)findViewById(R.id.helptext);
        textView.setText("LINEスタンプの使い方教えて");
        textView.setTextSize(50);

        BootstrapButton parent_button = (BootstrapButton)findViewById(R.id.button_maemoittayo);
        parent_button.setTextSize(50);
        parent_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpGetTask task = new HttpGetTask(HelpDetailActivity.this);
                task.execute(0, 9);
                Intent intent = new Intent(HelpDetailActivity.this, FinishAnswering.class);
                startActivity(intent);
            }
        });
        BootstrapButton button_ok = (BootstrapButton)findViewById(R.id.button_ok);
        button_ok.setTextSize(50);
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
        button_wakaranai.setTextSize(50);
        button_wakaranai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
