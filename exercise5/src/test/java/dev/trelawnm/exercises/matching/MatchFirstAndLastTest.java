package dev.trelawnm.exercises.matching;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatchFirstAndLastTest {
    private final PrintStream originalOut = System.out;
    private final java.io.InputStream originalIn = System.in;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }


    // TODO: write tests for MathFirstAndLast
    @Test void printResult() {
        int[] arr = {0,1,1,2,3,5,8,13,21,34,55};
        MatchFirstAndLast.printResult(arr,arr.length);
        String out = outContent.toString().trim();
        assertEquals("0 1 1 2 3 5 8 13 21 34 55");

    }
}
