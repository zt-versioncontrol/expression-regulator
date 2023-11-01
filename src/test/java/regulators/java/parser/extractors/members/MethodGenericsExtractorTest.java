package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodGenericsExtractorTest {

    MethodGenericsExtractor extractor = new MethodGenericsExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("", extractor.extractFromExpression("void fun(){}"));
        assertEquals("", extractor.extractFromExpression("List<String\n>    fun();"));
        assertEquals("", extractor.extractFromExpression("public static List\n<String> fun();"));
        assertEquals("<T>", extractor.extractFromExpression("<T> String fun(int i){}"));
        assertEquals("<T, l extends String>", extractor.extractFromExpression("public static <T, \n\nl\nextends String>\nMap<List<String>,Integer> func(){}"));

        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("<String><String>fun()"));
        assertEquals("<TT>", extractor.extractFromExpression("<TT><String><String>fun()"));
        assertEquals("<TT>", extractor.extractFromExpression("public <TT><String><String>fun()"));
        assertEquals("", extractor.extractFromExpression("(){}"));
        assertEquals("", extractor.extractFromExpression("fun(){}"));
        assertEquals("", extractor.extractFromExpression("<T> String fun"));
        assertEquals("", extractor.extractFromExpression("<T> String fun{}"));
        assertEquals("", extractor.extractFromExpression("<T> String fun{()"));
        assertEquals("", extractor.extractFromExpression("<T>{ String fun()"));
        assertEquals("", extractor.extractFromExpression("<T String fun()"));
        assertEquals("", extractor.extractFromExpression("<T List<String> fun()"));
    }
}