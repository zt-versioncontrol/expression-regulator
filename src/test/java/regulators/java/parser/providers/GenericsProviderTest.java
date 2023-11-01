package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsProviderTest {

    GenericsProvider provider = new GenericsProvider();

    @Test
    void provide() {
        assertNull(provider.provide(""));
    }
}