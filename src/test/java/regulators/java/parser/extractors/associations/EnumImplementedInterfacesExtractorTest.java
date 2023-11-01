package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnumImplementedInterfacesExtractorTest {

    EnumImplementedInterfacesExtractor extractor = new EnumImplementedInterfacesExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("", extractor.extractFromExpression("enum En{}"));
        assertEquals("implements I1", extractor.extractFromExpression("public enum   En \nimplements\nI1{A, B,C; public String toString(){}}"));
        assertEquals("implements Interface1 <String>, Interface2,I3", extractor.extractFromExpression("static enum En implements Interface1        <String>,\nInterface2,I3 {}"));


        //invalid expressions but have enough structure to extract from
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("        \n"));
        assertEquals("", extractor.extractFromExpression("enum"));
        assertEquals("implements I, J", extractor.extractFromExpression("enum En implements I, J"));
        assertEquals("", extractor.extractFromExpression("enum En{ implements I, J"));
        assertEquals("implements (", extractor.extractFromExpression("enum En implements ({) I, J"));
        assertEquals("extends S implements I", extractor.extractFromExpression("enum En extends S implements I{}"));
        assertEquals("s", extractor.extractFromExpression("enum Enimplements s{}"));



        assertEquals("", extractor.extractFromExpression(""));

        //invalid expressions
        assertEquals("abcd efg %$@", extractor.extractFromExpression("enum En abcd efg\n\n %$@"));
        assertEquals("extends K", extractor.extractFromExpression("private enum En extends K"));
        assertEquals("())", extractor.extractFromExpression("private enum En ())"));
        assertEquals("())", extractor.extractFromExpression("private enum En ())"));
        assertEquals("", extractor.extractFromExpression("class clas<T> implements I{}"));
        assertEquals("", extractor.extractFromExpression("interface clas<T> extends I{}"));

    }
}