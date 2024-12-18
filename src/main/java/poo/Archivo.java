package poo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @class Archivo
 * @brief Clase que maneja la lectura y escritura de puntuaciones en un archivo de texto.
 * Permite guardar las puntuaciones del jugador y obtener las mejores puntuaciones.
 */
public class Archivo {

    private static final Logger LOGGER = Logger.getLogger(Archivo.class.getName());
    private static List<String> topScores = new ArrayList<>();

    /**
     * @brief Escribe la puntuación de un jugador en un archivo de texto.
     * Si el archivo no existe, lo crea. Si ya existe, añade la puntuación al final.
     *
     * @param nickname El nombre del jugador.
     * @param score La puntuación obtenida por el jugador.
     */
    public static void writeScore(String nickname, Integer score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePuntos.txt", true))) {
            bw.write(nickname + ": " + score);
            bw.newLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing score to file", e);
        }
    }

    /**
     * @brief Escribe la puntuación de un jugador en un archivo de texto.
     * Si el archivo no existe, lo crea. Si ya existe, añade la puntuación al final.
     *
     * @param nickname El nombre del jugador.
     * @param score La puntuación obtenida por el jugador.
     */
    public static void writeScoreTest(String nickname, Integer score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePruebas.txt", true))) {
            bw.write(nickname + ": " + score);
            bw.newLine();
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing score to file", e);
        }
    }

    /**
     * @brief Obtiene las mejores puntuaciones almacenadas en el archivo de puntuaciones.
     * Lee las puntuaciones, las ordena de mayor a menor y retorna una lista con las mejores puntuaciones,
     * limitadas por el parámetro `limit`.
     *
     * @param limit El número máximo de puntuaciones a obtener.
     * @return Una lista de las mejores puntuaciones en formato de texto.
     */
    public static List<String> getTopScores(int limit) {
        List<String> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ArchivoDePuntos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading scores from file", e);
        }

        // Ordenar las puntuaciones de mayor a menor
        scores.sort((a, b) -> Integer.compare(
                Integer.parseInt(b.split(": ")[1]),
                Integer.parseInt(a.split(": ")[1])
        ));

        return scores.size() > limit ? scores.subList(0, limit) : scores;
    }

    /**
     * @brief Obtiene las mejores puntuaciones almacenadas en el archivo de puntuaciones.
     * Lee las puntuaciones, las ordena de mayor a menor y retorna una lista con las mejores puntuaciones,
     * limitadas por el parámetro `limit`.
     *
     * @param limit El número máximo de puntuaciones a obtener.
     * @return Una lista de las mejores puntuaciones en formato de texto.
     */
    public static List<String> getTopScoresTest(int limit) {
        List<String> scores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("ArchivoDePruebas.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                scores.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error reading scores from file", e);
        }

        // Ordenar las puntuaciones de mayor a menor
        scores.sort((a, b) -> Integer.compare(
                Integer.parseInt(b.split(": ")[1]),
                Integer.parseInt(a.split(": ")[1])
        ));

        return scores.size() > limit ? scores.subList(0, limit) : scores;
    }

    public int[][] createMatrix(int rows, int cols, int value) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
            }
        }
        return matrix;
    }

    public int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum += val;
            }
        }
        return sum;
    }

    public String describeMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : matrix) {
            for (int val : row) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}