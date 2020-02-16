package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class BattleStartActivity extends Activity {
    TextView enemyLayout1;
    TextView enemyLayout2;
    TextView enemyLayout3;
    TextView allyMembers1;
    TextView allyMembers2;
    TextView allyMembers3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_start);

        //敵パーティー情報
        enemyLayout1 = findViewById(R.id.enemy_members1);
        enemyLayout2 = findViewById(R.id.enemy_members2);
        enemyLayout3 = findViewById(R.id.enemy_members3);

        //自パーティー情報
        allyMembers1 = findViewById(R.id.ally_members1);
        allyMembers2 = findViewById(R.id.ally_members2);
        allyMembers3 = findViewById(R.id.ally_members3);

        //画面表示
        enemyLayout1.setText(""); //敵パーティー情報
        enemyLayout2.setText("");
        enemyLayout3.setText("");
        allyMembers1.setText(""); //自パーティー情報
        allyMembers2.setText("");
        allyMembers3.setText("");

        //この相手と戦う
        Button battleStartBtn = findViewById(R.id.battle_start_btn);
        battleStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【バトルメイン画面】に遷移
                Intent intent = new Intent(BattleStartActivity.this, BattleActivity.class);
                startActivity(intent);
            }
        });

        //相手を選びなおす
        Button reselectBtn = findViewById(R.id.reselect_btn);
        reselectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //敵パーティーを再作成し、画面表示を更新
                //相手選び直す
                //allyMembers1

                //allyMembers2

                //allyMembers3

                //敵パーティー情報 画面表示
                enemyLayout1.setText("");
                enemyLayout2.setText("");
                enemyLayout3.setText("");

            }
        });
    }
}
