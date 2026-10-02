package com.example.biddinggame;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.biddinggame.gamepieces.Gem;
import com.example.biddinggame.gamepieces.ShapeCard;
import com.example.biddinggame.gamepieces.ShapeCardDeck;

public class BiddingAreaTest {
    //Test that it accurately divvys out cards based on bids

    private BiddingArea biddingArea;
    private Player p1;
    private Player p2;
    private ShapeCard card1;
    private ShapeCard card2;
    private ShapeCard card3;

    @BeforeEach
    public void setup(){
        this.p1 = new Player();
        this.p2 = new Player();
        this.biddingArea = new BiddingArea(p1, p2);
        this.card1 = new ShapeCard(ShapeCard.Shape.SQUARE, ShapeCard.Color.RED, ShapeCard.Number.ONE);
        this.card2 = new ShapeCard(ShapeCard.Shape.CIRCLE, ShapeCard.Color.BLUE, ShapeCard.Number.ONE);
        this.card3 = new ShapeCard(ShapeCard.Shape.TRIANGLE, ShapeCard.Color.GREEN, ShapeCard.Number.ONE);
        ShapeCardDeck shapeDeck = new ShapeCardDeck(new ArrayList<>(List.of(card1, card2, card3)));
        this.biddingArea.setup(shapeDeck);
    }

    @Test 
    void testWinningBids(){
        this.biddingArea.bid(this.p1, this.card1, new ArrayList<Gem>(List.of(new Gem(1),new Gem(1),new Gem(1)))); //3 total
        this.biddingArea.bid(this.p1, this.card2, new ArrayList<Gem>(List.of(new Gem(4), new Gem(1)))); //5 total
        this.biddingArea.bid(this.p1, this.card3, new ArrayList<Gem>(List.of(new Gem(4)))); //4 total

        this.biddingArea.bid(this.p2, this.card1, new ArrayList<Gem>(List.of(new Gem(2)))); //2 total
        this.biddingArea.bid(this.p2, this.card2, new ArrayList<Gem>(List.of(new Gem(2), new Gem(1)))); //3 total
        this.biddingArea.bid(this.p2, this.card3, new ArrayList<Gem>(List.of(new Gem(7)))); //7 total
        this.biddingArea.resolve();

        assertTrue(p2.ownedCards.contains(card3));
        assertTrue(p1.ownedCards.contains(card1));
        assertTrue(p1.ownedCards.contains(card2));
        assertTrue(biddingArea.cardsForPurchase.isEmpty());
    }

    @Test 
    void testEmptyBids(){
        biddingArea.resolve();

        assertTrue(p1.ownedCards.isEmpty());
        assertTrue(p2.ownedCards.isEmpty());
        assertTrue(biddingArea.cardsForPurchase.isEmpty());
    }

    @Test 
    void testTiedBids(){
        List<Gem> playerBid = List.of(new Gem(2), new Gem(1));
        List<Gem> opponentBid = List.of(new Gem(1), new Gem(2));
        int playerGemCount = p1.gemBag.getAllItems().size();
        int opponentGemCount = p2.gemBag.getAllItems().size();

        biddingArea.bid(p1, card1, playerBid);
        biddingArea.bid(p2, card1, opponentBid);
        biddingArea.resolve();

        assertTrue(p1.ownedCards.isEmpty());
        assertTrue(p2.ownedCards.isEmpty());
        assertEquals(playerGemCount + playerBid.size(), p1.gemBag.getAllItems().size());
        assertEquals(opponentGemCount + opponentBid.size(), p2.gemBag.getAllItems().size());
        assertTrue(biddingArea.cardsForPurchase.isEmpty());

    }
}
