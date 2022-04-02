package com.example.digitdilema;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Player {
    //instance variables
    private String name;
    private int score;
    private int level;
    private String date;
    private int highScore;

    public Player(){//creates a player object without parameters,and setting it empty
        setName("");
        setScore(0);
        setLevel(0);
    }
    public Player(Player player){//creates a player using another
        this.name = player.getName();
        this.score = player.getScore();
        this.level = player.getLevel();
        this.date = player.getDate();
    }

    //setters and getters for the instance variables defining the Player object
    public void setName(String newName){
        name = newName;
    }
    public String getName() {
        return name;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setHighScore(int score){
        this.highScore = score;
    }
    public int getHighScore(){
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
    public void setDate(){//sets the time when the player object is created
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
    //clears the player given the case using the int parameter
    public void clearPlayer(int a){
        if(a==1){
            setScore(0);
        }
        else if(a == 2){
            setScore(0);
            setHighScore(0);
        }
        else{
            setHighScore(0);
            setLevel(0);
        }
    }
}
