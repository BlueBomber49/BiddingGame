package com.example.biddinggame.gamepieces.scoring;

import java.util.List;

import com.example.biddinggame.gamepieces.GemBag;
import com.example.biddinggame.gamepieces.ShapeCard;

public class ScoringContext {
    List<ShapeCard> playerCards;
    List<ShapeCard> opponentCards;
    GemBag playerGems;

    public ScoringContext(List<ShapeCard> playerCards, List<ShapeCard> opponentCards, GemBag playerGems){
        this.playerCards = playerCards;
        this.opponentCards = opponentCards;
        this.playerGems = playerGems;
    }
}
