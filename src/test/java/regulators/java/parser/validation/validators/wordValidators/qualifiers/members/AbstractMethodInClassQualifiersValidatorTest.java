package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.extractors.members.MethodParametersExtractor;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMethodInClassQualifiersValidatorTest {

    AbstractMethodInClassQualifiersValidator validator = new AbstractMethodInClassQualifiersValidator();

    @Test
    void validate() {
        Expression abstractMethod = new Expression("meth", null);

        assertFalse(validator.validate(abstractMethod));

        Expression e1 = new Expression("abstract", MethodParametersExtractor.class);
        abstractMethod.addDerivedExpression(e1);

        assertFalse(validator.validate(abstractMethod));

        Expression q1 = new Expression("q1", MethodQualifiersExtractor.class);
        Expression q2 = new Expression("q2", MethodParametersExtractor.class);
        abstractMethod.addDerivedExpression(q1);
        abstractMethod.addDerivedExpression(q2);

        assertFalse(validator.validate(abstractMethod));

        Expression q3 = new Expression("abstract", MethodQualifiersExtractor.class);
        abstractMethod.addDerivedExpression(q3);

        assertTrue(validator.validate(abstractMethod));
    }
}