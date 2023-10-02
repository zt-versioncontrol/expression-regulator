package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorExtractorOfOriginAndHasDerivedByExtractorTest {

    @Test
    void isSelected() {
        Expression origin = new Expression("123", DummyExtractors.OriginalExtractor.class);
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived1 = new Expression("123", DummyExtractors.DervivedExtractor.class);
        Expression derived2 = new Expression("123", DummyExtractors.Extractor.class);

        Expression expression2 = new Expression("123", DummyExtractors.Extractor.class);

        Expression expression3 = new Expression("123", DummyExtractors.DervivedExtractor.class);
        Expression derived3 = new Expression("123", DummyExtractors.DervivedExtractor.class);

        Expression expression4 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived4 = new Expression("123", DummyExtractors.DervivedExtractor.class);

        Expression expression5 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived5 = new Expression("123", DummyExtractors.DervivedExtractor.class);

        origin.addDerivedExpression(expression1);
        expression1.addDerivedExpression(derived1);
        expression1.addDerivedExpression(derived2);

        origin.addDerivedExpression(expression2);

        origin.addDerivedExpression(expression3);
        expression3.addDerivedExpression(derived3);

        expression3.addDerivedExpression(expression4);
        expression4.addDerivedExpression(derived4);

        expression5.addDerivedExpression(derived5);

        ByExtractorExtractorOfOriginAndHasDerivedByExtractor selector1 =
                new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(
                        DummyExtractors.Extractor.class,
                        DummyExtractors.OriginalExtractor.class,
                        DummyExtractors.DervivedExtractor.class
                ) {};
       ByExtractorExtractorOfOriginAndHasDerivedByExtractor selector2 =
                new ByExtractorExtractorOfOriginAndHasDerivedByExtractor(null, null, null) {};

        assertTrue(selector1.isSelected(expression1));
        assertFalse(selector1.isSelected(origin)); //all extractors do not match

        assertFalse(selector1.isSelected(expression2)); //derived expression does not match
        assertFalse(selector1.isSelected(expression3)); //extractor does not match
        assertFalse(selector1.isSelected(expression4)); //extractor of origin does not match

        assertFalse(selector1.isSelected(expression5)); //origin is null

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}