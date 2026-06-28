package dev.trelawnm.exercises.fibonacci;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class FindFibonacciTest {
    
    @Test
    void testCalculateHoursMinutesSeconds() {
        assertArrayEquals(new int[]{1, 1, 1}, 
            TimeConverter.calculateHoursMinutesSeconds(3661));
        assertArrayEquals(new int[]{0, 0, 0}, 
            TimeConverter.calculateHoursMinutesSeconds(0));
        assertArrayEquals(new int[]{2, 30, 45}, 
            TimeConverter.calculateHoursMinutesSeconds(9045));
        assertArrayEquals(new int[]{0, 59, 59}, 
            TimeConverter.calculateHoursMinutesSeconds(3599));
        assertArrayEquals(new int[]{1, 0, 1}, 
            TimeConverter.calculateHoursMinutesSeconds(3601));

        // handle time overflow
        assertArrayEquals(new int[]{23, 59, 59}, 
            TimeConverter.calculateHoursMinutesSeconds(86399));
        assertArrayEquals(new int[]{0, 0, 0}, 
            TimeConverter.calculateHoursMinutesSeconds(86400));
    }

    @Test
    void testInputTotalSeconds() {
        String simulatedInput = "3661\n";
        Scanner scanner = new Scanner(simulatedInput);
        int result = TimeConverter.inputTotalSeconds(scanner);
        assertEquals(3661, result);
    }

    @Test
    void testOutputResult() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        try {
            TimeConverter.printResult(1, 1, 1);
            String printed = baos.toString().trim();
            assertEquals("01:01:01", printed);
        } finally {
            System.setOut(originalOut);
        }
    }
}
