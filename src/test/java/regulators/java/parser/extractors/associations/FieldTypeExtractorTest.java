package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldTypeExtractorTest {

    FieldTypeExtractor extractor = new FieldTypeExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("T", extractor.extractFromExpression("T s;"));
        assertEquals("Integer", extractor.extractFromExpression("private static final Integer s = 5   ;"));
        assertEquals("Map< String, Boolean >", extractor.extractFromExpression("private Map< \nString, Boolean\n> map = new HashMap<>();"));
        assertEquals("Map<List <String> , Map <Integer, Boolean> >", extractor.extractFromExpression("private Map<List<String>, Map<Integer, Boolean>> map = new HashMap<>();"));


        assertEquals("", extractor.extractFromExpression(";"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("<String><String>", extractor.extractFromExpression("<String><String> s;"));
        assertEquals("< String ><String>", extractor.extractFromExpression("< String ><String> s;"));
        assertEquals("<List <str> ><String>", extractor.extractFromExpression("<Map><Integer><List<str>><String> s;"));
        assertEquals("List<=String>", extractor.extractFromExpression("List<=String> s;"));
    }
}