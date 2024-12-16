package poo.food.pineapple;

import poo.config.Config;
import poo.food.Food;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * @class Pineapple
 * @brief Representa una comida tipo "piña" en el juego de la serpiente utilizando un emoji.
 */
public class Pineapple extends Food {

    /**
     * @brief Representa la piña utilizando un Label con emoji.
     */
    private Label pineapple;

    /**
     * @brief Constructor de la clase `Pineapple`.
     *
     * Inicializa la piña gráficamente como un emoji y le asigna una posición aleatoria.
     */
    public Pineapple() {
        creatingFood();
        setRandomPosition();
    }

    /**
     * @brief Crea la piña utilizando un Label con emoji.
     *
     * Este método establece el emoji de la piña y su apariencia visual.
     */
    @Override
    protected void creatingFood() {
        this.pineapple = new Label("🍍"); // Emoji de piña
        this.pineapple.setFont(Font.font("Arial", 30)); // Tamaño grande del emoji
        this.pineapple.setStyle(
                "-fx-text-fill: yellow; " + // Intenta colorear el emoji (según compatibilidad)
                        "-fx-effect: dropshadow(gaussian, #F9A825, 10, 0.5, 0, 0);" // Sombra amarilla suave
        );
        this.pineapple.setOpacity(1.0); // Asegura opacidad total
    }

    /**
     * @brief Asigna una posición aleatoria a la piña dentro del área del juego.
     */
    public void setRandomPosition() {
        this.pineapple.setTranslateX(randomNumbers(Config.oneQuarterWidthDown, Config.oneQuarterWidthUp - Config.squareSize));
        this.pineapple.setTranslateY(randomNumbers(Config.oneQuarterfHeightDown, Config.oneQuarterfHeightUp - Config.squareSize));
    }

    /**
     * @brief Obtiene el objeto Label que representa la piña.
     *
     * @return El Label con el emoji de la piña.
     */
    public Label getPineapple() {
        return pineapple;
    }

    /**
     * @brief Obtiene la posición X actual de la piña.
     *
     * @return Un valor entero que representa la posición X de la piña.
     */
    @Override
    public Integer getPosicionX() {
        return (int) this.pineapple.getTranslateX();
    }

    /**
     * @brief Obtiene la posición Y actual de la piña.
     *
     * @return Un valor entero que representa la posición Y de la piña.
     */
    @Override
    public Integer getPosicionY() {
        return (int) this.pineapple.getTranslateY();
    }
}
