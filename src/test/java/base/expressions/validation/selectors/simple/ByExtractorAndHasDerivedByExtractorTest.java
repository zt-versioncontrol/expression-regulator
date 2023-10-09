package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;


class ByExtractorAndHasDerivedByExtractorTest {
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
        BasicExpressionSelector selectorTrue = new ByExtractorAndHasDerivedByExtractor(Extractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorAndHasDerivedByExtractor(DervivedExtractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorAndHasDerivedByExtractor(Extractor.class, OriginalExtractor.class){};
        BasicExpressionSelector selectorNull = new ByExtractorAndHasDerivedByExtractor(null, null){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithMatcher() {
        StringMatcher dummyMatcher = string -> string.equals("dummy");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector selectorTrue = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, DervivedExtractor.class, dummyMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, DervivedExtractor.class, dummyMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, dummyMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse3 = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, DervivedExtractor.class, derivedMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse4 = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, DervivedExtractor.class, dummyMatcher, dummyMatcher){};
        BasicExpressionSelector selectorNull = new ByExtractorAndHasDerivedByExtractor.WithMatcher(
                null, null, dummyMatcher, derivedMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
        assertFalse(selectorFalse4.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }
}