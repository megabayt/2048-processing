import processing.core.*;

public class Game2048Applet extends PApplet {
    public static void main(String args[]) {
        PApplet.main("Game2048Applet");
    }

    @Override
    public void setup() {
        background(0);
        this.frameRate(10);
    }

    @Override
    public void keyPressed() {
    }

    @Override
    public void draw() {
        clear();
    }
}

