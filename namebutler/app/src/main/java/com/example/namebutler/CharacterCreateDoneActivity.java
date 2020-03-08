package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CharacterCreateDoneActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_create_done);

        //検索用に名前を取得
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME_DATA");

        // SQLから値取得
        SqlRegister sqlRegister = new SqlRegister();
        Cursor searchDb = sqlRegister.searchDB();

        //それぞれセットする
        TextView name = findViewById(R.id.name);
        TextView job = findViewById(R.id.job);
        TextView hp = findViewById(R.id.hp);
        TextView mp = findViewById(R.id.mp);
        TextView str = findViewById(R.id.str);
        TextView def = findViewById(R.id.def);
        TextView agi = findViewById(R.id.agi);
        TextView luck = findViewById(R.id.luck);

        // 画面に値を表示
        name.setText(searchDb.getString(0));
        job.setText(searchDb.getInt(1));
        hp.setText(searchDb.getInt(2));
        mp.setText(searchDb.getInt(3));
        str.setText(searchDb.getInt(4));
        def.setText(searchDb.getInt(5));
        agi.setText(searchDb.getInt(6));
        luck.setText(searchDb.getInt(7));

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
