package regulators.java.parser.validation.validators.structureValidators.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaticBlockValidatorTest {

    StaticBlockValidator validator = new StaticBlockValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("static {...}", null);
        Expression e2 = new Expression("static    \n\n\t\t  {\n}", null);
        Expression e3 = new Expression("static{...}", null);

        Expression e4 = new Expression(" static{}", null);
        Expression e5 = new Expression(" static {}", null);
        Expression e6 = new Expression("static{};", null);
        Expression e7 = new Expression("static{} ", null);
        Expression e8 = new Expression("static {", null);
        Expression e9 = new Expression("{}", null);
        Expression e10 = new Expression("", null);
        Expression e11 = new Expression("static({}", null);

        assertTrue(validator.validate(e1));
        assertTrue(validator.validate(e2));
        assertTrue(validator.validate(e3));

        assertFalse(validator.validate(e4));
        assertFalse(validator.validate(e5));
        assertFalse(validator.validate(e6));
        assertFalse(validator.validate(e7));
        assertFalse(validator.validate(e8));
        assertFalse(validator.validate(e9));
        assertFalse(validator.validate(e10));
        assertFalse(validator.validate(e11));
    }
}