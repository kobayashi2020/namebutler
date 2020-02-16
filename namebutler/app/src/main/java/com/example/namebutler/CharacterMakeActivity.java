package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterMakeActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_make);

        //キャラクター情報一覧	〔キャラクターテーブル〕から取得したデータを表示


        //［削除する］ボタン
        Button deleteBtn = findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            // 〔キャラクターテーブル〕からデータを削除


            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【キャラクター一覧画面】に遷移
                Intent intent = new Intent(CharacterMakeActivity.this, CharacterDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
