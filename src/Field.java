import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private final List<Cell> cells;
    private final int size;

    public Field(int size) {
        this.size = size;
        cells = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            cells.add(new Cell());
        }
    }

    private int getIndexByIJ(int i, int j) {
        return i * size + j;
    }

    private Coords getIJByIndex(int index) {
        return new Coords((index / size), (index % size));
    }

    private void initRandomCell() {
        Random random = new Random();
        int i = random.nextInt(cells.size());
        Cell cell = cells.get(i);
        if (cell.getValue() == 0) {
            cell.setValue(2);
        } else {
            initRandomCell();
        }
    }

    public void initField() {
        initRandomCell();
        initRandomCell();
    }

    private void mergeCells(Cell cell1, Cell cell2) {
        if (cell2.getValue() == cell1.getValue()) {
            cell1.setValue(cell1.getValue() * 2);
            cell2.setValue(0);
        }
    }

    public void move(int dirI, int dirJ) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int k = dirI != 0 ? i + dirI : j + dirJ;
                if (k == -1 || k == size) {
                    continue;
                }
                int dir = dirI != 0 ? dirI : dirJ;
                while (dir == 1 ? k < size : k >= 0) {
                    System.out.printf("%d, %d, %d, %d\n", i, j, dirI != 0 ? k : i, dirJ != 0 ? k : j);
                    Cell cell1 = cells.get(getIndexByIJ(dirI != 0 ? k : i, dirJ != 0 ? k : j));
                    Cell cell2 = cells.get(getIndexByIJ(i, j));
                    mergeCells(cell1, cell2);
                    k += dir;
                }
            }
        }
    }

    public void moveUp() {
        move(-1, 0);
    }

    public void moveRight() {
        move(0, 1);
    }

    public void moveDown() {
        move(1, 0);
    }

    public void moveLeft() {
        move(0, -1);
    }

    void display(Game2048Applet context) {
        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            Coords ij = getIJByIndex(i);
            cell.display(context, ij.getI(), ij.getJ());
        }
    }
}
