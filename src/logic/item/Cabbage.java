package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can slice to sliced tomato
public class Cabbage extends Item implements Sliceable {

    public Cabbage(double x, double y) {
        super(x, y);
        setName("cabbage");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.cabbage, x, y);
    }

    @Override
    public Item afterSlice() {
        return new SlicedCabbage(x, y);
    }

}
