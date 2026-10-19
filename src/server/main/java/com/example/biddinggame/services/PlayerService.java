package com.example.biddinggame.services;

import com.example.biddinggame.database.Database;
import com.example.biddinggame.gamecomponents.Player;

public class PlayerService {
    private Database db;

    public PlayerService(Database db){
        this.db = db;
    }

    public int createPlayer(String name){
        Player p = new Player(name);
        this.db.addPlayer(p);
        return p.id;
    }

    public void updatePlayerName(int playerId, String name){
        Player p = this.db.getPlayer(playerId);
        p.name = name;
        this.db.addPlayer(p);
    }
}
