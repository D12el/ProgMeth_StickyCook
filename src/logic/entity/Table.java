package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Pickable;
import logic.entity.ability.Placeable;
import logic.item.Item;
import sharedObject.RenderableHolder;

//entity that can place or pick item on it
public class Table extends Entity implements Pickable, Placeable {
    public Table(double x, double y, int z) {
        super(x, y, z, 32, 32);
    }

    @Override
    public void pick(Slime user) {
        Item pickItem = inventory.getItem();
        user.getInventory().setItem(pickItem);
        inventory.setItem(null);
        pickItem.setX(user.getInventory().getX() + 16);
        pickItem.setY(user.getInventory().getY() + 16);
    }

    @Override
    public void place(Slime user) {
        Item placeItem = user.getInventory().getItem();
        inventory.setItem(placeItem);
        user.getInventory().setItem(null);
        placeItem.setX(x);
        placeItem.setY(y);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.table, x, y);
        if (inventory.getItem() != null) {
            inventory.getItem().draw(gc);
        }
    }
}
