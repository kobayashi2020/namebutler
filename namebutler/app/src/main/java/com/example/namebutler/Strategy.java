package com.example.namebutler;

/**
 * 作戦クラスの作成
 */
public class Strategy {
    //・ドラクエのような「さくせん(AI)」を５つ作る
    //例：魔法を優先して使う、
    //    魔法を節約する、
    //    バランスよく、
    //    いのちを大事に(回復、補助魔 法優先)、
    //    １人づつ集中攻撃、など
    //・作戦は作戦毎にクラスを作成する(作戦の基底クラスと実際の作戦毎のロジックを組み込ん だサブクラスを作成する)



    //======================= // フィールド変数 // =======================
    // 作戦
    static int strategy;

    //相手
    static int yourNanber;

    //魔法優先
    static int magicPriority;

    //攻撃優先
    static int attacPriority;

    NameBattler nameBattler = new NameBattler();


    // =======================
    // コンストラクタ
    // =======================
    /**
     * コンストラクタ
     * @param name : プレイヤー名
     */
    public Strategy() {
        // TODO 自動生成されたコンストラクター・スタブ
    }

    // ======================= Getter / Setter // =======================

    // ======================= // protected メソッド // =======================

    // ======================= // private メソッド // =======================

    // ======================= // public メソッド // =======================
    /** * 作戦内容を追加する
     * * @param player : 作戦
     * */
    public void strategyContent(Player name,int strategySet) {
        //それぞれで作成する
        switch(strategySet){
            case 1:
                Strategy1 strategy1 = new Strategy1();
                strategy1.strategyContent(name,strategySet);
                break;
            case 2:
                Strategy2 strategy2 = new Strategy2();
                strategy2.strategyContent(name,strategySet);
                break;
            case 3:
                Strategy3 strategy3 = new Strategy3();
                strategy3.strategyContent(name,strategySet);
                break;
            case 4:
                Strategy4 strategy4 = new Strategy4();
                strategy4.strategyContent(name,strategySet);
                break;
            case 5:
                Strategy5 strategy5 = new Strategy5();
                strategy5.strategyContent(name,strategySet);
                break;
            default:
                break;
        }
    }

    /** * プレイヤーの作戦を追加する
     * * @param player : 作戦
     * */
    public void AppendStrategy(String strategySet) {
        //strategy.add(strategySet);
    }

    /** * プレイヤーの作戦を削除する
     *
     * * @param player : 作戦
     * */
    public void RemoveStrategy(String strategySet) {
        //strategy.remove(strategySet);
    }

    //相手
    public int YourNanber()
    {
        System.out.println("選択:"+Strategy.yourNanber);
        return Strategy.yourNanber;
    }

    //魔法優先
    public int MagicPriority()
    {
        System.out.println("選択:"+Strategy.magicPriority);
        return Strategy.magicPriority;
    }

    //攻撃優先
    public int AttacPriority()
    {
        System.out.println("選択:"+Strategy.attacPriority);
        return Strategy.attacPriority;
    }
}
