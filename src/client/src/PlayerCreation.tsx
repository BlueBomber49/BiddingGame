import { useState } from "react";
import { gameStates, type ScreenProps } from "./gameStates";

interface PlayerCreationProps extends ScreenProps {
  onNameChange: (name: string) => void;
  onPlayerCreated: (playerId: number) => void;
}

export function PlayerCreation({
  playerName,
  onNameChange,
  onNavigate,
  onPlayerCreated,
  serverFacade,
}: PlayerCreationProps) {
  const [error, setError] = useState<string | null>(null);
  const [isCreating, setIsCreating] = useState(false);

  const createPlayer = async () => {
    setIsCreating(true);
    setError(null);
    try {
      const response = await serverFacade.createPlayer({
        playerName: playerName.trim(),
      });
      onPlayerCreated(response.playerId);
      onNavigate(gameStates.MENU);
    } catch (err) {
      setError(err instanceof Error ? err.message : "Could not create player");
    } finally {
      setIsCreating(false);
    }
  };

  return (
    <main className="player-creation-screen">
      <h1>Bidding Game</h1>
      <h2>Create your player</h2>
      <input
        aria-label="Player name"
        value={playerName}
        onChange={(event) => onNameChange(event.target.value)}
        onKeyDown={(event) => {
          if (event.key === "Enter" && playerName.trim() && !isCreating) {
            void createPlayer();
          }
        }}
      />
      <button
        type="button"
        disabled={!playerName.trim() || isCreating}
        onClick={() => void createPlayer()}
      >
        {isCreating ? "Creating..." : "Create Player"}
      </button>
      {error && <p role="alert">{error}</p>}
    </main>
  );
}
