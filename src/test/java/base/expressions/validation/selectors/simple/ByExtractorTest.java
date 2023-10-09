package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class ByExtractorTest {
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
        BasicExpressionSelector byExtractorTrue = new ByExtractor(Extractor.class) {};
        BasicExpressionSelector byExtractorFalse = new ByExtractor(OriginalExtractor.class) {};
        BasicExpressionSelector byExtractorNull = new ByExtractor(null) {};

        assertTrue(byExtractorTrue.isSelected(dummyExpression));
        assertFalse(byExtractorFalse.isSelected(dummyExpression));
        assertFalse(byExtractorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithStringMatcher() {
        StringMatcher dummyMatcher = string -> string.equals("dummy");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector withMatcherTrue = new ByExtractor.WithMatcher(Extractor.class, dummyMatcher) {};
        BasicExpressionSelector withMatcherFalse1 = new ByExtractor.WithMatcher(DervivedExtractor.class, dummyMatcher) {};
        BasicExpressionSelector withMatcherFalse2 = new ByExtractor.WithMatcher(Extractor.class, derivedMatcher) {};
        BasicExpressionSelector withMatcherNull = new ByExtractor.WithMatcher(null, dummyMatcher) {};

        assertTrue(withMatcherTrue.isSelected(dummyExpression));
        assertFalse(withMatcherFalse1.isSelected(dummyExpression));
        assertFalse(withMatcherFalse2.isSelected(dummyExpression));
        assertFalse(withMatcherNull.isSelected(dummyExpression));

    }
}