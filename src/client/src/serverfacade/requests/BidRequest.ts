export type GemDto = {
  value: number;
};

export type ShapeCardDto = {
  color: "RED" | "BLUE" | "GREEN";
  shape: "SQUARE" | "TRIANGLE" | "CIRCLE";
  number: "ONE" | "TWO" | "THREE";
  purchasedPrice: GemDto[];
};

export type BidDto = {
  player: {
    id: number;
  };
  card: ShapeCardDto;
  gemList: GemDto[];
};

export type BidRequest = {
  bidList: BidDto[];
};
