package com.learning.chess.model.figure;


import com.learning.chess.model.Cell;
import com.learning.chess.model.Color;
import com.learning.chess.model.Figure;
import com.learning.chess.model.FigureType;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bishop extends Figure {
    private final Color color;
    private Cell position;

    public Bishop(Color color, Cell initPosition) {
        this.color = color;
        this.position = initPosition;
    }

    @Override
    public FigureType getType() {
        return FigureType.BISHOP;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public List<Cell> getAvailableMovements(Integer boardSize) {
        return Stream.of(
                Stream.iterate(position.getX(), pos -> pos < boardSize, pos -> pos + 1)
                        .map(pos -> new Cell(pos, position.getY())),
                Stream.iterate(position.getX(), pos -> pos >= 0, pos -> pos - 1)
                        .map(pos -> new Cell(pos, position.getY())),
                Stream.iterate(position.getY(), pos -> pos < boardSize, pos -> pos + 1)
                        .map(pos -> new Cell(position.getX(), pos)),
                Stream.iterate(position.getY(), pos -> pos >= 0, pos -> pos - 1)
                        .map(pos -> new Cell(position.getX(), pos))
        ).flatMap(Function.identity()).collect(Collectors.toList());
    }

    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }
}
