package logic.entity;

import input.InputUtility;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import logic.Field;
import logic.Pocket;
import logic.entity.ability.Pickable;
import logic.entity.ability.Placeable;
import logic.entity.ability.Useable;
import logic.item.Item;
import logic.item.Upgradeable;
import sharedObject.RenderableHolder;
import utils.MethodUtils;

import static sharedObject.RenderableHolder.*;

//The main entity of the game that the player will control
public class Slime extends Entity {

    private int speed;
    private int animationIndex = 0;
    private int animationTick = 0;
    private int animationSpeed = 15;
    private Entity blockType;
    private Pocket pocket;


    public Slime(double x, double y) {
        super(x, y, 100, 32, 30);
        this.speed = 2;
        inventory.setX(9 * 32);
        inventory.setY(13 * 32);
        inventory.setVisible(true);
        pocket = new Pocket(0, 0);
        pocket.setVisible(true);
    }

    public void update() {
        positionUpdate();
        pickAndPlaceUpdate();
        useUpdate();
    }

    public void positionUpdate() {
        int xSpeed = 0;
        int ySpeed = 0;
        boolean moving = false;

        if (InputUtility.getKeyPressed(KeyCode.W)) {
            ySpeed -= speed;
            blockType = MethodUtils.findBlockType(hitBox.getX() + 16, hitBox.getY() - 2, Field.getEntities());
            moving = true;
        }
        if (InputUtility.getKeyPressed(KeyCode.S)) {
            ySpeed += speed;
            blockType = MethodUtils.findBlockType(hitBox.getX() + 16, hitBox.getY() + height + 4, Field.getEntities());
            moving = true;
        }
        if (InputUtility.getKeyPressed(KeyCode.D)) {
            xSpeed += speed;
            blockType = MethodUtils.findBlockType(hitBox.getX() + width + 2, hitBox.getY() + 15, Field.getEntities());
            moving = true;
        }
        if (InputUtility.getKeyPressed(KeyCode.A)) {
            xSpeed -= speed;
            blockType = MethodUtils.findBlockType(hitBox.getX() - 2, hitBox.getY() + 15, Field.getEntities());
            moving = true;
        }
        if (moving && !walkSound.isPlaying()) {
            walkSound.play();
        } else if (!moving) {
            walkSound.stop();
        }


        if (MethodUtils.canPass(hitBox.getX() + xSpeed, hitBox.getY() + ySpeed, hitBox.getWidth(), hitBox.getHeight(), Field.getEntities())) {
            this.x += xSpeed;
            this.y += ySpeed;
        }
        hitBox.setX((int) this.x + 9);
        hitBox.setY((int) this.y + 7);
    }

    public void pickAndPlaceUpdate() {
        if (InputUtility.getKeyPressed(KeyCode.E)) {
            if (blockType != null) {
                if (inventory.getItem() == null) {
                    if (blockType instanceof Pickable) {
                        if (blockType.getInventory().getItem() != null) {
                            pick((Pickable) blockType);
                            System.out.println("pick");
                        }
                    }
                } else {
                    if (blockType.getInventory().getItem() == null) {
                        if (blockType instanceof Placeable) {
                            place((Placeable) blockType);
                            System.out.println("Place");
                        }
                    } else {
                        if (canFuseIngredient(blockType)) {
                            fuseIngredient(blockType);
                        }
                    }
                }
            }
            InputUtility.setKeyPressed(KeyCode.E, false);
        }
    }

    public void useUpdate() {
        if (InputUtility.getKeyPressed(KeyCode.F)) {
            if (blockType instanceof Useable) {
                if (blockType.getInventory().getItem() != null) {
                    use((Useable) blockType);
                }
            }
        }
    }

    public void animationUpdate() {
        animationTick++;
        if (animationTick >= animationSpeed) {
            animationTick = 0;
            animationIndex++;
            if (animationIndex >= 8) {
                animationIndex = 0;
            }
        }
    }

    @Override
    public void draw(GraphicsContext gc) {
        animationUpdate();
        if (InputUtility.getKeyPressed(KeyCode.W) || InputUtility.getKeyPressed(KeyCode.A) || InputUtility.getKeyPressed(KeyCode.S) || InputUtility.getKeyPressed(KeyCode.D)) {
            gc.drawImage(slimeWalkAnimation[animationIndex], x, y);
        } else {
            gc.drawImage(slimeIdleAnimation[animationIndex], x, y);
        }

        inventory.draw(gc);
    }

    public void pick(Pickable entity) {
        entity.pick(this);
        RenderableHolder.pickItemSound.play();
    }

    public void place(Placeable entity) {
        entity.place(this);
    }

    public boolean canFuseIngredient(Entity entity) {
        Item ingredient1 = entity.getInventory().getItem();
        Item ingredient2 = inventory.getItem();

        //burger recipe
        if (ingredient1 instanceof Upgradeable) {
            if (ingredient1.getName().equals("sliced bread") && ingredient2.getName().equals("sliced cabbage")) {
                return true;
            }
            if (ingredient1.getName().equals("bread with cabbage") && ingredient2.getName().equals("cooked meat")) {
                return true;
            }
            if (ingredient1.getName().equals("bread with cabbage with meat") && ingredient2.getName().equals("sliced tomato")) {
                return true;
            }
            if (ingredient1.getName().equals("bread with cabbage with meat with tomato") && ingredient2.getName().equals("sliced bread")) {
                return true;
            }
        }
        return false;
    }

    public void fuseIngredient(Entity entity) {
        Upgradeable upgradingItem = (Upgradeable) entity.getInventory().getItem();
        entity.getInventory().setItem(upgradingItem.afterUpgrade());
        inventory.setItem(null);
    }

    public void use(Useable entity) {
        entity.use(this);
    }

    public Entity getBlockType() {
        return blockType;
    }

    public void setBlockType(Entity blockType) {
        this.blockType = blockType;
    }

    public Pocket getPocket() {
        return pocket;
    }

    public void setPocket(Pocket pocket) {
        this.pocket = pocket;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

}
