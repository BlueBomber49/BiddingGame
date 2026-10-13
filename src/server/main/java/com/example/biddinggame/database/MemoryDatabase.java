package com.example.biddinggame.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.biddinggame.Game;

public class MemoryDatabase implements Database{
    public Map<Integer, Game> gameMap;

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(gameMap.values());
    }

    @Override
    public Game getGame(int gameId) {
        return gameMap.get(gameId);
    }

    @Override
    public void updateGame(Game game) {
        if(gameMap.containsKey(game.id)) {
            gameMap.put(game.id, game);
        }
    }

    @Override 
    public void addGame(Game game){
        gameMap.put(game.id, game);
    }
    
}
