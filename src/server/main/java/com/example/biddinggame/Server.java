package com.example.biddinggame;

import java.util.List;

import com.example.biddinggame.communications.createGameRequest;
import com.example.biddinggame.communications.joinGameRequest;
import com.example.biddinggame.communications.listGamesResponse;
import com.example.biddinggame.database.Database;
import com.example.biddinggame.database.MemoryDatabase;
import com.example.biddinggame.gameservice.GameService;
import com.google.gson.Gson;

import spark.*;

public class Server {

    public Database db;
    public GameService gameService;
        private Gson serializer = new Gson();

    public Server(){
        this.db = new MemoryDatabase();
        this.gameService = new GameService(db);
    }

    public int run(int desiredPort){
        Spark.port(desiredPort);
        Spark.put("/test", this::test);
        Spark.put("/bid", this::resolveBids);
        Spark.put("/create", this::createGame);
        Spark.put("/join", this::joinGame);
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
        var response = serializer.fromJson(req.body(), createGameRequest.class);
        this.gameService.createGame(response.gameName);
        return res;
    }

    public Object joinGame(Request req, Response res){
        var response = serializer.fromJson(req.body(), joinGameRequest.class)
        this.gameService.joinGame(response.gameId, response.playerId);
        return res;
    }

    public Object getGames(Request req, Response res){
        List<Game> gamesList = this.gameService.getGames();
        return serializer.toJson(new listGamesResponse(gamesList));
    }

}
