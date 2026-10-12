package com.example.biddinggame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.biddinggame.gamepieces.*;

public class BiddingArea {
    Player player;
    Player opponent;
    List<ShapeCard> cardsForPurchase;
    Map<ShapeCard, List<Gem>> playerBids;
    Map<ShapeCard, List<Gem>> opponentBids;

    public BiddingArea(Player player, Player opponent){
        this.cardsForPurchase = new ArrayList<>();
        this.playerBids = new HashMap<>();
        this.opponentBids = new HashMap<>();
        this.player = player;
        this.opponent = opponent;
    }

    public void setup(ShapeCardDeck deck){
        for(int i=0; i<3; i++){
            ShapeCard card = deck.getItem();
            cardsForPurchase.add(card);
            playerBids.put(card, new ArrayList<>());
            opponentBids.put(card, new ArrayList<>());
        }
    }

    public void bid(Player player, ShapeCard card, List<Gem> bid){
        if(player == this.player){
            playerBids.put(card, bid);
        }
        else if(player == this.opponent){
            opponentBids.put(card, bid);
        }
    }

    public void resolve(){
        for(int i=0; i<3; i++){
            ShapeCard card = cardsForPurchase.get(i);
            int playerBid = playerBids.get(card).stream().mapToInt(gem -> gem.getValue()).sum();
            int opponentBid = opponentBids.get(card).stream().mapToInt(gem -> gem.getValue()).sum();
            if(playerBid > opponentBid){
                this.player.addCard(card);
            }
            else if(playerBid < opponentBid){
                this.opponent.addCard(card);
            }
            else{ //bids tied, return gems.  TODO: discard card
                this.player.addGems(playerBids.get(card));
                this.opponent.addGems(opponentBids.get(card));
            }
        }
        //Cleanup.  TODO: discard gems
        playerBids.clear();
        opponentBids.clear();
        cardsForPurchase.clear();
    }
}
