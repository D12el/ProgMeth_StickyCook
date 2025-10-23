import drawing.GameScreen;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import logic.GameLogic;

public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        StackPane root = new StackPane();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("");

        GameLogic logic = new GameLogic();
        GameScreen gameScreen = new GameScreen();
        root.getChildren().add(gameScreen);
        gameScreen.requestFocus();

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long l) {
                GraphicsContext gc = gameScreen.getGraphicsContext2D();
                logic.logicUpdate();
                gameScreen.paintComponent();
            }
        };
        gameLoop.start();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        stage.show();

    }
}