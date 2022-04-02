package com.example.digitdilema;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;

public class ScoreBoard {
    //instance variables
    private static Player player = new Player();
    private static Player[] sbEasy = new Player[10];
    private static Player[] sbMedium = new Player[10];
    private static Player[] sbHard = new Player[10];

    //constructor
    public ScoreBoard() {
        setLevel(0);
        player.setDate();
    }

    //setters and getters for the instance variables
    public static void setPlayer(Player player1) {
        player = player1;
    }

    public void setLevel(int level) {
        player.setLevel(level);
    }

    public static int getLevel() {
        return player.getLevel();
    }

    //checks if player exists in the level scoreboard stored
    public static int checkName(int level, Player p) {
        int index = -1;
        if (level == 1) {
            index = getIndex(sbEasy, p.getName());
        } else if (level == 2) {
            index = getIndex(sbMedium, p.getName());
        } else if (level == 3) {
            index = getIndex(sbHard, p.getName());
        }
        return index;
    }

    //sorts array from lowest score to highest
    public static void sort(Player[] list) {
        for (int i = 1; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (list[i] != null) {
                    if (list[j].getScore() < list[j - 1].getScore()) {
                        Player temp = list[j];
                        list[j] = list[j - 1];
                        list[j - 1] = temp;
                    }
                }
            }
        }
    }

    //returns the sorted scoreboard needed indicated my the level parameter when called on
    public static Player[] getScoreboard(int level) {
        if (level == 1) {
            sort(sbEasy);
            return sbEasy;
        } else if (level == 2) {
            sort(sbMedium);
            return sbMedium;
        } else {
            sort(sbHard);
            return sbHard;
        }
    }

    //adds the player object to the designated array using its level and score
    public static void addPlayer(Player player) {
        setPlayer(player);
        if (getLevel() == 1) {
            int x = getIndex(sbEasy);
            if (x == -1) {
                int y = getIndex(sbEasy, player.getScore());
                if (y != -1){
                    ArrayList<Player> array = new ArrayList<>(Arrays.asList(sbEasy));
                    array.add(y, new Player(player));
                    array.remove(array.size()-1);
                    Player[] temp = new Player[array.size()];
                    sbEasy = array.toArray(temp);
                }
            }
            else {
                sbEasy[x] = new Player(player);

            }
        }
        else if (getLevel() == 2) {
            int x = getIndex(sbMedium);
            if (x == -1) {
                int y = getIndex(sbMedium, player.getScore());
                if (y != -1){
                    ArrayList<Player> array = new ArrayList<>(Arrays.asList(sbMedium));
                    array.add(y, new Player(player));
                    array.remove(array.size()-1);
                    Player[] temp = new Player[array.size()];
                    sbMedium = array.toArray(temp);
                }
            }
            else {
                sbMedium[x] = new Player(player);

            }
        }
        else if (getLevel() == 3){
            int x = getIndex(sbHard);
            if (x == -1) {
                int y = getIndex(sbHard, player.getScore());
                if (y != -1){
                    ArrayList<Player> array = new ArrayList<>(Arrays.asList(sbHard));
                    array.add(y, new Player(player));
                    array.remove(array.size()-1);
                    Player[] temp = new Player[array.size()];
                    sbHard = array.toArray(temp);
                }
            }
            else {
                sbHard[x] = new Player(player);

            }
        }



    }

    public static int getIndex(Player[] a, int x) {
        for (int i = 0; i < 10; i++) {
            if (a[i].getScore() > x) {
                return i;
            }
        }
        return -1;
    }

    public static int getIndex(Player[] a) {
        for (int i = 0; i < 10; i++) {
            if (a[i] == null) {
                return i;
            }
        }
        return -1;
    }
    //gets index when any of the names in the player array match the string
    public static int getIndex(Player[] a, String x){
        for(int i = 0;i<10;i++){
            if(a[i] != null){
                if (a[i].getName().equals(x)){
                    return i;
                }
            }
        }
        return -1;
    }
}