import { gameStates, type ScreenProps } from "./gameStates";

function CharacterSelect({ playerName, onNavigate }: ScreenProps) {
  return (
    <main className="character-select-screen">
      <h1>Character Select</h1>
      <h3>Hi, {playerName}</h3>
      <button onClick={() => onNavigate(gameStates.GAME)}>Start Game</button>
    </main>
  );
}

export default CharacterSelect;
