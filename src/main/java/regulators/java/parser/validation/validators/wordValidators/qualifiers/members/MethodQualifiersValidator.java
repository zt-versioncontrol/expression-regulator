package regulators.java.parser.validation.validators.wordValidators.qualifiers.members;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.simple.ByConcreteTypeSelectos;

import java.util.Set;

public class MethodQualifiersValidator extends BasicExpressionValidator {

    private final Set<String> keywords = Set.of("public", "private", "protected", "final", "static");

    protected MethodQualifiersValidator() {
        super(ByConcreteTypeSelectos.MethodSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
