package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.ability.Pickable;
import logic.item.Cabbage;
import logic.item.Item;
import sharedObject.RenderableHolder;

//this entity will give you a cabbage when you pick it
public class CabbageBox extends Entity implements Pickable {

    public CabbageBox(double x, double y, int z) {
        super(x, y, z, 32, 32);
        Cabbage cabbage = new Cabbage(x, y);
        inventory.setItem(cabbage);
    }

    @Override
    public void pick(Slime user) {
        System.out.println("pick cabbage");
        Item pickItem = inventory.getItem();
        user.getInventory().setItem(pickItem);
        pickItem.setX(user.getInventory().getX() + 16);
        pickItem.setY(user.getInventory().getY() + 16);
        inventory.setItem(new Cabbage(x, y));
    }

    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.cabbageBox, x, y);
    }
}
