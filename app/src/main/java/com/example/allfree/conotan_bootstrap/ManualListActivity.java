package com.example.allfree.conotan_bootstrap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ManualListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        // アイテムを追加します
        adapter.add("LINEのスタンプの使い方教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("VimとEmacsどっちがいいのか教えて！");
        adapter.add("自撮りの仕方教えて！");
        ListView listView = (ListView) findViewById(R.id.listView);
        // アダプターの設定
        listView.setAdapter(adapter);
        // リストビューのマニュアルタイトルがクリックされた時に呼び出されるコールバックリスナーを登録します
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ListView listView = (ListView) parent;
                // クリックされたマニュアルタイトルを取得します
                String item = (String) listView.getItemAtPosition(position);
                //マニュアル閲覧ページに遷移
                //[受け渡すデータ] クリックされたマニュアルタイトル
                Intent intent = new Intent(ManualListActivity.this, ShowManualActivity.class);
                intent.putExtra("ManualTitle", item);
                startActivity(intent);
                //Toast.makeText(ManualListActivity.this, item, Toast.LENGTH_LONG).show();
            }
        });
//        // リストビューのアイテムが選択された時に呼び出されるコールバックリスナーを登録します
//        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view,
//                                       int position, long id) {
//                ListView listView = (ListView) parent;
//                // 選択されたアイテムを取得します
//                String item = (String) listView.getSelectedItem();
//                Toast.makeText(ManualListActivity.this, item, Toast.LENGTH_LONG).show();
//            }
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });

    }
}
