package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.entity.ability.Pickable;
import logic.entity.ability.Placeable;
import logic.entity.ability.Useable;
import logic.item.Cookable;
import logic.item.Item;
import sharedObject.RenderableHolder;

//you can use this entity to cook a cookable item
public class Oven extends Entity implements Pickable, Placeable, Useable {

    private boolean isCooking;

    public Oven(double x, double y, int z) {
        super(x, y, z, 32, 32);
    }


    @Override
    public void pick(Slime user) {
        if (!isCooking) {
            Item pickItem = inventory.getItem();
            user.getInventory().setItem(pickItem);
            inventory.setItem(null);
            pickItem.setX(user.getInventory().getX() + 16);
            pickItem.setY(user.getInventory().getY() + 16);
        }
    }

    @Override
    public void place(Slime user) {
        if (!isCooking) {
            Item placeItem = user.getInventory().getItem();
            if (placeItem instanceof Cookable) {
                inventory.setItem(placeItem);
                user.getInventory().setItem(null);
                placeItem.setX(x);
                placeItem.setY(y);
            }
        }
    }

    @Override
    public void use(Slime user) {
        if (!isCooking) {
            if (inventory.getItem() instanceof Cookable) {
                isCooking = true;
                Thread cook = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            RenderableHolder.grillSound.play();
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException();
                        }
                        RenderableHolder.grillSound.stop();
                        RenderableHolder.doneCookingSound.play();
                        System.out.println("Finish");
                        isCooking = false;
                        Cookable cookingItem = (Cookable) inventory.getItem();
                        inventory.setItem(cookingItem.afterCooked());
                    }
                });
                cook.start();
            }
        }

    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.oven, x, y);
        if (isCooking()) {
            gc.drawImage(RenderableHolder.usingOven, x, y);
        }
        if (!isCooking() && this.inventory.getItem() != null) {
            gc.setLineWidth(2);
            gc.setStroke(Color.RED);
            gc.strokeRect(x, y, 32, 38);
        }
    }

    public boolean isCooking() {
        return isCooking;
    }
}
