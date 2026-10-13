import { gameStates, type ScreenProps } from "./gameStates";

function Game({ playerName, onNavigate, serverFacade }: ScreenProps) {
  return (
    <main className="game-screen">
      <h1>Gameplay</h1>
      <h2>{playerName}, you're losing</h2>
      <button onClick={() => onNavigate(gameStates.MENU)}>To Menu</button>
      <button onClick={() => serverFacade.test()}>Hit the endpoint</button>
    </main>
  );
}

export default Game;
