package regulators.java.parser.validation.validators.structureValidators.associations;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImportValidatorTest {

    ImportValidator validator = new ImportValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("import abc;", null);
        Expression e2 = new Expression("import abc*;", null);
        Expression e3 = new Expression("import ;", null);
        Expression e4 = new Expression("import **;", null);
        Expression e5 = new Expression("import abc*", null);
        Expression e6 = new Expression("import gg*.we*;", null);
        Expression e7 = new Expression(" import fl;", null);
        Expression e8 = new Expression("import;", null);
        Expression e9 = new Expression("abc.ewe;", null);
        Expression e10 = new Expression("", null);
        Expression e11 = new Expression(";", null);

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