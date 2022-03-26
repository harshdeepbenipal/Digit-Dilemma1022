package com.example.digitdilema;

public class ScoreBoard {
    private static Player player = new Player();
    private static int level;
    private static ScoreBoard sbEasy[] = new ScoreBoard[11];
    private static ScoreBoard sbMedium[] = new ScoreBoard[11];
    private static ScoreBoard sbHard[] = new ScoreBoard[11];

    public ScoreBoard(){
        setPlayer(null);
        setLevel(0);
    }
    public ScoreBoard(Player player){
        setPlayer(player);
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
    public static Player getPlayer() {
        return player;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    public static int checkName(){
        int index = -1;
        if(level==1){
            for(int i = 0; i<11;i++){
                if(sbEasy[i].getPlayer().getName().equals(player.getName())){
                    index = i;
                }
            }
        }else if(level==2){
            for(int i = 0; i<11;i++){
                if(sbMedium[i].getPlayer().getName().equals(player.getName())){
                    index = i;
                }
            }
        }else if(level==3){
            for(int i = 0; i<11;i++){
                if(sbHard[i].getPlayer().getName().equals(player.getName())){
                    index = i;
                }
            }
        }
        return index;
    }
    public static void replacePlayer(){//as long as there's a index where the name is present replace the previous player with present if score is higher
        if(checkName()>-1) {
            if (level == 1 && sbEasy[checkName()].getPlayer().getScore() > player.getScore()) {
                sbEasy[checkName()].setPlayer(player);
            } else if (level == 2 && sbMedium[checkName()].getPlayer().getScore() > player.getScore()) {
                sbMedium[checkName()].setPlayer(player);
            } else if (level == 3 && sbHard[checkName()].getPlayer().getScore() > player.getScore()) {
                sbHard[checkName()].setPlayer(player);
            }
        }
    }
    public static void sort(ScoreBoard[] list){ // Implement in the scoreboards java files maybe also with given array not sure
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[j].getPlayer().getScore() < list[j - 1].getPlayer().getScore()) {
                    ScoreBoard temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                }
            }
        }
        for(int i = 0;i< list.length;i++){
            list[i].getPlayer().setRank(i);
        }
    }
}
