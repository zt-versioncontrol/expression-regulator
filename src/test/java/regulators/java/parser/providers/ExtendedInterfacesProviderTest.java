package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedInterfacesProviderTest {

    ExtendedInterfacesProvider provider = new ExtendedInterfacesProvider();

    @Test
    void provide() {

        assertNull(provider.provide(""));
    }
}