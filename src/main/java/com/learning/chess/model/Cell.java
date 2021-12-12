package com.learning.chess.model;

import java.util.Objects;
import java.util.Optional;

public class Cell {
    private final Integer x, y;
    private final Optional<Figure> figure;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
        this.figure = Optional.empty();
    }

    public Cell(Integer x, Integer y, Figure figure) {
        this.x = x;
        this.y = y;
        this.figure = Optional.ofNullable(figure);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Optional<Figure> getFigure() {
        return figure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(x, cell.x) && Objects.equals(y, cell.y) && Objects.equals(figure, cell.figure);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, figure);
    }

    @Override
    public String toString() {
        return String.format("Cell[%d, %d] figure = %s", x, y, figure);
    }
}
