package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonObjectValidatorTest {

    @Test
    void validate() {
        JsonObjectValidator validator = new JsonObjectValidator();

        assertTrue(validator.validate(new Expression("{}", null)));
        assertTrue(validator.validate(new Expression("{\"a\": 54}", null)));

        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression(" {}", null)));
        assertFalse(validator.validate(new Expression("{} ", null)));
        assertFalse(validator.validate(new Expression("{", null)));
        assertFalse(validator.validate(new Expression("}", null)));
        assertFalse(validator.validate(new Expression("1", null)));
        assertFalse(validator.validate(new Expression("[]", null)));
    }
}