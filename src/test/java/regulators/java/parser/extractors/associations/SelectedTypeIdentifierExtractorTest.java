package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectedTypeIdentifierExtractorTest {

    SelectedTypeIdentifierExtractor extractor = new SelectedTypeIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("String", extractor.extractFromExpression("String "));
        assertEquals("List", extractor.extractFromExpression("List\n\n<\nInteger>  "));
        assertEquals("Map", extractor.extractFromExpression("Map<String,   List\t<List\n<Integer>>>"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("<List>"));
        assertEquals("", extractor.extractFromExpression("List<String><String>"));
        assertEquals("", extractor.extractFromExpression("<String><String>"));
        assertEquals("", extractor.extractFromExpression("<String>List"));
        assertEquals("List", extractor.extractFromExpression("List<String"));
        assertEquals("", extractor.extractFromExpression("< List<String>"));
        assertEquals("List List", extractor.extractFromExpression("List List"));
        assertEquals("List List", extractor.extractFromExpression("List List<String>"));
        assertEquals("{List", extractor.extractFromExpression("{List<String>"));

    }
}