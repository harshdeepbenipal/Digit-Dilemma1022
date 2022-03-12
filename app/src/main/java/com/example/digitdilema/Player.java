package com.example.digitdilema;

public class Player {
    private String name;
    private int score;

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
    public String getInformation(boolean change){
        if(change){
            return "Congratulations! New Score of" + score + "!";
        }else{
            return "Better Luck Next Time!";
        }
    }
}
