package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.complex.InterfaceMemberQualifiersSelector;

import java.util.Set;

public class InterfaceMemberQualifiersValidator extends BasicExpressionValidator {

    private final Set<String> invalidKeywords = Set.of("private", "protected");

    protected InterfaceMemberQualifiersValidator() {
        super(InterfaceMemberQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {

        return !invalidKeywords.contains(expression.getExpressionString());
    }
}
