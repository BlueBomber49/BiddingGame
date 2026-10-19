package com.example.biddinggame;

import java.util.ArrayList;
import java.util.List;

import com.example.biddinggame.gamecomponents.Player;
import com.example.biddinggame.gamecomponents.ShapeCardDeck;
import com.example.biddinggame.gamecomponents.scoring.IdentityCardDeck;
import com.example.biddinggame.gamezones.Bid;
import com.example.biddinggame.gamezones.BiddingArea;

public class Game {
    public Player player1;
    public Player player2;
    public IdentityCardDeck identityCards;
    public ShapeCardDeck shapeCards;
    public ShapeCardDeck shapeDiscard;
    public BiddingArea biddingArea;
    public static int nextId = 1;
    public final int id;
    public String name;
    public int roundCount;
    
    public Game(String name){
        this.id = nextId++;
        this.identityCards = new IdentityCardDeck();
        this.shapeCards = new ShapeCardDeck();
        this.shapeDiscard = new ShapeCardDeck(new ArrayList<>());
        this.name = name == null || name.isBlank() ? "Unnamed Game " + id : name;
    }

    public Game(String name, ShapeCardDeck shapeCards){
        this.id = nextId++;
        this.identityCards = new IdentityCardDeck();
        this.shapeCards = shapeCards;
        this.shapeDiscard = new ShapeCardDeck(new ArrayList<>());
        this.name = name == null || name.isBlank() ? "Unnamed Game " + id : name;
    }

    public void setupIdentities(){

    }

    public void addPlayer(Player player){
        if(this.player1 == null){
            this.player1 = player;
        }
        else if(this.player2 == null){
            this.player2 = player;
        }
        else{
            throw new IllegalStateException("Game already has two players");
        }
    }

    public void setupBiddingArea(){
        this.biddingArea = new BiddingArea(this.player1, this.player2);
        this.biddingArea.setup(shapeCards);
        this.roundCount = 1;
    }

    public void resolveRound(List<Bid> allBids){
        for(Bid b: allBids){
            this.biddingArea.bid(b);
        }
        this.shapeDiscard.addItems(this.biddingArea.resolve());
        this.biddingArea.setup(shapeCards);
        this.roundCount++;
    }

}
