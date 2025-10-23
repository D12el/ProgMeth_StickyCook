package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import logic.Pocket;
import logic.entity.ability.Placeable;
import logic.item.Sellable;
import sharedObject.RenderableHolder;

//you sold the item when you place it in this entity
public class Boat extends Entity implements Placeable {
    public Boat(double x, double y, int z) {
        super(x, y, z, 64, 64);
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.boat, x, y);
    }

    @Override
    public void place(Slime user) {
        if (user.getInventory().getItem() instanceof Sellable) {
            Sellable sellingItem = (Sellable) user.getInventory().getItem();
            user.getInventory().setItem(null);
            Pocket userPocket = user.getPocket();
            userPocket.setMoney(userPocket.getMoney() + sellingItem.sell());
            System.out.println(userPocket.getMoney());
            RenderableHolder.sold.play();
        }
    }
}
