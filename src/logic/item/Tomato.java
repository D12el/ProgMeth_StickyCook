package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can slice to sliced tomato
public class Tomato extends Item implements Sliceable {

    public Tomato(double x, double y) {
        super(x, y);
        setName("tomato");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.tomato, x, y);
    }

    @Override
    public Item afterSlice() {
        return new SlicedTomato(x, y);
    }
}
