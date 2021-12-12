package com.learning.chess.model;

public class Cell {
    private final Integer x, y;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
