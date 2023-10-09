package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class ByExtractorOfOriginTest {
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
        BasicExpressionSelector byExtractorOfOriginTrue = new ByExtractorOfOrigin(OriginalExtractor.class) {};
        BasicExpressionSelector byExtractorOfOriginFalse = new ByExtractorOfOrigin(Extractor.class) {};
        BasicExpressionSelector byExtractorOfOriginNull = new ByExtractorOfOrigin(null) {};

        assertTrue(byExtractorOfOriginTrue.isSelected(dummyExpression));
        assertFalse(byExtractorOfOriginFalse.isSelected(dummyExpression));
        assertFalse(byExtractorOfOriginNull.isSelected(dummyExpression));

    }

    @Test
    void isSelectedWithMatcher() {
        StringMatcher originMatcher = string -> string.equals("origin");
        StringMatcher dummyMatcher = string -> string.equals("dummy");

        BasicExpressionSelector withMatcherTrue = new ByExtractorOfOrigin.WithMatcher(OriginalExtractor.class, originMatcher){};
        BasicExpressionSelector withMatcherFalse1 = new ByExtractorOfOrigin.WithMatcher(Extractor.class, originMatcher){};
        BasicExpressionSelector withMatcherFalse2 = new ByExtractorOfOrigin.WithMatcher(OriginalExtractor.class, dummyMatcher){};
        BasicExpressionSelector withMatcherNull = new ByExtractorOfOrigin.WithMatcher(null, originMatcher){};

        assertTrue(withMatcherTrue.isSelected(dummyExpression));
        assertFalse(withMatcherFalse1.isSelected(dummyExpression));
        assertFalse(withMatcherFalse2.isSelected(dummyExpression));
        assertFalse(withMatcherNull.isSelected(dummyExpression));
    }
}