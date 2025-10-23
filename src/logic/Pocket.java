package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

//player money pouch
public class Pocket implements IRenderable {

    private int money;
    private double x, y;
    protected boolean visible, destroyed;

    public Pocket(double x, double y) {
        money = 0;
        this.x = x;
        this.y = y;
        visible = false;
        destroyed = false;
    }

    @Override
    public int getZ() {
        return 200;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.pocket, x, y);
        gc.drawImage(RenderableHolder.coin, x + 26, y + 48);
        gc.setFont(Font.font(10));
        gc.setFill(Color.WHITE);
        gc.fillText(Integer.toString(money), x + 54, y + 61);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        if (GameState.state != GameState.GAME) {
            return false;
        }
        return visible;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
