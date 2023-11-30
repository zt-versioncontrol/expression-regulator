package regulators.json.extractor.validation.validators;

import base.components.expression.validation.BasicExpressionValidator;
import base.expressions.Expression;
import regulators.json.extractor.validation.selectors.IteratorSelector;

public class IteratorValidator extends BasicExpressionValidator {
    protected IteratorValidator() {
        super(IteratorSelector.class);
    }

    @Override
    public boolean validate(Expression expression) {
        return expression.getExpressionString().startsWith("[") && expression.getExpressionString().endsWith("]");
    }
}
