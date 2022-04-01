package com.example.digitdilema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    private String name;
    private int score;
    private int level;
    private String date;
    private int highscore;

   // public String rank; rank instance variable for the order of players might change in the scoreboard class when highscore changes

    public Player(){
        setName("");
        setScore(0);
        setLevel(0);
    }
    public Player(Player player){
        this.name = player.getName();
        this.score = player.getScore();
        this.level = player.getLevel();
        this.date = player.getDate();
    }
    public void setName(String newName){
        name = newName;
    }
    public String getName() {
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setHighscore(int score){
        this.highscore = score;
    }
    public int getHighscore(){
        return highscore;
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
    public void setDate(String date){
        this.date = date;
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
    public void clearPlayer(int a){
        if(a==1){
            setScore(0);
        }
        else if(a == 2){
            setScore(0);
            setHighscore(0);
        }
        else{
            setHighscore(0);
            setLevel(0);
            setName("");
        }
    }
}
