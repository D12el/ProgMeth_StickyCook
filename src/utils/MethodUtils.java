package utils;

import drawing.GameScreen;
import logic.entity.Entity;

//contain helpful method
public class MethodUtils {
    public static boolean canPass(double x, double y, double width, double height, Entity[][] entities) {
        if (findBlockType(x, y, entities) == null) {
            if (findBlockType(x + width, y, entities) == null) {
                if (findBlockType(x, y + height, entities) == null) {
                    if (findBlockType(x + width, y + height, entities) == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Entity findBlockType(double x, double y, Entity[][] entities) {

        double xIndex = x / GameScreen.TILES_SIZE;
        double yIndex = y / GameScreen.TILES_SIZE;

        return entities[(int) yIndex][(int) xIndex];
    }
}


