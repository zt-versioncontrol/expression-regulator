package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperClassProviderTest {

    SuperClassProvider provider = new SuperClassProvider();

    @Test
    void provide() {

        assertNull(provider.provide(""));
    }
}