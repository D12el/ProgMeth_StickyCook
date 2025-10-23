package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//meat after cooked
public class CookedMeat extends Item {

    public CookedMeat(double x, double y) {
        super(x, y);
        setName("cooked meat");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.cookedMeat, x, y);
    }
}
