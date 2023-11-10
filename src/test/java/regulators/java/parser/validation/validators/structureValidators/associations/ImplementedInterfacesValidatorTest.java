package regulators.java.parser.validation.validators.structureValidators.associations;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImplementedInterfacesValidatorTest {

    ImplementedInterfacesValidator validator = new ImplementedInterfacesValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("implements a", null);
        Expression e2 = new Expression("implements ", null);
        Expression e3 = new Expression("implements", null);
        Expression e4 = new Expression(" implements a", null);
        Expression e5 = new Expression("implementsimplements", null);
        Expression e6 = new Expression("implementsa", null);
        Expression e7 = new Expression("implements a<ewqe>Eqwep", null);
        Expression e8 = new Expression("", null);



        assertTrue(validator.validate(e1));
        assertFalse(validator.validate(e2));
        assertFalse(validator.validate(e3));
        assertFalse(validator.validate(e4));
        assertFalse(validator.validate(e5));
        assertFalse(validator.validate(e6));
        assertTrue(validator.validate(e7));
        assertTrue(validator.validate(e8));
    }
}