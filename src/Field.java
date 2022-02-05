import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Field {
    private final List<List<Cell>> cells;

    public Field(int size) {
        cells = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                row.add(new Cell());
            }
            cells.add(row);
        }
    }

    private void initRandomCell() {
        Random random = new Random();
        int i = random.nextInt(cells.size());
        List<Cell> row = cells.get(i);
        int j = random.nextInt(row.size());
        Cell cell = row.get(j);
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

    void display(Game2048Applet context) {
        for (int i = 0; i < cells.size(); i++) {
            List<Cell> row = cells.get(i);
            for (int j = 0; j < row.size(); j++) {
                Cell cell = row.get(j);
                cell.display(context, i, j);
            }
        }
    }
}
