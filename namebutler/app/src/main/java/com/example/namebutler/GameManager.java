package com.example.namebutler;

import java.util.ArrayList;

/**
 * ゲーム進行を制御するクラスの作成
 */
public class GameManager  extends Player {
    protected int fighter = 0;    // 戦士
    protected int wizard = 1;     // 魔法使い
    protected int priest = 2;     // 僧侶
    protected int beastmaster= 3; // 獣使い
    protected int job;
    static int parizeFlag = 0;
    static Boolean poisonFlag = false;
    Strategy strategy = new Strategy();
    int random = -1;
    // =======================
    // コンストラクタ
    // =======================
    public GameManager(String name,int i){
        super(name);
    }

    // =======================
    // protected メソッド
    // =======================
    /**
     * 名前(name)からキャラクターに必要なパラメータを生成する
     */
    @Override
    protected void MakeCharacter(int job){
        if(job == 1){
            //職業:戦士
            // 戦士のパラメータを名前から生成する
            this.hp = GetNumber(2, 300);  //HP:100～300
            this.str = GetNumber(1, 100); //STR:30～100
            this.def = GetNumber(2, 100); //DEF:30～100
            this.mp = 0;                  //MP:0
            this.luck = GetNumber(3, 100);//LUCK:1～100
            this.agi = GetNumber(0, 50);  //AGI:1～50

            if(this.hp < 100){//HP:100～300
                this.hp = 100;
            }
            if(this.str < 30){//STR:30～100
                this.str = 30;
            }
            if(this.def < 30){//DEF:30～100
                this.def = 30;
            }
            if(this.luck < 1){//LUCK:1～100
                this.luck = 1;
            }
            if(this.agi < 1){//AGI:1～50
                this.agi = 1;
            }
        }else if(job == 2){
            //魔法使い
            // 魔法使いのパラメータを名前から生成する
            this.hp = GetNumber(2, 150);  //HP:50～150
            this.str = GetNumber(1, 50); //STR:1～50
            this.def = GetNumber(4, 50); //DEF:1～50
            this.mp = GetNumber(5, 80);  //MP:30～80
            this.luck = GetNumber(2, 100);//LUCK:1～100
            this.agi = GetNumber(0, 60);  //AGI:20～60

            if(this.hp < 50){ //HP:50～150
                this.hp = 100;
            }
            if(this.str < 1){//STR:1～50
                this.str = 30;
            }
            if(this.def < 1){//DEF:1～50
                this.def = 30;
            }
            if(this.mp < 30){//MP:30～80
                this.mp = 30;
            }
            if(this.luck < 1){//LUCK:1～100
                this.luck = 1;
            }
            if(this.agi < 20){//AGI:20～60
                this.agi = 1;
            }
        }else if(job == 3){
            //職業:僧侶     HP:80～200  MP:20～50 STR:10～70  DEF:10～70  LUCK:1～100 AGI:20～60
            // 僧侶のパラメータを名前から生成する
            this.hp = GetNumber(2, 200);  //HP:80～200
            this.str = GetNumber(1, 70); //STR:10～70
            this.def = GetNumber(4, 70); //DEF:10～70
            this.mp = GetNumber(5, 50);  //MP:20～50
            this.luck = GetNumber(2, 100);//LUCK:1～100
            this.agi = GetNumber(0, 60);  //AGI:20～60

            if(this.hp < 80){//HP:80～200
                this.hp = 80;
            }
            if(this.str < 10){//STR:10～70
                this.str = 40;
            }
            if(this.def < 10){//DEF:10～70
                this.def = 40;
            }
            if(this.mp < 20){//MP:20～50
                this.mp = 20;
            }
            if(this.luck < 1){//LUCK:1～100
                this.luck = 1;
            }
            if(this.agi < 20){//AGI:20～60
                this.agi = 40;
            }
        }else if(job == 4){
            //職業:獣使い     HP:80～300  MP:0 STR:40～80  DEF:10～70  LUCK:1～100 AGI:20～60
            // 獣使いのパラメータを名前から生成する
            this.hp = GetNumber(2, 300);  //HP:80～300
            this.str = GetNumber(1, 80); //STR:40～80
            this.def = GetNumber(4, 70); //DEF:10～70
            this.mp = 0;
            this.luck = GetNumber(2, 100);//LUCK:LUCK:1～100
            this.agi = GetNumber(0, 60);  //AGI:20～60

            if(this.hp < 80){//HP:80～300
                this.hp = 80;
            }
            if(this.str < 40){//STR:40～80
                this.str = 40;
            }
            if(this.def < 10){//DEF:10～70
                this.def = 10;
            }
            if(this.luck < 1){//LUCK:LUCK:1～100
                this.luck = 20;
            }
            if(this.agi < 20){//AGI:20～60
                this.agi = 20;
            }
        }else{

        }
    }

    /**
     * 対象プレイヤーに攻撃を行う
     *
     */
    @Override
    public void Attack(Player player,int job){
        // ジョブごとにオーバーライドして処理を記述してください
        //戦士(Fighter:0)、魔法使いwizard:1)、僧侶(priest:2)、獣使い(beastmaster:3)

        //攻撃プレイヤー表示
        System.out.println(GetName() + "の攻撃！");
        int damage = -1;
        String magicName = null;

        if(job == 1){
            //戦士
            // 与えるダメージを求める
            damage = CalcDamage(player);
            //ダメージが0以下か判定
            damage = damageDone(damage);
            // 求めたダメージを対象プレイヤーに与える
            System.out.println(player.GetName() + "に" + damage + "のダメージ！");
            player.Damage(damage);

        }else if(job == 2){
            //魔法使い
            //名称:ファイア 職業:魔法使い 消費MP:10 効果:敵に10～30の防御無視ダメージ
            //名称:サンダー 職業:魔法使い 消費MP:20 効果:敵に10～30の防御無視ダメージ
            //   ・MPがあれば魔法をランダムで使用して攻撃し、MPが無い場合は通常攻撃を行う
            // 与えるダメージを求める
            if(this.mp >= 20){
                //作戦
                if(Strategy.strategy == 3 & Strategy.attacPriority == 1){
                    // 攻撃優先
                    random = 0;
                }else{
                    random = (int)((Math.random()*2)+Strategy.magicPriority);
                }

                if(random == 0){
                    //通常
                    magicName = "通常攻撃";
                    damage = CalcDamage(player);
                }else if(random == 1){
                    //ファイア
                    magicName = "ファイア";
                    damage = magicDamage(player,10,30);
                    //mpを10消費
                    this.mp = this.mp - 10;
                }else if(random == 2){
                    //サンダー
                    magicName = "サンダー";
                    damage = magicDamage(player,10,30);
                    //mpを20消費
                    this.mp = this.mp - 20;
                }
            }else if(this.mp >= 10){
                if(Strategy.strategy == 3 & Strategy.attacPriority == 1){
                    // 攻撃優先
                    random = 0;
                }else{
                    random = (int)((Math.random()*1)+Strategy.magicPriority);
                }
                if(random == 0){
                    //通常
                    magicName = "通常攻撃";
                    damage = CalcDamage(player);
                }else{
                    //ファイア
                    magicName = "ファイア";
                    damage = magicDamage(player,10,30);
                    //mpを10消費
                    this.mp = this.mp - 10;
                }
            }else{
                //通常
                magicName = "通常攻撃";
                damage = CalcDamage(player);
            }
            //ダメージが0以下か判定
            damage = damageDone(damage);
            //与えるダメージ
            player.Damage(damage);
            // 求めたダメージを対象プレイヤーに与える
            System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");

        }else if(job == 3){
            //僧侶
            //名称:ヒール   職業:僧侶     消費MP:20 効果:HPを50回復
            //名称:パライズ 職業:僧侶     消費MP:10 効果:麻痺の効果を与える 麻痺：20%の確率で麻痺で行動不能
            //名称:ポイズン 職業:僧侶     消費MP:10 効果:毒状態にする 毒：毎ターン20のダメージを受ける
            //   ・MPがあれば魔法をランダムで使用して攻撃し、MPが無い場合は通常攻撃を行う
            //   ※この段階では「ヒール」のみの実装でよい
            //   ・HPが減っていれば「ヒール」を使用し、減ってなければ通常攻撃を行う

            //パライズ,ポイズン用
            int specialMagic = (int)((Math.random()*100));

            // 与えるダメージを求める
            if(this.mp >= 20){
                if(Strategy.strategy == 3&Strategy.attacPriority == 1){
                    // 攻撃優先
                    random = 0;
                }else{
                    random = (int)((Math.random()*3)+Strategy.magicPriority);
                }

                if(random == 0){
                    //通常
                    magicName = "通常攻撃";
                    damage = CalcDamage(player);
                    //ダメージが0以下か判定
                    damage = damageDone(damage);
                    //ダメージを与える
                    player.Damage(damage);
                    System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");

                }else if(random == 1){
                    //ヒール
                    Heel(player,job,50);

                }else if(random == 2){
                    //パライズ
                    magicName = "パライズ";
                    //名称:パライズ 職業:僧侶     消費MP:10 効果:麻痺の効果を与える 麻痺：20%の確率で麻痺で行動不能
                    //damage = specialMagic(player,10,1);
                    if(specialMagic <= 20){
                        //パライズフラグ
                        parizeFlag =1;
                        //行動不能にする相手を補完
                        parizeUser.add(player);
                        System.out.println(player.GetName() + "に" + magicName + "、次のターン"+player.GetName()+"は行動不能");
                    }else{
                        //相手の行動不能失敗
                        System.out.println(player.GetName() + "に" + magicName + "失敗");
                    }
                    this.mp = this.mp - 10;

                }else if(random == 3){
                    //ポイズン
                    magicName = "ポイズン";
                    //名称:ポイズン 職業:僧侶     消費MP:10 効果:毒状態にする 毒：毎ターン20のダメージを受ける
                    //毎ターン20ダメージ
                    damage = 20;

                    this.mp = this.mp - 10;
                    poisonFlag = true;
                    poisonUser.add(player);
                    //ダメージが0以下か判定
                    damage = damageDone(damage);
                    // 求めたダメージを対象プレイヤーに与える
                    System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");
                    player.Damage(damage);
                }
            }else if(this.mp >= 10){
                //ダメージ
                if(Strategy.strategy == 3 & Strategy.attacPriority == 1){
                    // 攻撃優先
                    random = 0;
                }else{
                    random = (int)((Math.random()*2)+Strategy.magicPriority);
                }

                if(random == 0){
                    //通常
                    magicName = "通常攻撃";
                    damage = CalcDamage(player);
                    //ダメージが0以下か判定
                    damage = damageDone(damage);
                    //ダメージを与える
                    player.Damage(damage);
                    System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");
                }else if(random == 1){
                    //パライズ
                    magicName = "パライズ";
                    //damage = specialMagic(player,10,1);
                    this.mp = this.mp - 10;
                    if(damage == 0){
                        //パライズフラグ
                        parizeFlag =1;
                        //行動不能にする相手を補完
                        parizeUser.add(player);
                        System.out.println(player.GetName() + "に" + magicName + "、"+player.GetName()+"の行動不能");
                    }else {
                        //相手の行動不能失敗
                        System.out.println(player.GetName() + "に" + magicName + "失敗");
                    }
                }else if(random == 2){
                    //ポイズン
                    magicName = "ポイズン";
                    this.mp = this.mp - 10;
                    poisonFlag = true;
                    poisonUser.add(player);
                    //ダメージが0以下か判定
                    damage = damageDone(damage);
                    //ダメージを与える
                    player.Damage(damage);
                    // 求めたダメージを対象プレイヤーに与える
                    System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");
                }
            }else{
                //通常
                magicName = "通常攻撃";
                damage = CalcDamage(player);
                //ダメージが0以下か判定
                damage = damageDone(damage);
                //ダメージを与える
                player.Damage(damage);
                System.out.println(player.GetName() + "に" + magicName + " で " + damage + "のダメージ！");
            }
        }else if(job == 4){
            //動物:トラ   効果:ひっかく 50のダメージ
            //動物:ヘビ   効果:かみつく 20のダメージ 確率で毒を付与
            //動物:ネズミ 効果:かみつく 20のダメージ
            //動物:ウサギ 効果：回復    30回復
            //自身の攻撃                10のダメージ

            // 与えるダメージを求める(0～5)
            if(Strategy.strategy == 3 & Strategy.attacPriority == 1){
                // 攻撃優先
                random = 0;
            }else{
                random = (int)((Math.random()*5)+Strategy.magicPriority);
            }
            if(random == 0) {
                //自身の攻撃
                damage = CalcDamage(player);
            }else if(random == 1){
                //トラ
                damage = beastDamage(player,50,1);

                // 求めたダメージを対象プレイヤーに与える
                System.out.println("トラが召喚された：ひっかく攻撃");

            }else if(random == 2){
                //蛇
                damage = beastDamage(player,20,2);
                //randomで毒を付与(1/10)
                // 求めたダメージを対象プレイヤーに与える
                System.out.println("ヘビが召喚された：かみつく攻撃");
            }else if(random == 3){
                //ネズミ
                damage = beastDamage(player,20,3);
                // 求めたダメージを対象プレイヤーに与える
                System.out.println("ネズミが召喚された：かみつく攻撃");
            }else if(random == 4){
                //ウサギ
                //damage = beastDamage(player,30,4);
                // 求めたダメージを対象プレイヤーに与える
                System.out.println("ウサギが召喚された：ユーザーのHPを回復");
                //ヒール
                Heel(player,job,10);
            }
            if(random != 4){
                //ダメージが0以下か判定
                damage = damageDone(damage);
                //ダメージを与える
                player.Damage(damage);
                System.out.println(player.GetName() + "に" + damage + "のダメージ！");
            }
        }else{
            System.out.println("else");
        }
        // 倒れた判定
        if (player.GetHP() <= 0) {
            System.out.println(player.GetName() + "は力尽きた...!!!!");
        }
    }

    public void Heel(Player player,int job,int heel){
        ArrayList<Player> group = new ArrayList<Player>();
        //自パーティーメンバーのHPが減っている場合にメンバーに回復魔法を使うようにする
        //グループメンバー取得
        if(player.GetName() == NameBattler.playerName1||player.GetName() == NameBattler.playerName2||player.GetName() == NameBattler.playerName3){
            //グループ2のメンバーがヒールを使用
            group = NameBattler.group2;
        }else{
            //グループ1のメンバーがヒールを使用
            group = NameBattler.group1;
        }

        //差分
        int difference = 0;
        //差分ダメージ
        int differenceDamage = 0;
        //回復相手
        String you = null;
        int youHp = 0;
        int youInitialUserHp =0;
        //初期のHP
        int initialUserHp = 0;
        //現在のHP
        int currentUserHp = 0;
        int j = 1;
        for(int i = 0;i<group.size();i++){
            //HPが減っているかどうか確認
            //初期のHP
            initialUserHp = NameBattler.playerHp.get(i);
            //現在のHP
            currentUserHp = group.get(i).GetHP();

            if(initialUserHp == currentUserHp){
                //初期のHPと同じ
                if(j == 3){
                    you = group.get(i).GetName();
                }
                j++;
            }else if(initialUserHp > currentUserHp){
                //初期のHP より 現在のHP が少ない場合
                //差分を取得(初期のHP - 現在のHP)
                difference = initialUserHp - currentUserHp;
            }

            if(0 < difference){
                //差分がある場合
                if(differenceDamage < difference){
                    //一人目より差分が大きい場合
                    System.out.println("差分ダメージ より 差分が大きい場合:"+difference);
                    //回復相手の名前を取得
                    you = group.get(i).GetName();
                    //回復相手の現在のHPを取得
                    youHp = currentUserHp;
                    //回復相手の初期HPを取得
                    youInitialUserHp = initialUserHp;
                    //回復相手の差分を設定
                    differenceDamage = difference;
                }
            }
        }

        String magicName = "ヒール";
        //HPを50回復(初期のHP -(現在のHP + 回復量))
        int damage =  youHp + heel;
        if(difference == 0){
            //相手を設定
            System.out.println(you+"に"+magicName + "しようとしたがHPが減っていなかったのでやめた");
        }else if(damage > youInitialUserHp){
            //回復したHP > 初期HP
            //初期値と同じ分回復
            player.hp = youInitialUserHp;
            //mpを20消費
            if(job != 4){
                this.mp = this.mp - 20;
            }
            System.out.println(you+"に"+magicName + "、" + difference + "! "+heel+"の回復");
        }else{
            //回復量が初期値に達しない
            //回復量確認()
            player.hp = damage;
            //mpを20消費
            if(job != 4){
                this.mp = this.mp - 20;
            }
            System.out.println(you+"に"+magicName + "、" + damage + "! "+heel+"の回復");
        }
    }
}
