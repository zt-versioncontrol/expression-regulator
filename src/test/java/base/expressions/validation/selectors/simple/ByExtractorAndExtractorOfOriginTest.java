package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorAndExtractorOfOriginTest {

    @Test
    void isSelected() {
        Expression origin = new Expression("123", DummyExtractors.OriginalExtractor.class);
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression expression2 = new Expression("123", DummyExtractors.Extractor.class);
        Expression expression3 = new Expression("123", DummyExtractors.OriginalExtractor.class);
        Expression expression4 = new Expression("123", DummyExtractors.Extractor.class);

        origin.addDerivedExpression(expression1);
        expression1.addDerivedExpression(expression2);
        origin.addDerivedExpression(expression3);

        ByExtractorAndExtractorOfOrigin selector1 =
                new ByExtractorAndExtractorOfOrigin(DummyExtractors.Extractor.class, DummyExtractors.OriginalExtractor.class) {};
        ByExtractorAndExtractorOfOrigin selector2 =
                new ByExtractorAndExtractorOfOrigin(null, null) {};

        assertTrue(selector1.isSelected(expression1)); //both extractors match
        assertFalse(selector1.isSelected(origin)); //both extractors do not match

        assertFalse(selector1.isSelected(expression2)); //only extractor matches
        assertFalse(selector1.isSelected(expression3)); //only original extractor matches

        assertFalse(selector1.isSelected(expression4)); //null origin

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}