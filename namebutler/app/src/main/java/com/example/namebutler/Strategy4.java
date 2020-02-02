package com.example.namebutler;

import java.util.ArrayList;

public class Strategy4 extends Strategy {
    public Strategy4() {
    }

    public void strategyContent(Player name,int strategySet) {
        //攻撃力が高い順に攻撃
        //作戦
        Strategy.strategy = strategySet;

        //グループ
        ArrayList<Player> yourGroup = new ArrayList<Player>();
        //str
        int str = 0;
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

        //相手グループのstrが一番高い人を選択
        for(int i =0;i >yourGroup.size();i++){
            if(str == 0){
                //1番目の人の防御力
                str = yourGroup.get(i).GetSTR();
                yourNanber = i;
            }else{
                if(str > yourGroup.get(i).GetSTR()){
                    //1番目の人より攻撃力が高いか確認
                    str = yourGroup.get(i).GetSTR();
                    //youUser = yourGroup.get(i).GetName();
                    // 相手がリストの何番目か返す
                    yourNanber = i;
                }
            }
        }
    }
}
