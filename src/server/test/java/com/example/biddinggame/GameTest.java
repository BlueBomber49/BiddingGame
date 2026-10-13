package com.example.biddinggame;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.biddinggame.gamecomponents.Gem;
import com.example.biddinggame.gamecomponents.Player;
import com.example.biddinggame.gamecomponents.ShapeCard;
import com.example.biddinggame.gamecomponents.ShapeCardDeck;
import com.example.biddinggame.gamezones.Bid;

public class GameTest {

    private Player p1;
    private Player p2;
    private ShapeCard card1;
    private ShapeCard card2;
    private ShapeCard card3;
    private Game game;

    @BeforeEach
    public void setup(){
        this.card1 = new ShapeCard(ShapeCard.Shape.SQUARE, ShapeCard.Color.RED, ShapeCard.Number.ONE);
        this.card2 = new ShapeCard(ShapeCard.Shape.CIRCLE, ShapeCard.Color.BLUE, ShapeCard.Number.ONE);
        this.card3 = new ShapeCard(ShapeCard.Shape.TRIANGLE, ShapeCard.Color.GREEN, ShapeCard.Number.ONE);
        ShapeCardDeck shapeDeck = new ShapeCardDeck(new ArrayList<>(List.of(card1, card2, card3)));
        this.game = new Game("Test Game", shapeDeck);
        this.p1 = this.game.player;
        this.p2 = this.game.opponent;
        this.game.setupBiddingArea();
    }
    @Test 
    public void testRoundResolution(){
        Bid b1 = new Bid(p1, this.card1, new ArrayList<>(List.of(new Gem(4))));
        Bid b2 = new Bid(p1, this.card2, new ArrayList<>(List.of(new Gem(2))));
        Bid b3 = new Bid(p2, this.card2, new ArrayList<>(List.of(new Gem(2))));
        Bid b4 = new Bid(p2, this.card3, new ArrayList<>(List.of(new Gem(2), new Gem(1))));
        this.game.resolveRound(List.of(b1, b2, b3, b4));
        assertTrue(this.p1.ownedCards.contains(this.card1));
        assertTrue(this.p2.ownedCards.contains(this.card3));
        assertTrue(this.game.shapeDiscard.getAllItems().contains(card2));
        assertTrue(this.game.roundCount == 2);

    }
    
}
