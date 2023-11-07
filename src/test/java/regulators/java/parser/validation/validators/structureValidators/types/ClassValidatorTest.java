package regulators.java.parser.validation.validators.structureValidators.types;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassValidatorTest {

    ClassValidator validator = new ClassValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("class cls{}", null);
        Expression e2 = new Expression(" class cls{}", null);
        Expression e3 = new Expression("private class clas{}", null);
        Expression e4 = new Expression("class <..> {}", null);
        Expression e5 = new Expression("class {}", null);

        Expression e6  = new Expression("class cls {};", null);
        Expression e7 = new Expression("class cls<{asd> {}", null);
        Expression e8 = new Expression("class cls {{}", null);
        Expression e9 = new Expression("class cls{}{}", null);
        Expression e10 = new Expression("public < class > cls{}", null);
        Expression e11 = new Expression("class cls {} ", null);
        Expression e12 = new Expression("xx {}", null);
        Expression e13 = new Expression("{}", null);
        Expression e14 = new Expression("interface cls{}", null);
        Expression e15 = new Expression("enum cls{}", null);
        Expression e16 = new Expression("class{}", null);
        Expression e17 = new Expression("publicclass cls{}", null);

        assertTrue(validator.validate(e1));
        assertTrue(validator.validate(e2));
        assertTrue(validator.validate(e3));
        assertTrue(validator.validate(e4));
        assertTrue(validator.validate(e5));

        assertFalse(validator.validate(e6));
        assertFalse(validator.validate(e7));
        assertFalse(validator.validate(e8));
        assertFalse(validator.validate(e9));
        assertFalse(validator.validate(e10));
        assertFalse(validator.validate(e11));
        assertFalse(validator.validate(e12));
        assertFalse(validator.validate(e13));
        assertFalse(validator.validate(e14));
        assertFalse(validator.validate(e15));
        assertFalse(validator.validate(e16));
        assertFalse(validator.validate(e17));
    }
}