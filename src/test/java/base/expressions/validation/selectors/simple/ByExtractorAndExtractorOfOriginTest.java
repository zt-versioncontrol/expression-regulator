package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class ByExtractorAndExtractorOfOriginTest {
    Expression dummyExpression;

    @BeforeEach
    void setUp() {
        Expression origin = new Expression("origin", OriginalExtractor.class);
        dummyExpression = new Expression("dummy", Extractor.class);
        Expression derived1 = new Expression("derived", DervivedExtractor.class);
        Expression derived2 = new Expression("derived", Extractor.class);

        origin.addDerivedExpression(dummyExpression);
        dummyExpression.addDerivedExpression(derived1);
        dummyExpression.addDerivedExpression(derived2);
    }

    @Test
    void isSelected() {
        BasicExpressionSelector selectorTrue =new ByExtractorAndExtractorOfOrigin(Extractor.class, OriginalExtractor.class){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorAndExtractorOfOrigin(OriginalExtractor.class, OriginalExtractor.class){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorAndExtractorOfOrigin(Extractor.class, Extractor.class){};
        BasicExpressionSelector selectorNull = new ByExtractorAndExtractorOfOrigin(null, null){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithMatcher() {
        StringMatcher originMatcher = string -> string.equals("origin");
        StringMatcher dummyMatcher = string -> string.equals("dummy");

        BasicExpressionSelector selectorTrue = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                Extractor.class, OriginalExtractor.class, dummyMatcher, originMatcher){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                OriginalExtractor.class, OriginalExtractor.class, dummyMatcher, originMatcher){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                Extractor.class, Extractor.class, dummyMatcher, originMatcher){};
        BasicExpressionSelector selectorFalse3 = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                Extractor.class, OriginalExtractor.class, originMatcher, originMatcher){};
        BasicExpressionSelector selectorFlase4 = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                Extractor.class, OriginalExtractor.class, dummyMatcher, dummyMatcher){};
        BasicExpressionSelector selectorNull = new ByExtractorAndExtractorOfOrigin.WithMatcher(
                null, null, dummyMatcher, originMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
        assertFalse(selectorFlase4.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }

}