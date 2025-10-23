package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Pickable;
import logic.item.Bread;
import logic.item.Item;
import sharedObject.RenderableHolder;

//this entity will give you a bread when you pick it
public class BreadBox extends Entity implements Pickable {
    public BreadBox(double x, double y, int z) {
        super(x, y, z, 32, 32);
        Bread bread = new Bread(x, y);
        inventory.setItem(bread);
    }

    @Override
    public void pick(Slime user) {
        System.out.println("pick bread");
        Item pickItem = inventory.getItem();
        user.getInventory().setItem(pickItem);
        pickItem.setX(user.getInventory().getX() + 16);
        pickItem.setY(user.getInventory().getY() + 16);
        inventory.setItem(new Bread(x, y));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.breadBox, x, y);
    }
}
