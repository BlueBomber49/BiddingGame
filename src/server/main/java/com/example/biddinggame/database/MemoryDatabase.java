package com.example.biddinggame.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.biddinggame.Game;
import com.example.biddinggame.gamecomponents.Player;

public class MemoryDatabase implements Database{
    public Map<Integer, Game> gameMap = new HashMap<>();
    public Map<Integer, Player> playerMap = new HashMap<>();

    @Override
    public List<Game> getGames() {
        return new ArrayList<>(this.gameMap.values());
    }

    @Override
    public Game getGame(int gameId) {
        return this.gameMap.get(gameId);
    }

    @Override
    public void updateGame(Game game) {
        if(this.gameMap.containsKey(game.id)) {
            this.gameMap.put(game.id, game);
        }
    }

    @Override 
    public void addGame(Game game){
        this.gameMap.put(game.id, game);
    }

    @Override
    public void addPlayer(Player player) {
        this.playerMap.put(player.id, player);
    }

    @Override
    public Player getPlayer(int playerId) {
       return this.playerMap.get(playerId);
    }

    @Override 
    public void updatePlayer(Player player){
        if(this.playerMap.containsValue(player)){
            this.playerMap.put(player.id, player);
        }
    }
    
}
