package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorTest {

    @Test
    void isSelected() {
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression expression2 = new Expression("123", DummyExtractors.OriginalExtractor.class);

        ByExtractor byExtractor1 = new ByExtractor(DummyExtractors.Extractor.class) {};
        ByExtractor byExtractor2 = new ByExtractor(DummyExtractors.OriginalExtractor.class) {};
        ByExtractor byExtractor3 = new ByExtractor(null) {};

        assertTrue(byExtractor1.isSelected(expression1));
        assertFalse(byExtractor2.isSelected(expression1));

        assertFalse(byExtractor1.isSelected(expression2));
        assertTrue(byExtractor2.isSelected(expression2));

        assertThrowsExactly(NullPointerException.class, () -> byExtractor3.isSelected(expression1));
    }
}