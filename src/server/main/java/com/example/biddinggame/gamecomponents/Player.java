package com.example.biddinggame.gamecomponents;

import java.util.ArrayList;
import java.util.List;

import com.example.biddinggame.gamecomponents.scoring.IdentityCard;

public class Player {
    public static int nextId = 1;
    public final int id;
    public List<ShapeCard> ownedCards;
    public IdentityCard identity;
    public GemBag gemBag;
    public GemBag discardedGems;

    public Player(){
        this.ownedCards = new ArrayList<>();
        this.gemBag = new GemBag(true);
        this.discardedGems = new GemBag(false);
        this.identity = null;
        this.id = nextId++;
    }

    public void addCard(ShapeCard card){
        this.ownedCards.add(card);
    }

    public void addGems(List<Gem> gems){
        this.gemBag.addItems(gems);
    }

    public void get5Gems(){
        this.gemBag.getNItems(5);
    }

    public void discardGems(List<Gem> gems){
        this.discardedGems.addItems(gems);
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
