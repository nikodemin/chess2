package chess.model.figure;


import com.learning.chess.model.Board;
import com.learning.chess.model.Cell;
import com.learning.chess.model.Color;
import com.learning.chess.model.figure.Bishop;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BishopTest {
    private final CellComparator cellComparator = new CellComparator();

    /**
     * x x x x
     * x x B x
     * x x x x
     * x x x x
     */
    @Test
    void emptyBoard() {
        Bishop bishop = new Bishop(Color.WHITE);
        Cell cell = new Cell(2, 1, bishop);
        Board board = new Board(4, cell);
        bishop.setBoard(board);
        bishop.setPosition(cell);

        List<Cell> expected = Stream.of(
                new Cell(2, 0),
                new Cell(2, 2),
                new Cell(2, 3),
                new Cell(0, 1),
                new Cell(1, 1),
                new Cell(3, 1)
        ).sorted(cellComparator).collect(Collectors.toList());

        List<Cell> actual = bishop.getAvailableMovements();
        actual.sort(cellComparator);

        assertEquals(expected, actual);
    }
}
