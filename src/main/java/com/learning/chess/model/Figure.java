package com.learning.chess.model;

import java.util.List;

public interface Figure {
    FigureType getType();

    Color getColor();

    List<Cell> getAvailableMovements();

    void setPosition(Cell position);

    void setBoard(Board board);
}
