package logic;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

//background that show when you finish the game
public class EndBackground implements IRenderable {
    @Override
    public int getZ() {
        return -9999;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.endBackground, 0, 0);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return GameState.state == GameState.END;
    }
}
