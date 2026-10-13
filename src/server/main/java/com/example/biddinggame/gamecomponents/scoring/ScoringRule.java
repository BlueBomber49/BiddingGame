package com.example.biddinggame.gamecomponents.scoring;
@FunctionalInterface 
public interface ScoringRule {
    int score(ScoringContext context);
}
