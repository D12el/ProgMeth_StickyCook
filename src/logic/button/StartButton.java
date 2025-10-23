package logic.button;

import javafx.scene.canvas.GraphicsContext;
import logic.GameState;
import sharedObject.RenderableHolder;

//button that show at the first page of the game.
// The function of this button is to send you to the main game page.
public class StartButton extends MenuButton {
    public StartButton(double x, double y, int z, int width, int height) {
        super(x, y, z, width, height);
        visible = true;
        destroyed = false;
    }

    @Override
    public void click() {
        GameState.state = GameState.GAME;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (isMouseOver())
            gc.drawImage(RenderableHolder.startButtonHover, x, y);
        else {
            gc.drawImage(RenderableHolder.startButton, x, y);
        }
    }
}
