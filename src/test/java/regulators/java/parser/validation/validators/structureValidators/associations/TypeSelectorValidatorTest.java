package regulators.java.parser.validation.validators.structureValidators.associations;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeSelectorValidatorTest {

    TypeSelectorValidator validator = new TypeSelectorValidator();

    @Test
    void validate() {
        Expression e1 = new Expression("String", null);
        Expression e2 = new Expression("qpwjeq qweq[e e", null);
        Expression e3 = new Expression("List<R>", null);
        Expression e4 = new Expression("List<>", null);
        Expression e5 = new Expression("<>", null);
        Expression e6 = new Expression("<T>", null);

        Expression e7 = new Expression("", null);
        Expression e8 = new Expression("List<T>e", null);
        Expression e9 = new Expression("String<T><e>", null);
        Expression e10 = new Expression("List<t", null);
        Expression e11 = new Expression("List<T> ", null);


        assertTrue(validator.validate(e1));
        assertTrue(validator.validate(e2));
        assertTrue(validator.validate(e3));
        assertTrue(validator.validate(e4));
        assertTrue(validator.validate(e5));
        assertTrue(validator.validate(e6));

        assertFalse(validator.validate(e7));
        assertFalse(validator.validate(e8));
        assertFalse(validator.validate(e9));
        assertFalse(validator.validate(e10));
        assertFalse(validator.validate(e11));

    }
}