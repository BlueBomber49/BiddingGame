package com.example.biddinggame.gamezones;

import java.util.List;

import com.example.biddinggame.gamecomponents.Gem;
import com.example.biddinggame.gamecomponents.Player;
import com.example.biddinggame.gamecomponents.ShapeCard;

public class Bid{
    public Player player;
    public ShapeCard card;
    public List<Gem> gemList;

    public Bid(Player player, ShapeCard card, List<Gem> gemList){
        this.player = player;
        this.card = card;
        this.gemList = gemList;
    }
}
