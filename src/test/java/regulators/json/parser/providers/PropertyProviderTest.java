package regulators.json.parser.providers;

import org.junit.jupiter.api.Test;
import regulators.json.parser.parsedObjects.Property;

import static org.junit.jupiter.api.Assertions.*;

class PropertyProviderTest {

    @Test
    void provide() {
        PropertyProvider provider = new PropertyProvider();

        assertEquals(Property.class, provider.provide("").getClass());
        assertEquals(Property.class, provider.provide("xxx").getClass());
        assertEquals(Property.class, provider.provide("\"a\": 3").getClass());
    }
}