package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;
import regulators.java.parser.extractors.attributes.MethodIdentifierExtractor;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.extractors.members.MethodParametersExtractor;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMethodQualifiersValidatorTest {

    AbstractMethodQualifiersValidator validator = new AbstractMethodQualifiersValidator();

    @Test
    void validate() {

        Expression abstractMethod = new Expression("meth", null);

        assertTrue(validator.validate(abstractMethod));

        Expression e1 = new Expression("e1", MethodIdentifierExtractor.class);
        Expression e2 = new Expression("e2", MethodParametersExtractor.class);
        abstractMethod.addDerivedExpression(e1);
        abstractMethod.addDerivedExpression(e2);

        assertTrue(validator.validate(abstractMethod));

        Expression q1 = new Expression("public", MethodQualifiersExtractor.class);
        Expression q2 = new Expression("protected", MethodQualifiersExtractor.class);
        Expression q3 = new Expression("abstract", MethodQualifiersExtractor.class);
        abstractMethod.addDerivedExpression(q1);
        abstractMethod.addDerivedExpression(q2);
        abstractMethod.addDerivedExpression(q3);

        assertTrue(validator.validate(abstractMethod));

        Expression q4 = new Expression("q4", MethodQualifiersExtractor.class);
        abstractMethod.addDerivedExpression(q4);

        assertFalse(validator.validate(abstractMethod));
    }
}