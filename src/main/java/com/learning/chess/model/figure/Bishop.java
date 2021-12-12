package com.learning.chess.model.figure;


import com.learning.chess.model.*;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bishop implements Figure {
    private final Color color;
    private Board board;
    private Cell position;

    public Bishop(Color color) {
        this.color = color;
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
    public List<Cell> getAvailableMovements() {
        if (position == null || board == null)
            throw new IllegalStateException("position or board or both are not initialized");

        return Stream.of(
                Stream.iterate(position.getX() + 1, pos -> pos < board.getSize(), pos -> pos + 1)
                        .map(pos -> board.getCell(pos, position.getY()))
                        .takeWhile(c -> c.getFigure().isEmpty()),
                Stream.iterate(position.getX() - 1, pos -> pos >= 0, pos -> pos - 1)
                        .map(pos -> board.getCell(pos, position.getY()))
                        .takeWhile(c -> c.getFigure().isEmpty()),
                Stream.iterate(position.getY() + 1, pos -> pos < board.getSize(), pos -> pos + 1)
                        .map(pos -> board.getCell(position.getX(), pos))
                        .takeWhile(c -> c.getFigure().isEmpty()),
                Stream.iterate(position.getY() - 1, pos -> pos >= 0, pos -> pos - 1)
                        .map(pos -> board.getCell(position.getX(), pos))
                        .takeWhile(c -> c.getFigure().isEmpty())
        ).flatMap(Function.identity()).collect(Collectors.toList());
    }

    @Override
    public void setPosition(Cell position) {
        this.position = position;
    }

    @Override
    public void setBoard(Board board) {
        this.board = board;
    }
}
