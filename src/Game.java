public class Game {
    private boolean gameStarted = false;
    boolean getGameStarted() {
        return gameStarted;
    }
    private int score = 0;
    int getScore() {
        return score;
    }

    void initGame() {
        gameStarted = true;
        score = 0;
    }

    void finishGame(int score) {
        gameStarted = false;
        this.score = score;
    }
}
