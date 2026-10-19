import type { BidRequest } from "./requests/BidRequest";
import type { CreateGameRequest } from "./requests/CreateGameRequest";
import type { CreatePlayerRequest } from "./requests/CreatePlayerRequest";
import type { JoinGameRequest } from "./requests/JoinGameRequest";
import type { UpdatePlayerNameRequest } from "./requests/UpdatePlayerNameRequest";
import type { CreatePlayerResponse } from "./responses/CreatePlayerResponse";
import type { GetGamesResponse } from "./responses/GetGamesResponse";

export class ServerFacade {
  private baseUrl!: string;
  constructor(baseUrl: string = "/api") {
    if (!baseUrl) {
      throw Error("No server URL");
    }
    this.baseUrl = baseUrl;
  }

  public async test(): Promise<void> {
    const response = await fetch(`${this.baseUrl}/test`, { method: "PUT" });
    if (!response.ok) {
      throw new Error(`Test request failed: ${response.status}`);
    }
  }

  public async sendBids(body: BidRequest): Promise<void> {
    const response = await fetch(`${this.baseUrl}/bid`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    if (!response.ok) {
      throw new Error(`Sending bids failed: ${response.status}`);
    }
  }

  public async createGame(body: CreateGameRequest): Promise<void> {
    const response = await fetch(`${this.baseUrl}/createGame`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    if (!response.ok) {
      throw new Error(`Creating game failed: ${response.status}`);
    }
  }

  public async joinGame(body: JoinGameRequest): Promise<void> {
    const response = await fetch(`${this.baseUrl}/join`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    if (!response.ok) {
      throw new Error(`Joining game failed: ${response.status}`);
    }
  }

  public async getGames(): Promise<GetGamesResponse | null> {
    const response = await fetch(`${this.baseUrl}/gamesList`, {
      method: "GET",
      headers: { "Content-Type": "application/json" },
    });
    if (!response.ok) {
      throw new Error(`Getting games failed: ${response.status}`);
    }
    return await response.json();
  }

  public async createPlayer(
    request: CreatePlayerRequest,
  ): Promise<CreatePlayerResponse> {
    const response = await fetch(`${this.baseUrl}/createPlayer`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(request),
    });
    if (!response.ok) {
      throw new Error(`Creating player failed: ${response.status}`);
    }
    return await response.json();
  }

  public async updatePlayerName(request: UpdatePlayerNameRequest){
    const response = await fetch(`${this.baseUrl}/updateName`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(request),
    })
    if (!response.ok) {
      throw new Error(`Getting games failed: ${response.status}`);
    }
  }
}
