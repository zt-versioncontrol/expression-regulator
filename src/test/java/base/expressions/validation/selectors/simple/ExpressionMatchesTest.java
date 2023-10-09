package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionMatchesTest {
    Expression dummyExpression;

    @BeforeEach
    void setUp() {
        Expression origin = new Expression("origin", DummyExtractors.OriginalExtractor.class);
        dummyExpression = new Expression("dummy", DummyExtractors.Extractor.class);
        Expression derived1 = new Expression("derived", DummyExtractors.DervivedExtractor.class);
        Expression derived2 = new Expression("derived", DummyExtractors.Extractor.class);

        origin.addDerivedExpression(dummyExpression);
        dummyExpression.addDerivedExpression(derived1);
        dummyExpression.addDerivedExpression(derived2);
    }

    @Test
    void isSelected() {
        StringMatcher dummyMatcher = string -> string.equals("dummy");
        StringMatcher originMatcher = string -> string.equals("origin");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector selectorTrue = new  ExpressionMatches(dummyMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse1 = new  ExpressionMatches(derivedMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse2 = new  ExpressionMatches(dummyMatcher, derivedMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse3 = new  ExpressionMatches(dummyMatcher, originMatcher, originMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
    }
}