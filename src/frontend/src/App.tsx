import "./App.css";
import { useState } from "react";
import { gameStates } from "./gameStates";
import Game from "./Game";
import CharacterSelect from "./CharacterSelect";
import { MainMenu } from "./MainMenu";

function App() {
  const [playerName, setPlayerName] = useState("Player 1");
  const [gameState, setGameState] = useState<gameStates>(gameStates.MENU);
  const navigateTo = (screen: gameStates) => setGameState(screen);

  if (gameState == gameStates.MENU)
    return (
      <MainMenu
        onNavigate={navigateTo}
        onNameChange={setPlayerName}
        playerName={playerName}
      />
    );
  else if (gameState == gameStates.GAME) {
    return <Game onNavigate={navigateTo} playerName={playerName} />;
  } else if (gameState == gameStates.CHARACTER_SELECT) {
    return <CharacterSelect onNavigate={navigateTo} playerName={playerName} />;
  } else {
    return <h1>IDK how you got here, but congrats I guess?</h1>;
  }
}

export default App;
