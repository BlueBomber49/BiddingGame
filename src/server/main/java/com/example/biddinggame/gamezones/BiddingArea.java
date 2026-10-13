package com.example.biddinggame.gamezones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.biddinggame.gamecomponents.*;

public class BiddingArea {
    Player player;
    Player opponent;
    public List<ShapeCard> cardsForPurchase;
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

    public void bid(Bid bid){
        if(bid.player == this.player){
            playerBids.put(bid.card, bid.gemList);
        }
        else if(bid.player == this.opponent){
            opponentBids.put(bid.card, bid.gemList);
        }
    }

    public List<ShapeCard> resolve(){
        List<ShapeCard> cardsDiscarded = new ArrayList<>();
        for(int i=0; i<3; i++){
            ShapeCard card = cardsForPurchase.get(i);
            int playerBid = playerBids.get(card).stream().mapToInt(gem -> gem.getValue()).sum();
            int opponentBid = opponentBids.get(card).stream().mapToInt(gem -> gem.getValue()).sum();
            if(playerBid > opponentBid){
                this.player.addCard(card);
                this.opponent.discardGems(opponentBids.get(card));
            }
            else if(playerBid < opponentBid){
                this.opponent.addCard(card);
                this.player.discardGems(playerBids.get(card));
            }
            else{ //bids tied, return gems and discard card
                this.player.addGems(playerBids.get(card));
                this.opponent.addGems(opponentBids.get(card));
                cardsDiscarded.add(card);
            }
        }
        playerBids.clear();
        opponentBids.clear();
        cardsForPurchase.clear();
        return cardsDiscarded;
    }
}
