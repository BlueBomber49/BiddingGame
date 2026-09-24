package SharedGameAssets.Scoring;

import java.util.List;

import SharedGameAssets.GemBag;
import SharedGameAssets.ShapeCard;

public class ScoringContext {
    List<ShapeCard> playerCards;
    List<ShapeCard> opponentCards;
    GemBag playerGems;

    public ScoringContext(List<ShapeCard> playerCards, List<ShapeCard> opponentCards, GemBag playerGems){
        this.playerCards = playerCards;
        this.opponentCards = opponentCards;
        this.playerGems = playerGems;
    }
}
