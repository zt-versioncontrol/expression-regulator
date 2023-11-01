package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParameterIdentifierExtractorTest {

    ParameterIdentifierExtractor extractor = new ParameterIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("str", extractor.extractFromExpression("String str              "));
        assertEquals("lst", extractor.extractFromExpression("List<Integer>\n\n\nlst"));
        assertEquals("map", extractor.extractFromExpression("Map<String, List<String>> map"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("String"));
        assertEquals("String>", extractor.extractFromExpression("Map<String, String>"));
        assertEquals("lst", extractor.extractFromExpression("List<Integer lst"));
        assertEquals("<String>", extractor.extractFromExpression("List<String><String>"));
        assertEquals(">", extractor.extractFromExpression("List<String>< String >"));
        assertEquals("<String>", extractor.extractFromExpression("List<String>><String><String><String>"));
        assertEquals("efg", extractor.extractFromExpression("List<String> abc efg "));
        assertEquals("str", extractor.extractFromExpression("String String str "));
    }
}