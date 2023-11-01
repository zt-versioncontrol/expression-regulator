package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodTypeExtractorTest {

    MethodTypeExtractor extractor = new MethodTypeExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("void", extractor.extractFromExpression("void fun(){}"));
        assertEquals("void", extractor.extractFromExpression("void fun();"));
        assertEquals("String", extractor.extractFromExpression("public static\nString\tfunc\n(String s){}"));
        assertEquals("Map<String, List <List <String> > >", extractor.extractFromExpression("private Map<String, List<List<String>>> fun\n(int i);"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("fun()"));
        assertEquals("", extractor.extractFromExpression("< fun()"));
        assertEquals("String", extractor.extractFromExpression("String< fun()"));
        assertEquals("Map", extractor.extractFromExpression("private Map<String, List<List<String>> fun\n(int i);"));

        assertEquals("", extractor.extractFromExpression("List<String>fun"));
        assertEquals("List<String>", extractor.extractFromExpression("List<String><String>()"));
        assertEquals("<String>", extractor.extractFromExpression("<String> fun()"));
        assertEquals("<List><String>", extractor.extractFromExpression("<List><List><String> fun()"));
    }
}