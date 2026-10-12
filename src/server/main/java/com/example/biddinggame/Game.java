package com.example.biddinggame;

import com.example.biddinggame.gamepieces.scoring.IdentityCardDeck;

public class Game {
    public Player player;
    public Player opponent;
    public IdentityCardDeck identityCards;
    public BiddingArea biddingArea;
    public static int nextId = 1;
    public final int id;
    
    public Game(){
        this.id = nextId++;
        this.identityCards = new IdentityCardDeck();
        this.player = new Player();
        this.opponent = new Player();
        this.biddingArea = new BiddingArea(this.player, this.opponent);
    }

}
