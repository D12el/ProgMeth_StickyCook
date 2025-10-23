package logic;

import javafx.scene.canvas.GraphicsContext;
import logic.item.Item;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

//inventory that contain one item. every entity need to have inventory
public class Inventory implements IRenderable {
    private Item item;
    private double x, y;
    protected boolean visible, destroyed;

    public Inventory(double x, double y) {
        item = null;
        this.x = x;
        this.y = y;
        visible = false;
        destroyed = false;
    }

    @Override
    public int getZ() {
        return 200;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.inventoryBar, x, y);
        if (item != null) {
            item.draw(gc);
        }
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public boolean isVisible() {
        if (GameState.state != GameState.GAME)
            return false;
        return visible;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
