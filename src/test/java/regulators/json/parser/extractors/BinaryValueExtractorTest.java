package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.BinaryValueExtractor;

import static org.junit.jupiter.api.Assertions.*;

class BinaryValueExtractorTest {

    @Test
    void extractFromExpression() {
        BinaryValueExtractor extractor = new BinaryValueExtractor();

        assertEquals("true",extractor.extractFromExpression("true"));
        assertEquals("false", extractor.extractFromExpression("false"));
        assertEquals("true", extractor.extractFromExpression("TrUe"));
        assertEquals("false", extractor.extractFromExpression("FalsE"));

        assertFalse(isBinary(extractor.extractFromExpression(" true")));
        assertFalse(isBinary(extractor.extractFromExpression("false\n")));
        assertFalse(isBinary(extractor.extractFromExpression("")));
        assertFalse(isBinary(extractor.extractFromExpression("  \n\t ")));
        assertFalse(isBinary(extractor.extractFromExpression("abc")));


    }

    boolean isBinary(String s){
       return s.equals("true") || s.equals("false");
    }
}