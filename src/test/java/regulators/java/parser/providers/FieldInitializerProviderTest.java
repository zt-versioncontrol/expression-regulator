package regulators.java.parser.providers;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FieldInitializerProviderTest {

    FieldInitializerProvider provider = new FieldInitializerProvider();

    @Test
    void provide() {
        assertNull(provider.provide(""));
    }
}