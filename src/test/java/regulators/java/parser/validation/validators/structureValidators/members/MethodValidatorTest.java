package regulators.java.parser.validation.validators.structureValidators.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MethodValidatorTest {

    MethodValidator validator = new MethodValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("void method(...){}", null);
        Expression e2 = new Expression("(){}", null);
        Expression e3 = new Expression("({){}", null);
        Expression e4 = new Expression("<()><{}", null);

        Expression e5 = new Expression("void methd(...){};", null);
        Expression e6 = new Expression("void meth(..){", null);
        Expression e7 = new Expression("void meth({}", null);
        Expression e8 = new Expression("void meth{}", null);
        Expression e9 = new Expression("void { meth(){}", null);
        Expression e10 = new Expression("void meth(){{}", null);
        Expression e11 = new Expression("void meth(){} ", null);

        assertTrue(validator.validate(e1));
        assertTrue(validator.validate(e2));
        assertTrue(validator.validate(e3));
        assertTrue(validator.validate(e4));

        assertFalse(validator.validate(e5));
        assertFalse(validator.validate(e6));
        assertFalse(validator.validate(e7));
        assertFalse(validator.validate(e8));
        assertFalse(validator.validate(e9));
        assertFalse(validator.validate(e10));
        assertFalse(validator.validate(e11));
    }
}