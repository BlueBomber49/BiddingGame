export type GameSummary = {
  id: number;
  name: string;
  player1: string | null;
  player2: string | null;
};

export type GetGamesResponse = {
  games: GameSummary[];
};
