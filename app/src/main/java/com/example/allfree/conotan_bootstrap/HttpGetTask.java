package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by tsuruda_tomohiro on 2016/08/29.
 */
public class HttpGetTask extends AsyncTask<String, Void, Void> {
    private final String DEFAULTURL = "https://fcm.googleapis.com/fcm/send";

    private Activity mParentActivity;
    private ProgressDialog mDialog = null;
    private String mUri =null;

    public HttpGetTask(Activity parentActivity) {
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
        //mUri = DEFAULTURL + "num=" + arg0[0].toString() + "&stat=" + arg0[1].toString() + "&pwm=1023" ;
        //exec_get();
        doPost(arg0[0].toString(), arg0[1].toString());
        return null;

    }
    @Override
    protected void onPostExecute(Void result) {
        mDialog.dismiss();
    }

//    private String exec_get() {
//        HttpURLConnection http = null;
//        InputStream in =null;
//        String src = "";
//        try {
//            URL url = new URL(mUri);
//            http = (HttpURLConnection) url.openConnection();
//            http.setRequestMethod("GET");
//            http.connect();
//
//            in = http.getInputStream();
//
//            byte[] line = new byte[1024];
//            int size;
//            while (true) {
//                size = in.read(line);
//                if(size <= 0) {
//                    break;
//                }
//                src += new String(line);
//            }
//        }catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (http != null) {
//                    http.disconnect();
//                }
//                if (in != null) {
//                    in.close();
//                }
//            } catch(Exception ignored) {
//            }
//        }
//        return src;
//
//    }

    private void doPost(String title, String content)  {
        String url = "https://fcm.googleapis.com/fcm/send";
        String requestJSON = "{\"to\":\"ey4GCB8DgII:APA91bFgO-PxuYuwGOmKofdTIIsaraAsSk4iE97N0rd4gFhRKYs_YkMhvjs3BI6FbUANubsATKj76jqfNi4YpmVsj3xokswVlGx03vSR3hpGP5Jsp60fvzPnaixL2bXGhSy_5F_q46sS\",\"notification\":{\"body\":\""+content+"\",\"title\":\""+title+"\"}}";

        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(requestJSON.getBytes().length);
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Authorization", "key=AIzaSyDKRVv3Yt1KEPCcmPHNX0q2gsYSEfWGV4g");
            Log.i("OSA030","doPost start.:" + conn.toString());

            conn.connect();

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.write(requestJSON.getBytes("UTF-8"));
            os.flush();
            os.close();
            Log.d("STATUS CODE",""+conn.getResponseCode());
            if( conn.getResponseCode() == HttpURLConnection.HTTP_OK ){
                StringBuffer responseJSON = new StringBuffer();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    responseJSON.append(inputLine);
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
