package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import logic.GameState;
import logic.Inventory;
import sharedObject.IRenderable;


//abstract class of all entity of this project
public abstract class Entity implements IRenderable {
    protected double x, y;
    protected double width, height;
    protected int z;
    protected boolean visible, destroyed;
    protected Rectangle hitBox;

    protected Inventory inventory;

    public Entity(double x, double y, int z, double width, double height) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.width = width;
        this.height = height;
        visible = true;
        destroyed = false;
        setHitBox(x, y, width, height);
        inventory = new Inventory(x, y);
    }

    protected void drawHItBox(GraphicsContext gc) {
        gc.setLineWidth(2.0);
        gc.setFill(Color.PINK);
        gc.strokeRect(hitBox.getX(), hitBox.getY(), hitBox.getWidth(), hitBox.getHeight());
    }

    public void setHitBox(double x, double y, double width, double height) {
        hitBox = new Rectangle((int) x + 9, (int) y + 7, width, height);
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public boolean isVisible() {
        if (GameState.state != GameState.GAME) {
            return false;
        }
        return visible;
    }

    @Override
    public int getZ() {
        return z;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
