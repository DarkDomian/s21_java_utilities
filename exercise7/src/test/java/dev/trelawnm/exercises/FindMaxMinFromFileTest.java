package dev.trelawnm.exercises;

import java.io.StringReader;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FindMaxMinFromFileTest {

    @Test
    void testFindMinMaxNormal() throws InsufficientDataException {
        String data = "5\n2.5 1.0 7.3 4.2 0.9";
        Scanner sc = new Scanner(new StringReader(data));
        int n = FindMaxMinFromFile.readInteger(sc);
        double[] arr = new double[n];
        double[] minMax = new double[2];
        FindMaxMinFromFile.findMinMax(arr, minMax, sc);
        assertEquals(0.9, minMax[0]);
        assertEquals(7.3, minMax[1]);
    }

    @Test
    void testInsufficientData() throws InsufficientDataException {
        String data = "5\n2.5 1.0 7.3";
        Scanner sc = new Scanner(new StringReader(data));
        int n = FindMaxMinFromFile.readInteger(sc);
        double[] arr = new double[n];
        double[] minMax = new double[2];
        assertThrows(InsufficientDataException.class, () -> {
            FindMaxMinFromFile.findMinMax(arr, minMax, sc);
        });
    }
}