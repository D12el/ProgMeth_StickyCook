package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can fuse with tomato
public class BreadCabbageMeat extends Item implements Upgradeable {

    public BreadCabbageMeat(double x, double y) {
        super(x, y);
        setName("bread with cabbage with meat");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.breadWithCabbageWithMeat, x, y);
    }

    @Override
    public Item afterUpgrade() {
        return new BreadCabbageMeatTomato(x, y);
    }
}
