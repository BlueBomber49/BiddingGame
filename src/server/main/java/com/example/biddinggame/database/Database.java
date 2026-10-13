package com.example.biddinggame.database;

import java.util.List;

import com.example.biddinggame.Game;

public interface Database {
    public List<Game> getGames(); // Map of ID's to games
    public Game getGame(int gameId); // returns all the data associated with a game
    public void updateGame(Game game); //Updates gem/card counts and round number
    public void addGame(Game game);
}
