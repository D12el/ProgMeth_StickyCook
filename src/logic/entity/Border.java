package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//Border
public class Border extends Entity {
    public Border(double x, double y, int z) {
        super(x, y, z, 32, 32);
        setVisible(false);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.border, x, y);
    }
}
