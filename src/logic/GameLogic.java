package logic;

import drawing.GameScreen;
import logic.button.*;
import logic.entity.Entity;
import logic.entity.Slime;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

import java.util.ArrayList;
import java.util.List;

//logic
public class GameLogic {
    private static final List<MenuButton> menuObjectContainer = new ArrayList<>();
    private static final List<EndButton> endObjectContainer = new ArrayList<>();
    private List<IRenderable> gameObjectContainer = new ArrayList<>();
    private Slime player;
    private MenuButton startButton;
    private EndButton restartButton, homeButton;
    private Timer timer;
    private boolean isGameStart = false;
    private boolean isRunMenu = false;
    private ScoreText scoreText;

    public GameLogic() {
        Field field = new Field();
        RenderableHolder.getInstance().add(field);
        MenuBackground menuBackground = new MenuBackground();
        RenderableHolder.getInstance().add(menuBackground);
        EndBackground endBackground = new EndBackground();
        RenderableHolder.getInstance().add(endBackground);
        homeButton = new HomeButton(353, 193, 10, 64, 64);
        startButton = new StartButton(170, 300, 10, 300, 80);
        restartButton = new RestartButton(253, 195, 10, 64, 64);
        timer = new Timer(550, 40);
        scoreText = new ScoreText(235, 175);
        RenderableHolder.getInstance().add(scoreText);
        addEndObject(restartButton);
        addNewObject(timer);
        addMenuObject(startButton);
        addEndObject(homeButton);

    }

    private void addNewObject(IRenderable renderObject) {
        gameObjectContainer.add(renderObject);
        RenderableHolder.getInstance().add(renderObject);
    }

    private void addMenuObject(MenuButton menuButton) {
        menuObjectContainer.add(menuButton);
        RenderableHolder.getInstance().add(menuButton);
    }

    private void addEndObject(EndButton endButton) {
        endObjectContainer.add(endButton);
        RenderableHolder.getInstance().add(endButton);
    }

    public static List<MenuButton> getMenuObjectContainer() {
        return menuObjectContainer;
    }

    public static List<EndButton> getEndObjectContainer() {
        return endObjectContainer;
    }

    public void startGame() {
        RenderableHolder.menuBackgroundMusic.stop();
        RenderableHolder.gameBackgroundMusic.play();
        if (RenderableHolder.endSound.isPlaying()) {
            RenderableHolder.endSound.stop();
        }
        Field.loadEntities();
        player = new Slime(300, 240);
        addNewObject(player);
        addNewObject(player.getInventory());
        addNewObject(player.getPocket());
        timer.setTimer(3, 0);
        for (int i = 0; i < GameScreen.AMOUNT_TILES_IN_HEIGHT; i++) {
            for (int j = 0; j < GameScreen.AMOUNT_TILES_IN_WIDTH; j++) {
                if (Field.getEntities()[i][j] != null) {
                    addNewObject(Field.getEntities()[i][j]);
                }
            }
        }
        timer.runTimer();
        isGameStart = true;
        isRunMenu = false;
    }

    public void endGame() {
        RenderableHolder.menuBackgroundMusic.stop();
        RenderableHolder.gameBackgroundMusic.stop();
        RenderableHolder.endSound.play();
        scoreText.setScore(player.getPocket().getMoney());
        for (IRenderable object : gameObjectContainer) {
            if (object instanceof Entity) {
                ((Entity) object).setDestroyed(true);
            } else if (object instanceof Inventory) {
                ((Inventory) object).setDestroyed(true);
            } else if (object instanceof Pocket) {
                ((Pocket) object).setDestroyed(true);
            }
        }
        if (RenderableHolder.doneCookingSound.isPlaying()) {
            RenderableHolder.doneCookingSound.stop();
        }
        if (RenderableHolder.grillSound.isPlaying()) {
            RenderableHolder.grillSound.stop();
        }
        if (RenderableHolder.walkSound.isPlaying()) {
            RenderableHolder.walkSound.stop();
        }
        if (RenderableHolder.chopSound.isPlaying()) {
            RenderableHolder.chopSound.stop();
        }
        if (RenderableHolder.clockSound.isPlaying()) {
            RenderableHolder.clockSound.stop();
        }
        isGameStart = false;
        isRunMenu = false;
    }

    public void runMenu() {
        if (RenderableHolder.endSound.isPlaying()) {
            RenderableHolder.endSound.stop();
        }
        RenderableHolder.menuBackgroundMusic.play();
        isRunMenu = true;
    }

    public void logicUpdate() {
        if (GameState.state == GameState.GAME && player != null) {
            player.update();
        }
        if (GameState.state == GameState.GAME && !isGameStart) {
            startGame();
        }
        if (GameState.state == GameState.END && isGameStart) {
            endGame();
        }
        if (GameState.state == GameState.MENU && !isRunMenu) {
            runMenu();
        }
        if (GameState.state == GameState.END) {

        }
    }
}
