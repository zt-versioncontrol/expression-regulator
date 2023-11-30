package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.SelectorTypeSelector;

import java.util.Set;

public class SelectorTypeValidator extends BasicExpressionValidator {
    private final Set<String> keywords = Set.of("string", "number", "binary");

    protected SelectorTypeValidator() {
        super(SelectorTypeSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return keywords.contains(expression.getExpressionString());
    }
}
