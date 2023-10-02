package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorOfOriginTest {

    @Test
    void isSelected() {
        Expression origin = new Expression("123", DummyExtractors.OriginalExtractor.class);
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);

        Expression expression2 = new Expression("123", DummyExtractors.Extractor.class);

        origin.addDerivedExpression(expression1);

        ByExtractorOfOrigin selector1 = new ByExtractorOfOrigin(DummyExtractors.OriginalExtractor.class) {};
        ByExtractorOfOrigin selector2 = new ByExtractorOfOrigin(null) {};

        assertTrue(selector1.isSelected(expression1)); //matches
        assertFalse(selector1.isSelected(origin)); //does not match

        assertFalse(selector1.isSelected(expression2)); //null

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}