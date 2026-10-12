package com.example.biddinggame.gamepieces.scoring;

import java.util.List;

import com.example.biddinggame.gamepieces.Gem;
import com.example.biddinggame.gamepieces.ShapeCard;
import com.example.biddinggame.gamepieces.ShapeCard.*;
 
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

    /*
    Scores 2 points per even number, loses 1 point for each odd number
    */
    public static int scoreEvenSteven(ScoringContext context){
        int totalPoints = context.playerCards.stream().filter(card -> card.getNumber() % 2 == 0 ).toList().size()*2;
        totalPoints -= context.playerCards.stream().filter(card -> card.getNumber() % 2 == 1 ).toList().size();
        return totalPoints;
    }

    /*
    Scores 1 point per pair of squares/triangles, loses 1 point for excess squares/triangles
    */
    public static int scoreBuildingContractor(ScoringContext context){
        int totalPoints = 0;
        int numSquares = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.SQUARE ).toList().size();
        int numTriangles = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.TRIANGLE ).toList().size();
        totalPoints += Math.min(numSquares, numTriangles); // Number of pairs of squares/triangles
        totalPoints -= Math.max(numSquares, numTriangles) - totalPoints; // Number of excess squares/triangles
        return totalPoints;
    }

    /*
    Scores 6 points for having more 3's than your opponent, 3 points for being tied
    */
    public static int scoreMusketeer(ScoringContext context){
        int numThrees = context.playerCards.stream().filter(card -> card.number == ShapeCard.Number.THREE).toList().size();
        int opponentThrees = context.opponentCards.stream().filter(card -> card.number == ShapeCard.Number.THREE).toList().size();
        return numThrees > opponentThrees ? 6 : (numThrees == opponentThrees ? 3 : 0);
    }

    /*
    Scores 1 point for every 4 squares, plus 2 points for every 4 squares if you have a multiple of 4
    */
    public static int scoreFourSquareMaster(ScoringContext context){
        int numSquares = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.SQUARE).mapToInt(card -> card.getNumber()).sum();
        int totalPoints = Math.floorDiv(numSquares, 4);
        if(numSquares % 4 == 0){
            totalPoints *= 3;
        }
        return totalPoints;
    }

    /*
    Scores 4 points for each shape category which is tied with your opponent
    */
    public static int scoreDiplomat(ScoringContext context){
        int tiedCirclesPoints = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.CIRCLE).toList().size() == context.opponentCards.stream().filter(card -> card.shape == ShapeCard.Shape.CIRCLE ).toList().size() ? 4 : 0;
        int tiedTrianglePoints = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.TRIANGLE).toList().size() == context.opponentCards.stream().filter(card -> card.shape == ShapeCard.Shape.TRIANGLE ).toList().size() ? 4 : 0;
        int tiedSquarePoints = context.playerCards.stream().filter(card -> card.shape == ShapeCard.Shape.SQUARE).toList().size() == context.opponentCards.stream().filter(card -> card.shape == ShapeCard.Shape.SQUARE ).toList().size() ? 4 : 0;
        return tiedCirclesPoints + tiedTrianglePoints + tiedSquarePoints;
    }

    /*
    TODO: implement
    */
    public static int scoreJester(ScoringContext context){
        return 0;
    }

    /*
    Scores 3 points for blue gem, 1 point for white gems
    */
    public static int scoreScrooge(ScoringContext context){
        int totalPoints = context.playerGems.getAllItems().size();
        if(context.playerGems.getAllItems().contains(new Gem(7))){
            totalPoints += 2;
        }
        return totalPoints;
    }

    /*
    TODO: implement
    */
    public static int scoreWereVampire(ScoringContext context){
        return 0;
    }
}
