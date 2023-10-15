package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.PropertyValueExtractor;

import static org.junit.jupiter.api.Assertions.*;

class PropertyValueExtractorTest {

    @Test
    void extractFromExpression() {
        PropertyValueExtractor extractor = new PropertyValueExtractor();

        assertEquals("452", extractor.extractFromExpression("\n \"abc\": 452  "));
        assertEquals("452 :eew", extractor.extractFromExpression("\n \"a:bc\": 452 :eew"));
        assertEquals("\"ab:c\":123", extractor.extractFromExpression("{:\"ab:c\":123"));
        assertEquals("}:\"ab:c\":123", extractor.extractFromExpression("{:}:\"ab:c\":123"));
        assertEquals("\"ab:c\":123", extractor.extractFromExpression("\"{:}\":\"ab:c\":123"));
        assertEquals("1", extractor.extractFromExpression("\"a:\\\"b:\\\":c\": 1"));
        assertEquals("c': 1", extractor.extractFromExpression("'ab:c': 1"));

        assertEquals("", extractor.extractFromExpression("abc"));
        assertEquals("abc", extractor.extractFromExpression(":abc"));
        assertEquals("", extractor.extractFromExpression("abc:"));
    }
}