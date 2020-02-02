package com.example.namebutler;

/**
 * 剣士
 */
public class ProfessionFighter extends Player {

    // =======================
    // フィールド変数
    // =======================


    // =======================
    // コンストラクタ
    // =======================
    public ProfessionFighter(String name)
    {
        super(name);
    }


    // =======================
    // Getter / Setter
    // =======================


    // =======================
    // protected メソッド
    // =======================
    /**
     * 名前(name)からキャラクターに必要なパラメータを生成する
     */
    protected void MakeCharacter()
    {
        //職業:戦士
        // 戦士のパラメータを名前から生成する
        this.hp = GetNumber(2, 300);  //HP:100～300
        this.str = GetNumber(1, 100); //STR:30～100
        this.def = GetNumber(2, 100); //DEF:30～100
        this.mp = 0;                  //MP:0
        this.luck = GetNumber(3, 100);//LUCK:1～100
        this.agi = GetNumber(0, 50);  //AGI:1～50

        if(this.hp < 100){
            this.hp = 100;
        }
        if(this.str < 30){
            this.str = 30;
        }
        if(this.def < 30){
            this.def = 30;
        }
        if(this.luck < 1){
            this.luck = 1;
        }
        if(this.agi < 1){
            this.agi = 1;
        }
    }

    /**
     * 対象プレイヤーに攻撃を行う
     * @param defender : 対象プレイヤー
     */
    public void Attack(Player defender)
    {
        // 与えるダメージを求める
        System.out.println(GetName() + "の攻撃！");
        int damage = CalcDamage(defender);

        // 求めたダメージを対象プレイヤーに与える
        System.out.println(defender.GetName() + "に" + damage + "のダメージ！");
        defender.Damage(damage);

        // 倒れた判定
        if (defender.GetHP() <= 0) {
            System.out.println(defender.GetName() + "は力尽きた...");
        }
    }


    // =======================
    // private メソッド
    // =======================


    // =======================
    // public メソッド
    // =======================
}
