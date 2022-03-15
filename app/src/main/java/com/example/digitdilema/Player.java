package com.example.digitdilema;

public class Player {
    private String name;
    private int score;
    private int level;

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
    public String getInformation(boolean change){
        if(change){
            return "Congratulations! New Score of " + score + "!";
        }else{
            return "Better Luck Next Time!";
        }
    }
}
