import type { ServerFacade } from "./serverfacade/serverFacade";

export enum gameStates {
  MENU,
  CHARACTER_SELECT,
  GAME,
}

export interface ScreenProps {
  playerName: string;
  onNavigate: (screen: gameStates) => void;
  serverFacade: ServerFacade;
}