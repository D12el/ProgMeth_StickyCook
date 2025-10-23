package logic.entity;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.entity.ability.Pickable;
import logic.entity.ability.Placeable;
import logic.entity.ability.Useable;
import logic.item.Item;
import logic.item.Sliceable;
import sharedObject.RenderableHolder;

//you can use this entity to slice a sliceable item
public class CuttingBoard extends Entity implements Placeable, Pickable, Useable {
    private int status = 0;
    boolean onUse = false;

    public CuttingBoard(double x, double y, int z) {
        super(x, y, z, 32, 32);
    }

    @Override
    public void pick(Slime user) {
        if (!onUse) {
            Item pickItem = inventory.getItem();
            user.getInventory().setItem(pickItem);
            inventory.setItem(null);
            pickItem.setX(user.getInventory().getX() + 16);
            pickItem.setY(user.getInventory().getY() + 16);
        }
    }

    @Override
    public void place(Slime user) {
        if (!onUse) {
            Item placeItem = user.getInventory().getItem();
            inventory.setItem(placeItem);
            user.getInventory().setItem(null);
            placeItem.setX(x);
            placeItem.setY(y);
        }
    }

    @Override
    public void use(Slime user) {
        Entity cuttingBoard = this;
        if (inventory.getItem() instanceof Sliceable) {
            Thread cut = new Thread(new Runnable() {
                @Override
                public void run() {
                    RenderableHolder.chopSound.play();
                    while (status < 3) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        if (InputUtility.getKeyPressed(KeyCode.F) && user.getBlockType() == cuttingBoard) {
                            status += 1;
                        } else {
                            System.out.println("out when status : " + status);
                            break;
                        }
                    }
                    RenderableHolder.chopSound.stop();
                    onUse = false;
                    if (status == 3) {
                        System.out.println("Finish");
                        Sliceable slicingItem = (Sliceable) inventory.getItem();
                        inventory.setItem(slicingItem.afterSlice());
                        status = 0;
                    }
                }
            });
            if (!isOnUse()) {
                onUse = true;
                cut.start();
                System.out.println("start thread");
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.cuttingBoard, x, y);
        if (inventory.getItem() != null) {
            inventory.getItem().draw(gc);
        }
        if (onUse) {
            gc.drawImage(RenderableHolder.state[status], x, y - 32);
        }
    }

    public boolean isOnUse() {
        return onUse;
    }
}
