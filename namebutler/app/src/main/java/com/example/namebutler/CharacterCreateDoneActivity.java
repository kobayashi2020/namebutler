package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterCreateDoneActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_create_done);

        //［続けて作成する］ボタン
        Button createNextBtn = findViewById(R.id.create_next_btn);
        createNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【キャラクター作成画面】に遷移
                Intent intent = new Intent(CharacterCreateDoneActivity.this, CharacterCreateActivity.class);
                startActivity(intent);
            }
        });

        //［作成を終了する］ボタン
        Button createExitBtn = findViewById(R.id.create_exit_btn);
        createExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //【キャラクター一覧画面】に遷移
                Intent intent = new Intent(CharacterCreateDoneActivity.this, CharacterDetailsActivity.class);
                startActivity(intent);
            }
        });
    }




}
