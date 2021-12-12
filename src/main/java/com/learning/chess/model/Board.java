package com.learning.chess.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final Integer size;
    private final List<Cell> figuresCells;

    public Board(Integer size, Cell... figuresCells) {
        this.size = size;
        this.figuresCells = new ArrayList<>(Arrays.asList(figuresCells));
    }

    public Cell getCell(Integer x, Integer y) {
        if (x < 0 || y < 0 || x > size || y > size)
            throw new IllegalArgumentException("Index out of board bounds");

        return figuresCells.stream()
                .filter(c -> c.getX().equals(x) && c.getY().equals(y))
                .findAny()
                .orElseGet(() -> new Cell(x, y));
    }

    public Integer getSize() {
        return size;
    }
}
