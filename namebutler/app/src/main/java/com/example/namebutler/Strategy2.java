package com.example.namebutler;

public class Strategy2 extends Strategy {
    public Strategy2() {
        // TODO 自動生成されたコンストラクター・スタブ
    }


    public void strategyContent(Player name,int strategySet) {
        //魔法を優先して使う
        //UserのMPがあるか確認

        //作戦
        Strategy.strategy = strategySet;

        if(name.GetMp() == 0){
            //MPがない場合
            //指示なし
            System.out.printf("2.MPがない場合");
        }else{
            //MPがある場合
            //魔法を優先して使うようにする
            Strategy.magicPriority = 1;
            System.out.printf("2.MPがある場合");
        }
    }
}
