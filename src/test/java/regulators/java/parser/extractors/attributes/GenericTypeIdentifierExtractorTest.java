package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericTypeIdentifierExtractorTest {

    GenericTypeIdentifierExtractor extractor = new GenericTypeIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("T", extractor.extractFromExpression("T     "));
        assertEquals("TT", extractor.extractFromExpression("TT\nextends \n\n\tString"));
        assertEquals("TT", extractor.extractFromExpression("TT      extends        <List<List>>"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("T implements Comparable", extractor.extractFromExpression("T implements Comparable"));
        assertEquals("extends", extractor.extractFromExpression("extends"));
        assertEquals("extends", extractor.extractFromExpression(" extends "));
        assertEquals("T extends", extractor.extractFromExpression("T extends "));
        assertEquals("T extends", extractor.extractFromExpression("T extends"));
        assertEquals("Textends String", extractor.extractFromExpression("Textends String"));
    }
}