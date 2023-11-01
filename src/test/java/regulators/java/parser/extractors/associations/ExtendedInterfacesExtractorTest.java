package regulators.java.parser.extractors.associations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedInterfacesExtractorTest {
    ExtendedInterfacesExtractor extractor = new ExtendedInterfacesExtractor();

    @Test
    void extractFromExpression() {
        assertEquals("extends I1, I2", extractor.extractFromExpression("interface I \nextends   I1, \nI2{{abc}}"));
        assertEquals("extends I4", extractor.extractFromExpression("interface I<T, R extend U> extends I4{}"));
        assertEquals("", extractor.extractFromExpression("interface I<T, R extend U>{}"));
        assertEquals("", extractor.extractFromExpression("interface I{}"));

        //works for any expression but intended for interfaces only
        assertEquals("extends R", extractor.extractFromExpression("class cls extends R{}"));
        assertEquals("extends R", extractor.extractFromExpression("xxx extends R"));
        assertEquals("extends R}", extractor.extractFromExpression("xxx <extend T> extends R}"));


        //invalid expressions
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("{ interface i extends k"));
        assertEquals("", extractor.extractFromExpression("interface I implements R{extends l"));
        assertEquals("", extractor.extractFromExpression("interface I extends{T"));
        assertEquals("", extractor.extractFromExpression("interface I extends {T"));
        assertEquals("", extractor.extractFromExpression("interface Iextends T"));
        assertEquals("extends l", extractor.extractFromExpression(" extends interface extends l"));
        assertEquals("extends interface extends l", extractor.extractFromExpression("public extends interface extends l"));

    }
}