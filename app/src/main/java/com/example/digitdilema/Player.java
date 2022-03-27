package com.example.digitdilema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    private String name;
    private int score;
    private int level;
    private String date;
   // public String rank; rank instance variable for the order of players might change in the scoreboard class when highscore changes

    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    public void setDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        this.date = dateFormat.format(date);
    }
    public String getDate() {
        return date;
    }
    /*public void setRank(int rank) {//sets the rank as the given index but plus one
        this.rank = rank+1+"";
    }
    public String getRank() {
        return rank;
    }*/

    public String getInformation(boolean change){
        if(change){
            return "Congratulations! New high score of " + score + "!";
        }else{
            return "Better luck next time!";
        }
    }
}
