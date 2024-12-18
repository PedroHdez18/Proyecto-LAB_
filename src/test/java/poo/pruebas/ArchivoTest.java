package poo.pruebas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poo.Archivo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoTest {

    private static final String FILE_NAME = "ArchivoDePuntos.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Ensure the file is empty before each test
        Files.deleteIfExists(Paths.get(FILE_NAME));
        Files.createFile(Paths.get(FILE_NAME));
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the file after each test
        Files.deleteIfExists(Paths.get(FILE_NAME));
    }

    @Test
    void testWriteScore() throws IOException {
        Archivo.writeScore("Player1", 100);
        Archivo.writeScore("Player2", 200);

        List<String> lines = Files.readAllLines(Path.of(FILE_NAME));

        assertEquals(2, lines.size());
        assertEquals("Player1: 100", lines.get(0));
        assertEquals("Player2: 200", lines.get(1));
    }
//
//    @Test
//    void testGetTopScores() throws IOException {
//        Files.write(Paths.get(FILE_NAME), List.of(
//                "Player1: 100",
//                "Player2: 200",
//                "Player3: 150"
//        ));
//
//        List<String> topScores = Archivo.getTopScores(2);
//
//        assertEquals(2, topScores.size());
//        assertEquals("Player2: 200", topScores.get(0));
//        assertEquals("Player3: 150", topScores.get(1));
//    }

    @Test
    void testCreateMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = archivo.createMatrix(3, 3, 5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(5, matrix[i][j]);
            }
        }
    }

    @Test
    void testSumMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int sum = archivo.sumMatrix(matrix);
        assertEquals(45, sum);
    }

    @Test
    void testDescribeMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };

        String description = archivo.describeMatrix(matrix);
        String expected = "1 2 \n3 4 \n";

        assertEquals(expected, description);
    }
}
