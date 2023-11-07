package regulators.java.parser.validation.validators.structureValidators.associations;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperClassValidatorTest {

    SuperClassValidator validator = new SuperClassValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("extends a", null);
        Expression e2 = new Expression("extemds ", null);
        Expression e3 = new Expression("extends", null);
        Expression e4 = new Expression(" extends a", null);
        Expression e5 = new Expression("extendsextends", null);
        Expression e6 = new Expression("extendsa", null);
        Expression e7 = new Expression("extends a<ewqe>Eqwep", null);



        assertTrue(validator.validate(e1));
        assertFalse(validator.validate(e2));
        assertFalse(validator.validate(e3));
        assertFalse(validator.validate(e4));
        assertFalse(validator.validate(e5));
        assertFalse(validator.validate(e6));
        assertTrue(validator.validate(e7));
    }
}