package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class StrategyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strategy);

        RadioButton radioBtn1 = findViewById(R.id.radio_btn1);
        RadioButton radioBtn2 = findViewById(R.id.radio_btn2);
        RadioButton radioBtn3 = findViewById(R.id.radio_btn3);
        //作戦内容を回す

        //作戦内容を表示


        //［決定］ボタン
        Button battleStartBtn = findViewById(R.id.battle_start_btn);
        battleStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【バトルメイン画面】に遷移
                Intent intent = new Intent(StrategyActivity.this, BattleActivity.class);
                startActivity(intent);
            }
        });
    }
}
