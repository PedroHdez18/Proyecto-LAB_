package poo.play_button;

import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import poo.config.Config;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

/**
 * @class PlayButton
 * @brief Clase que representa un botón de inicio junto con un título y descripción para la pantalla de bienvenida.
 */
public class PlayButton extends VBox {

    /**
     * @brief Constructor que inicializa la pantalla de bienvenida con sus elementos.
     *
     * @param playAction Acción que se ejecutará al presionar el botón "Iniciar Intento".
     */
    public PlayButton(EventHandler<ActionEvent> playAction) {

        // Título principal del juego
        Text title = new Text("Snake Game");
        title.setFont(Font.font("Georgia", FontWeight.BOLD, 60));
        title.setStyle("-fx-fill: #333; -fx-effect: dropshadow(gaussian, lightgray, 10, 0.5, 2, 2);");

        // Contenedor de la descripción con fondo estilizado
        StackPane descriptionContainer = new StackPane();
        descriptionContainer.setPadding(new Insets(10));
        descriptionContainer.setStyle(
                "-fx-background-color: #EAF2F8; " + // Color pastel para el contenedor de descripción
                        "-fx-background-radius: 10; " +
                        "-fx-border-color: #D6EAF8; " +
                        "-fx-border-radius: 10;"
        );

        Text description = new Text(
                "Observaciones:\n" +
                        "🍎 Las manzanas valen 3 puntos.\n" +
                        "🍍 Las piñas valen 1 punto.\n" +
                        "🎮 Usa las flechas o las teclas W, A, S y D para mover la serpiente!"
        );
        description.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
        description.setTextAlignment(TextAlignment.CENTER);
        description.setFill(Color.web("#2C3E50"));

        descriptionContainer.getChildren().add(description);

        // Botón para iniciar el juego
        Button play = new Button("Iniciar Intento");
        play.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        // Eliminar el efecto del foco (rectángulo) desde el estilo en línea
        play.setStyle(
                "-fx-background-color: linear-gradient(#4CAF50, #2E7D32); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        );

        // Desactivar programáticamente el foco
        play.setFocusTraversable(false);

        // Efecto hover (cuando el ratón pasa sobre el botón)
        play.setOnMouseEntered(e -> play.setStyle(
                "-fx-background-color: linear-gradient(#a48def, #3fd4e6); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        ));
        play.setOnMouseExited(e -> play.setStyle(
                "-fx-background-color: linear-gradient(#4CAF50, #2E7D32); " +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20; " +
                        "-fx-background-radius: 20; " +
                        "-fx-border-color: transparent; " +
                        "-fx-focus-color: transparent; " +
                        "-fx-faint-focus-color: transparent;"
        ));

        play.setOnAction(playAction);

        // Configurar el VBox (contenedor)
        this.setMinWidth(Config.width);
        this.setMinHeight(Config.height);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20));

        // Fondo pastel aplicado al contenedor principal
        this.setStyle("-fx-background-color: #f8ecb4;"); // Color sólido pastel

        // Agregar los elementos al VBox
        this.getChildren().addAll(title, descriptionContainer, play);
    }
}
