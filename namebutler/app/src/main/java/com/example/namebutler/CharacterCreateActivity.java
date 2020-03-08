package com.example.namebutler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CharacterCreateActivity extends Activity {
    Context context = null;
    //ユーザー名
    String userName = null;
    //職業名
    String userJobName = null;
    //職業番号
    int userJob = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_create);
        setTitle("キャラ作成");

        context = this;

        // 入力された文字を取得
        EditText editText = (EditText) findViewById(R.id.name_input_text);

        while (true){
            //文字取得
            userName = editText.getText().toString();
            //最大文字数チェック(20)
            if(userName.length()>20){
                //名前が長すぎます
                editText.setText("名前が長いので入力し直して下さい", TextView.BufferType.NORMAL);
            }else{
                break;
            }
        }

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
            userJob = 1;
            userJobName = "戦士";
        }else if(radioButton == wizardBtn){
            //魔法使い
            userJob = 2;
            userJobName = "魔法使い";
        }else if(radioButton == priestBtn){
            //僧侶
            userJob = 3;
            userJobName = "僧侶";
        }else if(radioButton == beastBtn){
            //獣使い
            userJob = 4;
            userJobName = "獣使い";
        }

        //作成するボタン
        Button charaCreateBtn = findViewById(R.id.chara_create_btn);
        charaCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SQLに登録にステータス登録
                NameBattler nameBattler = new NameBattler();
                nameBattler.UseStatus(userName,userJob);

                //【キャラクター作成完了画面】に遷移
                Intent intent = new Intent(CharacterCreateActivity.this, CharacterCreateDoneActivity.class);
                intent.putExtra("USER_NAME_DATA", userName);
                startActivity(intent);
            }
        });
    }
}
