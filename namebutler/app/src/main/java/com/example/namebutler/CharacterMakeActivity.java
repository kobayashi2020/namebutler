package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

public class CharacterMakeActivity extends Activity {
    String name =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_make);

        //キャラクター情報一覧	〔キャラクターテーブル〕から取得したデータを表示
        Intent intent = getIntent();
         name =intent.getStringExtra(CharacterDetailsActivity.NAME);
        TextView textView = findViewById(R.id.name);
        textView.setText(name);
        textView = findViewById(R.id.profession);
        textView.setText(intent.getStringExtra(CharacterDetailsActivity.JOB));
        textView = findViewById(R.id.hp);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.HP,0));
        textView = findViewById(R.id.mp);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.MP,0));
        textView = findViewById(R.id.str);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.STR,0));
        textView = findViewById(R.id.def);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.DEF,0));
        textView = findViewById(R.id.agi);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.AGI,0));
        textView = findViewById(R.id.luck);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.LUCK,0));
        textView = findViewById(R.id.data);
        textView.setText(intent.getIntExtra(CharacterDetailsActivity.CREATE_AT,0));

        //［削除する］ボタン
        Button deleteBtn = findViewById(R.id.delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    // 〔キャラクターテーブル〕からデータを削除
                    String sql = "DELETE FROM CHARACTERS_TABLE WHERE name = ?";
                    Connection conn = DriverManager.getConnection(CharacterDetailsActivity.URL, CharacterDetailsActivity.USERNAME, CharacterDetailsActivity.PASSWORD);
                    conn.setAutoCommit(false);
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps = conn.prepareStatement(sql);
                    ps.setString(1, name);

                    //DELETE文を実行する
                    ps.executeUpdate();
                }catch(SQLException e){
                    e.printStackTrace();
                }
                setContentView(R.layout.activity_top);
                //【キャラクター一覧画面】に遷移
                Intent intent = new Intent(CharacterMakeActivity.this, CharacterDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
