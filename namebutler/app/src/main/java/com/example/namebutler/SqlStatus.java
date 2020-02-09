package com.example.namebutler;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//SQLの制御をするクラス
public class SqlStatus extends SQLiteOpenHelper {

    // データベース自体の名前(テーブル名ではない)
    static final private String DBName = "main";
    // データベースのバージョン(2,3と挙げていくとonUpgradeメソッドが実行される)
    static final private int VERSION = 1;

    // コンストラクタ　以下のように呼ぶこと
    public SqlStatus(Context context){
        super(context, DBName, null, VERSION);
    }

    // データベースが作成された時に実行される処理
    @Override
    public void onCreate(SQLiteDatabase db) {
        // テーブルを作成。SQLの文法は通常のSQLiteと同様
        db.execSQL(
                "create table characters_table ("
                        + "_id  integer primary key autoincrement not null, "
                        + "name text not null, "
                        + "job int not null, "
                        + "hp int not null, "
                        + "mp int not null, "
                        + "str int not null, "
                        + "def int not null, "
                        + "agi int not null, "
                        + "luck int not null, "
                        + "job int not null, "
                        + "create_at Date)" );
    }

    public void doAddEntry(SQLiteDatabase db,String name, int job, int hp, int mp, int str, int def, int agi, int luck, int createAt) {
        // 挿入するデータはContentValuesに格納
        ContentValues val = new ContentValues();
        val.put( "name", name );
        val.put( "job" , job  );
        val.put( "hp", hp );
        val.put( "mp" , mp  );
        val.put( "str", str );
        val.put( "def" , def  );
        val.put( "agi", agi );
        val.put( "luck" , luck  );
        val.put( "create_at", createAt );

        // “name_book_table”に1件追加
        db.insert( "characters_table", null, val );
    }

    // データベースをバージョンアップした時に実行される処理
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
    }


    // データベースが開かれた時に実行される処理
    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
