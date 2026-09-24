package SharedGameAssets.Scoring;

import java.util.List;

import SharedGameAssets.ShapeCard;
import SharedGameAssets.ShapeCard.*;

public class ScoringRules {

    /*
    Scores 1 point for every 2 green shapes, + 1 point for having more green than red or blue shapes
    */
    public static int scoreVegan(ScoringContext context){
        int greenShapes = context.playerCards.stream().filter(card -> card.color == Color.GREEN).mapToInt(card -> card.getNumber()).sum();
        int redShapes = context.playerCards.stream().filter(card -> card.color == Color.RED).mapToInt(card -> card.getNumber()).sum();
        int blueShapes = context.playerCards.stream().filter(card -> card.color == Color.BLUE).mapToInt(card -> card.getNumber()).sum();
        int totalScore = 0;
        if(greenShapes > blueShapes){
            totalScore += 1;
        }
        if(greenShapes > redShapes){
            totalScore += 1;
        }
        totalScore += Math.floorDiv(greenShapes, 2);
        return totalScore;
    }

    /*
    Scores 3 points for each set of cards of different colors
    */
    public static int scorePainter(ScoringContext context){
        int numRedCards = context.playerCards.stream().filter(card -> card.color == Color.RED).toList().size();
        int numBlueCards = context.playerCards.stream().filter(card -> card.color == Color.BLUE).toList().size();
        int numGreenCards = context.playerCards.stream().filter(card -> card.color == Color.GREEN).toList().size();
        return Math.min(numRedCards, Math.min(numBlueCards, numGreenCards))*3;
    }

    /*
    Scores 1 point for each pair, 3 points for each complete set (Same cards, different colors)
    */
    public static int scoreCollector(ScoringContext context){
        int totalPoints = 0;
        for(Shape s : ShapeCard.Shape.values()){
            for(ShapeCard.Number n : ShapeCard.Number.values()){
                List<ShapeCard> l = context.playerCards.stream().filter(card -> card.shape == s && card.number == n).toList();
                if(l.size() > 1){
                    totalPoints += l.size() == 2 ? 1 : 3;
                }
            }
        }
        return totalPoints;
    }
}
