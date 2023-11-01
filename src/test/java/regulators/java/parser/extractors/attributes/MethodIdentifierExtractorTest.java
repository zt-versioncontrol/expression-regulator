package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodIdentifierExtractorTest {

    MethodIdentifierExtractor extractor = new MethodIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("fun", extractor.extractFromExpression("void\n  fun  \n()\n{}"));
        assertEquals("fun", extractor.extractFromExpression("void\n fun();"));
        assertEquals("fun", extractor.extractFromExpression("private static String fun(int i)\n{\n\treturn null;}"));
        assertEquals("fun", extractor.extractFromExpression("private static String fun(int i);"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("()"));
        assertEquals("fun", extractor.extractFromExpression("fun()"));
        assertEquals("<fun>", extractor.extractFromExpression("<fun>()"));
        assertEquals(">", extractor.extractFromExpression("< fun  >   ()"));
        assertEquals("", extractor.extractFromExpression("public void{}"));
        assertEquals("", extractor.extractFromExpression("public void{(String s)"));
        assertEquals("", extractor.extractFromExpression("{static String f()"));
    }
}