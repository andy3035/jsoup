package org.jsoup.internal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleBufferedTest {
    private final byte[] testString = "Test string.".getBytes();
    private SimpleBufferedInput simpleBufferedInput =
            new SimpleBufferedInput(new ByteArrayInputStream(testString));

    @Test
    public void testMarkAndReset() throws IOException {
        // Test de marquage d'une position dans le flux et réinitialisation à cette position

        simpleBufferedInput.mark(SimpleBufferedInput.BufferSize);
        byte[] buffer = new byte[4];
        simpleBufferedInput.read(buffer, 0, buffer.length);

        simpleBufferedInput.reset();
        int result = simpleBufferedInput.read();

        // Assert
        assertEquals('T', result);
    }

    @Test
    public void testReadAfterEndOfStream() throws IOException {
        // Test de lecture après avoir atteint la fin du flux
        // Arrange
        byte[] buffer = new byte[testString.length];
        simpleBufferedInput.read(buffer, 0, buffer.length);

        // Act
        int result = simpleBufferedInput.read();

        // Assert
        assertEquals(-1, result);
    }

}
