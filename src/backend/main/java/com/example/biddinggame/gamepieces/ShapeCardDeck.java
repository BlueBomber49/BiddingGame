package com.example.biddinggame.gamepieces;

import java.util.List;

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

    public ShapeCardDeck(List<ShapeCard> cardList){
        this.addItems(cardList);
    }
    
}
