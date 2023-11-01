package regulators.java.parser.extractors.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldInitializerExtractorTest {

    FieldInitializerExtractor extractor = new FieldInitializerExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("", extractor.extractFromExpression("String s;"));
        assertEquals("\"abc\";", extractor.extractFromExpression("String s = \n\n\"abc\";    "));
        assertEquals("5*k + 2*l;", extractor.extractFromExpression("private\nint = 5*k + 2*l;"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("abc"));
        assertEquals("5;", extractor.extractFromExpression(" = 5;"));
        assertEquals("4", extractor.extractFromExpression("int i = 4"));
        assertEquals("r", extractor.extractFromExpression("List<=l> = r"));
        assertEquals("List<k=1>", extractor.extractFromExpression("int i = List<k=1>"));

    }
}