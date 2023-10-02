package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class ByExtractorAndHasDerivedByExtractorTest {

    @Test
    void isSelected() {
        Expression expression1 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived1 = new Expression("123", DummyExtractors.DervivedExtractor.class);
        Expression derived2 = new Expression("123", DummyExtractors.Extractor.class);
        Expression derived3 = new Expression("123", DummyExtractors.DervivedExtractor.class);

        Expression expression2 = new Expression("123", DummyExtractors.OriginalExtractor.class);

        expression1.addDerivedExpression(derived1);
        expression1.addDerivedExpression(derived2);

        expression2.addDerivedExpression(derived3);

        ByExtractorAndHasDerivedByExtractor selector1 =
                new ByExtractorAndHasDerivedByExtractor(DummyExtractors.Extractor.class, DummyExtractors.DervivedExtractor.class) {};
        ByExtractorAndHasDerivedByExtractor selector2 =
                new ByExtractorAndHasDerivedByExtractor(null, null) {};

        assertTrue(selector1.isSelected(expression1)); //both extractors match
        assertFalse(selector1.isSelected(derived1)); //both extractors do not match
        assertFalse(selector1.isSelected(derived2)); //derived extractor does not match
        assertFalse(selector1.isSelected(expression2)); //only derivedExtractor matches

        assertThrowsExactly(NullPointerException.class, () -> selector2.isSelected(expression1));
    }
}