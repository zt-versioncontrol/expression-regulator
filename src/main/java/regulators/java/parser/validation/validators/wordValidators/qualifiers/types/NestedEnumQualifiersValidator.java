package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.NestedEnumQualifiersSelector;

import java.util.Set;

public class NestedEnumQualifiersValidator extends BasicExpressionValidator {

    private final Set<String> keywords = Set.of("public", "private", "protected", "static");

    protected NestedEnumQualifiersValidator() {
        super(NestedEnumQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
