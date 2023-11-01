package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeBoundProviderTest {

    TypeBoundProvider provider = new TypeBoundProvider();

    @Test
    void provide() {

        assertNull(provider.provide(""));
    }
}