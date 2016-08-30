package com.example.allfree.conotan_bootstrap;

import android.app.Application;

/**
 * Created by ntoeda on 16/08/29.
 */

//ボタンサイズ&フォントサイズ用のグローバス変数群
public class Globals extends Application {
    double return_button_width = 0.35;
    double return_button_height = 0.1;
    double return_button_font = 0.02;
    double long_button_width = 0.9;
    double long_button_height = 0.1;
    double long_button_font = 0.02;
    double form_button_width = 0.45;
    double form_button_height = 0.15;
    double form_button_font = 0.03;

    public void globals(){
        //戻るボタン
        return_button_width=0.5;
        return_button_height=0.1;
        return_button_font=0.02;

        //細長いボタン
        long_button_width=0.9;
        long_button_height=0.1;
        long_button_font=0.02;

        //「送る」ボタン的なやつ
        form_button_width=0.5;
        form_button_height=0.15;
        form_button_font=0.02;

    }
}
