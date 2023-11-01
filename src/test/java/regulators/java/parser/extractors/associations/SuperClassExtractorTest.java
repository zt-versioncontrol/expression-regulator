package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperClassExtractorTest {

    SuperClassExtractor extractor = new SuperClassExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("", extractor.extractFromExpression("class cls{}"));
        assertEquals("extends String", extractor.extractFromExpression("class cls extends String{}"));
        assertEquals("extends List <String>", extractor.extractFromExpression("class cls      \n\textends\nList<String>\n\timplements Comparable{{}}"));
        assertEquals("extends List <String>", extractor.extractFromExpression("class cls extends List<String>implements Comparable{{}}"));


        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("extends String", extractor.extractFromExpression("class cls extends String"));
        assertEquals("extends String", extractor.extractFromExpression("class extends String"));
        assertEquals("", extractor.extractFromExpression("extends String"));
        assertEquals("extends String", extractor.extractFromExpression("extends extends String"));
        assertEquals("extends String", extractor.extractFromExpression("x extends String"));
        assertEquals("", extractor.extractFromExpression("classextends String"));
        assertEquals("extends implements", extractor.extractFromExpression("class extends implements"));
        assertEquals("extends implementsComparable", extractor.extractFromExpression("class extends implementsComparable"));
        assertEquals("", extractor.extractFromExpression("extends"));
        assertEquals("extends A, B,C", extractor.extractFromExpression("class cls extends A,   B,C"));
    }
}