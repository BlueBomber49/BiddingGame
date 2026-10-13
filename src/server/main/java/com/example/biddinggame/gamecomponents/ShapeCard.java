package com.example.biddinggame.gamecomponents;

import java.util.ArrayList;
import java.util.List;

public class ShapeCard {
    public enum Color {RED, BLUE, GREEN}
    public enum Shape {SQUARE, TRIANGLE, CIRCLE}
    public enum Number {ONE, TWO, THREE;}

    public Color color;
    public Shape shape;
    public Number number;
    public List<Gem> purchasedPrice;

    public ShapeCard(Shape shape, Color color, Number number){
        this.color = color;
        this.shape = shape;
        this.number = number;
        this.purchasedPrice = new ArrayList<>();
    }

    public int getNumber(){
        switch(this.number){
            case ONE:
                return 1;
            case TWO:
                return 2;
            case THREE:
                return 3;
            default:
                return 0;
        }
    }

    public void purchase(List<Gem> gems){
        this.purchasedPrice = gems;
    }

    @Override public String toString(){
        return "(Color: " + this.color + " Shape: " + this.shape + " Number: " + this.number + ")";
    }

}
