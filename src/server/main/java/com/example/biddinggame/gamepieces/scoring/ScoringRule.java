package com.example.biddinggame.gamepieces.scoring;
@FunctionalInterface 
public interface ScoringRule {
    int score(ScoringContext context);
}
