package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.expressions.Expression;
import org.junit.jupiter.api.Test;
import regulators.java.parser.extractors.attributes.ClassQualifiersExtractor;
import regulators.java.parser.extractors.members.ClassMembersExtractor;

import static org.junit.jupiter.api.Assertions.*;

class AbstractClassValidatorTest {
    AbstractClassValidator validator = new AbstractClassValidator();

    @Test
    void validate() {
        Expression classExpression = new Expression("cls", null);
        Expression abstractMethodExpression = new Expression("meth", ClassMembersExtractor.class);
        Expression q1 = new Expression("q1", ClassQualifiersExtractor.class);
        Expression q2 = new Expression("q2", ClassQualifiersExtractor.class);

        classExpression.addDerivedExpression(abstractMethodExpression);

        assertFalse(validator.validate(abstractMethodExpression));

        classExpression.addDerivedExpression(q1);
        classExpression.addDerivedExpression(q2);

        assertFalse(validator.validate(abstractMethodExpression));

        Expression e1 = new Expression("abstract", ClassMembersExtractor.class);
        classExpression.addDerivedExpression(e1);

        assertFalse(validator.validate(abstractMethodExpression));

        Expression q3 = new Expression("abstract", ClassQualifiersExtractor.class);
        classExpression.addDerivedExpression(q3);

        assertTrue(validator.validate(abstractMethodExpression));

    }
}