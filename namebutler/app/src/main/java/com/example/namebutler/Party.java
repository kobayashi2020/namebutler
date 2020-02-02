package com.example.namebutler;

import java.util.ArrayList;

/**
 * パーティー管理用クラスの作成
 */
public class Party {
    //2.パーティーを管理するための Party クラスを作成する
    //・資料後半にある Party クラスのひな型を利用して作成する
    //

    //======================= // フィールド変数 // =======================
    private ArrayList<Player> members;

    // =======================
    // コンストラクタ
    // =======================
    Party() {
        members = new ArrayList<Player>();
    }
    // ======================= Getter / Setter // =======================
    /** * パーティーメンバーを ArrayList で取得する
     * */
    ArrayList<Player> GetMembers() {
        return members;
    }

    // ======================= // protected メソッド // =======================

    // ======================= // private メソッド // =======================

    // ======================= // public メソッド // =======================
    /** * パーティーにプレイヤーを追加する
     * * @param player : 追加するプレイヤー
     * */
    public void AppendPlayer(Player player) {
        members.add(player);
    }

    /** * パーティーからプレイヤーを離脱させる
     *
     * * @param player : 離脱させるプレイヤー
     * */
    public void RemovePlayer(Player player) {
        members.remove(player);
    }
}

