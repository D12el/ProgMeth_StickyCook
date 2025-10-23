package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can sell
public class Burger extends Item implements Sellable {

    public Burger(double x, double y) {
        super(x, y);
        setName("burger");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.burger, x, y);
    }

    @Override
    public int sell() {
        return 20;
    }
}
