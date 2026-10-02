package com.example.biddinggame;

import java.util.ArrayList;
import java.util.List;

import com.example.biddinggame.gamepieces.Gem;
import com.example.biddinggame.gamepieces.GemBag;
import com.example.biddinggame.gamepieces.ShapeCard;
import com.example.biddinggame.gamepieces.scoring.IdentityCard;

public class Player {
    public static int nextId = 1;
    public final int id;
    public List<ShapeCard> ownedCards;
    public IdentityCard identity;
    public GemBag gemBag;

    public Player(){
        this.ownedCards = new ArrayList<>();
        this.gemBag = new GemBag();
        this.identity = null;
        this.id = nextId++;
    }

    public void addCard(ShapeCard card){
        this.ownedCards.add(card);
    }

    public void addGems(List<Gem> gems){
        this.gemBag.addItems(gems);
    }

    @Override 
    public boolean equals(Object o){
        if(this == o) {
            return true;
        }
        if(!(o instanceof Player player)){
            return false;
        }
        return this.id == player.id;
    }
}
