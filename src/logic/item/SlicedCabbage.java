package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//cabbage after sliced
public class SlicedCabbage extends Item {

    public SlicedCabbage(double x, double y) {
        super(x, y);
        setName("sliced cabbage");
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.slicedCabbage, x, y);
    }
}
