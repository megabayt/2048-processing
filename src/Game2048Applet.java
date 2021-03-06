import processing.core.*;

public class Game2048Applet extends PApplet {
    private final int w = 600;
    private final int h = 600;
    private final int fSize = 4;
    public float getCellSize() {
        return w / (float) fSize;
    }
    private Game game;
    private Field field;

    public static void main(String[] args) {
        PApplet.main("Game2048Applet");
    }

    @Override
    public void setup() {
        surface.setSize(w, h);
        game = new Game();
        field = new Field(fSize);
    }

    @Override
    public void keyPressed() {
        if (!game.getGameStarted()) {
            game.initGame();
            field.initRandomCells(2);
            return;
        }
        if (keyCode == UP) {
            field.moveUp();
        } else if (keyCode == RIGHT) {
            field.moveRight();
        } else if (keyCode == DOWN) {
            field.moveDown();
        } else if (keyCode == LEFT) {
            field.moveLeft();
        } else {
            return;
        }
        int score = field.getScore();
        if (!field.initRandomCells(2) || score == 2048) {
            game.finishGame(score);
            field = new Field(fSize);
        }
    }

    @Override
    public void draw() {
        background(255);
        if (game.getGameStarted()) {
            field.display(this);
        } else {
            fill(0);
            textAlign(CENTER);
            if (game.getScore() == 0) {
                text("Press any key", (float)w / 2, (float)h / 2);
            } else {
                text("Game Over\n"
                        + "Your score: " + game.getScore() + "\n"
                        + "Press any key to continue",
                        (float)w / 2,
                        (float)h / 2);
            }
        }
    }
}

