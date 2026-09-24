package SharedGameAssets.Scoring;

public class IdentityCard {

    public ScoringRules score;
    public String description;
    public String name;
    
    public IdentityCard(String name, ScoringRules score, String description){
        this.score = score;
        this.name = name;
        this.description = description;
    }
    
}
