package com.example.biddinggame.gamecomponents.scoring;

public class IdentityCard {

    public ScoringRule score;
    public String description;
    public String name;
    
    public IdentityCard(String name, ScoringRule score, String description){
        this.score = score;
        this.name = name;
        this.description = description;
    }
    
}
