import processing.core.*;

public class Game2048Applet extends PApplet {
    private final int w = 600;
    private final int h = 600;
    private Game game;

    public static void main(String args[]) {
        PApplet.main("Game2048Applet");
    }

    @Override
    public void setup() {
        surface.setSize(w, h);
        game = new Game();
    }

    @Override
    public void keyPressed() {
        if (!game.getGameStarted()) {
            game.initGame();
        }
    }

    @Override
    public void draw() {
        background(255);
        if (game.getGameStarted()) {

        } else {
            fill(0);
            textAlign(CENTER);
            if (game.getScore() == 0) {
                text("Press any key", (float)w / 2, (float)h / 2);
            } else {
                text("Game Over\nYour score: " + game.getScore(), (float)w / 2, (float)h / 2);
            }
        }
    }
}

