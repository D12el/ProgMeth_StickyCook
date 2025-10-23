package drawing;

import input.InputUtility;
import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import logic.GameLogic;
import logic.GameState;
import logic.button.Button;
import logic.button.EndButton;
import logic.button.MenuButton;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

import java.util.ArrayList;

//Act as the user's screen, receiving events from the user
public class GameScreen extends Canvas {
    public static final int TILES_SIZE = 32;
    public static final int AMOUNT_TILES_IN_WIDTH = 20;
    public static final int AMOUNT_TILES_IN_HEIGHT = 15;
    public final static int GAME_WIDTH = TILES_SIZE * AMOUNT_TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * AMOUNT_TILES_IN_HEIGHT;
    private static final ArrayList<MenuButton> menuButtons = new ArrayList<>();
    private static final ArrayList<EndButton> endButtons = new ArrayList<>();

    public GameScreen() {
        super(GAME_WIDTH, GAME_HEIGHT);
        addListener();
        addButton();
    }

    public void addListener() {
        this.setOnKeyPressed((KeyEvent event) -> {
            InputUtility.setKeyPressed(event.getCode(), true);
        });
        this.setOnKeyReleased((KeyEvent event) -> {
            InputUtility.setKeyPressed(event.getCode(), false);
        });
        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameState.state == GameState.MENU) {
                    for (MenuButton menuButton : menuButtons) {
                        if (isOn(mouseEvent, menuButton)) {
                            menuButton.click();
                        }
                    }
                } else if (GameState.state == GameState.END) {
                    for (EndButton endButton : endButtons) {
                        if (isOn(mouseEvent, endButton)) {
                            endButton.click();
                        }
                    }
                }
            }
        });

        this.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (GameState.state == GameState.MENU) {
                    for (MenuButton menuButton : menuButtons) {
                        menuButton.setMouseOver(false);
                        if (isOn(mouseEvent, menuButton)) {
                            menuButton.setMouseOver(true);
                            break;
                        }
                    }
                } else if (GameState.state == GameState.END) {
                    for (EndButton endButton : endButtons) {
                        endButton.setMouseOver(false);
                        if (isOn(mouseEvent, endButton)) {
                            endButton.setMouseOver(true);
                            break;
                        }
                    }
                }
            }
        });
    }

    public boolean isOn(MouseEvent e, Button menuButton) {
        return menuButton.getHitBox().contains(e.getX(), e.getY());
    }

    public void addButton() {
        menuButtons.addAll(GameLogic.getMenuObjectContainer());
        endButtons.addAll(GameLogic.getEndObjectContainer());
    }

    public void paintComponent() {
        GraphicsContext gc = this.getGraphicsContext2D();
        for (IRenderable entity : RenderableHolder.getInstance().getEntities()) {
            if (entity.isVisible() && !entity.isDestroyed()) {
                entity.draw(gc);
            }
        }
    }
}
