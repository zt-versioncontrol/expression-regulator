package regulators.java.parser.extractors.members;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceGenericsExtractorTest {

    InterfaceGenericsExtractor extractor = new InterfaceGenericsExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("<T>", extractor.extractFromExpression("interface Inter<T>{}"));
        assertEquals("<T, R>", extractor.extractFromExpression("\npublic static\n interface   I<T,\nR> extends I2{}\n"));
        assertEquals("<T extends String, R extends List <Integer> >", extractor.extractFromExpression("private interface I<T extends String, R extends List<Integer>> extends I1, I2{}"));
        assertEquals("", extractor.extractFromExpression("public interface cls{}"));
        assertEquals("", extractor.extractFromExpression(" interface cls{}"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("abcdef wqqw$##", extractor.extractFromExpression("interface Inter abcdef wqqw$##{}"));
        assertEquals("", extractor.extractFromExpression("Inter<T> extends R{}"));
        assertEquals("<T> abc", extractor.extractFromExpression("interface R<T>abc extends K"));
        assertEquals("<r <extends String", extractor.extractFromExpression("interface Inter<r <extends String"));
        assertEquals("", extractor.extractFromExpression("interface inter{<T>{}"));
        assertEquals("", extractor.extractFromExpression("{interface I<R>{}"));
        assertEquals("", extractor.extractFromExpression("class cls<T>"));
        assertEquals("", extractor.extractFromExpression("<interface cls<T>"));
        assertEquals("<T>", extractor.extractFromExpression("< interface cls<T>"));
        assertEquals("<T> extends", extractor.extractFromExpression("interface I <T> extends {}"));
    }
}