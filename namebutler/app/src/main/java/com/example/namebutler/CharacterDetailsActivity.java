package com.example.namebutler;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.sql.Time;

public class CharacterDetailsActivity extends Activity {
    // SqlHelperクラスを定義
    SqlHelper helper = null;

    String name;
    int job;
    int hp;
    int mp;
    int str;
    int def;
    int agi;
    int luck;
    Time create_at;

    public static String NAME = "";
    public static String JOB = "";
    public static String HP = "";
    public static String MP = "";
    public static String STR = "";
    public static String DEF = "";
    public static String AGI = "";
    public static String LUCK = "";
    public static String CREATE_AT = "";
    public static String URL = "jdbc:mysql://DESKTOP-J7NUHQA:3306/battle_DB?useCursorFetch=true&defaultFetchSize=1000";
    //public static String URL = "jdbc:mysql://localhost/battle_DB";
    public static String USERNAME = "MySQL80";
    public static String PASSWORD = "k_kobayashi";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_details);
        setTitle("キャラ一覧");

        //SQLから一覧を取得
        // ボタン作成・追加
        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);

//        button = new Button(this);
//        button.setText("");
//        LinearLayout.LayoutParams *buttonLayoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT);
//        button.setLayoutParams(buttonLayoutParams);
//        layout.addView(button);
//
//        //DB
//        String sql = "SELECT * FROM battle_DB;";

        // CustomOpenHelperクラスがまだインスタンス化されていなかったらインスタンス化する
        if (helper == null) {
            helper = new SqlHelper(CharacterDetailsActivity.this);
        }

        // データベースを取得する
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            // rawQueryというSELECT専用メソッドを使用してデータを取得する
            //Cursor cursor = db.rawQuery("select name, job, hp,mp,str,def,agi,luck from CHARACTERS_TABLE", null);
            Cursor cursor = db.rawQuery("select name from CHARACTERS_TABLE;", null);
            // Cursorの先頭行がある+かどうか確認
            boolean next = cursor.moveToFirst();

            // 最終的に表示する文字列
            String dispStr = "";

            if(next){
                //カーソルの行数を取得
                int count = cursor.getCount();


                // 取得した全ての行を取得
                while (!next) {
                    // 取得したカラムの順番(0から始まる)と型を指定してデータを取得するmoveToFirst
                    //name
                    String rowdata = cursor.getString(0) + " , ";
                    //job
                    rowdata = rowdata + String.valueOf(cursor.getInt(1)) + " , ";
                    //hp
                    rowdata = rowdata + String.valueOf(cursor.getInt(2)) + " , ";
                    //mp
                    rowdata = rowdata + String.valueOf(cursor.getInt(3)) + " , ";
                    //str
                    rowdata = rowdata +  String.valueOf(cursor.getInt(4)) + " , ";
                    //def
                    rowdata = rowdata +  String.valueOf(cursor.getInt(5)) + " , ";
                    //agi
                    rowdata = rowdata +  String.valueOf(cursor.getInt(6)) + " , ";
                    //luck
                    rowdata  = rowdata + String.valueOf(cursor.getInt(7));
                    dispStr += rowdata + "\n";// \nは改行を表し、複数行取れた場合に一行ごとに改行するため
                    // 次の行が存在するか確認
                    next = cursor.moveToNext();
                }
            }else{

            }

            dispStr += "取得完了";
            // TextViewに取得したデータを表示
            ((Button) findViewById(R.id.character_list_btn)).setText(dispStr);
        } finally {
            // finallyは、tryの中で例外が発生した時でも必ず実行される
            // dbを開いたら確実にclose
            db.close();
        }


//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//
//            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//            PreparedStatement statement = connection.prepareStatement(sql);
//            ResultSet result = statement.executeQuery();

        //ボタン
        //RadioButton characterListBtn = (RadioButton) findViewById(R.id.radio_setting_btn);
//            while (result.next()) {
//                /* 行からデータを取得 */
//                //ボタンに値を設定
//                job = result.getInt("job");
//                hp = result.getInt("hp");
//                mp = result.getInt("mp");
//                str = result.getInt("str");
//                def = result.getInt("def");
//                agi = result.getInt("agi");
//                luck = result.getInt("luck");
//                create_at = result.getTime("create_at");
//                button.setText(result.getString("name") + "\n");
//                button.setText(result.getString("job:" + job + " hp:" + hp + " mp:" + mp + " str:" + str + " def:" + def + " agi:" + agi + " luck:" + luck));
//            }
//            button.setOnClickListener(new View.OnClickListener() {
//                // クリック時に呼ばれるメソッド
//                @Override
//                public void onClick(View view) {
//                    //キャラクター詳細画面を呼び出す
//                    Intent intent = new Intent(CharacterDetailsActivity.this, CharacterMakeActivity.class);
//                    intent.putExtra(JOB,job);
//                    intent.putExtra(HP,hp);
//                    intent.putExtra(MP,mp);
//                    intent.putExtra(STR,str);
//                    intent.putExtra(DEF,def);
//                    intent.putExtra(AGI,agi);
//                    intent.putExtra(LUCK,luck);
//                    intent.putExtra(CREATE_AT,create_at);
//                    startActivity(intent);
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //画面に表示

        //「キャラクター」ボタンを押下
        //キャラ一覧押下で、画面遷移　character_list_btn
        Button characterListBtn = (Button) findViewById(R.id.character_list_btn);
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
