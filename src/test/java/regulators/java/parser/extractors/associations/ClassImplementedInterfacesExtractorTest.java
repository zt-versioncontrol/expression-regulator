package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassImplementedInterfacesExtractorTest {

    ClassImplementedInterfacesExtractor extractor = new ClassImplementedInterfacesExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("implements I", extractor.extractFromExpression("class cls\n implements\tI{}"));
        assertEquals("implements I1, I2", extractor.extractFromExpression("private class   cls<T> implements\nI1,\nI2{}"));
        assertEquals("implements I1", extractor.extractFromExpression("private static class cls<T,R> extends S implements I1{}"));
        assertEquals("", extractor.extractFromExpression("class cls{}"));
        assertEquals("", extractor.extractFromExpression("class cls<T> extends SS{}"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("implements I", extractor.extractFromExpression("class implements I{}"));
        assertEquals("", extractor.extractFromExpression("implements I{}"));
        assertEquals("", extractor.extractFromExpression("class cls < implements > TT{}"));
        assertEquals("implements TT", extractor.extractFromExpression("class cls < implements >implements TT{}"));
        assertEquals("", extractor.extractFromExpression("class cls implements {T"));
        assertEquals("", extractor.extractFromExpression("class cls {implements T"));
        assertEquals("", extractor.extractFromExpression("class clsimplements I"));
    }
}