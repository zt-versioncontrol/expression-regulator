package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HasDerivedByExtractorTest {

    @Test
    void isSelected() {
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived1 = new Expression("!23", DummyExtractors.DervivedExtractor.class);
        Expression derived2 = new Expression("!23", DummyExtractors.OriginalExtractor.class);

        Expression expression2 = new Expression("123", DummyExtractors.Extractor.class);

        Expression expression3 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived3 = new Expression("!23", DummyExtractors.OriginalExtractor.class);
        Expression derived4 = new Expression("!23", DummyExtractors.OriginalExtractor.class);

        expression1.addDerivedExpression(derived1);
        expression1.addDerivedExpression(derived2);

        expression3.addDerivedExpression(derived3);
        expression3.addDerivedExpression(derived4);

        HasDerivedByExtractor selector1 = new HasDerivedByExtractor(DummyExtractors.DervivedExtractor.class) {};
        HasDerivedByExtractor selector2 = new HasDerivedByExtractor(null) {};

        assertTrue(selector1.isSelected(expression1)); //one derived expression match
        assertFalse(selector1.isSelected(expression2)); //no derived expressions
        assertFalse(selector1.isSelected(expression3)); //no derived expression matches

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}