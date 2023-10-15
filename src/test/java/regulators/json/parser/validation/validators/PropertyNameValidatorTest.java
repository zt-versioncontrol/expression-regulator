package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyNameValidatorTest {

    @Test
    void validate() {
        PropertyNameValidator validator = new PropertyNameValidator();

        assertTrue(validator.validate(new Expression("\"abc\"", null)));
        assertTrue(validator.validate(new Expression("\"$abc\"", null)));
        assertTrue(validator.validate(new Expression("\"_abc\"", null)));
        assertTrue(validator.validate(new Expression("\"_$$_12345abc\"", null)));

        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression("abc", null)));
        assertFalse(validator.validate(new Expression("abc\"", null)));
        assertFalse(validator.validate(new Expression("\"abc", null)));
        assertFalse(validator.validate(new Expression(" \"abc\"", null)));
        assertFalse(validator.validate(new Expression("\"abc\" ", null)));
        assertFalse(validator.validate(new Expression("\"1abc\"", null)));
        assertFalse(validator.validate(new Expression("\"1\"", null)));
        assertFalse(validator.validate(new Expression("\"abc1%\"", null)));
        assertFalse(validator.validate(new Expression("\"abc#\"", null)));
        assertFalse(validator.validate(new Expression("\"abc\\\"", null)));
        assertFalse(validator.validate(new Expression("\"abc\"\"", null)));
        assertFalse(validator.validate(new Expression("\"abc\\\"\"", null)));
        assertFalse(validator.validate(new Expression("\"abcü\"", null)));
    }
}