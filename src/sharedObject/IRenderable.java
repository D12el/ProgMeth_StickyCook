package sharedObject;

import javafx.scene.canvas.GraphicsContext;

//The ability that indicates a class can be drawn onto the canvas.
public interface IRenderable {
    public int getZ();

    public void draw(GraphicsContext gc);

    public boolean isDestroyed();

    public boolean isVisible();
}

