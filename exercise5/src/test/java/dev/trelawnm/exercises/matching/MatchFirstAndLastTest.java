package dev.trelawnm.exercises.matching;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    void some() {
        String input = "4\n100 200 300 400\n";
        provideInput(input);
        MatchFirstAndLast.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("There are no such elements", lastLine);
    }
    
    @Test
    void some1() {
        String input = "-1";
        provideInput(input);
        MatchFirstAndLast.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("Input error. Size <= 0", lastLine);
    }

    @Test
    void some2() {
        String input = "5\n1 202 300 200005 301213\n";
        provideInput(input);
        MatchFirstAndLast.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("1 202 301213", lastLine);
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
