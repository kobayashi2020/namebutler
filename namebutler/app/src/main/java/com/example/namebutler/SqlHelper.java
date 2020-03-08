package com.example.namebutler;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//SQL 登録用
public class SqlHelper extends SQLiteOpenHelper {
    // バージョン
    public static final int DATABASE_VERSION = 1;
    // DB名
    public static final String DATABASE_NAME = "battle_DB.db";

    // コンストラクタ
    public SqlHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // データベース作成・テーブルの作成
    public void onCreate(SQLiteDatabase db) {
        //CHARACTERS_TABLEに追加する
        db.execSQL("create table CHARACTERS_TABLE(" +
                "name varchar primary key, " +
                "job int , " +
                "hp int , " +
                "mp int, " +
                "str int, " +
                "def int, " +
                "agi int, " +
                "luck int, " +
                "create_at datetime " +
                ");" +
                "");
    }

    // データベースが開かれた時に実行される処理
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    /*
     * onUpgradeメソッド
     * onUpgrade()メソッドはデータベースをバージョンアップした時に呼ばれます。
     * 現在のレコードを退避し、テーブルを再作成した後、退避したレコードを戻すなどの処理を行います。
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    // DB         : battle_DB
    // テーブル名  :CHARACTERS_TABLE
    /*mysql> desc CHARACTERS_TABLE;
            +-----------+-------------+------+-----+---------+-------+
            | Field     | Type        | Null | Key | Default | Extra |
            +-----------+-------------+------+-----+---------+-------+
            | name      | varchar(20) | NO   | PRI |         |       |
            | job       | int(11)     | NO   |     | 0       |       |
            | hp        | int(11)     | NO   |     | 0       |       |
            | mp        | int(11)     | NO   |     | 0       |       |
            | str       | int(11)     | NO   |     | 0       |       |
            | def       | int(11)     | NO   |     | 0       |       |
            | agi       | int(11)     | NO   |     | 0       |       |
            | luck      | int(11)     | NO   |     | 0       |       |
            | create_at | datetime    | YES  |     | NULL    |       |
            +-----------+-------------+------+-----+---------+-------+"
   */
}
