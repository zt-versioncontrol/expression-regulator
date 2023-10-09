package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class HasDerivedByExtractorTest {
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
       BasicExpressionSelector selectorTrue = new HasDerivedByExtractor(DervivedExtractor.class){};
       BasicExpressionSelector selectorFalse = new HasDerivedByExtractor(OriginalExtractor.class){};
       BasicExpressionSelector selectorNull = new HasDerivedByExtractor(null){};

       assertTrue(selectorTrue.isSelected(dummyExpression));
       assertFalse(selectorFalse.isSelected(dummyExpression));
       assertFalse(selectorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithMatcher() {
        StringMatcher dummyMatcher = string -> string.equals("dummy");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector selectorTrue = new HasDerivedByExtractor.WithMatcher(DervivedExtractor.class, derivedMatcher){};
        BasicExpressionSelector selectorFalse1 = new HasDerivedByExtractor.WithMatcher(OriginalExtractor.class, derivedMatcher){};
        BasicExpressionSelector selectorFalse2 = new HasDerivedByExtractor.WithMatcher(DervivedExtractor.class, dummyMatcher){};
        BasicExpressionSelector selectorNull = new HasDerivedByExtractor.WithMatcher(null, derivedMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }
}