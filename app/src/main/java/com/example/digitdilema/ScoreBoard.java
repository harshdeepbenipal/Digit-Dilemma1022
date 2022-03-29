package com.example.digitdilema;

public class ScoreBoard {
    private static Player player = new Player();
    private static int level;
    private static Player sbEasy[] = new Player[10];
    private static Player sbMedium[] = new Player[10];
    private static Player sbHard[] = new Player[10];

    public ScoreBoard(){
        setLevel(0);
        player.setDate();
    }

    public static void setPlayer(Player player1) {
        player = new Player(player1);//i don't think this does anything
        player = player1;
    }
    public static Player getPlayer() {
        return player;
    }
    public void setLevel(int level) {
        this.level = level;
        player.setLevel(level);
    }
    public int getLevel() {
        return level;
    }
    public static int checkName(){
        int index = -1;
        if(level==1){
            index = getIndex(sbEasy,player.getName());
        }else if(level==2){
            index = getIndex(sbMedium,player.getName());
        }else if(level==3){
            index = getIndex(sbHard,player.getName());
        }
        return index;
    }
    public static void replacePlayer(){//as long as there's a index where the name is present replace the previous player with present if score is higher
        if(checkName()>-1) {
            if (level == 1 && sbEasy[checkName()].getScore() > player.getScore()) {
                sbEasy[checkName()] = player;
            } else if (level == 2 && sbMedium[checkName()].getScore() > player.getScore()) {
                sbMedium[checkName()] = player;
            } else if (level == 3 && sbHard[checkName()].getScore() > player.getScore()) {
                sbHard[checkName()] = player;
            }
        }
    }
    public static void sort(Player[] list){ // Implement in the scoreboards java files maybe also with given array not sure
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if(list[i]!=null){
                    if (list[j].getScore() < list[j - 1].getScore()) {
                        Player temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                }
            }
        }
        /*for(int i = 0;i< list.length;i++){ what does this even do? question to self
            list[i].getPlayer();
        }*/
    }
    public static Player[] getScoreboard(int level){
        if(level==1){
            sort(sbEasy);
            return sbEasy;
        }else if(level==2){
            sort(sbMedium);
            return sbMedium;
        }else{
            sort(sbHard);
            return sbHard;
        }
    }
    public static void addPlayer(Player player){
        setPlayer(player);
        if(checkName()==-1){
            int x = getIndex(sbEasy,"");
            if(level==1&&x!=-1){
                sbEasy[x] = player;
            }
            x = getIndex(sbMedium,"");
            if(level==2&&x!=-1){
                sbMedium[x] = player;
            }
            x = getIndex(sbHard,"");
            if(level==3&&x!=-1){
                sbHard[x] = player;
            }
        }
    }
    public static int getIndex(Player[] a, String x){//checking the
        //System.out.println("BONJOUR"); Testing lol
        for(int i = 0;i<10;i++){
            if(a[i]!=null){
                if(a[i].getName().equals(x)){
                    //System.out.println("HOLA"); testing
                    return i;
                }
            }
        }
        /*for(int i = 0;i<10;i++){
            if(a[i]==null){
               return i;
            }
        }*/
        return -1;
    }
}