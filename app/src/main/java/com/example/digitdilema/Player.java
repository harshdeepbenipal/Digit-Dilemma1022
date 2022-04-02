package com.example.digitdilema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    private String name;
    private int score;
    private int level;
    private String date;
    private int highScore;

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
        this.highScore = score;
    }
    public int getHighscore(){
        return highScore;
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
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        this.date = dateFormat.format(date);
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getDate() {
        return date;
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
        }
    }
}
