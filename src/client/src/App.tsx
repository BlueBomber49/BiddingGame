import "./App.css";
import { useState } from "react";
import { gameStates } from "./gameStates";
import Game from "./Game";
import CharacterSelect from "./CharacterSelect";
import { MainMenu } from "./MainMenu";
import { PlayerCreation } from "./PlayerCreation";
import { ServerFacade } from "./serverfacade/serverFacade";

function App() {
  const [playerName, setPlayerName] = useState("Player 1");
  const [playerId, setPlayerId] = useState<number | null>(null);
  const [gameState, setGameState] = useState<gameStates>(gameStates.PLAYER_CREATION);
  const navigateTo = (screen: gameStates) => setGameState(screen);
  const serverFacade: ServerFacade = new ServerFacade()

  if (gameState == gameStates.PLAYER_CREATION)
    return (
      <PlayerCreation
        onNavigate={navigateTo}
        onPlayerCreated={setPlayerId}
        onNameChange={setPlayerName}
        playerName={playerName}
        serverFacade={serverFacade}
      />
    );
  else if (gameState == gameStates.MENU && playerId !== null)
    return (
      <MainMenu
        onNavigate={navigateTo}
        onNameChange={setPlayerName}
        playerName={playerName}
        playerId={playerId}
        serverFacade={serverFacade}
      />
    );
  else if (gameState == gameStates.GAME) {
    return <Game onNavigate={navigateTo} playerName={playerName} serverFacade={serverFacade} />;
  } else if (gameState == gameStates.CHARACTER_SELECT) {
    return <CharacterSelect onNavigate={navigateTo} playerName={playerName} serverFacade={serverFacade}/>;
  } else {
    return <h1>IDK how you got here, but congrats I guess?</h1>;
  }
}

export default App;
