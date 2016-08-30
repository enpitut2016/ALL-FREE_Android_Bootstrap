package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Owner on 2016/08/30.
 */
public class HttpPostText extends AsyncTask<String, Void, Void> {
    private Activity mParentActivity;
    private ProgressDialog mDialog = null;
    private String mUri =null;

    public HttpPostText(Activity parentActivity) {
        this.mParentActivity = parentActivity;
    }

    @Override
    protected void onPreExecute() {
        mDialog = new ProgressDialog(mParentActivity);
        mDialog.setMessage("通信中．．．");
        mDialog.show();
    }

    @Override
    protected Void doInBackground(String... arg0) {

        doPost(arg0[0]);
        return null;
    }

    private void doPost(String text)  {
        String url = "https://floating-beyond-66396.herokuapp.com/pushparent/help";
        String sendtext = "name=" + text;

        Log.d("text", sendtext);

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            //conn.setRequestProperty("Content-Length", Integer.toString(text.length()));
            Log.i("OSA030","doPost start.:" + conn.toString());

            conn.connect();

            OutputStream os = conn.getOutputStream();
            os.write(sendtext.getBytes("UTF-8"));
            os.flush();
            os.close();

            Log.d("STATUS CODE",""+conn.getResponseCode());

            if( conn.getResponseCode() == HttpURLConnection.HTTP_OK ){
                StringBuffer temp = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    temp.append(inputLine);
                }
                Log.i("OSA030", "doPost success");
            }

        }catch(IOException e){
            Log.e("OSA030","error orz:" + e.getMessage(), e);
        }finally {
            if( conn != null ){
                conn.disconnect();
            }
        }
    }
}