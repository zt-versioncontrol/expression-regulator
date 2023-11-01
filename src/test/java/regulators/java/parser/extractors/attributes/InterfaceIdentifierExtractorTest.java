package regulators.java.parser.extractors.attributes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterfaceIdentifierExtractorTest {

    InterfaceIdentifierExtractor extractor = new InterfaceIdentifierExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("Inter", extractor.extractFromExpression("interface Inter{}"));
        assertEquals("inter", extractor.extractFromExpression("private static interface\ninter<T> extends I2{}"));
        assertEquals("I", extractor.extractFromExpression("public interface I<t extends String> extends R{}"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("<T>", extractor.extractFromExpression("interface <T><G>{}"));
        assertEquals("<", extractor.extractFromExpression("interface < T ><G>{}"));
        assertEquals("", extractor.extractFromExpression("class cls{}"));
        assertEquals("", extractor.extractFromExpression("xxx"));
        assertEquals("U", extractor.extractFromExpression("interface U"));
        assertEquals("", extractor.extractFromExpression("interface {U {}"));
        assertEquals("", extractor.extractFromExpression("{interface U {}"));
        assertEquals("", extractor.extractFromExpression("interfaceU {}"));
        assertEquals("interface", extractor.extractFromExpression("interface interface<T> {}"));
    }
}