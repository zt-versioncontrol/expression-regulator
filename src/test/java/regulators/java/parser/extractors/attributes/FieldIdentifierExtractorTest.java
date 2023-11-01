package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldIdentifierExtractorTest {

    FieldIdentifierExtractor extractor = new FieldIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("s", extractor.extractFromExpression("String s;"));
        assertEquals("s", extractor.extractFromExpression("private static String s   \n;"));
        assertEquals("str", extractor.extractFromExpression("  String \t\nstr \n=\n \"ttt\";"));
        assertEquals("lst", extractor.extractFromExpression(" List<\nInteger> \nlst\n =\n new List<>();"));
        assertEquals("lst", extractor.extractFromExpression("public    List<Integer>lst=new List<>;"));
        assertEquals("", extractor.extractFromExpression(";"));

        //invalid expressions buy have enough structure to extract from
        assertEquals("String", extractor.extractFromExpression("String;"));
        assertEquals("<name>", extractor.extractFromExpression("<name>;"));
        assertEquals(">", extractor.extractFromExpression("<name >;"));
        assertEquals("name>", extractor.extractFromExpression("< name>;"));
        assertEquals(">", extractor.extractFromExpression("< >;"));

        //invalid expression (expression must end with semicolon
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("String s"));

        assertEquals("", extractor.extractFromExpression("= \"abcdefg\";"));
        assertEquals("", extractor.extractFromExpression("=;"));
        assertEquals("", extractor.extractFromExpression("="));
    }
}