package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonNumberValidatorTest {

    @Test
    void validate() {
        JsonNumberValidator validator = new JsonNumberValidator();

        assertTrue(validator.validate(new Expression("123", null)));
        assertTrue(validator.validate(new Expression("123.1", null)));
        assertTrue(validator.validate(new Expression("03.1", null)));
        assertTrue(validator.validate(new Expression("0.1", null)));

        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression("abc", null)));
        assertFalse(validator.validate(new Expression("{123}", null)));
        assertFalse(validator.validate(new Expression("\"123\"", null)));
        assertFalse(validator.validate(new Expression("[123]", null)));
    }
}