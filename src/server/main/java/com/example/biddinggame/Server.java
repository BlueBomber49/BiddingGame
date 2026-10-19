package com.example.biddinggame;

import java.util.List;

import com.example.biddinggame.communications.requests.CreateGameRequest;
import com.example.biddinggame.communications.requests.CreatePlayerRequest;
import com.example.biddinggame.communications.requests.JoinGameRequest;
import com.example.biddinggame.communications.requests.UpdatePlayerNameRequest;
import com.example.biddinggame.communications.responses.CreatePlayerResponse;
import com.example.biddinggame.communications.responses.ListGamesResponse;
import com.example.biddinggame.database.Database;
import com.example.biddinggame.database.MemoryDatabase;
import com.example.biddinggame.services.GameService;
import com.example.biddinggame.services.PlayerService;
import com.google.gson.Gson;

import spark.*;

public class Server {

    public Database db;
    public GameService gameService;
    public PlayerService playerService;
    private Gson serializer = new Gson();

    public Server(){
        this.db = new MemoryDatabase();
        this.gameService = new GameService(db);
        this.playerService = new PlayerService(db);
    }

    public int run(int desiredPort){
        Spark.port(desiredPort);
        Spark.put("/test", this::test);
        Spark.put("/bid", this::resolveBids);
        Spark.put("/createGame", this::createGame);
        Spark.put("/createPlayer", this::createPlayer);
        Spark.put("/updateName", this::updatePlayerName);
        Spark.put("/joinGame", this::joinGame);
        Spark.get("/gamesList", this::getGames);
        Spark.awaitInitialization();
        desiredPort = Spark.port();
        System.out.printf("Listening on port %d%n", desiredPort);

        return Spark.port();
    }

    public Object test(Request req, Response res) {
        System.out.println("Hit endpoint"); 
        return res;
    }

    public Object resolveBids(Request req, Response res) {
        return res;
    }

    public Object createGame(Request req, Response res){
        var response = serializer.fromJson(req.body(), CreateGameRequest.class);
        this.gameService.createGame(response.gameName);
        return res;
    }

    public Object joinGame(Request req, Response res){
        var response = serializer.fromJson(req.body(), JoinGameRequest.class);
        this.gameService.joinGame(response.gameId, response.playerId);
        return res;
    }

    public Object getGames(Request req, Response res){
        List<Game> gamesList = this.gameService.getGames();
        res.type("application/json");
        return serializer.toJson(ListGamesResponse.fromGames(gamesList));
    }

    public Object createPlayer(Request req, Response res){
        var request = serializer.fromJson(req.body(), CreatePlayerRequest.class);
        int id = this.playerService.createPlayer(request.playerName);
        res.type("application/json");
        return serializer.toJson(CreatePlayerResponse.fromId(id));
    }

    public Object updatePlayerName(Request req, Response res){
        var request = serializer.fromJson(req.body(), UpdatePlayerNameRequest.class);
        this.playerService.updatePlayerName(request.id, request.playerName);
        return res;
    }

}
