package base.expressions.validation.selectors.simple;

import base.components.expression.validation.BasicExpressionSelector;
import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class ByExtractorExtractorOfOriginAndHasDerivedByExtractorTest {
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
        BasicExpressionSelector selectorTrue = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(
                Extractor.class, OriginalExtractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(
                DervivedExtractor.class, OriginalExtractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(
                Extractor.class, Extractor.class, DervivedExtractor.class){};
        BasicExpressionSelector selectorFalse3 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(
                Extractor.class, OriginalExtractor.class, OriginalExtractor.class){};
        BasicExpressionSelector selectorNull = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(null, null, null){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));
    }

    @Test
    void isSelectedWithMatcher() {
        StringMatcher dummyMatcher = string -> string.equals("dummy");
        StringMatcher originMatcher = string -> string.equals("origin");
        StringMatcher derivedMatcher = string -> string.equals("derived");

        BasicExpressionSelector selectorTrue = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, DervivedExtractor.class,
                dummyMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse1 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                OriginalExtractor.class, OriginalExtractor.class, DervivedExtractor.class,
                dummyMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse2 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, Extractor.class, DervivedExtractor.class,
                dummyMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse3 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, OriginalExtractor.class,
                dummyMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse4 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, DervivedExtractor.class,
                derivedMatcher, originMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse5 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, DervivedExtractor.class,
                dummyMatcher, derivedMatcher, derivedMatcher){};
        BasicExpressionSelector selectorFalse6 = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                Extractor.class, OriginalExtractor.class, DervivedExtractor.class,
                dummyMatcher, originMatcher, originMatcher){};
        BasicExpressionSelector selectorNull = new ByExtractorExtractorOfOriginAndHasDerivedByExtractor.WithMatcher(
                null, null, null,
                dummyMatcher, originMatcher, derivedMatcher){};

        assertTrue(selectorTrue.isSelected(dummyExpression));
        assertFalse(selectorFalse1.isSelected(dummyExpression));
        assertFalse(selectorFalse2.isSelected(dummyExpression));
        assertFalse(selectorFalse3.isSelected(dummyExpression));
        assertFalse(selectorFalse4.isSelected(dummyExpression));
        assertFalse(selectorFalse5.isSelected(dummyExpression));
        assertFalse(selectorFalse6.isSelected(dummyExpression));
        assertFalse(selectorNull.isSelected(dummyExpression));

    }
}