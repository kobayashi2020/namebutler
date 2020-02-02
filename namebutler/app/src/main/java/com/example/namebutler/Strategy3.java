package com.example.namebutler;

public class Strategy3 extends Strategy {
    public Strategy3() {
        // TODO 自動生成されたコンストラクター・スタブ
    }
    public void strategyContent(Player name,int strategySet) {
        //魔法を節約する
        //作戦
        Strategy.strategy = strategySet;

        //UserのMPがあるか確認
        if(name.GetMp() == 0){
            //MPがない場合
            //指示なし
            System.out.printf("3.MPがない場合");
        }else{
            //MPがある場合
            //魔法を節約する(1/5で魔法も選択肢に入れる(0～4))
            int random = (int)((Math.random()*4));
            if(random == 0){
                //魔法を節約
                Strategy.attacPriority = 1;
                System.out.printf("3.MPがある場合：魔法節約");
            }else{
                Strategy.attacPriority = 0;
                System.out.printf("3.MPがある場合");
            }
        }
    }
}
