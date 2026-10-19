import { useCallback, useEffect, useState } from "react";
import { gameStates, type ScreenProps } from "./gameStates";
import type { GameSummary } from "./serverfacade/responses/GetGamesResponse";

interface MainMenuProps extends ScreenProps {
  onNameChange: (name: string) => void;
  playerId: number;
}

export function MainMenu({
  playerName,
  onNameChange,
  playerId,
  onNavigate,
  serverFacade,
}: MainMenuProps) {
  const [games, setGames] = useState<GameSummary[]>([]);
  const [error, setError] = useState<string | null>(null);
  const [gameName, setGameName] = useState<string>("");
  const [nameDraft, setNameDraft] = useState(playerName);
  const [nameError, setNameError] = useState<string | null>(null);

  const loadGames = useCallback(async () => {
    try {
      const response = await serverFacade.getGames();
      setGames(response?.games ?? []);
    } catch (err) {
      setError(err instanceof Error ? err.message : "Could not load games");
    }
  }, [serverFacade]);

  useEffect(() => {
    void loadGames();
  }, [loadGames]);

  return (
    <main className="main-menu">
      <h1>Bidding Game</h1>
      <h3>By: Tony Johnson</h3>
      <aside className="menu-player-editor" aria-label="Player settings">
        <label htmlFor="player-name">Player name</label>
        <div className="menu-player-controls">
          <input
            id="player-name"
            value={nameDraft}
            onChange={(event) => setNameDraft(event.target.value)}
          />
          <button
            type="button"
            disabled={!nameDraft.trim() || nameDraft === playerName}
            onClick={async () => {
              try {
                await serverFacade.updatePlayerName({
                  id: playerId,
                  playerName: nameDraft.trim(),
                });
                onNameChange(nameDraft.trim());
                setNameError(null);
              } catch (err) {
                setNameError(
                  err instanceof Error
                    ? err.message
                    : "Could not update player name",
                );
              }
            }}
          >
            Update
          </button>
        </div>
        {nameError && <p role="alert">{nameError}</p>}
      </aside>
      {error && <p role="alert">{error}</p>}
      <input
        value={gameName}
        onChange={(event) => setGameName(event.target.value)}
        placeholder="Insert game name here"
      />
      <button
        onClick={async () => {
          await serverFacade.createGame({ gameName: gameName });
          setGameName("");
          void loadGames();
        }}
      >
        Create game
      </button>
      <section className="game-list" aria-labelledby="game-list-title">
        <h2 id="game-list-title">Example games</h2>
        <ul>
          {games.map((game) => (
            <li className="game-list-item" key={game.id}>
              <div className="game-list-heading">
                <h3>{game.name}</h3>
                <button
                  type="button"
                  onClick={() => {
                    void serverFacade.joinGame({ gameId: game.id, playerId });
                    onNavigate(gameStates.CHARACTER_SELECT);
                  }}
                >
                  Join Game
                </button>
              </div>
              <p>
                Players: {game.player1 ?? "Open seat"} ·{" "}
                {game.player2 ?? "Open seat"}
              </p>
            </li>
          ))}
        </ul>
      </section>
      <button onClick={() => void loadGames()}>Refresh</button>
    </main>
  );
}
