package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Pickable;
import logic.item.Item;
import logic.item.Tomato;
import sharedObject.RenderableHolder;

//this entity will give you a tomato when you pick it
public class TomatoBox extends Entity implements Pickable {

    public TomatoBox(double x, double y, int z) {
        super(x, y, z, 32, 32);
        Tomato tomato = new Tomato(x, y);
        inventory.setItem(tomato);
    }

    @Override
    public void pick(Slime user) {
        System.out.println("pick tomato");
        Item pickItem = inventory.getItem();
        user.getInventory().setItem(pickItem);
        pickItem.setX(user.getInventory().getX() + 16);
        pickItem.setY(user.getInventory().getY() + 16);
        inventory.setItem(new Tomato(x, y));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.tomatoBox, x, y);
    }
}
