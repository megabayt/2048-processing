public class Cell {
    private final float padding = (float) 5;
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    private boolean isNew;
    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public void display(Game2048Applet context, int i, int j) {
        float cSize = context.getCellSize() - padding * 2;
        float x = j * cSize + j * padding * 2 + padding;
        float y = i * cSize + i * padding * 2 + padding;
        if (isNew) {
            context.fill(0, 255, 0);
        } else {
            context.fill(255);
        }
        context.rect(x, y, cSize, cSize);
        if (value != 0) {
            context.fill(0);
            context.textAlign(context.CENTER);
            context.text(value, x + cSize / 2, y + cSize / 2);
        }
    }
}
