package regulators.java.parser.validation.validators.wordValidators.qualifiers;

import base.expressions.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueQualifiersValidatorTest {

    UniqueQualifiersValidator validator;

    @BeforeEach
    void setUp() {
        validator = new UniqueQualifiersValidator();
    }

    @Test
    void repeatedKeyword() {
        Expression root1 = new Expression("root1", null);
        Expression e11 = new Expression("q1", null);
        Expression e12 = new Expression("q2", null);
        Expression e13 = new Expression("q1", null);
        root1.addDerivedExpression(e11);
        root1.addDerivedExpression(e12);
        root1.addDerivedExpression(e13);

        Expression root2 = new Expression("root2", null);
        Expression e21 = new Expression("q1", null);
        Expression e22 = new Expression("q2", null);
        root2.addDerivedExpression(e21);
        root2.addDerivedExpression(e22);




        assertTrue(validator.validate(e11));
        assertTrue(validator.validate(e12));
        assertFalse(validator.validate(e13));

        assertTrue(validator.validate(e21));
        assertTrue(validator.validate(e22));
    }

    @Test
    void mutuallyExclusiveKeywords() {
        Expression root1 = new Expression("root1", null);
        Expression e11 = new Expression("public", null);
        Expression e12 = new Expression("abstract", null);
        Expression e13 = new Expression("private", null);
        Expression e14 = new Expression("protected", null);
        root1.addDerivedExpression(e11);
        root1.addDerivedExpression(e12);
        root1.addDerivedExpression(e13);
        root1.addDerivedExpression(e14);

        Expression root2 = new Expression("root1", null);
        Expression e21 = new Expression("private", null);
        root2.addDerivedExpression(e21);

        assertTrue(validator.validate(e11));
        assertTrue(validator.validate(e12));
        assertFalse(validator.validate(e13));
        assertFalse(validator.validate(e14));

        assertTrue(validator.validate(e21));
    }

    @Test
    void nullCases() {
        Expression e11 = new Expression("q1", null);
        Expression e12 = new Expression("q1", null);

        Expression e21 = new Expression("private", null);
        Expression e22 = new Expression("public", null);
        Expression e23 = new Expression("protected", null);

        assertTrue(validator.validate(e11));
        //e11 and e12 are not derived from the same expression however this still return false
        //because originalExpression for e11 and e12 is null
        //there is no need to fix this because qualifiers are expected to be always derived from some expression
        assertFalse(validator.validate(e12));

        assertTrue(validator.validate(e21));
        assertFalse(validator.validate(e22));
        assertFalse(validator.validate(e23));
    }
}