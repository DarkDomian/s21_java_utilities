package dev.trelawnm.exercises.fibonacci;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class FindFibonacciTest {

    @Test
    void testInputTotalSeconds() {
        String simulatedInput = "3661\n";
        Scanner scanner = new Scanner(simulatedInput);
        int result = FindFibonacci.inputFibonacciOrder(scanner);
        assertEquals(3661, result);
    }

    @Test
    void testCountFibonacci() {
        // long result = FindFibonacci.countFibonacci(9);
        assertEquals(55L, FindFibonacci.countFibonacci(10));
        assertEquals(4660046610375530309L, FindFibonacci.countFibonacci(91));
    }

    @Test
    void testCountFibonacciThrowable() {
        assertThrows(ArithmeticException.class, () -> {
            FindFibonacci.countFibonacci(92);
        });
    }

    @Test
    void testPrintFibonacci() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        try {
            FindFibonacci.printFibonacci(Long.MAX_VALUE);
            String printed = baos.toString().trim();
            assertEquals(Long.toUnsignedString(Long.MAX_VALUE), printed);
        } finally {
            System.setOut(originalOut);
        }
    }
}
