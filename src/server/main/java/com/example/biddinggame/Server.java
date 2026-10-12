package com.example.biddinggame;

import spark.*;

public class Server {

    public Server(){
    }

    public int run(int desiredPort){
        Spark.port(desiredPort);
        Spark.put("/game", this::joinGame);
        Spark.awaitInitialization();
        desiredPort = Spark.port();
        System.out.printf("Listening on port %d%n", desiredPort);

        return Spark.port();
    }

    public Object joinGame(Request req, Response res) {
        System.out.println("Hit endpoint"); 
        return res;
    }
}
