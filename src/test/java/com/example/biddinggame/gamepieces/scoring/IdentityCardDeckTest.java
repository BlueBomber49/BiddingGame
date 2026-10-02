package com.example.biddinggame.gamepieces.scoring;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class IdentityCardDeckTest {

    @Test
    void containsTwoCopiesOfEachUniqueCard() {
        IdentityCardDeck deck = new IdentityCardDeck();
        List<IdentityCard> uniqueCards = deck.getUniqueCards();

        assertEquals(6, uniqueCards.size(), "the deck should select six unique cards");
        assertEquals(6, uniqueCards.stream().map(card -> card.name).distinct().count(),
                "the unique-card list should contain six different identities");

        for (IdentityCard uniqueCard : uniqueCards) {
            long copies = deck.getAllItems().stream()
                    .filter(card -> card.name.equals(uniqueCard.name))
                    .count();
            assertEquals(2, copies, "each identity should have two drawable copies");
        }
    }
}
