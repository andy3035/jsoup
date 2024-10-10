package org.jsoup.helper;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateTest {
    @Test
    public void testNotNull() {
        Validate.notNull("foo");
        boolean threw = false;
        try {
            Validate.notNull(null);
        } catch (IllegalArgumentException e) {
            threw = true;
        }
        Assertions.assertTrue(threw);
    }

    @Test void stacktraceFiltersOutValidateClass() {
        boolean threw = false;
        try {
            Validate.notNull(null);
        } catch (ValidationException e) {
            threw = true;
            assertEquals("Object must not be null", e.getMessage());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement trace : stackTrace) {
                assertNotEquals(trace.getClassName(), Validate.class.getName());
            }
            assertTrue(stackTrace.length >= 1);
        }
        Assertions.assertTrue(threw);
    }

    @Test void nonnullParam() {
        boolean threw = true;
        try {
            Validate.notNullParam(null, "foo");
        } catch (ValidationException e) {
            assertEquals("The parameter 'foo' must not be null.", e.getMessage());
        }
        assertTrue(threw);
    }

    @Test
    public void testNotEmpty(){

        String testNullString = null;
        String testEmptyString = "";
        String validString = "test string is-valid";

        // Valid string case
        Assertions.assertDoesNotThrow(() -> Validate.notEmpty(validString), "Valid string should not throw an exception");

        // Empty string case
        ValidationException emptyException = Assertions.assertThrows(ValidationException.class, () -> Validate.notEmpty(testEmptyString));
        Assertions.assertEquals("String must not be empty", emptyException.getMessage());

        // Null string case
        ValidationException nullException = Assertions.assertThrows(ValidationException.class, () -> Validate.notEmpty(testNullString));
        Assertions.assertEquals("String must not be empty", nullException.getMessage());

    }
}
