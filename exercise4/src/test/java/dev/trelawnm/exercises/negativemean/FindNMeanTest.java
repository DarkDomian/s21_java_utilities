package dev.trelawnm.exercises.negativemean;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FindNMeanTest {

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
    void testNoNegativeNumbers() {
        String input = "4\n1\n2\n3\n4\n";
        provideInput(input);
        FindNMean.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("There are no negative elements", lastLine);
    }

    @Test
    void testInvalidSize() {
        String input = "-1\n";
        provideInput(input);
        FindNMean.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("Input error. Size <= 0", lastLine);
    }

    @Test
    void testNegativeMean() {
        String input = "4\n1\n-2\n3\n-4\n";
        provideInput(input);
        FindNMean.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("-3", lastLine);
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