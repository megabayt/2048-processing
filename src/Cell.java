public class Cell {
    private final float padding = (float) 5;
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    public void display(Game2048Applet context, int i, int j) {
        float cSize = context.getCellSize() - padding * 2;
        float x = i * cSize + i * padding * 2 + padding;
        float y = j * cSize + j * padding * 2 + padding;
        context.fill(255);
        context.rect(x, y, cSize, cSize);
        if (value != 0) {
            context.fill(0);
            context.textAlign(context.CENTER);
            context.text(value, x + cSize / 2, y + cSize / 2);
        }
    }
}
