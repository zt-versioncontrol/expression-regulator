package regulators.json.parser.providers;

import org.junit.jupiter.api.Test;
import regulators.json.parser.parsedObjects.*;

import static org.junit.jupiter.api.Assertions.*;

class JsonProviderTest {

    @Test
    void provide() {
        JsonProvider provider = new JsonProvider();

        assertEquals(JsonObject.class, provider.provide("{\"a\": 33}").getClass());
        assertEquals(JsonArray.class, provider.provide("[1, 4, 5, \"z\"]").getClass());
        assertEquals(JsonString.class, provider.provide("\"abcd\"efg123\"").getClass());
        assertEquals(JsonNumber.class, provider.provide("65").getClass());
        assertEquals(JsonBinary.class, provider.provide("true").getClass());
        assertEquals(JsonBinary.class, provider.provide("false").getClass());
        assertEquals(JsonNull.class, provider.provide("null").getClass());


        assertEquals(JsonInvalid.class, provider.provide("").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" ").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" {\"b\": 3} ").getClass());
        assertEquals(JsonInvalid.class, provider.provide("{\"b\": 3} ").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" {\"b\": 3}").getClass());
        assertEquals(JsonInvalid.class, provider.provide("{").getClass());
        assertEquals(JsonInvalid.class, provider.provide("}").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" [] ").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" []").getClass());
        assertEquals(JsonInvalid.class, provider.provide("[] ").getClass());
        assertEquals(JsonInvalid.class, provider.provide("[").getClass());
        assertEquals(JsonInvalid.class, provider.provide("]").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" \"abc\" ").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" \"abc\"").getClass());
        assertEquals(JsonInvalid.class, provider.provide("\"abc\" ").getClass());
        assertEquals(JsonInvalid.class, provider.provide("\"").getClass());
        assertEquals(JsonInvalid.class, provider.provide("43ew").getClass());
        assertEquals(JsonInvalid.class, provider.provide("True").getClass());
        assertEquals(JsonInvalid.class, provider.provide("TRUE").getClass());
        assertEquals(JsonInvalid.class, provider.provide("False").getClass());
        assertEquals(JsonInvalid.class, provider.provide("FALSE").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" true ").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" false ").getClass());
        assertEquals(JsonInvalid.class, provider.provide("Null").getClass());
        assertEquals(JsonInvalid.class, provider.provide("NULL").getClass());
        assertEquals(JsonInvalid.class, provider.provide(" null ").getClass());
    }
}