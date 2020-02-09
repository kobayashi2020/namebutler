package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CharacterDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        //SQLから一覧を取得

        //画面に表示

//        //「キャラクター」ボタンを押下
//        //キャラ一覧押下で、画面遷移　character_list_btn
//        Button characterListBtn = (Button) findViewById(R.id.character_list_btn);
//        // ボタンに OnClickListener インターフェースを実装する
//        characterListBtn.setOnClickListener(new View.OnClickListener() {
//            // クリック時に呼ばれるメソッド
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.activity_top);
//
//                //呼び出す
//                Intent intent = new Intent(TopActivity.this, CharacterDetailsActivity.class);
//                startActivity(intent);
//            }
//        });

        //「新しく作成する」ボタンを押下
        //キャラ一覧押下で、画面遷移　character_list_btn
        Button createNewBtn = (Button) findViewById(R.id.create_new_btn);
        // ボタンに OnClickListener インターフェースを実装する
        createNewBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //新規作成画面を呼び出す
                Intent intent = new Intent(CharacterDetailsActivity.this, CharacterCreateActivity.class);
                startActivity(intent);
            }
        });

    }
}
