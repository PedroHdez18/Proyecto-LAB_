package poo.scenario;

import poo.Archivo;
import poo.play_button.PlayButton;
import poo.snake.Snake;
import poo.config.Config;
import poo.food.apple.Apple;
import poo.food.pineapple.Pineapple;
import poo.key_event_loop.KeyEventLoop;
import poo.try_again_button.TryAgainButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.KeyEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class Scenario {

    private Scene scene;
    public Group container = new Group();
    private Snake snake;
    private Apple apple;
    private Pineapple pineapple;
    private String playerName;

    public Scenario(Stage primaryStage, Snake snake, Apple apple, Pineapple pineapple) {
        this.scene = new Scene(container, Config.width, Config.height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game - Proyecto POO");
        primaryStage.show();

        this.snake = snake;
        this.apple = apple;
        this.pineapple = pineapple;

        TextInputDialog dialog = new TextInputDialog("Jugador");
        dialog.setTitle("Nombre de Usuario");
        dialog.setHeaderText("Bienvenido al Snake Game");
        dialog.setContentText("Por favor, ingresa tu nombre:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(name -> this.playerName = name);

        new KeyEventLoop(this, snake, apple, pineapple);

        PlayButton playButton = new PlayButton(e -> {
            cleanScene();
            container.getChildren().add(snake.getHead());
            container.getChildren().add(apple.getApple());
            container.getChildren().add(pineapple.getPineapple());
        });

        this.container.getChildren().addAll(playButton);
    }

    public void keyPressed(EventHandler<? super KeyEvent> keyAction) {
        this.scene.setOnKeyPressed(keyAction);
    }

    public void showGameOver(KeyEventLoop keyEventLoop) {
        TryAgainButton tryAgainButton = new TryAgainButton(e -> {
            Integer scoreTotal = Config.score;
            Archivo.writeScores(playerName, scoreTotal);
            Config.tries += 1;
            Config.score = 0;
            cleanScene();
            snake.changeSnakeColor(Color.GREEN);
            this.container.getChildren().add(this.snake.resetGame());
            this.container.getChildren().add(apple.getApple());
            this.container.getChildren().add(pineapple.getPineapple());
            keyEventLoop.startLoop();
        });

        this.container.getChildren().add(tryAgainButton);
    }

    public void cleanScene() {
        this.container.getChildren().remove(0, this.container.getChildren().size());
    }

    public void addSnakeBodyPart(Node node) {
        this.container.getChildren().add(node);
    }

}

