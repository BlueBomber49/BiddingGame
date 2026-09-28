package com.example.biddinggame.gamepieces;

public class ShapeCard {
    public enum Color {RED, BLUE, GREEN}
    public enum Shape {SQUARE, TRIANGLE, CIRCLE}
    public enum Number {ONE, TWO, THREE;}

    public Color color;
    public Shape shape;
    public Number number;

    public ShapeCard(Shape shape, Color color, Number number){
        this.color = color;
        this.shape = shape;
        this.number = number;
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

}
