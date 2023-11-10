package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;
import regulators.java.parser.extractors.attributes.MethodIdentifierExtractor;
import regulators.java.parser.extractors.attributes.MethodQualifiersExtractor;
import regulators.java.parser.extractors.members.MethodParametersExtractor;

import static org.junit.jupiter.api.Assertions.*;

class MethodQualifiersValidatorTest {

    MethodQualifiersValidator validator =  new MethodQualifiersValidator();

    @Test
    void validate() {
        Expression method = new Expression("meth", null);

        assertTrue(validator.validate(method));

        Expression e1 = new Expression("e1", MethodIdentifierExtractor.class);
        Expression e2 = new Expression("e2", MethodParametersExtractor.class);
        method.addDerivedExpression(e1);
        method.addDerivedExpression(e2);

        assertTrue(validator.validate(method));

        Expression q1 = new Expression("public", MethodQualifiersExtractor.class);
        Expression q2 = new Expression("protected", MethodQualifiersExtractor.class);
        Expression q3 = new Expression("private", MethodQualifiersExtractor.class);
        Expression q4 = new Expression("static", MethodQualifiersExtractor.class);
        Expression q5 = new Expression("final", MethodQualifiersExtractor.class);
        method.addDerivedExpression(q1);
        method.addDerivedExpression(q2);
        method.addDerivedExpression(q3);
        method.addDerivedExpression(q4);
        method.addDerivedExpression(q5);

        assertTrue(validator.validate(method));

        Expression q6 = new Expression("abstract", MethodQualifiersExtractor.class);
        method.addDerivedExpression(q6);

        assertFalse(validator.validate(method));
    }
}