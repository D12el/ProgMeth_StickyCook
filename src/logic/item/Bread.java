package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can slice to sliced bread
public class Bread extends Item implements Sliceable {

    public Bread(double x, double y) {
        super(x, y);
        setName("bread");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.bread, x, y);
    }


    @Override
    public Item afterSlice() {
        return new SlicedBread(x, y);
    }
}
