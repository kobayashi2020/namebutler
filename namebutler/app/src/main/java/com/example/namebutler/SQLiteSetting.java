package com.example.namebutler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteSetting extends SQLiteOpenHelper {
    // データーベースのバージョン
    private static final int DATABASE_VERSION = 3;
    // データーベース情報を変数に格納
    private static final String DATABASE_NAME = "CHARACTERS.db";
    // テーブル
    private static final String TABLE_NAME = "CHARACTERS";
    // キャラクター名称
    private static final String COLUMN_CHARACTER_NAME = "NAME";
    // 職業：0:戦士,1:魔法使い,2:僧侶…
    private static final String COLUMN_JOB = "JOB";
    // 最大HP
    private static final String COLUMN_HP = "HP";
    // 最大MP
    private static final String COLUMN_MP = "MP";
    // 攻撃力
    private static final String COLUMN_STR = "STR";
    // 防御力
    private static final String COLUMN_DEF = "DEF";
    // 素早さ
    private static final String COLUMN_AGI = "AGI";
    // 運
    private static final String COLUMN_LUCK = "LUCK";
    // キャラクターの作成日
    private static final String COLUMN_CREATE_AT = "CREATE_AT";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;

    SQLiteSetting(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    public void onCreate(SQLiteDatabase db) {

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(
                SQL_DELETE_ENTRIES
        );
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void saveData(SQLiteDatabase db, String title, int score){
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("score", score);

        db.insert("testdb", null, values);
    }
}
