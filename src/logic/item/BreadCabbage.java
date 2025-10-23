package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can fuse with meat
public class BreadCabbage extends Item implements Upgradeable {

    public BreadCabbage(double x, double y) {
        super(x, y);
        setName("bread with cabbage");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.breadWithCabbage, x, y);
    }

    @Override
    public Item afterUpgrade() {
        return new BreadCabbageMeat(x, y);
    }
}
