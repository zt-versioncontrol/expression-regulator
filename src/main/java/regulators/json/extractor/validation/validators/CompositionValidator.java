package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.CompositionSelector;

public class CompositionValidator extends BasicExpressionValidator {
    protected CompositionValidator() {
        super(CompositionSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().contains("<") && !expression.getExpressionString().contains("=");
    }
}
