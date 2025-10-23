package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Placeable;
import sharedObject.RenderableHolder;

//Drop the item on this entity
public class TrashCan extends Entity implements Placeable {
    public TrashCan(double x, double y, int z) {
        super(x, y, z, 32, 32);
    }

    @Override
    public void place(Slime user) {
        user.getInventory().setItem(null);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.trashcan, x, y);
    }
}
