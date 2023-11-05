package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.NestedInterfaceQualifiersSelector;

import java.util.Set;

public class NestedInterfaceQualifiersValidator extends BasicExpressionValidator {
    private final Set<String> keywords = Set.of("public", "private", "protected", "static", "abstract");

    protected NestedInterfaceQualifiersValidator() {
        super(NestedInterfaceQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
