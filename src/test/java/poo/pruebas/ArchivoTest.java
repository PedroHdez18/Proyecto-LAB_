package poo.pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import poo.Archivo;

public class ArchivoTest {

    @Test
    public void testCreateMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = archivo.createMatrix(3, 3, 5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(5, matrix[i][j]);
            }
        }
    }

    @Test
    public void testSumMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int sum = archivo.sumMatrix(matrix);

        assertEquals(45, sum);
    }

    @Test
    public void testDescribeMatrix() {
        Archivo archivo = new Archivo();
        int[][] matrix = {{1, 2}, {3, 4}};
        String description = archivo.describeMatrix(matrix);

        String expected = "1 2 \n3 4 \n";
        assertEquals(expected, description);
    }
}
