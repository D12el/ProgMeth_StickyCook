package logic;

import javafx.scene.canvas.GraphicsContext;
import logic.entity.*;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;


//The area that specifies the position of each entity and renders it.
public class Field implements IRenderable {

    private static int[][] field = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 2, 2, 2, 9, 5, 6, 6, 6, 2, 4, 2, 2, 2, 7, 8, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 2, 9, 9, 9, 6, 6, 2, 2, 2, 7, 7, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 10, 1},
            {1, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 11, 1},
            {1, 0, 2, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1},
            {1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1},
            {1, 0, 2, 2, 2, 2, 2, 2, 4, 8, 3, 4, 2, 2, 2, 2, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    private static Entity[][] entities = new Entity[15][20];

    public static Entity[][] getEntities() {
        return entities;
    }

    public static void loadEntities() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 20; j++) {
                if (field[i][j] == 1) {
                    entities[i][j] = new Border(j * 32, i * 32, i);
                }
                if (field[i][j] == 2) {
                    entities[i][j] = new Table(j * 32, i * 32, i);
                }
                if (field[i][j] == 3) {
                    entities[i][j] = new TomatoBox(j * 32, i * 32, i);
                }
                if (field[i][j] == 4) {
                    entities[i][j] = new CuttingBoard(j * 32, i * 32, 200);
                }
                if (field[i][j] == 5) {
                    entities[i][j] = new TrashCan(j * 32, i * 32, i);
                }
                if (field[i][j] == 6) {
                    entities[i][j] = new Oven(j * 32, i * 32, i);
                }
                if (field[i][j] == 7) {
                    entities[i][j] = new MeatBox(j * 32, i * 32, i);
                }
                if (field[i][j] == 8) {
                    entities[i][j] = new CabbageBox(j * 32, i * 32, i);
                }
                if (field[i][j] == 9) {
                    entities[i][j] = new BreadBox(j * 32, i * 32, i);
                }
                if (field[i][j] == 10) {
                    entities[i][j] = new Boat(j * 32, i * 32, i);
                }
                if (field[i][j] == 11) {
                    entities[i][j] = new Boat(j * 32, i * 32, i);
                    entities[i][j].setVisible(false);
                }
            }
        }
    }

    @Override
    public int getZ() {
        return -9999;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.drawImage(RenderableHolder.BackgroundImage, 0, 0);
    }

    @Override
    public boolean isDestroyed() {
        return false;
    }

    @Override
    public boolean isVisible() {
        return GameState.state == GameState.GAME;
    }

    public static int[][] getField() {
        return field;
    }

    public static void setField(int[][] field) {
        Field.field = field;
    }

    public static void setEntities(Entity[][] entities) {
        Field.entities = entities;
    }
}

