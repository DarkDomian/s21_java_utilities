package dev.trelawnm.exercises;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class FindSubstringTest {
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
        String input = "4\nFirst car\nSecond door\nThird message\nFourth wood\noo\n";
        provideInput(input);
        FindSubstring.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("Second door, Fourth wood", lastLine);
    }
    
    @Test
    void some1() {
        String input = "2\nFirst car\nSecond door\nkek\n";
        provideInput(input);
        FindSubstring.main(new String[]{});
        String lastLine = getLastOutputLine();
        assertEquals("", lastLine);
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
