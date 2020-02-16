package com.example.namebutler;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BattleResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_result);

        //敵のステータス表示
        //敵1
        TextView enemyMembers1 = findViewById(R.id.enemy_members1);
        //敵2
        TextView enemyMembers2 = findViewById(R.id.enemy_members2);
        //敵3
        TextView enemyMembers3 = findViewById(R.id.enemy_members3);


        //味方のステータス表示
        //仲間メンバー1
        TextView allyMembers1 = findViewById(R.id.ally_members1);
        //仲間メンバー2
        TextView allyMembers2 = findViewById(R.id.ally_members2);
        //仲間メンバー3
        TextView allyMembers3 = findViewById(R.id.ally_members3);


        //再挑戦
        Button challengingAgainBtn = findViewById(R.id.challenging_again_btn);
        // ボタンに OnClickListener インターフェースを実装する
        challengingAgainBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                //【バトルメイン画面】に遷移（同じ敵パーティーと再戦）BattleActivity
                Intent intent = new Intent(BattleResultActivity.this, BattleActivity.class);
                startActivity(intent);
            }
        });

        //次の挑戦へ
        Button battleNextBtn = findViewById(R.id.battle_next_btn);
        // ボタンに OnClickListener インターフェースを実装する
        battleNextBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                //【バトル開始画面】に遷移 BattleStartActivity
                Intent intent = new Intent(BattleResultActivity.this, BattleStartActivity.class);
                startActivity(intent);
            }
        });

        //対戦を終了する
        Button BattleExitBtn = findViewById(R.id.Battle_exit_btn);
        // ボタンに OnClickListener インターフェースを実装する
        BattleExitBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                //【トップ画面】に遷移 TopActivity
                Intent intent = new Intent(BattleResultActivity.this, TopActivity.class);
                startActivity(intent);
            }
        });
    }
}
