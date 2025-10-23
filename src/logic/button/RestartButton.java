package logic.button;

import javafx.scene.canvas.GraphicsContext;
import logic.GameState;
import sharedObject.RenderableHolder;

//button that show when you finish the game. The function of this button is to restart the game
public class RestartButton extends EndButton {
    public RestartButton(double x, double y, int z, double width, int height) {
        super(x, y, z, width, height);
    }

    @Override
    public void click() {
        GameState.state = GameState.GAME;
    }

    @Override
    public void draw(GraphicsContext gc) {

        if (isMouseOver())
            gc.drawImage(RenderableHolder.restartButtonHover, x, y);
        else {
            gc.drawImage(RenderableHolder.restartButton, x, y);
        }

    }
}
