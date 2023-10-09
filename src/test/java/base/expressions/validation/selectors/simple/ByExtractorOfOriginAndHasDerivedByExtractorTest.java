package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class ByExtractorOfOriginAndHasDerivedByExtractorTest {

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
        BasicExpressionSelector selectorTrue = new ByExtractorOfOriginAndHasDerivedByExtractor(OriginalExtractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorOfOriginAndHasDerivedByExtractor(Extractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorOfOriginAndHasDerivedByExtractor(OriginalExtractor.class, OriginalExtractor.class){};
        BasicExpressionSelector selectorNull = new ByExtractorOfOriginAndHasDerivedByExtractor(null, null){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithMatchers() {
        StringMatcher originMatcher = string -> string.equals("origin");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector selectorTrue = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, DervivedExtractor.class, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, DervivedExtractor.class, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFlase2 = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, OriginalExtractor.class, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse3 = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, DervivedExtractor.class, derivedMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFlase4 = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, DervivedExtractor.class, originMatcher, originMatcher){};
        BasicExpressionSelector selectorNull = new ByExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                null, null, originMatcher, derivedMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFlase2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
        assertFalse(selectorFlase4.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }
}