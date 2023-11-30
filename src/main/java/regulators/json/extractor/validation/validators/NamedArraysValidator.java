package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.NamedArraysSelector;

public class NamedArraysValidator extends BasicExpressionValidator {
    protected NamedArraysValidator() {
        super(NamedArraysSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().startsWith("{") && expression.getExpressionString().endsWith("}");
    }
}
