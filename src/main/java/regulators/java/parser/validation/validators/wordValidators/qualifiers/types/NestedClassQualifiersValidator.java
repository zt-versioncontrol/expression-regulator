package regulators.java.parser.validation.validators.wordValidators.qualifiers.types;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.java.parser.validation.selectors.aggregate.NestedClassQualifiersSelector;

import java.util.HashSet;
import java.util.Set;

public class NestedClassQualifiersValidator extends BasicExpressionValidator {


    private final Set<String> keywords = new HashSet<>(Set.of("public", "private", "protected", "static", "final", "abstract"));

    protected NestedClassQualifiersValidator() {
        super(NestedClassQualifiersSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
