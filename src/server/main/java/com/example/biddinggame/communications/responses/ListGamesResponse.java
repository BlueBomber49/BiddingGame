package com.example.biddinggame.communications.responses;

import java.util.List;

import com.example.biddinggame.Game;

public record ListGamesResponse(List<GameSummary> games) {
	public record GameSummary(int id, String name, String player1, String player2) {}

	public static ListGamesResponse fromGames(List<Game> games) {
		return new ListGamesResponse(games.stream()
			.map(game -> new GameSummary(
				game.id,
				game.name,
				game.player1 == null ? null : game.player1.name,
				game.player2 == null ? null : game.player2.name))
			.toList());
	}
}
