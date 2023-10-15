package regulators.json.parser.extractors;

import org.junit.jupiter.api.Test;
import regulators.json.parser.extractors.NumberValueExtractor;

import static org.junit.jupiter.api.Assertions.*;

class NumberValueExtractorTest {

    @Test
    void extractFromExpression() {

        NumberValueExtractor extractor = new NumberValueExtractor();

        assertEquals("123", extractor.extractFromExpression("123"));
        assertThrowsExactly(NumberFormatException.class, () -> Double.parseDouble(extractor.extractFromExpression("abc")));
        assertThrowsExactly(NumberFormatException.class, () -> Double.parseDouble(extractor.extractFromExpression("1ab")));
        assertThrowsExactly(NumberFormatException.class, () -> Double.parseDouble(extractor.extractFromExpression("")));
        assertThrowsExactly(NumberFormatException.class, () -> Double.parseDouble(extractor.extractFromExpression(" \n")));

    }
}