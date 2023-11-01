package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementedInterfacesProviderTest {

    ImplementedInterfacesProvider provider = new ImplementedInterfacesProvider();

    @Test
    void provide() {
        assertNull(provider.provide(""));
    }
}