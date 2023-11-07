package regulators.java.parser.validation.validators.wordValidators.qualifiers;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnePublicTypeInFileValidatorTest {

    OnePublicTypeInFileValidator validator = new OnePublicTypeInFileValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("public", null);
        Expression e2 = new Expression("private", null);
        Expression e3 = new Expression("protected", null);
        Expression e4 = new Expression("public", null);
        Expression e5 = new Expression("protected", null);
        Expression e6 = new Expression("q1", null);
        Expression e7 = new Expression("public", null);
        Expression e8 = new Expression(" public", null);

        assertTrue(validator.validate(e1));
        assertTrue(validator.validate(e2));
        assertTrue(validator.validate(e3));
        assertFalse(validator.validate(e4));
        assertTrue(validator.validate(e5));
        assertTrue(validator.validate(e6));
        assertFalse(validator.validate(e7));
        assertTrue(validator.validate(e8));
    }
}