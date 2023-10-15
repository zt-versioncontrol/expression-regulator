package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonArrayValidatorTest {

    @Test
    void validate() {
        JsonArrayValidator validator = new JsonArrayValidator();

        assertTrue(validator.validate(new Expression("[1,3,4]", null)));
        assertTrue(validator.validate(new Expression("[]", null)));

        assertFalse(validator.validate(new Expression("abc", null)));
        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression(" [] ", null)));
        assertFalse(validator.validate(new Expression(" [1,3,4] ", null)));
        assertFalse(validator.validate(new Expression("[1,3,4] ", null)));
        assertFalse(validator.validate(new Expression(" [1,3,4]", null)));
        assertFalse(validator.validate(new Expression("[1,3,4", null)));
        assertFalse(validator.validate(new Expression("1,3,4]", null)));

    }
}