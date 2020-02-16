package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //キャラ一覧押下で、画面遷移　character_list_btn
        Button characterListBtn = findViewById(R.id.character_list_btn);
        // ボタンに OnClickListener インターフェースを実装する
        characterListBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //キャラクター一覧
                Intent intent = new Intent(TopActivity.this, CharacterDetailsActivity.class);
                startActivity(intent);
            }
        });

        //バトル開始押下で、画面遷移　battle_start_btn
        Button battleStartBtn = findViewById(R.id.battle_start_btn);
        // ボタンに OnClickListener インターフェースを実装する
        battleStartBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                //バトル開始画面
                setContentView(R.layout.activity_top);
            }
        });
    }
}
