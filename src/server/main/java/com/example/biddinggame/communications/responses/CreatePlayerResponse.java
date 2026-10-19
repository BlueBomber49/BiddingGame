package com.example.biddinggame.communications.responses;

public class CreatePlayerResponse {
    public int playerId;

    public CreatePlayerResponse(int id){
        this.playerId = id;
    }

    public static CreatePlayerResponse fromId(int id){
        return new CreatePlayerResponse(id);
    }
}
