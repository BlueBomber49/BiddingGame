import { gameStates, type ScreenProps } from "./gameStates";

interface MainMenuProps extends ScreenProps {
  onNameChange: (name: string) => void;
}

export function MainMenu({
  playerName,
  onNameChange,
  onNavigate,
}: MainMenuProps) {
  return (
    <main className="main-menu">
      <h1>Bidding Game</h1>
      <h3>By: Tony Johnson</h3>
      <p>Player Name:</p>
      <input
        value={playerName}
        onChange={(event) => onNameChange(event.target.value)}
      ></input>
      <button onClick={() => onNavigate(gameStates.CHARACTER_SELECT)}>
        Start Game
      </button>
    </main>
  );
}
