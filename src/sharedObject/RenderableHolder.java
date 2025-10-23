package sharedObject;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//the container of IRenderable object and Resource
public class RenderableHolder {

    private static final RenderableHolder instance = new RenderableHolder();

    private List<IRenderable> entities;
    private Comparator<IRenderable> comparator;

    public static Image slimeWalkSprite, slimeIdleSprite, tomatoBox, table, tomato, fieldSprite, fieldSprite2, fieldSprite3,
            UIsprite, BackgroundImage, inventoryBar, pocket, coin, trashcan, border, oven, usingOven, kitchenSprite, cuttingBoard,
            slicedTomato, meatBox, meat, cookedMeat, cabbageBox, cabbage, slicedCabbage, breadBox, bread, slicedBread, burgerSprite,
            breadWithCabbage, breadWithCabbageWithMeat, breadWithCabbageWithMeatWithTomato, burger, boat, menu, startButton,
            startButtonHover, menuBackground, croppedMenuBackground, endBackground, restartButton, restartButtonHover, homeButton, homeButtonHover, croppedEndBackground;

    public static WritableImage[] slimeWalkAnimation;
    public static WritableImage[] slimeIdleAnimation;
    public static Image[] state;
    public static AudioClip pickItemSound;
    public static MediaPlayer gameBackgroundMusic, menuBackgroundMusic;
    public static AudioClip walkSound, chopSound, grillSound, doneCookingSound, sold, clockSound, endSound;

    static {
        loadResource();
        loadAnimation();
        loadMenuResource();
        loadSound();
        loadEndResource();
    }

    public RenderableHolder() {
        entities = new ArrayList<IRenderable>();
        comparator = (IRenderable o1, IRenderable o2) -> {
            if (o1.getZ() > o2.getZ()) {
                return 1;
            }
            return -1;
        };
    }

    public static RenderableHolder getInstance() {
        return instance;
    }


    public static void loadResource() {
        slimeIdleSprite = new Image("Blue_Slime/Idle.png");

        slimeWalkSprite = new Image(ClassLoader.getSystemResource("Blue_Slime/walk.png").toString());

        fieldSprite = new Image(ClassLoader.getSystemResource("Map_Resource/obj_atlas.png").toString());
        fieldSprite2 = new Image(ClassLoader.getSystemResource("Map_Resource/obj_misk_atlas.png").toString());
        fieldSprite3 = new Image(ClassLoader.getSystemResource("Map_Resource/build_atlas.png").toString());
        kitchenSprite = new Image(ClassLoader.getSystemResource("Map_Resource/kitchenware.png").toString());
        UIsprite = new Image(ClassLoader.getSystemResource("Menu_Resource/ui_split.png").toString());
        BackgroundImage = new WritableImage(fieldSprite.getPixelReader(), 0, 32 * 4, 640, 480);

        tomatoBox = new WritableImage(fieldSprite.getPixelReader(), 32 * 13, 32 * 21, 32, 32);
        tomato = new WritableImage(fieldSprite2.getPixelReader(), 32 * 19, 32 * 4, 32, 32);
        table = new WritableImage(fieldSprite2.getPixelReader(), 32 * 11, 32 * 16, 32, 64);
        trashcan = new WritableImage(fieldSprite2.getPixelReader(), 32 * 23, 32 * 16 + 20, 32, 40);
        border = new WritableImage(fieldSprite3.getPixelReader(), 32 * 10, 0, 32, 32);
        oven = new WritableImage(kitchenSprite.getPixelReader(), 32 * 6, 32 * 30 + 20, 32, 44);
        usingOven = new WritableImage(kitchenSprite.getPixelReader(), 32 * 7, 32 * 30 + 20, 32, 44);
        cuttingBoard = new WritableImage(kitchenSprite.getPixelReader(), 32 * 11, 32 * 16, 32, 64);
        slicedTomato = new Image(ClassLoader.getSystemResource("Map_Resource/slicedtomato.png").toString());
        meatBox = new WritableImage(kitchenSprite.getPixelReader(), 32 * 5, 32 * 19, 32, 32);
        meat = new WritableImage(kitchenSprite.getPixelReader(), 32, 32 * 20, 32, 32);
        cookedMeat = new WritableImage(kitchenSprite.getPixelReader(), 32, 32 * 22, 32, 32);
        cabbageBox = new WritableImage(kitchenSprite.getPixelReader(), 32 * 10, 32 * 21, 32, 32);
        cabbage = new WritableImage(kitchenSprite.getPixelReader(), 32 * 10, 32 * 20, 32, 32);
        slicedCabbage = new WritableImage(kitchenSprite.getPixelReader(), 32 * 16, 32 * 4, 32, 32);
        breadBox = new WritableImage(kitchenSprite.getPixelReader(), 32 * 12, 32 * 21, 32, 32);
        bread = new WritableImage(kitchenSprite.getPixelReader(), 32 * 17, 32 * 4, 32, 32);
        boat = new WritableImage(kitchenSprite.getPixelReader(), 32 * 11, 32 * 25, 64, 64);
        burgerSprite = new Image(ClassLoader.getSystemResource("Map_Resource/Burger.png").toString());
        slicedBread = new WritableImage(burgerSprite.getPixelReader(), 32 * 0, 32 * 0, 32, 32);
        breadWithCabbage = new WritableImage(burgerSprite.getPixelReader(), 32 * 1, 32 * 0, 32, 32);
        breadWithCabbageWithMeat = new WritableImage(burgerSprite.getPixelReader(), 32 * 2, 32 * 0, 32, 32);
        breadWithCabbageWithMeatWithTomato = new WritableImage(burgerSprite.getPixelReader(), 32 * 3, 32 * 0, 32, 32);
        burger = new WritableImage(burgerSprite.getPixelReader(), 32 * 4, 32 * 0, 32, 32);

        state = new Image[4];
        for (int i = 0; i < state.length; i++) {
            state[i] = new WritableImage(kitchenSprite.getPixelReader(), (32 * 16) + (i * 32), 32 * 6, 32, 32);
        }


        inventoryBar = new WritableImage(fieldSprite3.getPixelReader(), 32 * 3, 32 * 6, 64, 64);
        pocket = new WritableImage(UIsprite.getPixelReader(), 32 * 5, 32 * 3, 32 * 4 + 10, 32 * 2 + 20);
        coin = new Image(ClassLoader.getSystemResource("Menu_Resource/coin.png").toString());

    }

    public static void loadMenuResource() {
        startButton = new Image(ClassLoader.getSystemResource("Menu_Resource/playButton.png").toString());
        startButtonHover = new Image(ClassLoader.getSystemResource("Menu_Resource/playButtonHover.png").toString());
        menuBackground = new Image(ClassLoader.getSystemResource("Menu_Resource/gameMenuBackground.png").toString());
        croppedMenuBackground = new WritableImage(menuBackground.getPixelReader(), 0, 0, 640, 480);
    }

    public static void loadEndResource() {
        endBackground = new Image(ClassLoader.getSystemResource("End_Resource/endBackground.png").toString());
        restartButton = new Image(ClassLoader.getSystemResource("End_Resource/restart.png").toString());
        homeButton = new Image(ClassLoader.getSystemResource("End_Resource/home.png").toString());
        restartButtonHover = new Image(ClassLoader.getSystemResource("End_Resource/restartHover.png").toString());
        homeButtonHover = new Image(ClassLoader.getSystemResource("End_Resource/homeHover.png").toString());
        croppedEndBackground = new WritableImage(endBackground.getPixelReader(), 0, 0, 640, 480);
    }

    public static void loadAnimation() {
        slimeWalkAnimation = new WritableImage[8];
        for (int i = 0; i < slimeWalkAnimation.length; i++) {
            slimeWalkAnimation[i] = new WritableImage(slimeWalkSprite.getPixelReader(), 35 + (i * 128), 90, 53, 38);
        }

        slimeIdleAnimation = new WritableImage[8];
        for (int i = 0; i < slimeIdleAnimation.length; i++) {
            slimeIdleAnimation[i] = new WritableImage(slimeIdleSprite.getPixelReader(), 35 + (i * 128), 90, 53, 38);
        }
    }

    public static void loadSound() {
        pickItemSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/pickItemSound.mp3").toString());
        Media sound = new Media(ClassLoader.getSystemResource("Sound_Resource/gameBackgroundMusic.wav").toString());
        gameBackgroundMusic = new MediaPlayer(sound);
        sound = new Media(ClassLoader.getSystemResource("Sound_Resource/menuBackgroundMusic.wav").toString());
        menuBackgroundMusic = new MediaPlayer(sound);
        gameBackgroundMusic.setVolume(0.2);
        gameBackgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        menuBackgroundMusic.setCycleCount(MediaPlayer.INDEFINITE);
        menuBackgroundMusic.setVolume(0.2);
        walkSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/walk.wav").toString());
        chopSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/chop.wav").toString());
        grillSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/grill.wav").toString());
        doneCookingSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/doneCooking.wav").toString());
        sold = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/sold.wav").toString());
        clockSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/clockRunOut.wav").toString());
        endSound = new AudioClip(ClassLoader.getSystemResource("Sound_Resource/endSound.wav").toString());
    }

    public void add(IRenderable entity) {
        entities.add(entity);
        Collections.sort(entities, comparator);
    }

    public void update() {
        for (int i = entities.size() - 1; i >= 0; i--) {
            if (entities.get(i).isDestroyed())
                entities.remove(i);
        }
    }

    public List<IRenderable> getEntities() {
        return entities;
    }
}
