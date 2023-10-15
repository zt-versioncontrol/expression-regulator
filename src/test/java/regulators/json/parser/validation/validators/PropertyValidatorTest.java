package regulators.json.parser.validation.validators;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyValidatorTest {

    @Test
    void validate() {

        PropertyValidator validator = new PropertyValidator();

        assertTrue(validator.validate(new Expression(":", null)));
        assertTrue(validator.validate(new Expression("abc: as", null)));
        assertTrue(validator.validate(new Expression("\"zx:y\": {\"a\": \"q:qq\"}", null)));
        assertTrue(validator.validate(new Expression("\"zx:y\": {::::::}", null)));
        assertTrue(validator.validate(new Expression("\"zx:y\": [::::::]", null)));
        assertTrue(validator.validate(new Expression("{\"abc\":1}", null)));

        assertFalse(validator.validate(new Expression("", null)));
        assertFalse(validator.validate(new Expression(" ", null)));
        assertFalse(validator.validate(new Expression("abc", null)));
        assertFalse(validator.validate(new Expression("\"abc:1\"", null)));
        assertFalse(validator.validate(new Expression("{\"abc:1\"}", null)));
    }
}