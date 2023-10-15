package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.StringValueExtractor;

import static org.junit.jupiter.api.Assertions.*;

class StringValueExtractorTest {

    @Test
    void extractFromExpression() {
        StringValueExtractor extractor = new StringValueExtractor();

        assertEquals("abc", extractor.extractFromExpression("\"abc\""));
        assertEquals("a\\\"bc", extractor.extractFromExpression("\"a\\\"bc\""));

        //invalid inputs
        assertEquals("b", extractor.extractFromExpression("abc"));
        assertEquals("\"abc\"", extractor.extractFromExpression(" \"abc\" "));

    }
}