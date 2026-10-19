package com.example.biddinggame.services;

import java.util.List;

import com.example.biddinggame.Game;
import com.example.biddinggame.database.Database;
import com.example.biddinggame.gamecomponents.Player;

public class GameService {
    private Database db;

    public GameService(Database db){
        this.db = db;
    }

    public int createGame(String name){
        Game game = new Game(name);
        this.db.addGame(game);
        return game.id;
    }

    public void joinGame(int gameId, int playerId){
        Game gameToJoin = this.db.getGame(gameId);
        if(gameToJoin == null){
            //throw Error("Invalid Game Id");
            return;
        }
        gameToJoin.addPlayer(new Player());
    }

    public List<Game> getGames(){
        return this.db.getGames();
    }
}
