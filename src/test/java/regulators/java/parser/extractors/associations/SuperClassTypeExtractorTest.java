package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperClassTypeExtractorTest {

    SuperClassTypeExtractor extractor = new SuperClassTypeExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("String", extractor.extractFromExpression("extends String"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("String"));
        assertEquals("", extractor.extractFromExpression("extends"));
        assertEquals("", extractor.extractFromExpression(" extends String"));
        assertEquals("List String", extractor.extractFromExpression("extends List String"));
        assertEquals("List, String", extractor.extractFromExpression("extends List, String"));
    }
}