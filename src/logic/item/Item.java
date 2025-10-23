package logic.item;

import sharedObject.IRenderable;

//abstract class of all item in this project
public abstract class Item implements IRenderable {
    protected boolean visible, destroyed;
    protected int z;
    protected double x, y;

    protected String name;

    public Item(double x, double y) {
        this.x = x;
        this.y = y;
        this.z = 0;
    }

    @Override
    public int getZ() {
        return z;
    }

    @Override
    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void setZ(int z) {
        this.z = z;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
