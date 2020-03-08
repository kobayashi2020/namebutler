package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BattleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        //敵メンバー1
        TextView enemyMembers1 = findViewById(R.id.enemy_members1);

        //敵メンバー2
        TextView enemyMembers2 = findViewById(R.id.enemy_members2);

        //敵メンバー3
        TextView enemyMembers3 = findViewById(R.id.enemy_members3);

        //仲間メンバー1
        TextView allyMembers1 = findViewById(R.id.ally_members1);

        //仲間メンバー2
        TextView allyMembers2 = findViewById(R.id.ally_members2);

        //仲間メンバー3
        TextView allyMembers3 = findViewById(R.id.ally_members3);


        //作戦名create_name
        TextView createName = findViewById(R.id.create_name);
        createName.setText("TODO 作戦名を取得して貼り付け");

        Button battleStartBtn = findViewById(R.id.battle_start_btn);
        battleStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【作戦変更画面】に遷移
                Intent intent = new Intent(BattleActivity.this, StrategyActivity.class);
                startActivity(intent);
            }
        });

        //［次のターン］ボタン
        Button battleExitBtn = findViewById(R.id.battle_exit_btn);
        //ログに出す文字列取得
        String log ="";

        //バトルログを出す
        TextView battleLog = findViewById(R.id.battle_log);
        battleLog.setText(log = log + "ログ");

        //［次のターン］ボタン押下
        battleExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //ターンが20ターン立ったら終了
                //敵または味方が全員死んだら終わり
                if("死んだ" == "死んだ"|| "ターン" == "20" ){
                    //【バトル結果画面】に遷移
                    Intent intent = new Intent(BattleActivity.this, BattleResultActivity.class);
                    intent.putExtra("","");
                    startActivity(intent);
                }else {
                    //１ターン分、「戦闘」を進める

                }
            }
        });
    }
}
