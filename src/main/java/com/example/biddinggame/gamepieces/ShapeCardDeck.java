package com.example.biddinggame.gamepieces;

public class ShapeCardDeck extends RandomAccessContainer<ShapeCard>{

    public ShapeCardDeck(){
        for(ShapeCard.Shape s: ShapeCard.Shape.values()){
            for(ShapeCard.Color c: ShapeCard.Color.values()){
                for(ShapeCard.Number n: ShapeCard.Number.values()){
                    this.addItem(new ShapeCard(s, c, n));
                }
            }
        }
    }
    
}
