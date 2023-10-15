package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.PropertyNameExtractor;

import static org.junit.jupiter.api.Assertions.*;

class PropertyNameExtractorTest {

    @Test
    void extractFromExpression() {
        PropertyNameExtractor extractor = new PropertyNameExtractor();

        assertEquals("\"abc\"", extractor.extractFromExpression("\n \"abc\": 452  "));
        assertEquals("\"a:bc\"", extractor.extractFromExpression("\n \"a:bc\": 452 :eew"));
        assertEquals("{", extractor.extractFromExpression("{:\"ab:c\":123"));
        assertEquals("{", extractor.extractFromExpression("{:}:\"ab:c\":123"));
        assertEquals("\"{:}\"", extractor.extractFromExpression("\"{:}\":\"ab:c\":123"));
        assertEquals("\"a:\\\"b:\\\":c\"", extractor.extractFromExpression("\"a:\\\"b:\\\":c\": 1"));
        assertEquals("'ab", extractor.extractFromExpression("'ab:c': 1"));

        assertEquals("", extractor.extractFromExpression("abc"));
        assertEquals("", extractor.extractFromExpression(":abc"));
        assertEquals("abc", extractor.extractFromExpression("abc:"));

    }
}