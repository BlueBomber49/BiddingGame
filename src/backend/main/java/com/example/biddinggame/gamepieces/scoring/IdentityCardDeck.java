package com.example.biddinggame.gamepieces.scoring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.biddinggame.gamepieces.*;

public class IdentityCardDeck extends RandomAccessContainer<IdentityCard>{

    public List<IdentityCard> uniqueCards;

    private List<IdentityCard> allCards = new ArrayList<IdentityCard>(List.of(
        new IdentityCard("The Painter", ScoringRules::scorePainter, "Scores 3 points for each set of 3 differently colored cards"),
        new IdentityCard("The Vegan", ScoringRules::scoreVegan, "Scores 1 point for every 2 green shapes, and 2 points for having more green shapes than your opponent"),
        new IdentityCard("The Collector", ScoringRules::scoreCollector, "Scores 1 point for pairs of cards (same card, different colors), and 3 points for a complete set"),
        new IdentityCard("The Musketeer", ScoringRules::scoreMusketeer, "Scores 6 points for having more 3's than your opponent, 3 points for tying"),
        new IdentityCard("The 4-Square Master", ScoringRules::scoreFourSquareMaster, "Scores 1 point for every 4 squares, plus an additional 2 points for every 4 squares if you have an exact multiple of 4"),
        new IdentityCard("The Diplomat", ScoringRules::scoreDiplomat,"Scores 4 points for each category of shapes that you tie with your opponent"),
        new IdentityCard("The Jester", ScoringRules::scoreJester, "Scores 1 point for every 3 circles, and 1 point per set of 3 colored circles"),
        new IdentityCard("Mr. Scrooge", ScoringRules::scoreScrooge, "Scores 1 point for each gem left in the bag at the end of the game, plus 2 points if the blue gem is left in the bag"),
        new IdentityCard("The Building Contractor", ScoringRules::scoreBuildingContractor, "Scores 1 point for each pair of square and triangle, loses 1 point for each lone square or triangle"),
        new IdentityCard("Even Steven", ScoringRules::scoreEvenSteven, "Scores 2 points for each even card, loses 1 point for each odd card"),
        new IdentityCard("The Were-Vampire", ScoringRules::scoreWereVampire, "Scores 3 points for having more red shapes than your opponent and...?")
    ));

    public IdentityCardDeck(){
        Collections.shuffle(allCards);
        this.uniqueCards = new ArrayList<>();
        this.addItems(allCards.subList(0, 6));
        this.uniqueCards.addAll(allCards.subList(0, 6));
        this.addItems(allCards.subList(0, 6));
    }

    public List<IdentityCard> getUniqueCards(){
        return this.uniqueCards;
    }
    
}
