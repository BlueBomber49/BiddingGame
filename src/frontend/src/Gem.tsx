import "./Gem.css";

import type { DragEventHandler, MouseEventHandler } from "react";

type GemColor = "ruby" | "sapphire" | "citrine" | "jade";

interface GemProps {
  value: number;
  color?: GemColor;
  selected?: boolean;
  compact?: boolean;
  onClick?: MouseEventHandler<HTMLButtonElement>;
  onDragStart?: DragEventHandler<HTMLButtonElement>;
}

function Gem({
  value,
  color = "ruby",
  selected = false,
  compact = false,
  onClick,
  onDragStart,
}: GemProps) {
  return (
    <button
      type="button"
      className={`gem gem--${color}${selected ? " gem--selected" : ""}${compact ? " gem--compact" : ""}`}
      draggable={!compact}
      onClick={onClick}
      onDragStart={onDragStart}
      aria-label={`${color} gem, value ${value}${selected ? ", selected" : ""}`}
      aria-pressed={onClick ? selected : undefined}
    >
      <span className="gem-value">{value}</span>
    </button>
  );
}

export default Gem;
