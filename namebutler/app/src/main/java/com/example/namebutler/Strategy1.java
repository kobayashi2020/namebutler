package com.example.namebutler;

import java.util.ArrayList;

public class Strategy1 extends Strategy {

    public Strategy1() {
        // TODO 自動生成されたコンストラクター・スタブ
    }

    public void strategyContent(Player name,int strategySet) {
        //defが低い人相手を選択
        //作戦
        Strategy.strategy = strategySet;

        //グループ
        ArrayList<Player> yourGroup = new ArrayList<Player>();
        //def
        int def = 0;
        //相手
        //String youUser = null;

        //名前がどちらのグループに属しているか確認
        for(int i = 0;i < NameBattler.group1.size();i++){
            // グループ1に属しているか確認
            Player user1 = NameBattler.group1.get(i);
            if(user1 == name){
                //グループ1に名前がある場合
                //グループ2を設定
                yourGroup = NameBattler.group2;
                break;
            }
        }

        for(int i = 0;i < NameBattler.group2.size();i++){
            // グループ2に属しているか確認
            Player user2 = NameBattler.group2.get(i);
            if(user2 == name){
                //グループ2に名前がある場合
                //グループ1を設定
                yourGroup = NameBattler.group1;
                break;
            }
        }

        //相手グループのdefが一番低い人を選択
        for(int i =0;i <yourGroup.size();i++){
            if(def == 0){
                //1番目の人の防御力
                def = yourGroup.get(i).GetDEF();
                yourNanber = i;
            }else{
                if(def > yourGroup.get(i).GetDEF()){
                    //1番目の人の防御力より低いか確認
                    def = yourGroup.get(i).GetDEF();
                    //youUser = yourGroup.get(i).GetName();
                    // 相手がリストの何番目か返す
                    yourNanber = i;
                }
            }
        }
    }
}

