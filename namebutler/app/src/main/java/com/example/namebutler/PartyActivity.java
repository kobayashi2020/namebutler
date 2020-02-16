package com.example.namebutler;


import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

public class PartyActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstaceState)
    {
        super.onCreate(savedInstaceState);

        setContentView(R.layout.activity_party);

        //アクションバー取得
        ActionBar actionBar = getActionBar();
        //戻るボタンを有効化
        if (actionBar == null) {
            return;
        }
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
}
