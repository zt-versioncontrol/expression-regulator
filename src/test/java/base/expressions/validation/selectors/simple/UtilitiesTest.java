package base.expressions.validation.selectors.simple;

import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static base.expressions.validation.selectors.simple.DummyExtractors.*;

class UtilitiesTest {

    Expression dummyExpression;
    StringMatcher dummyMatcher;
    StringMatcher originMatcher;
    StringMatcher derivedMatcher;



    @BeforeEach
    void setUp() {
        Expression origin = new Expression("origin", OriginalExtractor.class);
        dummyExpression = new Expression("dummy", Extractor.class);
        Expression derived1 = new Expression("derived", DervivedExtractor.class);
        Expression derived2 = new Expression("derived", Extractor.class);

        origin.addDerivedExpression(dummyExpression);
        dummyExpression.addDerivedExpression(derived1);
        dummyExpression.addDerivedExpression(derived2);

        dummyMatcher = string -> string.equals("dummy");
        originMatcher = string -> string.equals("origin");
        derivedMatcher = string -> string.equals("derived");
    }

    @Test
    void extractorMatches() {
        assertTrue(Utilities.extractorMatches(dummyExpression, Extractor.class));
        assertFalse(Utilities.extractorMatches(dummyExpression, OriginalExtractor.class));
        assertFalse(Utilities.extractorMatches(dummyExpression, null));
    }

    @Test
    void extractorOfOriginMatches() {
        assertTrue(Utilities.extractorOfOriginMatches(dummyExpression, OriginalExtractor.class));
        assertFalse(Utilities.extractorOfOriginMatches(dummyExpression, Extractor.class));
        assertFalse(Utilities.extractorOfOriginMatches(dummyExpression, null));
    }

    @Test
    void extractorOfDerivedPresent() {
        assertTrue(Utilities.extractorOfDerivedPresent(dummyExpression, DervivedExtractor.class));
        assertTrue(Utilities.extractorOfDerivedPresent(dummyExpression, Extractor.class));
        assertFalse(Utilities.extractorOfDerivedPresent(dummyExpression, null));
        assertFalse(Utilities.extractorOfDerivedPresent(dummyExpression, OriginalExtractor.class));
    }

    @Test
    void expressionMatches() {
        assertTrue(Utilities.expressionMatches(dummyExpression, dummyMatcher));
        assertFalse(Utilities.expressionMatches(dummyExpression, originMatcher));
        assertFalse(Utilities.expressionMatches(dummyExpression, derivedMatcher));
    }

    @Test
    void originalExpressionMatches() {
        assertTrue(Utilities.originalExpressionMatches(dummyExpression, originMatcher));
        assertFalse(Utilities.originalExpressionMatches(dummyExpression, dummyMatcher));
        assertFalse(Utilities.originalExpressionMatches(dummyExpression, derivedMatcher));
    }

    @Test
    void anyDerivedExpressionMatches() {
        assertTrue(Utilities.anyDerivedExpressionMatches(dummyExpression, derivedMatcher));
        assertFalse(Utilities.anyDerivedExpressionMatches(dummyExpression, dummyMatcher));
        assertFalse(Utilities.anyDerivedExpressionMatches(dummyExpression, originMatcher));
    }

    @Test
    void extractorOfDerivedPresentAndItsExpressionMatches() {
        assertTrue(Utilities.extractorOfDerivedPresentAndItsExpressionMatches(dummyExpression, DervivedExtractor.class, derivedMatcher));
        assertFalse(Utilities.extractorOfDerivedPresentAndItsExpressionMatches(dummyExpression, DervivedExtractor.class, dummyMatcher));
        assertFalse(Utilities.extractorOfDerivedPresentAndItsExpressionMatches(dummyExpression, OriginalExtractor.class, derivedMatcher));
    }
}