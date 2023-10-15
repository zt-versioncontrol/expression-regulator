package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.JsonExtractor;

import static org.junit.jupiter.api.Assertions.*;

class JsonExtractorTest {

    @Test
    void extractFromExpression() {
        JsonExtractor extractor = new JsonExtractor();

        assertEquals("{\"a\":3, \"b\":4}", extractor.extractFromExpression("{\"a\":3, \"b\":4}"));
        assertEquals("{\"a\":3, \"b\":4}", extractor.extractFromExpression("  \n{\"a\":3, \"b\":4}\n\n"));
        assertEquals("{aaa", extractor.extractFromExpression("{aaa\n\n"));
        assertEquals("", extractor.extractFromExpression(""));
        assertEquals("", extractor.extractFromExpression("  "));
    }
}