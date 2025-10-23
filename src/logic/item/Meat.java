package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can cook to cooked meat
public class Meat extends Item implements Cookable {

    public Meat(double x, double y) {
        super(x, y);
        setName("meat");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.meat, x, y);
    }

    @Override
    public Item afterCooked() {
        return new CookedMeat(x, y);
    }
}
