package poo;

import java.io.*;

public class Archivo {

    public static void writeScores(String playerName, Integer score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoDePuntos.txt", true))) {
            bw.write("Jugador: " + playerName + ", Puntuación: " + score);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
