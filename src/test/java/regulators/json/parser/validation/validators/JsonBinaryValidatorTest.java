package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonBinaryValidatorTest {

    @Test
    void validate() {
        JsonBinaryValidator validator = new JsonBinaryValidator();

        assertTrue(validator.validate(new Expression("true", null)));
        assertTrue(validator.validate(new Expression("false", null)));

        assertFalse(validator.validate(new Expression("True", null)));
        assertFalse(validator.validate(new Expression("TRUE", null)));
        assertFalse(validator.validate(new Expression("true ", null)));
        assertFalse(validator.validate(new Expression(" true ", null)));
        assertFalse(validator.validate(new Expression("\ntrue", null)));
        assertFalse(validator.validate(new Expression("true\n", null)));
        assertFalse(validator.validate(new Expression("False", null)));
        assertFalse(validator.validate(new Expression("FALSE", null)));
        assertFalse(validator.validate(new Expression("false ", null)));
        assertFalse(validator.validate(new Expression(" false ", null)));
        assertFalse(validator.validate(new Expression("\nfalse", null)));
        assertFalse(validator.validate(new Expression("false\n", null)));

    }
}