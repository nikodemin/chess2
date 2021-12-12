package chess.model.figure;

import com.learning.chess.model.Cell;

import java.util.Comparator;

public class CellComparator implements Comparator<Cell> {
    @Override
    public int compare(Cell o1, Cell o2) {
        return Comparator.comparing(Cell::getX)
                .thenComparing(Cell::getY)
                .compare(o1, o2);
    }
}
