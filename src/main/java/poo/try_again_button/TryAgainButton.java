package poo.try_again_button;

import javafx.scene.text.FontWeight;
import poo.config.Config;
import poo.Archivo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.CycleMethod;

import java.util.List;

public class TryAgainButton extends StackPane {

    public TryAgainButton(EventHandler<ActionEvent> buttonAction) {

        // Fondo principal que ocupa TODA la ventana
        this.setPrefSize(Config.width, Config.height);
        this.setBackground(new Background(new BackgroundFill(
                new LinearGradient(0, 0, 0, 1, true, null,
                        new Stop(0, Color.web("#f8ecb4")),
                        new Stop(1, Color.web("#f8ecb4"))), CornerRadii.EMPTY, Insets.EMPTY)));

        // Fondo blanco centrado
        Rectangle background = new Rectangle(Config.width * 0.8, Config.height * 0.8);
        background.setArcWidth(30);
        background.setArcHeight(30);
        background.setFill(Color.WHITE);
        background.setStroke(Color.LIGHTGRAY);
        background.setStrokeWidth(1.5);
        background.setEffect(new javafx.scene.effect.DropShadow(10, Color.GRAY));

        // Contenedor principal centrado
        VBox content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(20);
        content.setPrefSize(Config.width * 0.8, Config.height * 0.8);
        content.setPadding(new Insets(20));

        // Encabezado "Fin del Juego" mejorado
        Label gameOver = new Label("Fin del juego");
        gameOver.setFont(Font.font("Georgia", FontWeight.BOLD, 90));
        gameOver.setTextFill(new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE,
                new Stop(0, Color.web("#FF4E50")), // Degradado de rojo claro
                new Stop(1, Color.web("#F9D423")))); // Degradado hacia amarillo claro

        // Efecto sombra para darle profundidad
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setRadius(10);
        dropShadow.setOffsetX(3);
        dropShadow.setOffsetY(3);
        gameOver.setEffect(dropShadow);

        // Opcional: Agregar un stroke (borde) alrededor del texto
        gameOver.setStyle("-fx-stroke: black; -fx-stroke-width: 1px; -fx-stroke-type: outside;");

        // Texto "Puntuación" mejorado
        Label scoreText = new Label("Puntuación: " + Config.score);
        scoreText.setFont(Font.font("Verdana", FontWeight.BOLD, 40));

        // Scoreboard con estilo tabla
        VBox scoreboardContainer = new VBox();
        scoreboardContainer.setAlignment(Pos.CENTER);
        scoreboardContainer.setSpacing(10);
        scoreboardContainer.setStyle("-fx-background-color: #FFFFFF; " +
                "-fx-border-color: #BFC9D9; -fx-border-radius: 10; " +
                "-fx-background-radius: 10;");
        scoreboardContainer.setPadding(new Insets(15));

        Text scoreboardTitle = new Text("🏆 Mejores Puntuaciones 🏆");
        scoreboardTitle.setFont(Font.font("Arial", 30));
        scoreboardTitle.setFill(Color.web("#335C81"));

        GridPane scoreboard = new GridPane();
        scoreboard.setAlignment(Pos.CENTER);
        scoreboard.setHgap(60);
        scoreboard.setVgap(10);

// Encabezados estilizados
        Text rankHeader = new Text("Posición");
        rankHeader.setFont(Font.font("Georgia", FontWeight.BOLD, 22));
        rankHeader.setFill(Color.web("#3D5A80"));

        Text playerHeader = new Text("Jugador");
        playerHeader.setFont(Font.font("Georgia", FontWeight.BOLD, 22));
        playerHeader.setFill(Color.web("#3D5A80"));

        Text scoreHeader = new Text("Puntuación");
        scoreHeader.setFont(Font.font("Georgia", FontWeight.BOLD, 22));
        scoreHeader.setFill(Color.web("#3D5A80"));

// Agregar los encabezados a la tabla
        scoreboard.add(rankHeader, 0, 0);
        scoreboard.add(playerHeader, 1, 0);
        scoreboard.add(scoreHeader, 2, 0);

// Obtener y mostrar las mejores puntuaciones
        List<String> topScores = Archivo.getTopScores(5);
        int rank = 1;
        for (String entry : topScores) {
            String[] parts = entry.split(":"); // Dividir por ":"
            String playerName = parts[0].trim(); // Nombre del jugador
            String playerScore = parts[1].trim(); // Puntuación

            // Texto estilizado para la posición
            Text rankText = new Text(String.valueOf(rank));
            rankText.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
            rankText.setFill(Color.web("#606F7B"));

            // Texto estilizado para el nombre del jugador
            Text playerText = new Text(playerName);
            playerText.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
            playerText.setFill(Color.web("#333333"));

            // Texto estilizado para la puntuación
            Text scoreTextplayed = new Text(playerScore);
            scoreTextplayed.setFont(Font.font("Verdana", FontWeight.NORMAL, 18));
            scoreTextplayed.setFill(Color.web("#333333"));

            // Añadir las filas a la tabla
            scoreboard.add(rankText, 0, rank);
            scoreboard.add(playerText, 1, rank);
            scoreboard.add(scoreTextplayed, 2, rank);
            rank++;
        }

        scoreboardContainer.getChildren().addAll(scoreboardTitle, scoreboard);

        // Botón Reintentar con estilo mejorado
        Button tryAgainButton = new Button("Reintentar");
        tryAgainButton.setFont(Font.font("Arial", FontWeight.BOLD, 24));

// Eliminar el efecto del foco (rectángulo) desde el estilo en línea
        tryAgainButton.setStyle(
                "-fx-background-color: linear-gradient(#4CAF50, #2E7D32); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        );

// Desactivar programáticamente el foco
        tryAgainButton.setFocusTraversable(false);

// Efecto hover (cuando el ratón pasa sobre el botón)
        tryAgainButton.setOnMouseEntered(e -> tryAgainButton.setStyle(
                "-fx-background-color: linear-gradient(#a48def, #3fd4e6); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        ));
        tryAgainButton.setOnMouseExited(e -> tryAgainButton.setStyle(
                "-fx-background-color: linear-gradient(#4CAF50, #2E7D32); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        ));

// Configurar la acción del botón
        tryAgainButton.setOnAction(buttonAction);

        // Agregar todos los elementos al VBox
        content.getChildren().addAll(gameOver, scoreText, scoreboardContainer, tryAgainButton);

        // Añadir fondo y contenido al StackPane
        this.getChildren().addAll(background, content);
        this.setAlignment(Pos.CENTER); // Centrado absoluto
    }
}
