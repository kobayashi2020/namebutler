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

        //この相手と戦う
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

        //バトルログエリア(「バトルログ」を表示)
        TextView battleLog = findViewById(R.id.battle_log);
        battleLog.setText("ここに表示");

        //［次のターン］ボタン
        Button battleExitBtn = findViewById(R.id.battle_exit_btn);
        battleStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //１ターン分、「戦闘」を進める

                //「バトルログ」の更新

                //勝敗判定チェック
            }
        });
    }
}
