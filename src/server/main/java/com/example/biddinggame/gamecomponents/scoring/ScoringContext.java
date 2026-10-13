package com.example.biddinggame.gamecomponents.scoring;

import java.util.List;

import com.example.biddinggame.gamecomponents.GemBag;
import com.example.biddinggame.gamecomponents.ShapeCard;

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
