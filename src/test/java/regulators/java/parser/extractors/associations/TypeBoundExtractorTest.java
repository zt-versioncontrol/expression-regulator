package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeBoundExtractorTest {

    TypeBoundExtractor extractor = new TypeBoundExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("String", extractor.extractFromExpression("T extends String"));
        assertEquals("List<String>", extractor.extractFromExpression("T1 extends\nList<String>"));
        assertEquals("List<String>", extractor.extractFromExpression("T1 extends List<String>"));
        assertEquals("List <String>", extractor.extractFromExpression("T1\nextends List\n<String>"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("extends String"));
        assertEquals("", extractor.extractFromExpression("t extends "));
        assertEquals("", extractor.extractFromExpression(" extends "));
        assertEquals("", extractor.extractFromExpression("extends"));
        assertEquals("", extractor.extractFromExpression(" extends Map"));
        assertEquals("", extractor.extractFromExpression("T1 extendsList<String>"));

    }
}