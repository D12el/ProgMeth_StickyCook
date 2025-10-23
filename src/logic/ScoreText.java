package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import sharedObject.IRenderable;

//score text
public class ScoreText implements IRenderable {
    private int score;
    private double x, y;

    public ScoreText(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getZ() {
        return 0;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.LIGHTGOLDENRODYELLOW);
        gc.setLineWidth(3);
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        gc.strokeText("Your Score : " + score, x, y);
        gc.fillText("Your Score : " + score, x, y);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return GameState.state == GameState.END;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
