package logic.item;

import javafx.scene.canvas.GraphicsContext;
import sharedObject.RenderableHolder;

//can fuse with sliced bread
public class BreadCabbageMeatTomato extends Item implements Upgradeable {

    public BreadCabbageMeatTomato(double x, double y) {
        super(x, y);
        setName("bread with cabbage with meat with tomato");
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.breadWithCabbageWithMeatWithTomato, x, y);
    }

    @Override
    public Item afterUpgrade() {
        return new Burger(x, y);
    }
}
