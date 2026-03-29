package dev.trelawnm.exercises.triangle;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrianglePerimeterTest {
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

    @Test
    void validTriangle_printsPerimeter() {
        String input = String.join(System.lineSeparator(),
                "1.0", "2.0",
                "2.0", "1.0",
                "5.0", "5.0"
        ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TrianglePerimeter.main(new String[0]);
        String out = outContent.toString().trim();
        // exact expected line
        assertEquals("Perimeter: 11.414", out);
    }

    @Test
    void collinearPoints_printsNotTriangle_case1() {
        String input = String.join(System.lineSeparator(),
                "2.0", "1.0",
                "2.0", "1.0",
                "2.0", "1.0"
        ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TrianglePerimeter.main(new String[0]);
        String out = outContent.toString().trim();
        assertEquals("It's not a triangle", out);
    }

    @Test
    void collinearPoints_printsNotTriangle_case2() {
        String input = String.join(System.lineSeparator(),
                "2.0", "1.0",
                "2.0", "1.0",
                "3.0", "1.0"
        ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TrianglePerimeter.main(new String[0]);
        String out = outContent.toString().trim();
        assertEquals("It's not a triangle", out);
    }

    @Test
    void invalidInput_retriesAndParses() {
        // First token "bad" causes parse error, then valid numbers follow to form the first valid sample triangle
        String input = String.join(System.lineSeparator(),
                "bad",
                "1.0", "2.0",
                "2.0", "1.0",
                "5.0", "5.0"
        ) + System.lineSeparator();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TrianglePerimeter.main(new String[0]);
        String out = outContent.toString().trim();
        // Expect the error prompt printed once, then the final perimeter line.
        // The program prints "Could not parse a number. Please try again" then "Perimeter: 11.414"
        String[] lines = out.split("\\R+");
        // last non-empty line should be the perimeter
        String last = lines[lines.length - 1].trim();
        String first = lines[0].trim();
        assertEquals("Could not parse a number. Please try again", first);
        assertEquals("Perimeter: 11.414", last);
    }   
}