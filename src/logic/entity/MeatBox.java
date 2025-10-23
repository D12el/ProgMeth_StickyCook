package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Pickable;
import logic.item.Item;
import logic.item.Meat;
import sharedObject.RenderableHolder;

//this entity will give you a meat when you pick it
public class MeatBox extends Entity implements Pickable {

    public MeatBox(double x, double y, int z) {
        super(x, y, z, 32, 32);
        Meat meat = new Meat(x, y);
        inventory.setItem(meat);
    }

    @Override
    public void pick(Slime user) {
        System.out.println("pick meat");
        Item pickItem = inventory.getItem();
        user.getInventory().setItem(pickItem);
        pickItem.setX(user.getInventory().getX() + 16);
        pickItem.setY(user.getInventory().getY() + 16);
        inventory.setItem(new Meat(x, y));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.meatBox, x, y);
    }
}
