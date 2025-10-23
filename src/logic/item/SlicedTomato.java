package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//tomato after sliced
public class SlicedTomato extends Item {

    public SlicedTomato(double x, double y) {
        super(x, y);
        setName("sliced tomato");
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.slicedTomato, x, y);
    }
}
