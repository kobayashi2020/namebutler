package com.example.namebutler;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PartyActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.activity_party);

        //アクションバー取得
        ActionBar actionBar = getActionBar();
        //戻るボタンを有効化
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);

        //キャラクター一覧	〔キャラクターテーブル〕から取得したデータを表示

        //キャラクター選択ラジオボタン
        //「キャラクター」を三つ選択
        // 最大選択数チェックによるエラー表示


        //このパーティーで開始(3/3)
        Button partyBtn = findViewById(R.id.party_btn);
        partyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【バトル開始画面】に遷移
                Intent intent = new Intent(PartyActivity.this, BattleStartActivity.class);
                startActivity(intent);
            }
        });
    }
}
