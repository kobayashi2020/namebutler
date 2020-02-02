package com.example.namebutler;

import java.util.ArrayList;
import java.util.Scanner;

public class NameBattler {
    public static int hp1;
    public static int hp2;

    static Player player;
    static Player playerTmp;
    static boolean flagPoison = false;

    static Player player1 = null;
    static Player player2 = null;
    static Player player3 = null;
    static Player player4 = null;
    static Player player5 = null;
    static Player player6 = null;

    static java.util.ArrayList<Integer> playerHp = new ArrayList<>();
    static final ArrayList<Player> ArrayList = new ArrayList<Player>();
    static final ArrayList<Player> ArrayList2 = new ArrayList<Player>();
    static ArrayList<Player> remainingParty = new ArrayList<Player>();
    static final ArrayList<Player> group1 = new ArrayList<Player>();
    static final ArrayList<Player> group2 = new ArrayList<Player>();

    static int playerJob1;
    static int playerJob2;
    static int playerJob3;
    static int playerJob4;
    static int playerJob5;
    static int playerJob6;

    static String playerName1;
    static String playerName2;
    static String playerName3;
    static String playerName4;
    static String playerName5;
    static String playerName6;

    static Party party = new Party();

    public static void main(String[] args) throws InterruptedException {
        // ==================================================
        // バトル開始準備
        // ==================================================
        while (true) {
            //※プレイヤー情報やパーティー構成は、
            //  毎回実行時に入力するのが面倒な場合は、
            //  プログラミングで固定にしておいても良い
            playerName1 ="名前1";
            playerName2 ="名前2";
            playerName3 ="名前3";
            playerName4 ="name4";
            playerName5 ="name5";
            playerName6 ="name6";
            //プレイヤー設定
            player1 = new GameManager(playerName1,4);//1.剣士
            player2 = new GameManager(playerName2,4);//3.僧侶
            player3 = new GameManager(playerName3,4);//3.僧侶
            player4 = new GameManager(playerName4,4);//4.獣使い
            player5 = new GameManager(playerName5,4);//2.魔法使い
            player6 = new GameManager(playerName6,4);//2.魔法使い

            ArrayList.add(player1);
            ArrayList.add(player2);
            ArrayList.add(player3);
            ArrayList.add(player4);
            ArrayList.add(player5);
            ArrayList.add(player6);
            party.AppendPlayer(player1);
            party.AppendPlayer(player2);
            party.AppendPlayer(player3);
            party.AppendPlayer(player4);
            party.AppendPlayer(player5);
            party.AppendPlayer(player6);

            //・３対３のパーティーバトルとなるように修正する
            //パーティー1
            group1.add(player1);
            group1.add(player2);
            group1.add(player3);

            //作戦を考える
            Scanner strategyGroup = new Scanner(System.in);
            // １．プレイヤー名の入力プレイヤー名の入力
            System.out.println("作戦を選んでください :");
            System.out.println("0．ランダムな相手を狙う");
            System.out.println("1．一番ダメージを与えられそうな相手を狙う");
            System.out.println("2．魔法を優先して使う");
            System.out.println("3．魔法を節約する");
            System.out.println("4．攻撃力が高い相手を狙う");
            System.out.println("5．防御力が一番低い人を選択");
            System.out.print("グループ１の作戦 :");
            // プレイヤー１のキャラクターを作成

            boolean flag = true;
            int strategyGroup1 = -1;
            while(flag){
                strategyGroup1 = strategyGroup.nextInt();
                if(strategyGroup1 == 0){
                    // 作戦無し
                    flag = false;
                }else if(strategyGroup1 == 1||strategyGroup1 == 2 ||strategyGroup1 == 3||strategyGroup1 == 4||strategyGroup1 == 5){
                    // 作戦1～5を選択
                    flag = false;
                }else{
                    flag = true;
                    System.out.print("もう一回入力してください：");
                }
            }
            //パーティー2
            group2.add(player4);
            group2.add(player5);
            group2.add(player6);
            System.out.print("グループ２の作戦 :");
            // プレイヤー２のキャラクターを作成
            flag = true;
            int strategyGroup2 = -1;
            while(flag){
                strategyGroup2 = strategyGroup.nextInt();
                if(strategyGroup2 == 0){
                    // 作戦無し
                    flag = false;
                }else if(strategyGroup2 == 1||strategyGroup2 == 2 ||strategyGroup2 == 3||strategyGroup2 == 4||strategyGroup2 == 5){
                    // 作戦1～5を選択
                    flag = false;
                }else{
                    flag = true;
                    System.out.print("もう一回入力してください：");
                }
            }

            //パーティーメンバー取得
            ArrayList<Player> partyMen = party.GetMembers();
            for(int i = 0;i < partyMen.size();i++){
                player = partyMen.get(i);
                // ステータス表示
                player.PrintStatus();
                //初回のHPを取得
                playerHp.add(player.GetHP());
            }
            int arrayListFlag = 0;
            for(int i = 0;i < partyMen.size();i++){
                arrayListFlag = -1;
                player = partyMen.get(i);
                //速さ順に並び替える()
                if(ArrayList2.size() == 0 ){
                    //リストの一番目をArrayList2に入れる
                    ArrayList2.add(0,player);
                }else{
                    //2回目以降
                    if(ArrayList2.get(0).GetAgi() < player.GetAgi()){
                        //リストの最初より大きい場合
                        ArrayList2.add(0,player);
                    }else{
                        //リストの最初より小さい
                        for(int j = 0;j < ArrayList2.size();){
                            if(ArrayList2.get(j).GetAgi() < player.GetAgi()){
                                arrayListFlag = j;
                                break;
                            }
                            j++;
                        }
                        if(arrayListFlag == -1){
                            arrayListFlag =  ArrayList2.size();
                        }
                        ArrayList2.add(arrayListFlag,player);
                    }
                }
            }

            System.out.println("");
            //プレイヤーを削除
            for(int j = 0;j < 6;){
                party.RemovePlayer(partyMen.get(0));
                j++;
            }

            //・６人の攻撃順はパーティー関係なく、素早さ順で攻撃を行う
            //プレイヤーを速さ順に入れなおす
            for(int j = 0;j < ArrayList2.size();j++){
                party.AppendPlayer(ArrayList2.get(j));
            }
//ここまでは完了

            //・回復魔法は自分に対してのみ使用で良い

            //・ドラクエのような「さくせん(AI)」を５つ作る
            //例：魔法を優先して使う、魔法を節約する、
            //バランスよく、いのちを大事に(回復、補助魔 法優先)、
            //１人づつ集中攻撃、など
            //・作戦は作戦毎にクラスを作成する(作戦の基底クラスと実際の作戦毎のロジックを
            //組み込ん だサブクラスを作成する)

            //・ゲームとして面白くなるような機能を１つ追加する
            //例：ジョブ固有の特技を追加する、
            //    ガード機能を追加する、
            //    職業別の相性を設定する、
            //アイ テム（回復アイテム、攻撃アイテムなど）を追加する、など
            // ==================================================
            // バトル処理
            // ==================================================
            // バトル開始の表示
            System.out.println("");
            System.out.println("=== バトル開始 ===");

            int turnNumber = 1;
            Player playerYou = null;
            int job = 0;
            int random1 = 0;
            int random2 = 0;
            while (turnNumber <= 20) {
                System.out.println("--------------------------------");
                System.out.printf("- ターン%d -\n", turnNumber);
                // 最大でも20ターンまで
                //party分回す
                for(int i= 0;i< partyMen.size();i++){
                    //攻撃する人
                    //playerTmp = partyMen.get(i);
                    playerTmp = party.GetMembers().get(i);

                    System.out.println("攻撃する人"+playerTmp.name);
                    if(GameManager.parizeFlag == 1){
                        //パライズを受けている場合
                        for(int j = 0;j<Player.parizeUser.size();j++){
                            //パライズを受けてるユーザーを取得
                            if(playerTmp == Player.parizeUser.get(j)){
                                //グループ1から相手を設定
                                System.out.println("パライズを受けているため、"+playerTmp.name+"は行動不能");
                                GameManager.parizeFlag = 0;
                                flagPoison = true;
                                break;
                            }
                        }
                    }

                    if(GameManager.poisonFlag){
                        //ポイズンを受けている場合
                        for(int j = 0;j<Player.poisonUser.size();j++){
                            //ポイズンを受けてるユーザーを取得
                            if(playerTmp == Player.poisonUser.get(j)){
                                //グループ1から相手を設定
                                //毎ターン20のダメージ
                                player.Damage(20);
                                System.out.println("ポイズンを受けているため20のダメージ");
                                //ひんしか確認
                                deathCheck(playerTmp,random1,random2);
                                break;
                            }
                        }
                    }
                    //ランダム
                    random1 = -2;
                    random2 = -2;
                    //作戦に合わせる
                    if(playerTmp == player1 ||playerTmp == player2||playerTmp == player3){
                        Strategy strategy1 = new Strategy();
                        strategy1.strategyContent(playerTmp,strategyGroup2);
                        //グループ1の場合
                        switch(strategyGroup2){
                            case 0:
                                //ランダム相手を選択
                                random2 = (int)((Math.random()*group2.size()));
                                break;
                            case 1:
                                //defが低い人相手を選択
                                random2 = strategy1.YourNanber();
                                break;
                            case 2:
                                //魔法を優先して使う
                                //ランダム相手を選択
                                random2 = (int)((Math.random()*group2.size()));
                                break;
                            case 3:
                                //魔法を節約する
                                //ランダム相手を選択
                                random2 = (int)((Math.random()*group2.size()));
                                break;
                            case 4:
                                //攻撃力が高い順に攻撃
                                random2 = strategy1.YourNanber();
                                break;
                            case 5:
                                //いのちを大事に(回復、補助魔 法優先)、１人づつ集中攻撃、など
                                //HPの低い相手を選択
                                random2 = strategy1.YourNanber();
                                break;
                            default:
                        }
                        //グループ２から相手を設定
                        playerYou = group2.get(random2);
                    }else{
                        Strategy strategy2 = new Strategy();
                        strategy2.strategyContent(playerTmp,strategyGroup1);
                        //グループ２
                        switch(strategyGroup1){
                            case 0:
                                //ランダム相手を選択
                                random1 = (int)((Math.random()*group1.size()));
                                break;
                            case 1:
                                //defが低い人相手を選択
                                random1 = strategy2.YourNanber();
                                break;
                            case 2:
                                //魔法を優先して使う
                                //ランダム相手を選択
                                random1 = (int)((Math.random()*group1.size()));
                                break;
                            case 3:
                                //魔法を節約する
                                //ランダム相手を選択
                                random1 = (int)((Math.random()*group1.size()));
                                break;
                            case 4:
                                //攻撃力が高い順に攻撃
                                random1 = strategy2.YourNanber();
                                break;
                            case 5:
                                //いのちを大事に(回復、補助魔 法優先)、１人づつ集中攻撃、など
                                //HPの低い相手を選択
                                random1 = strategy2.YourNanber();
                                break;
                            default:
                        }
                        //グループ1から相手を設定
                        playerYou = group1.get(random1);
                    }
                    strategyGroup.close();
                    hp1 = playerTmp.GetHP();
                    hp2 = playerYou.GetHP();
                    job = player.GetJob();

                    if(flagPoison){
                        flagPoison = false;
                        break;
                    }else{
                        // ■自身の攻撃ターン
                        playerTmp.Attack(playerYou,job);
                        //ひんし確認
                        deathCheck(playerYou,random1,random2);
                        //6.好きな機能を１つ追加する  ラッキーの値を使って反撃、食らったダメージの半分のダメージを与える
                        //相手、自身
                        playerTmp.counterAttack(playerYou,playerTmp);
                        //ひんし確認
                        deathCheck(playerTmp,random1,random2);
                        playerTmp.PrintStatus();
                        playerYou.PrintStatus();
                        if(group1.size()==0||group2.size()==0){
                            //戦えるメンバーがいなくなったら抜ける
                            i = partyMen.size();
                            turnNumber = turnNumber + 20;
                        }
                    }
                }
                // 次のターン
                turnNumber = turnNumber + 1;
            }
            // ⑥勝ち負けの表示(ＨＰが多い方が勝ち)
            partyMen = party.GetMembers();
            Player nokori = null;
            int ti_mu1 = 0;
            int ti_mu2 = 0;
            //残りのメンバー
            System.out.println("-----生き残ったメンバー------------------");
            for(int i =0;i<partyMen.size();i++){
                partyMen.get(i).PrintStatus();
                nokori = partyMen.get(i);
                // グループの人数が多いほうが勝ち
                //相手チームのサイズ取得
                if(nokori == player1 ||nokori == player2||nokori == player3){
                    //グループ2
                    ti_mu1++;
                }else{
                    //グループ1
                    ti_mu2++;
                }
            }

            // ==================================================
            // 終了処理
            // ==================================================
            System.out.println("");
            if (ti_mu1 > ti_mu2) {
                System.out.println( "グループ１の勝利！！");
                break;
            } else {
                System.out.println("グループ２の勝利！！");
                break;
            }
        }
    }

    private static void deathCheck(Player player,int random1,int random2){
        // 相手の敗北判定
        if (player.GetHP() == 0) {
            //ひんしの人はメンバーから除外する
            if(random1 != -2){
                group1.remove(random1);
                playerHp.remove(random1);
            }else if(random2 != -2){
                group2.remove(random2);
                playerHp.remove(random2);
            }else{
                System.out.println("基本ココには来ないはず");
            }
            party.RemovePlayer(player);
        }
    }
}

