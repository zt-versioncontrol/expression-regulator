package regulators.java.parser.validation.validators.structureValidators.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericsValidatorTest {

    GenericsValidator validator = new GenericsValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("<...>", null);

        Expression e2 = new Expression("<...", null);
        Expression e3 = new Expression("...", null);
        Expression e4 = new Expression("", null);
        Expression e5 = new Expression("<>", null);

        assertTrue(validator.validate(e1));

        assertFalse(validator.validate(e2));
        assertFalse(validator.validate(e3));
        assertFalse(validator.validate(e4));
        assertFalse(validator.validate(e5));
    }
}