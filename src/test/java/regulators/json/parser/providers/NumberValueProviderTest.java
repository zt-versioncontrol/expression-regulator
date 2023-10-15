package regulators.json.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValueProviderTest {

    @Test
    void provide() {
        NumberValueProvider provider = new NumberValueProvider();

        assertEquals(500D, provider.provide("500"));
        assertEquals(500.1D, provider.provide("500.1"));
        assertThrowsExactly(NumberFormatException.class, () -> provider.provide("adf"));
        assertThrowsExactly(NumberFormatException.class, () -> provider.provide(""));
    }
}