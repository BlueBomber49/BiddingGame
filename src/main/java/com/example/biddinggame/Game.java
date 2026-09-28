package com.example.biddinggame;

import com.example.biddinggame.gamepieces.scoring.IdentityCardDeck;

public class Game {
    public Player player;
    public Player opponent;
    public IdentityCardDeck identityCards;
    
    public Game(){
        this.identityCards = new IdentityCardDeck();
        this.player = new Player();
        this.opponent = new Player();
    }
}
