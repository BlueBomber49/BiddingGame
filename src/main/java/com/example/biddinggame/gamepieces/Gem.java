package com.example.biddinggame.gamepieces;

public class Gem {
    private int value;
    public Gem(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override 
    public String toString(){
        return "Value: " + this.value;
    }

}
