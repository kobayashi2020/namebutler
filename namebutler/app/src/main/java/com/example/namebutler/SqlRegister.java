package com.example.namebutler;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class SqlRegister extends Activity {
    SqlHelper helper;
    SQLiteDatabase db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sql
        helper = new SqlHelper(this);
        db = helper.getWritableDatabase();
    }

    // 検索(Search)
    public Cursor searchDB() {
        String colomn[] = new String[]{"name, job, hp, mp, str, def, agi ,luck, create_at"};

        Cursor cursor = db.query(true,
                "CHARACTERS_TABLE",
                colomn,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }

    // 登録(insert)
    public void insertDB(String name, int job, int hp, int mp, int str, int def, int agi, int luck, String create_at) {
        ContentValues insertValue = new ContentValues();
        insertValue.put("name", name);
        insertValue.put("job", job);
        insertValue.put("hp", hp);
        insertValue.put("mp", mp);
        insertValue.put("str", str);
        insertValue.put("def", def);
        insertValue.put("agi", agi);
        insertValue.put("luck", luck);
        insertValue.put("create_at", create_at);
        db.insert("CHARACTERS_TABLE", "", insertValue);
    }

    // 更新(update)
    public void updateDB(String name, int job, int hp, int mp, int str, int def, int agi, int luck, String create_at) {
        ContentValues insertValue = new ContentValues();
        insertValue.put("name", name);
        insertValue.put("job", job);
        insertValue.put("hp", hp);
        insertValue.put("mp", mp);
        insertValue.put("str", str);
        insertValue.put("def", def);
        insertValue.put("agi", agi);
        insertValue.put("luck", luck);
        insertValue.put("create_at", create_at);
        db.update("test_db", insertValue, "name" + name, null);
    }

    // 削除(delete)
    public void deleteDB(String name) {
        // テーブルの値削除
        db.delete("test_db", "name = " + name, null);
    }
}
