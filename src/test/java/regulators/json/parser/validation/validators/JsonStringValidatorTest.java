package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonStringValidatorTest {

    @Test
    void validate() {
        JsonStringValidator validator = new JsonStringValidator();

        assertTrue(validator.validate(new Expression("\"abc\"", null)));
        assertTrue(validator.validate(new Expression("\"a'b'c\"", null)));
        assertTrue(validator.validate(new Expression("\"a{'b'}c\"", null)));
        assertTrue(validator.validate(new Expression("\"\n a\\\"b\\\"c\n\t \\\"d'\"", null)));

        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression(" \"abc\"", null)));
        assertFalse(validator.validate(new Expression("\"abc\" ", null)));
        assertFalse(validator.validate(new Expression("\"abc", null)));
        assertFalse(validator.validate(new Expression("abc\"", null)));
        assertFalse(validator.validate(new Expression("\"a\"bc\"", null)));
        assertFalse(validator.validate(new Expression("\"a\\\"\"bc\"", null)));

    }
}