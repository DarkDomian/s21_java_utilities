package dev.trelawnm.exercises;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SelectionSortTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
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


    @Test void correctInput() {
        String input = "4\n100.0 50.0 60.0 10.0\n";
        provideInput(input);
        SelectionSort.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("10.0 50.0 60.0 100.0", lastLine); 
    }

    @Test void incorrectInput() {
        String input = "-1";
        provideInput(input);
        SelectionSort.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("Input error. Size <= 0", lastLine); 
    }

    private void provideInput(String data) {
        System.setIn(new ByteArrayInputStream(data.getBytes()));
    }

    private String getLastOutputLine() {
        String output = outContent.toString();
        String[] lines = output.split(System.lineSeparator());
        for (int i = lines.length - 1; i >= 0; i--) {
            if (!lines[i].isEmpty()) {
                return lines[i];
            }
        }
        return "";
    }
}
