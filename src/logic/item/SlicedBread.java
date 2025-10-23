package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//bread after sliced
public class SlicedBread extends Item implements Upgradeable {

    public SlicedBread(double x, double y) {
        super(x, y);
        setName("sliced bread");
    }

    @Override
    public Item afterUpgrade() {
        return new BreadCabbage(x, y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.slicedBread, x, y);
    }
}
