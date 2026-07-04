package dev.trelawnm.exercises;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AscendingOrderTest {
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
    void some() {
        String input = "1 2 3 5 4";
        provideInput(input);
        AscendingOrder.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("The sequence is not ordered from the ordinal number of the number 4", lastLine);
    }
    
    @Test
    void some1() {
        String input = "a";
        provideInput(input);
        AscendingOrder.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("Input error", lastLine);
    }

    @Test
    void some2() {
        String input = "10 20 50 80 90\ng";
        provideInput(input);
        AscendingOrder.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("The sequence is ordered in ascending order", lastLine);
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
