package poo.food.apple;

import poo.config.Config;
import poo.food.Food;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * @class Apple
 * @brief Representa una comida tipo "manzana" en el juego de la serpiente utilizando un emoji.
 */
public class Apple extends Food {

    /**
     * @brief Representa la manzana utilizando un Label con emoji.
     */
    private Label apple;

    /**
     * @brief Constructor de la clase `Apple`.
     *
     * Inicializa la manzana gráficamente como un emoji y le asigna una posición aleatoria.
     */
    public Apple() {
        creatingFood();
        setRandomPosition();
    }

    /**
     * @brief Crea la manzana utilizando un Label con emoji.
     *
     * Este método establece el emoji de la manzana y su apariencia visual.
     */
    @Override
    protected void creatingFood() {
        this.apple = new Label("🍎"); // Emoji de manzana
        this.apple.setFont(Font.font("Arial", 30)); // Tamaño grande del emoji
        this.apple.setStyle(
                "-fx-text-fill: red; " + // Intenta colorear el emoji (según compatibilidad del sistema)
                        "-fx-effect: dropshadow(gaussian, #000000, 10, 0.5, 0, 0);" // Sombra roja suave
        );
        this.apple.setOpacity(1.0); // Asegura opacidad total
    }

    /**
     * @brief Asigna una posición aleatoria a la manzana dentro del área del juego.
     */
    public void setRandomPosition() {
        this.apple.setTranslateX(randomNumbers(0, Config.width - Config.squareSize));
        this.apple.setTranslateY(randomNumbers(0, Config.height - Config.squareSize));
    }

    /**
     * @brief Obtiene el objeto Label que representa la manzana.
     *
     * @return El Label con el emoji de la manzana.
     */
    public Label getApple() {
        return apple;
    }

    /**
     * @brief Obtiene la posición X actual de la manzana.
     *
     * @return Un valor entero que representa la posición X de la manzana.
     */
    @Override
    public Integer getPosicionX() {
        return (int) this.apple.getTranslateX();
    }

    /**
     * @brief Obtiene la posición Y actual de la manzana.
     *
     * @return Un valor entero que representa la posición Y de la manzana.
     */
    @Override
    public Integer getPosicionY() {
        return (int) this.apple.getTranslateY();
    }
}
