package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorOfOriginAndHasDerivedByExtractorTest {

    @Test
    void isSelected() {
        Expression origin = new Expression("123", DummyExtractors.OriginalExtractor.class);
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived1 = new Expression("!23", DummyExtractors.DervivedExtractor.class);
        Expression derived2 = new Expression("!23", DummyExtractors.Extractor.class);
        Expression derived3 = new Expression("!23", DummyExtractors.DervivedExtractor.class);

        Expression expression2 = new Expression("123", DummyExtractors.Extractor.class);

        Expression expression3 = new Expression("123", DummyExtractors.Extractor.class);

        Expression derived4 = new Expression("123", DummyExtractors.DervivedExtractor.class);


        origin.addDerivedExpression(expression1);
        expression1.addDerivedExpression(derived1);
        expression1.addDerivedExpression(derived2);

        origin.addDerivedExpression(expression2);

        expression1.addDerivedExpression(expression3);
        expression3.addDerivedExpression(derived3);

        origin.addDerivedExpression(derived4);

        ByExtractorOfOriginAndHasDerivedByExtractor selector1 =
                new ByExtractorOfOriginAndHasDerivedByExtractor(DummyExtractors.OriginalExtractor.class, DummyExtractors.DervivedExtractor.class) {};
        ByExtractorOfOriginAndHasDerivedByExtractor selector2 =
                new ByExtractorOfOriginAndHasDerivedByExtractor(null, null) {};

        assertTrue(selector1.isSelected(expression1)); //all match
        assertFalse(selector1.isSelected(derived1)); //none match

        assertFalse(selector1.isSelected(expression2)); //extractor of derived does not match
        assertFalse(selector1.isSelected(expression3)); //extractor of origin does not match

        assertFalse(selector1.isSelected(origin)); //origin is null

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}