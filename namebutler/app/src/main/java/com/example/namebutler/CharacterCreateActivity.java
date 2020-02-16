package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CharacterCreateActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_create);
        setTitle("キャラ作成");

        // 入力された文字を取得
        EditText editText = (EditText) findViewById(R.id.name_input_text);
        String nameInputText = editText.getText().toString();
        //最大文字数チェック

        RadioButton fighterBtn = findViewById(R.id.fighter_btn);
        RadioButton wizardBtn = findViewById(R.id.wizard_btn);
        RadioButton priestBtn = findViewById(R.id.priest_btn);
        RadioButton beastBtn = findViewById(R.id.beast_btn);
        // どのボタンを選んだか確認
        RadioGroup professionGrp = findViewById(R.id.profession_grp);
        // 選ばれたIDを選択
        int id = professionGrp.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(id);

        if(radioButton == fighterBtn){
            //戦士
        }else if(radioButton == wizardBtn){
            //魔法使い
        }else if(radioButton == priestBtn){
            //僧侶
        }else if(radioButton == beastBtn){
            //獣使い
        }
        //職業の一覧を表示
        //取得したデータ数に応じてリストの要素数を動的に変更

        //一覧から「職業」を一つ選択



        //作成するボタン
        Button charaCreateBtn = findViewById(R.id.chara_create_btn);
        charaCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //「職業」に応じた「パラメータ」の自動生成

                //〔キャラクターテーブル〕にデータを追加

                //【キャラクター作成完了画面】に遷移
                Intent intent = new Intent(CharacterCreateActivity.this, CharacterCreateDoneActivity.class);
                startActivity(intent);
            }
        });
    }
}
