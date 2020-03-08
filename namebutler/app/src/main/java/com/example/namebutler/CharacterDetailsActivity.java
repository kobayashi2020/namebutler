package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import static android.icu.text.MessagePattern.ArgType.SELECT;

public class CharacterDetailsActivity extends Activity {
    String name;
    int job;
    int hp;
    int mp;
    int str;
    int def;
    int agi;
    int luck;
    Time create_at;

    public static String NAME ="";
    public static String JOB ="";
    public static String HP ="";
    public static String MP ="";
    public static String STR ="";
    public static String DEF ="";
    public static String AGI="";
    public static String LUCK="";
    public static String CREATE_AT="";
    public static String URL = "jdbc:mysql://localhost/battle_DB";
    public static String USERNAME = "MySQL80";
    public static String PASSWORD = "k_kobayashi";
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);

        //SQLから一覧を取得
        // ボタン作成・追加
        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);

        button = new Button(this);
        button.setText("");
        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        //DB
        String sql = "SELECT * FROM battle_DB;";
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(sql); ) {
            ResultSet result = statement.executeQuery();

            //ボタン
            //RadioButton characterListBtn = (RadioButton) findViewById(R.id.radio_setting_btn);
            while(result.next()){
                /* 行からデータを取得 */
                //ボタンに値を設定
                job =result.getInt("job");
                hp =result.getInt("hp");
                mp =result.getInt("mp");
                str =result.getInt("str");
                def =result.getInt("def");
                agi =result.getInt("agi");
                luck =result.getInt("luck");
                create_at =result.getTime("create_at");
                button.setText(result.getString("name")+"\n");
                button.setText(result.getString("job:"+job+" hp:"+hp+" mp:"+mp+" str:"+str+" def:"+def+" agi:"+agi+" luck:"+luck));
            }
            button.setOnClickListener(new View.OnClickListener() {
                // クリック時に呼ばれるメソッド
                @Override
                public void onClick(View view) {
                    //キャラクター詳細画面を呼び出す
                    Intent intent = new Intent(CharacterDetailsActivity.this, CharacterMakeActivity.class);
                    intent.putExtra(JOB,job);
                    intent.putExtra(HP,hp);
                    intent.putExtra(MP,mp);
                    intent.putExtra(STR,str);
                    intent.putExtra(DEF,def);
                    intent.putExtra(AGI,agi);
                    intent.putExtra(LUCK,luck);
                    intent.putExtra(CREATE_AT,create_at);
                    startActivity(intent);
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //画面に表示

        //「キャラクター」ボタンを押下
        //キャラ一覧押下で、画面遷移　character_list_btn
        TextView characterListBtn = (TextView) findViewById(R.id.character_list_btn);

        // ボタンに OnClickListener インターフェースを実装する
        characterListBtn.setOnClickListener(new View.OnClickListener() {
            // クリック時に呼ばれるメソッド
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_top);
                //呼び出す
                Intent intent = new Intent(CharacterDetailsActivity.this, CharacterDetailsActivity.class);
                startActivity(intent);
            }
        });

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
