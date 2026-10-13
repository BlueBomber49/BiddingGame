package com.example.biddinggame.gameservice;

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

    public void joinGame(int gameId, int playerId){ //TODO: Reexamine Game being made with players
        Game gameToJoin = this.db.getGame(gameId);
        if(gameToJoin == null){
            //throw Error("Invalid Game Id");
            return;
        }
        else if(gameToJoin.player == null){
            Player p = new Player();  //Do we need a playerService?  Auth? This isn't going to work as is
            gameToJoin.player = p;
        }
        else if(gameToJoin.opponent == null){
            Player p = new Player();
            gameToJoin.opponent = p;
        }
        else{
            //Throw error("Game is already full")
            return;
        }
    }

    public List<Game> getGames(){
        return this.db.getGames();
    }
}
