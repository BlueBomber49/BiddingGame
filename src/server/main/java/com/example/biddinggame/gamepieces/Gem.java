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

    @Override 
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(!(o instanceof Gem gem)){
            return false;
        }
        return this.value == gem.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
}
}
