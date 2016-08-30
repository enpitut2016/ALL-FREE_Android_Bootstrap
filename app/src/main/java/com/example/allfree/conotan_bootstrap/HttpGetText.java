package com.example.allfree.conotan_bootstrap;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Owner on 2016/08/30.
 */
public class HttpGetText extends AsyncTask<Integer, Void, Void> {

    private String DEFAULTURL = "https://floating-beyond-66396.herokuapp.com/push/conotan";


    private Activity mParentActivity;
    private ProgressDialog mDialog = null;
    private String mUri = null;

    public HttpGetText(Activity parentActivity) {
        this.mParentActivity = parentActivity;
    }

    @Override
    protected void onPreExecute() {
        mDialog = new ProgressDialog(mParentActivity);
        mDialog.setMessage("通信中．．．");
        mDialog.show();
    }

    @Override
    protected Void doInBackground(Integer... arg0) {
        if (arg0[0] == 1) {
            DEFAULTURL = "https://floating-beyond-66396.herokuapp.com/push/wakaran";
        }

        mUri = DEFAULTURL;
        exec_get();
        return null;

    }

    @Override
    protected void onPostExecute(Void result) {
        mDialog.dismiss();
    }

    private String exec_get() {
        HttpURLConnection http = null;
        InputStream in = null;
        String src = "";
        try {
            URL url = new URL(mUri);
            http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
            http.connect();

            in = http.getInputStream();

            byte[] line = new byte[1024];
            int size;
            while (true) {
                size = in.read(line);
                if (size <= 0) {
                    break;
                }
                src += new String(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (http != null) {
                    http.disconnect();
                }
                if (in != null) {
                    in.close();
                }
            } catch (Exception ignored) {
            }
        }
        return src;

    }
}