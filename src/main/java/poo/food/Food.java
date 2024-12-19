package poo.food;

import java.security.SecureRandom;
import poo.config.Config;

/**
 * @class Food
 * @brief Clase abstracta que define la estructura básica para los objetos de tipo comida en el juego de la serpiente.
 *
 * Esta clase proporciona métodos y atributos comunes a todos los tipos de alimentos,
 * como el cálculo de posiciones aleatorias y la obtención de coordenadas.
 */
public abstract class Food {

    // Instancia de SecureRandom para garantizar la seguridad al generar números aleatorios
    private static final SecureRandom secureRandom = new SecureRandom();

    /**
     * @brief Método abstracto para crear la representación gráfica de un alimento.
     *
     * Las clases que heredan de `Food` deben implementar este método para definir
     * cómo se crea gráficamente el objeto de comida.
     */
    protected abstract void creatingFood();

    /**
     * @brief Genera un número aleatorio dentro de un rango dado y lo ajusta a la cuadrícula del juego.
     *
     * Este método asegura que el valor generado sea un múltiplo del tamaño de los cuadrados (`Config.squareSize`),
     * para que el objeto se alinee correctamente en la cuadrícula del área del juego.
     *
     * @param min Valor mínimo del rango.
     * @param max Valor máximo del rango.
     * @return Un número aleatorio ajustado al tamaño de la cuadrícula.
     */
    public Integer randomNumbers(Integer min, Integer max) {
        if (min == null || max == null || min > max) {
            throw new IllegalArgumentException("Los valores de min y max deben ser válidos.");
        }

        // Generar un número aleatorio dentro del rango [min, max]
        int value = secureRandom.nextInt((max - min) + 1) + min;

        // Ajustar el valor para que sea múltiplo de Config.squareSize
        return value - (value % Config.squareSize);
    }

    /**
     * @brief Obtiene la posición X actual del objeto de comida.
     *
     * Este es un método abstracto que debe ser implementado por las clases derivadas,
     * para devolver la posición X del objeto de comida en el área del juego.
     *
     * @return La posición X del objeto como un entero.
     */
    public abstract Integer getPosicionX();

    /**
     * @brief Obtiene la posición Y actual del objeto de comida.
     *
     * Este es un método abstracto que debe ser implementado por las clases derivadas,
     * para devolver la posición Y del objeto de comida en el área del juego.
     *
     * @return La posición Y del objeto como un entero.
     */
    public abstract Integer getPosicionY();
}
