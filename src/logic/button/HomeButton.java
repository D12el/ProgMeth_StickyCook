package logic.button;

import javafx.scene.canvas.GraphicsContext;
import logic.GameState;
import sharedObject.RenderableHolder;

//button that show when you finish the game. The function of this button is send you to home page
public class HomeButton extends EndButton {
    public HomeButton(double x, double y, int z, double width, int height) {
        super(x, y, z, width, height);
    }

    @Override
    public void click() {
        GameState.state = GameState.MENU;
    }

    @Override
    public void draw(GraphicsContext gc) {
        if (isMouseOver())
            gc.drawImage(RenderableHolder.homeButtonHover, x, y);
        else {
            gc.drawImage(RenderableHolder.homeButton, x, y);
        }
    }

}
