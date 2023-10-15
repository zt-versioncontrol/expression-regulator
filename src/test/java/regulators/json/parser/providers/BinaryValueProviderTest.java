package regulators.json.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryValueProviderTest {

    @Test
    void provide() {
        BinaryValueProvider provider = new BinaryValueProvider();

        assertEquals(true, provider.provide("true"));
        assertEquals(false, provider.provide("false"));

        //invalid input
        assertEquals(false, provider.provide("True"));
        assertEquals(false, provider.provide("tRue"));
        assertEquals(false, provider.provide(""));
        assertEquals(false, provider.provide("False"));
    }
}