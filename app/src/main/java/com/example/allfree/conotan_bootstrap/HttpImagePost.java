package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Owner on 2016/08/29.
 */

public class HttpImagePost extends AsyncTask<String, Void, String> {

    private Activity mParentActivity;
    private ProgressDialog mDialog = null;

    public HttpImagePost(Activity parentActivity) {
        this.mParentActivity = parentActivity;
    }

    @Override
    protected void onPreExecute() {
        mDialog = new ProgressDialog(mParentActivity);
        mDialog.setMessage("通信中．．．");
        mDialog.show();
    }

    @Override
    protected String doInBackground(String... ImagePath) {
        //mUri = DEFAULTURL + "num=" + arg0[0].toString() + "&stat=" + arg0[1].toString() + "&pwm=1023" ;
        //exec_get();
        //doPost(arg0[0].toString(), arg0[1].toString());
        //return null;

        //ポスト先のURL
        String url = "https://floating-beyond-66396.herokuapp.com/upload";

        File file = new File(ImagePath[0]);
        Log.d("filename", file.getPath());

        //ここでPOSTする内容を設定　"image/jpg"の部分は送りたいファイルの形式に合わせて変更する
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("uploadfile", file.getName(), RequestBody.create(MediaType.parse("image/png"), file))
                .build();

        Log.d("requestBody", requestBody.toString());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Log.d("request", request.toString());

        String result="";
        Log.d("test","aaaa");

        try {
            Response response = client.newCall(request).execute();
            response.close();
            Log.d("test2","bb");
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
            {
                result = response.body().string();
            }
        } catch (Exception e) {}

        Log.d("result", result);

        return result;

    }
}
