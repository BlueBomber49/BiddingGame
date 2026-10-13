import type { BidRequest } from "./requests/BidRequest";
import type { CreateGameRequest } from "./requests/CreateGameRequest";
import type { JoinGameRequest } from "./requests/JoinGameRequest";

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
    const response = await fetch(`${this.baseUrl}/create`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
  }

  public async joinGame(body: JoinGameRequest): Promise<void> {
    const response = await fetch(`${this.baseUrl}/create`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
  }
}
