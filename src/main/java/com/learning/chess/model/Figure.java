package com.learning.chess.model;

import java.util.List;

public abstract class Figure {
    public abstract FigureType getType();

    public abstract Color getColor();

    public abstract List<Cell> getAvailableMovements(Integer boardSize);

    public abstract void setPosition(Cell position);
}
